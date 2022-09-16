package com.example.apache.entities;
import com.example.apache.entities.enums.Enum_RoleName;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "profile_id")
    @JsonBackReference(value = "employee-profile")
    private Profile profile;

    @Column(name = "roleName")
    private Enum_RoleName roleName;

    @ManyToOne
    @JsonBackReference(value = "employee-enterprise")
    @JoinColumn(name = "Enterprise_id")
    private Enterprise enterprise;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "employee-transaction")
    private List<Transaction> transaction;

    @Column(name = "createdAt")
    private LocalDate createdAt;

    @Column(name = "updatedAt")
    private LocalDate updatedAt;

    public Employee(){

    }

    public Employee(Long id, String email, Profile profile, Enum_RoleName roleName, Enterprise enterprise, List<Transaction> transaction, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.email = email;
        this.profile = profile;
        this.roleName = roleName;
        this.enterprise = enterprise;
        this.transaction = transaction;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Profile getProfile() {
        return profile;
    }

    public Enum_RoleName getRoleName() {
        return roleName;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setRoleName(Enum_RoleName roleName) {
        this.roleName = roleName;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
