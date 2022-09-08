package com.example.apache.controllers;
import com.example.apache.entities.Employee;
import com.example.apache.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service =service;
    }

    @GetMapping("/employee")
    public List<Employee> EmployeeList(){
        return this.service.getEmployeeList();
    }

    @PostMapping(value = "/employee", consumes = {"application/json"})
    public Employee createEmployee(@RequestBody Employee employee){
        return  this.service.createEmployee(employee);
    }
}
