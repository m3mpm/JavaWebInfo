package org.m3mpm.webinfo.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.m3mpm.webinfo.dto.CheckDto;
import org.m3mpm.webinfo.service.CheckService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/checks")
public class CheckContoller {

    private final CheckService checkService;

    @GetMapping
    public String showAllChecks(Model model) {
        List<CheckDto> listChecks = checkService.getAllChecks();
        model.addAttribute("listChecks", listChecks);
        return "check/showAllChecks";
    }

    @GetMapping("{id}")
    public String showCheck(Model model, @PathVariable("id") Long id) {
        CheckDto checkDto = checkService.getCheckById(id);
        model.addAttribute("checkDto", checkDto);
        return "check/showCheck";
    }

    @GetMapping("/new")
    public String newCheck(@ModelAttribute("newCheckDto") CheckDto checkDto) {
        return "check/newCheck";
    }

    @PostMapping("/add")
    public String addCheck(Model model, @Valid @ModelAttribute("newCheckDto") CheckDto checkDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("newCheckDto", checkDto);
            return "check/newCheck";
        }
        checkService.saveCheck(checkDto);
        return "redirect:/checks";
    }
}
