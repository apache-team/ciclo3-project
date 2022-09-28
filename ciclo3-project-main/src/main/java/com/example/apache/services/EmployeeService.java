package com.example.apache.services;

import com.example.apache.entities.Employee;
import com.example.apache.exceptions.EmployeeNotFoundException;
import com.example.apache.repositories.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class EmployeeService {
  private EmployeeRepository repository;

  public EmployeeService(EmployeeRepository repository) {
    this.repository = repository;
  }

  public List<Employee> getEmployeeList() {
    return this.repository.findAll();
  }

  public Employee createEmployee(Employee newEmployee) {
    newEmployee.setCreatedAt(LocalDate.now());
    newEmployee.setUpdatedAt(LocalDate.now());
    return this.repository.save(newEmployee);
  }

  public Optional<Employee> getId(long id) {
    return this.repository.findById(id);
  }

  public void deleteId(long id) {
    this.repository.deleteById(id);
  }

  public Optional<Employee> updateID(Employee newData, Long id) {
    return Optional.of(
        this.repository
            .findById(id)
            .map(
                employee -> {
                  employee.setEmail(newData.getEmail());
                  employee.setUpdatedAt(LocalDate.now());
                  employee.setEnterprise(newData.getEnterprise());
                  employee.setProfile(newData.getProfile());
                  employee.setRoleName(newData.getRoleName());
                  return repository.save(employee);
                })
            .orElseGet(
                () -> {
                  newData.setUpdatedAt(LocalDate.now());
                  newData.setId(id);
                  return repository.save(newData);
                }));
  }

  public void updateEmployee(Employee newData, Long id) {
    Employee employee = repository.findById(id).orElseThrow(EmployeeNotFoundException::new);

    boolean needUpdate = false;

    if (StringUtils.hasLength(newData.getEmail())) {
      employee.setEmail(newData.getEmail());
      needUpdate = true;
    }

    if (newData.getProfile() != null) {
      employee.setProfile(newData.getProfile());
      needUpdate = true;
    }

    if (newData.getRoleName() != null) {
      employee.setRoleName(newData.getRoleName());
      needUpdate = true;
    }

    if (newData.getEnterprise() != null) {
      employee.setEnterprise(newData.getEnterprise());
      needUpdate = true;
    }

    if (newData.getTransaction() != null) {
      employee.setTransaction(newData.getTransaction());
      needUpdate = true;
    }

    if (needUpdate) {
      employee.setUpdatedAt(LocalDate.now());
      repository.save(employee);
    }
  }
}
