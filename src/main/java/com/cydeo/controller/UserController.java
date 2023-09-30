package com.cydeo.controller;


import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    UserService userService;
    RoleService roleService;

    @GetMapping("/create")
    public String userCreateView(Model model){

        model.addAttribute("user", new UserDTO());
        //bring all roles from DB
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());

        return "user/create";
    }

    //After Spring 4.3 we don't have to explicitly pass @ModelAttribute("user")
    //Spring configures implicitly

    @PostMapping("/create")
    public String userDisplayView( @ModelAttribute("user") UserDTO userDTO){

        userService.save(userDTO);

        //return "user/create"; //user, roles, users
        return "redirect:/user/create"; //redirecting above controller method

    }

}
