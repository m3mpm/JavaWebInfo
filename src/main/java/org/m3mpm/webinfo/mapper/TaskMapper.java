package org.m3mpm.webinfo.mapper;

import org.m3mpm.webinfo.dto.TaskDto;
import org.m3mpm.webinfo.model.Task;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TaskMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public TaskMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    
    public void setupMapper(){
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
        if (parentName == null || parentName.isEmpty()) {
            destination.setParentTask(null);
        } else {
            Task parentTask = new Task();
            parentTask.setTitle(parentName);
            destination.setParentTask(parentTask);
        }
    }

//    public void mapSpecificFields(Droid source, DroidDto destination) {
//        destination.setUnicornId(Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getUnicorn().getId());
//    }

//    void mapSpecificFields(DroidDto source, Droid destination) {
//        destination.setUnicorn(unicornRepository.findById(source.getUnicornId()).orElse(null));
//    }


    public TaskDto converToTaskDto(Task task) {
        return modelMapper.map(task,TaskDto.class);
    }

    public Task converToTask(TaskDto taskDto){
        return modelMapper.map(taskDto,Task.class);
    }
}
