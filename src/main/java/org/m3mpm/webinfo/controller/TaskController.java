package org.m3mpm.webinfo.controller;

import jakarta.validation.Valid;
import org.m3mpm.webinfo.dto.TaskDto;
import org.m3mpm.webinfo.mapper.TaskMapper;
import org.m3mpm.webinfo.mapper.TaskMapper2;
import org.m3mpm.webinfo.model.Task;
import org.m3mpm.webinfo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    private final TaskMapper2 taskMapper;

    @Autowired
    public TaskController(TaskService taskService, TaskMapper2 taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping()
    public String showAllTasks(Model model){
        List<TaskDto> listTasks = taskService.getAllTasks().stream().map(taskMapper::converToTaskDto).collect(Collectors.toList());
        model.addAttribute("listTask",listTasks);
        return "task/showAllTasks";
    }

    @GetMapping("/{title}")
    public String showTask(@PathVariable("title") String title, Model model){
        model.addAttribute("task", taskMapper.converToTaskDto(taskService.getTask(title)));
        return "task/showTask";
    }

    @GetMapping("/add")
    public String newTask(@ModelAttribute("addTaskDto") TaskDto taskDto){
        return "task/addTask";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute("addTaskDto") @Valid TaskDto taskDto, Errors errors){
        if (errors.hasErrors()){
            return "/task/addTask";
        }
        taskService.saveTask(taskMapper.converToTask(taskDto));
        return "redirect:/tasks";
    }

    @PostMapping("/delete")
    public String deleteTask(@ModelAttribute("deletedTask") TaskDto taskDto){
        Task task = taskMapper.converToTask(taskDto);
        taskService.deleteTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{title}")
    public String editTask(@PathVariable("title") String title, Model model){
        model.addAttribute("editTaskDto", taskMapper.converToTaskDto(taskService.getTask(title)));
        return "/task/editTask";
    }

    @PostMapping("/edit/{title}")
    public String editTask(@PathVariable("title") String title, @ModelAttribute("editTaskDto") @Valid TaskDto taskDto, Errors errors){
        if (errors.hasErrors()) {
            return "/task/editTask";
        }
        Task task = taskMapper.converToTask(taskDto);
        taskService.updateTask(title,task);
        return "redirect:/tasks";
    }

}
