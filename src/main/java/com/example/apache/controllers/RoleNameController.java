package com.example.apache.controllers;

import com.example.apache.entities.RoleName;
import com.example.apache.services.RoleNameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
