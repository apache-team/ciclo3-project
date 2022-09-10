package com.example.apache.controllers;

import com.example.apache.entities.Enterprise;
import com.example.apache.services.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/enterprise/{id}")
    public Optional<Enterprise> GetId(@PathVariable("id") Long id){
        return this.service.getId(id);
    }

    @DeleteMapping("/enterprise/{id}")
    public String DeleteId(@PathVariable("id") Long id){

        this.service.deleteId(id);
        return "Registro eliminado con exito";
    }

    @PutMapping("/enterprise/{id}")
    Optional<Enterprise> replaceUser(@RequestBody Enterprise newData, @PathVariable Long id) {
        return this.service.updateID(newData,id);
    }

}
