package org.m3mpm.webinfo.mapper;


import org.m3mpm.webinfo.dto.TaskDto;
import org.m3mpm.webinfo.model.Task;
import org.m3mpm.webinfo.service.TaskService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = TaskService.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class TaskMapper {

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

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
        if(title == null || title.isEmpty() || !taskService.isExistsById(title))
            return  null;
        return taskService.getTask(title);
    }
}
