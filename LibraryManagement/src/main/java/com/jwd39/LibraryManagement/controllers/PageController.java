package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.models.BookDetails;
import com.jwd39.LibraryManagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private BookService bookService;


    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("title","Login");
        return "user/userLogin";
    }


    @GetMapping("/user/home")
    public String userHome(Model model){

        model.addAttribute("title","Home");
        return "user/home";
    }

    @GetMapping("/user/login")
    public String userLogin(Model model){

        model.addAttribute("title","Login");
        return "user/userLogin";
    }


}
