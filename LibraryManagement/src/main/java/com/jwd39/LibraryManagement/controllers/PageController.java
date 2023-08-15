package com.jwd39.LibraryManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","Login");
        return "user/userLogin";

    }


}
