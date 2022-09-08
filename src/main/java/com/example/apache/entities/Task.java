package com.example.apache.entities;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "task")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "done")
    private Boolean done;
    @Column(name = "dueDate")
    private LocalDate dueDate;

    public Task(Long id, String description, Boolean done, LocalDate dueDate) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
    }
    public Task() {

    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getDone() {
        return done;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
