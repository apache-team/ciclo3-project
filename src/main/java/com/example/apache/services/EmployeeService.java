package com.example.apache.services;

import com.example.apache.entities.Employee;
import com.example.apache.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
