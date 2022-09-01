package com.mintic.financer.entities;

import com.mintic.financer.enums.Enum_RoleName;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Employee {

  private long id;
  private String email;
  private Profile profile;
  private Enum_RoleName role;
  private Enterprise enterprise;
  private List<Transaction> transactions;
  private LocalDateTime updateAt;
  private LocalDateTime createdAt;

  public Employee() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public Enum_RoleName getRole() {
    return role;
  }

  public void setRole(Enum_RoleName role) {
    this.role = role;
  }

  public Enterprise getEnterprise() {
    return enterprise;
  }

  public void setEnterprise(Enterprise enterprise) {
    this.enterprise = enterprise;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  public LocalDateTime getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(LocalDateTime updateAt) {
    this.updateAt = updateAt;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "id="
        + id
        + ", email='"
        + email
        + '\''
        + ", profile="
        + profile
        + ", role="
        + role
        + ", enterprise="
        + enterprise
        + ", transactions="
        + transactions
        + ", updateAt="
        + updateAt
        + ", createdAt="
        + createdAt
        + '}';
  }
}
