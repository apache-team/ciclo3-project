package com.example.apache.controllers;

import com.example.apache.entities.User;
import com.example.apache.services.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

  UserService services;

  public UserController(UserService services) {
    this.services = services;
  }

  @GetMapping("/user")
  public List<User> UserList() {
    return this.services.getUserList();
  }

  @PostMapping("/user")
  public User createUser(@RequestBody User user) {
    return this.services.createUser(user);
  }

  @GetMapping("/user/{id}")
  public Optional<User> UserId(@PathVariable("id") Long id) {
    return this.services.getUserId(id);
  }

  @DeleteMapping("/user/{id}")
  public String DeleteId(@PathVariable("id") Long id) {

    this.services.deleteUserId(id);
    return "Usuario fue eliminado con exito";
  }

  @PutMapping("/user/{id}")
  Optional<User> replaceUser(@RequestBody User newUser, @PathVariable Long id) {
    return this.services.updateID(newUser, id);
  }

  @PatchMapping(path = "/user/{id}", consumes = {"application/json"})
  public String update(@RequestBody User newData, @PathVariable("id") Long id){
    this.services.updateUser(newData, id);
    return "Registro actualizado con éxito";
  }

}
