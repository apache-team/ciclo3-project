package com.example.apache.controllers;

import com.example.apache.entities.Enterprise;
import com.example.apache.services.EnterpriseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnterpriseController {
    EnterpriseService service;

    public EnterpriseController(EnterpriseService service){
        this.service= service;
    }

    @GetMapping("/enterprise")
    public List<Enterprise> enterpriseList(){
        return this.service.getEnterpriseList();
    }

    @PostMapping(value = "/enterprise", consumes = {"application/json"})
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise){
        return this.service.createEnterprise(enterprise);
    }
}
