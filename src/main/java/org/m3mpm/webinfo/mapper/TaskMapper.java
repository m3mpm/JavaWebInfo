package org.m3mpm.webinfo.mapper;

import jakarta.annotation.PostConstruct;
import org.m3mpm.webinfo.dto.TaskDto;
import org.m3mpm.webinfo.model.Task;
import org.m3mpm.webinfo.service.TaskService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TaskMapper {

    private final ModelMapper modelMapper;
    private final TaskService taskService;

    @Autowired
    public TaskMapper(ModelMapper modelMapper, TaskService taskService) {
        this.modelMapper = modelMapper;
        this.taskService = taskService;
    }

    @PostConstruct
    protected void setupMapper(){
        modelMapper.createTypeMap(Task.class,TaskDto.class).addMappings(m->m.skip(TaskDto::setParentTask)).setPostConverter(toTaskDtoConverter());
        modelMapper.createTypeMap(TaskDto.class,Task.class).addMappings(m->m.skip(Task::setParentTask)).setPostConverter(toTaskConverter());
    }

    protected Converter<Task,TaskDto> toTaskDtoConverter(){
        return context -> {
            Task source = context.getSource();
            TaskDto destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    void mapSpecificFields(Task source, TaskDto destination){
//        Task parentTask = source.getParentTask();
//        if(parentTask != null ) destination.setParentTask(parentTask.getTitle());
        destination.setParentTask(Objects.isNull(source) ? null : source.getTitle());
    }

    protected Converter<TaskDto, Task> toTaskConverter() {
        return context -> {
            TaskDto source = context.getSource();
            Task destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    void mapSpecificFields(TaskDto source, Task destination)  {
        String parentName = source.getParentTask();
        boolean isExistsById = taskService.isExistsById(parentName);
        if (parentName == null || parentName.isEmpty() || !isExistsById) {
            destination.setParentTask(null);
        } else {
            Task parentTask = new Task();
            parentTask.setTitle(parentName);
            destination.setParentTask(parentTask);
        }
    }

    public TaskDto converToTaskDto(Task task) {
        return modelMapper.map(task,TaskDto.class);
    }

    public Task converToTask(TaskDto taskDto){
        return modelMapper.map(taskDto,Task.class);
    }


}
