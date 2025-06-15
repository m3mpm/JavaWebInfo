package org.m3mpm.webinfo.controller;

import lombok.AllArgsConstructor;
import org.m3mpm.webinfo.dto.TaskDto;
import org.m3mpm.webinfo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
