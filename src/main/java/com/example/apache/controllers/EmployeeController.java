package com.example.apache.controllers;

import com.example.apache.entities.Employee;
import com.example.apache.services.EmployeeService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
  EmployeeService service;

  public EmployeeController(EmployeeService service) {
    this.service = service;
  }

  @GetMapping("/employee")
  public List<Employee> EmployeeList() {
    return this.service.getEmployeeList();
  }

  @PostMapping(
      value = "/employee",
      consumes = {"application/json"})
  public Employee createEmployee(@RequestBody Employee employee) {
    return this.service.createEmployee(employee);
  }

  @GetMapping("/employee/{id}")
  public Optional<Employee> getId(@PathVariable("id") Long id) {
    return this.service.getId(id);
  }

  @DeleteMapping("/employee/{id}")
  public String DeleteId(@PathVariable("id") Long id) {

    this.service.deleteId(id);
    return "Registro eliminado con exito";
  }

  @PutMapping("/employee/{id}")
  Optional<Employee> replaceUser(@RequestBody Employee newData, @PathVariable Long id) {
    return this.service.updateID(newData, id);
  }

  @PatchMapping(
          path = "/employee/{id}",
          consumes = {"application/json"})
  public String update(@RequestBody Employee newData, @PathVariable("id") Long id) {
    this.service.updateEmployee(newData, id);
    return "Registro actualizado con éxito";
  }

}
