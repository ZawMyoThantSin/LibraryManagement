package com.jwd39.LibraryManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/login/user")
    public String userLogin(){
        return "user/userLogin";
    }

    @GetMapping("/create/user")
    public String createuser(){
        return "user/createUser";
    }

}
