package com.example.apache.services;

import com.example.apache.entities.Enterprise;
import com.example.apache.exceptions.EnterpriseNotFoundException;
import com.example.apache.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
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
        newEnterprise.setCreatedAt(LocalDate.now());
        newEnterprise.setUpdatedAt(LocalDate.now());
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
                    enterprise.setUpdatedAt(LocalDate.now());
                    return repository.save(enterprise);
                }).orElseGet(() -> {
                    newData.setUpdatedAt(LocalDate.now());
                    newData.setId(id);
                    return repository.save(newData);
                }));
    }

    public void updateEnterprise(Enterprise newData, Long id) {
        Enterprise enterprise = repository.findById(id).orElseThrow(EnterpriseNotFoundException::new);

        boolean needUpdate = false;

        if (StringUtils.hasLength((newData.getName()))) {
            enterprise.setName(newData.getName());
            needUpdate = true;
        }

        if (StringUtils.hasLength(newData.getDocument())) {
            enterprise.setDocument(newData.getDocument());
            needUpdate = true;
        }

        if (StringUtils.hasLength(newData.getPhone())) {
            enterprise.setPhone(newData.getPhone());
            needUpdate = true;
        }

        if (StringUtils.hasLength(enterprise.getAddress())) {
            enterprise.setAddress(enterprise.getAddress());
            needUpdate = true;
        }

        if (newData.getEmployee() != null) {
            enterprise.setEmployee(newData.getEmployee());
            needUpdate = true;
        }

        if (newData.getTransaction() != null) {
            enterprise.setTransaction(newData.getTransaction());
            needUpdate = true;
        }

        if (needUpdate) {
            enterprise.setUpdatedAt(LocalDate.now());
            repository.save(enterprise);
        }
    }

}
