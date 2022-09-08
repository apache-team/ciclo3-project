package com.example.apache.controllers;

import com.example.apache.entities.User;
import com.example.apache.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    UserService services;

    public UserController(UserService services){
        this.services =services;
    }

    @GetMapping("/users")
    public List<User> UserList(){
        return this.services.getUserList();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return this.services.createUser(user);
    }
}
