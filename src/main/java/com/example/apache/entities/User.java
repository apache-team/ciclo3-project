package com.example.apache.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameUser")
    private String nameUser;

    @Column(name = "fullName")
    private String fullName;

    @OneToOne(mappedBy = "user")
    @JsonManagedReference(value = "user-profile")
    private Profile profile;

    public User(){
    }

    public User(Long id, String nameUser, String fullName, Profile profile) {
        this.id = id;
        this.nameUser = nameUser;
        this.fullName = fullName;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getFullName() {
            return fullName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }


}