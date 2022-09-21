package com.example.apache.controllers;

import com.example.apache.entities.User;
import com.example.apache.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/users/{id}")
    public Optional<User> UserId(@PathVariable("id") Long id){
        return this.services.getUserId(id);
    }

    @DeleteMapping("/users/{id}")
    public String DeleteId(@PathVariable("id") Long id){

        this.services.deleteUserId(id);
        return "Usuario fue eliminado con exito";
    }

    @PutMapping("/users/{id}")
    Optional<User> replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return this.services.updateID(newUser,id);
    }
}
