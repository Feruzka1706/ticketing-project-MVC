package com.cydeo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
@AllArgsConstructor
public class ProjectController {


    @GetMapping("/create")
    public String projectCreateView(){


        return "project/create";
    }
}
