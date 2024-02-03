package org.m3mpm.webinfo.mapper;


import org.m3mpm.webinfo.dto.TaskDto;
import org.m3mpm.webinfo.model.Task;
import org.m3mpm.webinfo.service.TaskService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class TaskMapper2 {

    @Autowired
    private TaskService taskService;

    @Mapping(target = "parentTask", qualifiedByName = "mapParentTaskToString")
    public abstract TaskDto converToTaskDto(Task task);

    @Mapping(target = "parentTask", qualifiedByName = "mapStringToParentTask")
    public abstract Task converToTask(TaskDto taskDto);

    @Named("mapParentTaskToString")
    String mapParentTaskToString(Task parentTask){
        if (parentTask == null) {
            return null;
        }
        return parentTask.getTitle();
    }

    @Named("mapStringToParentTask")
    Task mapStringToParentTask(String title){
        boolean isExist = taskService.isExistsById(title);
        if(title == null || title.isEmpty() || !isExist){
            return null;
        }
        return taskService.getTask(title);
    }
}
