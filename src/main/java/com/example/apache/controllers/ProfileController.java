package com.example.apache.controllers;
import com.example.apache.entities.Profile;
import com.example.apache.services.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
