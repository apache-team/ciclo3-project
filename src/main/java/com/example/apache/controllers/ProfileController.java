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

    @GetMapping("/profile")
    public List<Profile> ProfileList(){
        return this.service.getProfileList();
    }

    @PostMapping(value = "/profile", consumes = {"application/json"})
    public Profile createProfile(@RequestBody Profile profile){
        return this.service.createProfile(profile);
    }

    @GetMapping("/profile/{id}")
    public Optional<Profile> GetId(@PathVariable("id") Long id){
        return this.service.getId(id);
    }

    @DeleteMapping("/profile/{id}")
    public String DeleteId(@PathVariable("id") Long id){

        this.service.deleteId(id);
        return "Registro eliminado con exito";
    }

    @PutMapping("/profile/{id}")
    Optional<Profile> replaceUser(@RequestBody Profile newData, @PathVariable Long id) {
        return this.service.updateID(newData,id);
    }

    @PatchMapping(
            path = "/profile/{id}",
            consumes = {"application/json"})
    public String update(@RequestBody Profile newData, @PathVariable("id") Long id) {
        this.service.updateProfile(newData, id);
        return "Registro actualizado con exito";
    }

}
