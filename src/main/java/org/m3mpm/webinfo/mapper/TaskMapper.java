package org.m3mpm.webinfo.mapper;

import org.m3mpm.webinfo.dto.TaskDto;
import org.m3mpm.webinfo.model.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public TaskMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TaskDto converToTaskDto(Task task) {
        return modelMapper.map(task,TaskDto.class);
    }

    public Task converToTask(TaskDto taskDto){
        return modelMapper.map(taskDto,Task.class);
    }
}
