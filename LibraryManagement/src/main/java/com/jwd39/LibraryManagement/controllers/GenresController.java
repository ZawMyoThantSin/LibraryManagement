package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.models.Genre;
import com.jwd39.LibraryManagement.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GenresController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public String createGenres(Model model){
        List<Genre> genres=new ArrayList<>();
        model.addAttribute("genres",genres);
        return "admin/admin.home.html";
    }

    @PostMapping("/genres")
    public String createGenres(@RequestParam String genreName) {
        if (genreName != null) {
            Genre genre = new Genre(genreName);
            int status = genreService.save(genre);
            if (status == 1)
                return "admin/admin.home.html";
        }
        return "admin/admin.home.html";
    }


}
