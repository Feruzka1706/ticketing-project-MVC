package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/task")
@Controller
@AllArgsConstructor
public class TaskController {

    UserService userService;
    ProjectService projectService;
    TaskService taskService;

    @GetMapping("/create")
    public String getCreateTaskForm(Model model){
    model.addAttribute("task",new TaskDTO());
    model.addAttribute("projects", projectService.findAll());
    model.addAttribute("employees",userService.findEmployees());
    model.addAttribute("tasks",taskService.findAll());
        return "task/create";
    }

    //adding new task
    @PostMapping("/create")
    public String userDisplayView( @ModelAttribute("task") TaskDTO taskDTO){

        taskService.save(taskDTO);
        return "redirect:/task/create"; //redirecting above controller method

    }


}
