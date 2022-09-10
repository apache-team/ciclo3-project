package com.example.apache.services;

import com.example.apache.entities.User;
import com.example.apache.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
                    user.setNameUser(newUser.getNameUser());
                    user.setFullName(newUser.getFullName());
                    return repository.save(user);
                }).orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                }));
    }

}
