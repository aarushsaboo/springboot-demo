package com.example.demo.services;

import com.example.demo.models.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    // In-memory store for tasks (instead of a database for this demo)
    private Map<Long, Task> tasks = new HashMap<>();
    private Long nextId = 1L;
    
    // Initialize with some sample data
    public TaskService() {
        addTask("Complete Spring Boot tutorial", "Learn the basics of Spring Boot", LocalDate.now().plusDays(3));
        addTask("Build a REST API", "Create endpoints for CRUD operations", LocalDate.now().plusDays(7));
        addTask("Add a database", "Connect the application to a database", LocalDate.now().plusDays(14));
    }
    
    // Get all tasks
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }
    
    // Get a task by ID
    public Task getTaskById(Long id) {
        return tasks.get(id);
    }
    
    // Add a new task
    public Task addTask(String title, String description, LocalDate dueDate) {
        Task task = new Task(nextId, title, description, false, dueDate);
        tasks.put(nextId, task);
        nextId++;
        return task;
    }
    
    // Update a task
    public Task updateTask(Long id, Task task) {
        if (tasks.containsKey(id)) {
            task.setId(id);
            tasks.put(id, task);
            return task;
        }
        return null;
    }
    
    // Delete a task
    public boolean deleteTask(Long id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            return true;
        }
        return false;
    }
    
    // Toggle task completion
    public Task toggleTaskCompletion(Long id) {
        if (tasks.containsKey(id)) {
            Task task = tasks.get(id);
            task.setCompleted(!task.isCompleted());
            return task;
        }
        return null;
    }
}