package com.example.apache.controllers;

import com.example.apache.entities.Task;
import com.example.apache.services.TaskServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    TaskServices services;

    public TaskController(TaskServices services){
        this.services= services;
    }

    @GetMapping("/tasks")
    public List<Task>  TaskList(){
        return this.services.getTaskList();
    }

    @PostMapping(value = "/tasks",  consumes = {"application/json"})
    public Task createTasks(@RequestBody Task task){
        return this.services.createTask(task);
    }

}