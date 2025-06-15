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

    @Mapping(target = "parentTask", qualifiedByName = "mapParentTaskToString")
    public abstract TaskDto toDto(TaskEntity taskEntity);

    @Mapping(target = "parentTask", qualifiedByName = "mapStringToParentTask")
    public abstract TaskEntity toEntity(TaskDto taskDto);

    @Named("mapParentTaskToString")
    String mapParentTaskToString(TaskEntity parentTask) {
        if (parentTask == null) {
            return null;
        }
        return parentTask.getTitle();
    }

    @Named("mapStringToParentTask")
    TaskEntity mapStringToParentTask(String title) {
        if (title == null || title.isEmpty()) {
            return null;
        }
        return null;
    }

    public abstract List<TaskDto> toDtoList(List<TaskEntity> taskEntities);

    public abstract List<TaskEntity> toEntityList(List<TaskDto> taskDtos);

    public void updateTaskFromDto(TaskDto taskDto, @MappingTarget TaskEntity taskEntity) {}

    String taskToString(TaskEntity taskEntity) {
        return taskEntity == null ? null : taskEntity.getTitle();
    }

    TaskEntity stringToTaskEntity(String title) {
        return taskRepository.findById(title).
                orElseThrow(() -> new EntityNotFoundException("Task with title '" + title + "' not found"));
    }

}
