package com.example.apache.controllers;

import com.example.apache.entities.RoleName;
import com.example.apache.services.RoleNameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoleNameController {
    RoleNameService services;

    public RoleNameController(RoleNameService services){
        this.services = services;
    }

    @GetMapping("/rolename")
    public List<RoleName> roleNameList(){
        return this.services.getRoleNameList();
    }

    @PostMapping(value = "/rolename", consumes = {"application/json"})
    public RoleName createRoleName(@RequestBody RoleName roleName){
        return this.services.createRoleName(roleName);
    }

    @GetMapping("/rolename/{id}")
    public Optional<RoleName> getId(@PathVariable("id") Long id){
        return this.services.getId(id);
    }

    @DeleteMapping("/rolename/{id}")
    public String DeleteId(@PathVariable("id") Long id){
        this.services.deleteId(id);
        return "Registro eliminado con exito";
    }

    @PutMapping("/rolename/{id}")
    Optional<RoleName> replaceUser(@RequestBody RoleName newData, @PathVariable Long id) {
        return this.services.updateID(newData,id);
    }
}
