package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.daos.GenresDAO;
import com.jwd39.LibraryManagement.models.Genres;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @GetMapping("/admin/home")
    public String adminHome(Model model){
        model.addAttribute("title","Admin Home");
        return"admin/admin.home";
    }

    @PostMapping("/admin/home")
    public String adminHome(@RequestParam int genreId, String genreName){
        Genres genres=new Genres(genreId,genreName);
        int status = new GenresDAO().genresCreate(genres);
        if (status==1){
            return "admin/admin.home";
        }
        return "admin/admin.home";
    }

    @GetMapping("/book/create")
    public String createBook(){
        return "admin/createBook";

    }

}
