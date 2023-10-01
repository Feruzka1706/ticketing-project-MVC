package com.cydeo.controller;


import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/update/{username}")
    public String getUpdateUserForm(@PathVariable(value = "username") String emailId,
                                    Model model){

       //define the modelAttributes -> user, roles, users
        model.addAttribute("user", userService.findById(emailId));
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());

        return "/user/update";
    }


    @PostMapping("/update/{username}")
    public String updateUserForm(@PathVariable(value = "username") String emailId,
                               @ModelAttribute("user") UserDTO userDTO){

        userService.update(userDTO);
        return "redirect:/user/create";
    }


    @GetMapping("/delete/{username}")
    public String deleteUserById(@PathVariable(value = "username") String emailId){

        userService.deleteById(emailId);
        return "redirect:/user/create";
    }

}
