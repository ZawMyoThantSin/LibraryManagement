package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.daos.GenresDAO;
import com.jwd39.LibraryManagement.models.Genres;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GenresController {

    @GetMapping("/genres")
    public String createGenres(Model model){
        List<Genres> genres=new ArrayList<>();
        model.addAttribute("genres",genres);
        return "admin/admin.home.html";
    }

    @PostMapping("/genres")
    public String createGenres(@RequestParam String genreName) {
        if (genreName != null) {
            Genres genres = new Genres(genreName);
            int status = new GenresDAO().genresCreate(genres);
            if (status == 1)
                return "admin/admin.home.html";
        }
        return "admin/admin.home.html";
    }


}