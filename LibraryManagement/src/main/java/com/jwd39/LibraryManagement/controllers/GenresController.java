package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.models.Genre;
import com.jwd39.LibraryManagement.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GenresController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/create/genre")
    public String createGenres(Model model){
        List<Genre> genres = genreService.getAll();
        model.addAttribute("genres",genres);
        return "admin/genrePage";
    }

    @PostMapping("/create/genre")
    public String createGenres(@RequestParam String name) {
        if (name != null) {
            Genre genre = new Genre(name);
            int status = genreService.save(genre);
            if (status == 1)
                return "redirect:/create/genre";
        }
        return "redirect:/create/genre";
    }

    @GetMapping("/genre/delete/{genre_id}")
    public String delete(@PathVariable int genre_id){
        if (genre_id!=0){
            genreService.delete(genre_id);
            return "redirect:/create/genre";
        }
        return "redirect:/create/genre";
    }

}
