package org.m3mpm.webinfo.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.m3mpm.webinfo.dto.TaskDto;
import org.m3mpm.webinfo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping()
    public String showAllTasks(Model model) {
        List<TaskDto> listTasks = taskService.getAllTasks();
        model.addAttribute("listTasks", listTasks);
        return "task/showAllTasks";
    }

    @GetMapping("{title}")
    public String showTask(Model model, @PathVariable("title") String title) {
        TaskDto taskDto = taskService.getTaskById(title);
        model.addAttribute("taskDto", taskDto);
        return "task/showTask";
    }

    @GetMapping("new")
    public String newTask(@ModelAttribute("newTaskDto") TaskDto taskDto) {
        return "task/newTask";
    }

    @PostMapping("/add")
    public String addTask(Model model, @Valid @ModelAttribute("newTaskDto") TaskDto taskDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("newTaskDto", taskDto);
            return "task/newTask";
        }
        taskService.saveTask(taskDto);
        return "redirect:/tasks";
    }

}
