package com.example.apache.services;

import com.example.apache.entities.RoleName;
import com.example.apache.repositories.RoleNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleNameService {
    private RoleNameRepository repository;

    public  RoleNameService(RoleNameRepository repository){
        this.repository=repository;
    }

    public List<RoleName> getRoleNameList(){
        return this.repository.findAll();
    }

    public RoleName createRoleName(RoleName newRoleName){
        return this.repository.save(newRoleName);
    }
}
