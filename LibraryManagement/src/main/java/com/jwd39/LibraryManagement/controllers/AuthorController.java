package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.models.Author;
import com.jwd39.LibraryManagement.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @GetMapping("/create/author")
    public String createAuthor(Model model){
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors",authors);
        return "admin/authorPage";
    }

    @PostMapping("/create/author")
    public String createAuthor(@RequestParam String name){
        if (name!=null){
            Author author = new Author(name);
            authorService.save(author);
        }
            return "redirect:/create/author";
    }

    @GetMapping("/author/delete/{author_id}")
    public String delete(@PathVariable int author_id){
        authorService.delete(author_id);
        return "redirect:/create/author";
    }
}
