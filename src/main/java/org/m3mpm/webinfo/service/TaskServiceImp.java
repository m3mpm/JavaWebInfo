package org.m3mpm.webinfo.service;

import lombok.AllArgsConstructor;
import org.m3mpm.webinfo.dto.TaskDto;
import org.m3mpm.webinfo.entity.TaskEntity;
import org.m3mpm.webinfo.exception.EntityAlreadyExistsException;
import org.m3mpm.webinfo.exception.EntityNotFoundException;
import org.m3mpm.webinfo.mapper.TaskMapper;
import org.m3mpm.webinfo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    @Override
    public List<TaskDto> getAllTasks() {
        List<TaskEntity> taskEntities = taskRepository.findAll();
        return taskMapper.toDtoList(taskEntities);
    }

    @Override
    public TaskDto getTaskById(String id) {
        return taskRepository.findById(id).map(taskMapper::toDto).
                orElseThrow(() -> new RuntimeException("Task with title '" + id + "' not found"));
    }

    @Override
    public void saveTask(TaskDto taskDto) {
        if(!taskRepository.existsById(taskDto.getTitle())){
            taskRepository.save(taskMapper.toEntity(taskDto));
        } else {
            throw new EntityAlreadyExistsException("Task with title '" + taskDto.getTitle() + "' is already exists");
        }
    }

    @Override
    public void deleteTask(TaskDto taskDto) {
        if(!taskRepository.existsById(taskDto.getTitle())){
            taskRepository.deleteById(taskDto.getTitle());
        } else {
            throw new EntityNotFoundException("Task with title '" + taskDto.getTitle() + "' not found");
        }
    }

    @Override
    public void updateTask(TaskDto taskDto) {
        Optional<TaskEntity> taskEntityOptional = taskRepository.findById(taskDto.getTitle());
        if(taskEntityOptional.isPresent()){
            TaskEntity taskEntity = taskEntityOptional.get();
            taskMapper.updateTaskFromDto(taskDto, taskEntity);
            taskRepository.save(taskEntity);
        }
    }
}
