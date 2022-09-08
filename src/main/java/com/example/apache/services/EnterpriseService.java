package com.example.apache.services;

import com.example.apache.entities.Enterprise;
import com.example.apache.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
