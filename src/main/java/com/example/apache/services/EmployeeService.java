package com.example.apache.services;

import com.example.apache.entities.Employee;
import com.example.apache.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository){
        this.repository=repository;
    }

    public List<Employee> getEmployeeList(){
        return this.repository.findAll();
    }

    public Employee createEmployee(Employee newEmployee){
        return this.repository.save(newEmployee);
    }

    public Optional<Employee> getId(long id){
        return this.repository.findById(id);
    }

    public void deleteId(long id){
        this.repository.deleteById( id);
    }

    public Optional<Employee> updateID(Employee newData, Long id){
        return Optional.of(this.repository.findById(id)
                .map(employee -> {
                    employee.setEmail(newData.getEmail());
                    employee.setCreatedAt(newData.getCreatedAt());
                    employee.setUpdatedAt(newData.getUpdatedAt());
                    employee.setEnterprise(newData.getEnterprise());
                    employee.setProfile(newData.getProfile());
                    employee.setRoleName(newData.getRoleName());
                    return repository.save(employee);
                }).orElseGet(() -> {
                    newData.setId(id);
                    return repository.save(newData);
                }));
    }
}
