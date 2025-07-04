package org.m3mpm.webinfo.mapper;

import org.m3mpm.webinfo.dto.TaskDto;
import org.m3mpm.webinfo.entity.TaskEntity;
import org.m3mpm.webinfo.exception.EntityNotFoundException;
import org.m3mpm.webinfo.repository.TaskRepository;
import org.m3mpm.webinfo.service.TaskService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class TaskMapper {

    @Autowired
    private TaskRepository taskRepository;

    @Mapping(target = "parentTask", qualifiedByName = "taskEntityToString")
    public abstract TaskDto toDto(TaskEntity taskEntity);

    @Mapping(target = "parentTask", qualifiedByName = "stringToTaskEntity")
    public abstract TaskEntity toEntity(TaskDto taskDto);

    public abstract List<TaskDto> toDtoList(List<TaskEntity> taskEntities);

    public abstract List<TaskEntity> toEntityList(List<TaskDto> taskDtos);

    @Mapping(target = "parentTask", qualifiedByName = "stringToTaskEntity")
    public abstract void updateTaskFromDto(TaskDto taskDto, @MappingTarget TaskEntity taskEntity);

    @Named("taskEntityToString")
    String taskEntityToString(TaskEntity taskEntity) {
        return taskEntity == null ? null : taskEntity.getTitle();
    }

    @Named("stringToTaskEntity")
    TaskEntity stringToTaskEntity(String title) {
        if (title == null || title.isEmpty()) {
            return null;
        }
        return taskRepository.findById(title).
                orElseThrow(() -> new EntityNotFoundException("Task with title '" + title + "' not found."));
    }

}
