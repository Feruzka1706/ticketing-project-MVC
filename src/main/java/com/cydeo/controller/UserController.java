package com.cydeo.controller;


import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

   UserService userService;

    @GetMapping("/create")
    public String userCreateView(Model model){

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles",userService.findAll());

        return "user/create";
    }


}
