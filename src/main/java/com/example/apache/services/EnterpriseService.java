package com.example.apache.services;

import com.example.apache.entities.Enterprise;
import com.example.apache.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {
    private EnterpriseRepository repository;

    public EnterpriseService(EnterpriseRepository repository){
        this.repository = repository;
    }

    public List<Enterprise> getEnterpriseList(){
        return this.repository.findAll();
    }

    public Enterprise createEnterprise(Enterprise newEnterprise){
        return this.repository.save(newEnterprise);
    }

    public Optional<Enterprise> getId(long id){
        return this.repository.findById(id);
    }

    public void deleteId(long id){
        this.repository.deleteById( id);
    }

    public Optional<Enterprise> updateID(Enterprise newData, Long id){
        return Optional.of(this.repository.findById(id)
                .map(enterprise -> {
                    enterprise.setName(newData.getName());
                    enterprise.setDocument(newData.getDocument());
                    enterprise.setPhone(newData.getPhone());
                    enterprise.setAddress(newData.getAddress());
                    enterprise.setCreatedAt(newData.getCreatedAt());
                    enterprise.setUpdatedAt(newData.getUpdatedAt());
                    return repository.save(enterprise);
                }).orElseGet(() -> {
                    newData.setId(id);
                    return repository.save(newData);
                }));
    }
}
