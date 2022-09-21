package com.example.apache.services;
import com.example.apache.entities.Profile;
import com.example.apache.entities.User;
import com.example.apache.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

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
                    profile.setCreatedAt(newData.getCreatedAt());
                    profile.setUpdatedAt(newData.getUpdatedAt());
                    profile.setUser(newData.getUser());
                    return repository.save(profile);
                }).orElseGet(() -> {
                    newData.setId(id);
                    return repository.save(newData);
                }));
    }
}
