package org.m3mpm.webinfo.service;

import org.m3mpm.webinfo.dto.TaskDto;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskService {

    List<TaskDto> getAllTasks();

    TaskDto getTaskById(String id);

    void saveTask(TaskDto taskDto);

    void deleteTask(TaskDto taskDto);

    void updateTask(TaskDto taskDto);
}
