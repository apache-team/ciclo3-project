package com.example.apache.services;

import com.example.apache.entities.User;
import com.example.apache.exceptions.UserNotFoundException;
import com.example.apache.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository =repository;
    }

    public List<User> getUserList(){
        return this.repository.findAll();
    }

    public User createUser(User newUser){
        return this.repository.save(newUser);
    }

    public Optional<User> getUserId(long id){
        return this.repository.findById(id);
    }

    public void deleteUserId(long id){
        this.repository.deleteById( id);
    }

    public Optional<User> updateID(User newUser, Long id){
        return Optional.of(this.repository.findById(id)
                .map(user -> {
                    user.setNickname(newUser.getNickname());
                    user.setEmail(newUser.getEmail());
                    return repository.save(user);
                }).orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                }));
    }

    public User findUserByEmail(String email){//Busca el usuario nuevo por email
        return this.repository.findByEmail(email);

    }
    public User getOrCreateUser(Map<String, Object> userData){ //en userData vienen los datos del usuario
        //se requiere enviar al Servicio el getclaims() para que encuentre a este usuario en la base de datos  y si no existe que lo crea
        String email = (String) userData.get("email"); //Permite buscar en la bd al usuario creado
        User user = findUserByEmail(email);
        if(user==null){//si no esta el usuario lo crea con estos datos  y lo devuelve
            String nickname = (String) userData.get("nickname");//elementos del Map que captua getcalims(
            String auth0Id = (String) userData.get("sub");

            User newUser = new User(nickname=nickname, email=email,auth0Id=auth0Id);
            return createUser(newUser);//se pasa el nuevo usuario al servicio para que lo cree
        }
        //System.out.println(user.getEmail());//probar que si consulta al usuario por email
        return user;//Si esta en el bd simplemente se devuelve
    }

    public void updateUser(User newData, long id) {
        User user = repository.findById(id).orElseThrow(UserNotFoundException::new);

        boolean needUpdate = false;

        if (StringUtils.hasLength(newData.getEmail())) {
            user.setEmail(newData.getEmail());
            needUpdate = true;
        }

        if (StringUtils.hasLength(newData.getNickname())) {
            user.setNickname(newData.getNickname());
            needUpdate = true;
        }

        if (newData.getProfile() != user.getProfile()) {
            user.setProfile(newData.getProfile());
            needUpdate = true;
        }

        if (needUpdate) {
            repository.save(user);
        }
    }


}
