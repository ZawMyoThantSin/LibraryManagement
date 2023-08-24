package com.jwd39.LibraryManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/home")
    public String adminHome(Model model){
        model.addAttribute("title","Admin Home");
        return"admin/adminHome";
    }
    @GetMapping("/book/create")
    public String createBook(){
        return "admin/createBook";

    }

}