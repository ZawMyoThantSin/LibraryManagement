package com.jwd39.LibraryManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/user/login")
    public String userLogin(Model model){
        model.addAttribute("title","Login");
        return "user/userLogin";
    }

    @GetMapping("/user/create")
    public String userCreate(Model model){
        model.addAttribute("title","User Create");
        return "user/createUser";
    }

    @GetMapping("/user/view")
    public String userViewScreen(){
        return "user/userView";
    }

}
