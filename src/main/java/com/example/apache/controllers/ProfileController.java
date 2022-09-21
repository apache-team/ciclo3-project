package com.example.apache.controllers;
import com.example.apache.entities.Profile;
import com.example.apache.entities.User;
import com.example.apache.services.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfileController {
    ProfileService service;

    public ProfileController(ProfileService service){
        this.service = service;
    }

    @GetMapping("/profiles")
    public List<Profile> ProfileList(){
        return this.service.getProfileList();
    }

    @PostMapping(value = "/profiles", consumes = {"application/json"})
    public Profile createProfile(@RequestBody Profile profile){
        return this.service.createProfile(profile);
    }

    @GetMapping("/profiles/{id}")
    public Optional<Profile> GetId(@PathVariable("id") Long id){
        return this.service.getId(id);
    }

    @DeleteMapping("/profiles/{id}")
    public String DeleteId(@PathVariable("id") Long id){

        this.service.deleteId(id);
        return "Registro eliminado con exito";
    }

    @PutMapping("/profiles/{id}")
    Optional<Profile> replaceUser(@RequestBody Profile newData, @PathVariable Long id) {
        return this.service.updateID(newData,id);
    }
}
