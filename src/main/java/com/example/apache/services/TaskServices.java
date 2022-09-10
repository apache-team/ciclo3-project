package com.example.apache.services;

import com.example.apache.entities.Task;
import com.example.apache.repositories.TaskRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {
    private TaskRepositorio repository;

    public TaskServices(TaskRepositorio repository){
        this.repository=repository;
    }

    public List<Task> getTaskList(){
        return this.repository.findAll();
    }

    public Task createTask(Task newTask){
        return this.repository.save(newTask);
    }


}
