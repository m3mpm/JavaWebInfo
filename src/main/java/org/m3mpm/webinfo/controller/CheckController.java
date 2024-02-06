package org.m3mpm.webinfo.controller;

import org.m3mpm.webinfo.dto.CheckDto;
import org.m3mpm.webinfo.dto.TaskDto;
import org.m3mpm.webinfo.mapper.CheckMapper;
import org.m3mpm.webinfo.model.Check;
import org.m3mpm.webinfo.model.Task;
import org.m3mpm.webinfo.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/checks")
public class CheckController {

    private final CheckService checkService;

    private final CheckMapper checkMapper;

    @Autowired
    public CheckController(CheckService checkService, CheckMapper checkMapper) {
        this.checkService = checkService;
        this.checkMapper = checkMapper;
    }

    @GetMapping()
    public String showAllChecks(Model model){
        List<CheckDto> listChecks = checkService.getAllChecks().stream().map(checkMapper::convertToCheckDto).collect(Collectors.toList());
        model.addAttribute("listChecks", listChecks);
        return "check/showAllChecks";
    }

    @GetMapping("/{id}")
    public String showTask(@PathVariable("id") Long id, Model model){
        model.addAttribute("check", checkMapper.convertToCheckDto(checkService.getCheck(id)));
//        return "task/showCheck";
        return null;
    }

    @PostMapping("/delete")
    public String deleteTask(@ModelAttribute("deletedCheck") CheckDto checkDto){
        Check check = checkMapper.convertToCheck(checkDto);
        checkService.deleteCheck(check);
        return "redirect:/checks";
    }
}
