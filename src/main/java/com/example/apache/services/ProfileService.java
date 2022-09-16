package com.example.apache.services;
import com.example.apache.entities.Profile;
import com.example.apache.entities.User;
import com.example.apache.exceptions.ProfileNotFoundException;
import com.example.apache.repositories.ProfileRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    private ProfileRepository repository;

    public ProfileService(ProfileRepository repository){
        this.repository =repository;
    }

    public List<Profile> getProfileList(){
        return this.repository.findAll();
    }

    public Profile createProfile(Profile newProfile){
        newProfile.setCreatedAt(LocalDate.now());
        newProfile.setUpdatedAt(LocalDate.now());
        return this.repository.save(newProfile);
    }

    public Optional<Profile> getId(long id){
        return this.repository.findById(id);
    }

    public void deleteId(long id){
        this.repository.deleteById(id);
    }

    public Optional<Profile> updateID(Profile newData, Long id){
        return Optional.of(this.repository.findById(id)
                .map(profile -> {
                    profile.setImage(newData.getImage());
                    profile.setPhone(newData.getPhone());
                    profile.setUpdatedAt(LocalDate.now());
                    profile.setUser(newData.getUser());
                    return repository.save(profile);
                }).orElseGet(() -> {
                    newData.setUpdatedAt(LocalDate.now());
                    newData.setId(id);
                    return repository.save(newData);
                }));
    }

    public void updateProfile(Profile newData, Long id) {
        Profile profile = repository.findById(id).orElseThrow(ProfileNotFoundException::new);

        boolean needUpdate = false;

        if (StringUtils.hasLength(newData.getImage())) {
            profile.setImage(newData.getImage());
            needUpdate = true;
        }

        if (StringUtils.hasLength(newData.getPhone())) {
            profile.setPhone(newData.getPhone());
            needUpdate = true;
        }

        if (newData.getEmployee() != null) {
            profile.setEmployee(newData.getEmployee());
            needUpdate = true;
        }

        if (needUpdate) {
            profile.setUpdatedAt(LocalDate.now());
            repository.save(profile);
        }


    }

}
