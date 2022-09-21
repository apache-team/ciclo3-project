package com.example.apache.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RoleName")

public class RoleName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RoleName")
    private String RoleName;

    @OneToMany(mappedBy ="roleName", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "employee-role")
    private List<Employee> employee;

    public RoleName() {

    }

    public RoleName(Long id, String roleName, List<Employee> employee) {
        this.id = id;
        RoleName = roleName;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return RoleName;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
