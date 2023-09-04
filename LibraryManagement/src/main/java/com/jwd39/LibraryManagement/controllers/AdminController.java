package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.models.*;
import com.jwd39.LibraryManagement.services.AccountService;
import com.jwd39.LibraryManagement.services.BookService;
import com.jwd39.LibraryManagement.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AccountService accountService;
    @Autowired
    BookService bookService;
    @Autowired
    GenreService genreService;

    @GetMapping("/admin/home")
    public String adminHome(Model model){
        List<Account> users = accountService.getAll();
        List<Genre> genres = genreService.getAll();
        List<BookDetails> raw = bookService.getAll();
        List<BookDetails> filteredBooks = new ArrayList<>();

        for (BookDetails book : raw ){
            if (book.getIs_delete()==1){
                continue;
            }else {
                filteredBooks.add(book);
            }
        }

        model.addAttribute("genres",genres);
        model.addAttribute("users",users);
        model.addAttribute("books",filteredBooks);
        model.addAttribute("title","Admin Home");

        return"admin/adminHome";
    }



}