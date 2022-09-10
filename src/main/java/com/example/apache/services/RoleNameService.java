package com.example.apache.services;

import com.example.apache.entities.RoleName;
import com.example.apache.repositories.RoleNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<RoleName> getId(long id){
        return this.repository.findById(id);
    }

    public void deleteId(long id){
        this.repository.deleteById( id);
    }

    public Optional<RoleName> updateID(RoleName newData, Long id){
        return Optional.of(this.repository.findById(id)
                .map(roleName -> {
                    roleName.setRoleName(newData.getRoleName());
                    return repository.save(roleName);
                }).orElseGet(() -> {
                    newData.setId(id);
                    return repository.save(newData);
                }));
    }
}
