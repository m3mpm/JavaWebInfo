package org.m3mpm.webinfo.service;


import org.m3mpm.webinfo.model.Task;
import org.m3mpm.webinfo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTask(String title){
        return taskRepository.getReferenceById(title);
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(Task task){
        taskRepository.delete(task);
    }

    @Transactional
    public void updateTask(String title, Task updatedTask){
        if (taskRepository.existsById(title)){
            System.out.println(taskRepository.existsById(title));
            taskRepository.save(updatedTask);
        }
    }

    public boolean isExistsById(String title){
        return taskRepository.existsById(title);
    }

}
