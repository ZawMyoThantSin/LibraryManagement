package com.jwd39.LibraryManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/create/book")
    public String createBook(){
        return "admin/createBook";

    }

}
