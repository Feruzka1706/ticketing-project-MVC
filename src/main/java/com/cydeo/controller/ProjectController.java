package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
@AllArgsConstructor
public class ProjectController {

    UserService userService;
    ProjectService projectService;

    @GetMapping("/create")
    public String projectCreateView(Model model){
      //model attribute
     model.addAttribute("project", new ProjectDTO());
     model.addAttribute("managers",userService.findManagers());
     model.addAttribute("projects",projectService.findAll());
        return "project/create";
    }


    //adding new project
    @PostMapping("/create")
    public String userDisplayView( @ModelAttribute("project") ProjectDTO projectDTO){

        projectService.save(projectDTO);
        //return "project/create"; //project, assigned manager,
        return "redirect:/project/create"; //redirecting above controller method

    }

    //deleting existing project
    @GetMapping("/delete/{projectCode}")
    public String deleteUserById(@PathVariable(value = "projectCode") String projectCode){

        projectService.deleteById(projectCode);
        return "redirect:/project/create";
    }

    //completing project status
    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable(value = "projectCode") String projectCode){

        projectService.completeProject(projectService.findById(projectCode));
        return "redirect:/project/create";
    }


    // get mapping to update project details
    @GetMapping("/update/{projectCode}")
    public String getUpdateProjectForm(@PathVariable(value = "projectCode") String projectCode,
                                       Model model){
        model.addAttribute("project",projectService.findById(projectCode));
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("managers",userService.findManagers());
        return "/project/update";
    }


    //method to update project details
    @PostMapping("/update")
    public String updateProject(@ModelAttribute("project") ProjectDTO projectDTO){
        projectService.update(projectDTO);

        return "redirect:/project/create";
    }

}
