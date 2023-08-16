package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.daos.GenresDAO;
import com.jwd39.LibraryManagement.models.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private GenresDAO genresDAO;

    @GetMapping("/admin/home")
    public String adminHome(Model model){
        model.addAttribute("title","Admin Home");
        return"admin/admin.home";
    }

    @PostMapping("/admin/home")
    public String adminHome(){
        return "admin/admin.home";
    }

    @GetMapping("/book/create")
    public String createBook(){
        return "admin/createBook";

    }

    @GetMapping("/genres")
    public String listGenres(Model model) {
        List<Genres> genres = genresDAO.getAllGenres();
        model.addAttribute("genres", genres);
        return "admin/admin.home";
    }



}
