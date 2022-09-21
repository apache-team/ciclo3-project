package com.example.apache.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "concept")
    private String concept;

    @Column(name = "amount")
    private Float amount;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference(value = "employee-transaction")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    @JsonBackReference(value = "enterprise-transaction")
    private Enterprise enterprise;

    @Column(name = "createdAt")
    private LocalDate createdAt;

    @Column(name = "updatedAt")
    private LocalDate updatedAt;

    public Transaction(){

    }

    public Transaction(Long id, String concept, Float amount, Employee employee, Enterprise enterprise, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.employee = employee;
        this.enterprise = enterprise;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getConcept() {
        return concept;
    }

    public Float getAmount() {
        return amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Enterprise getEnterprise() {
        return enterprise;
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

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
