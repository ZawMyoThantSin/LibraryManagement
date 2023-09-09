package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.models.*;
import com.jwd39.LibraryManagement.services.AccountService;
import com.jwd39.LibraryManagement.services.BookService;
import com.jwd39.LibraryManagement.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

        List<Genre> genres = genreService.getAll();
        List<BookDetails> raw = bookService.getAll();
        List<BookDetails> filteredBooks = new ArrayList<>();
        for(BookDetails books: raw){
            if (books.getIs_delete()==1){
                continue;
            }else {
                filteredBooks.add(books);
            }
        }

        model.addAttribute("genres",genres);
        model.addAttribute("books",filteredBooks);
        model.addAttribute("title","Admin Home");

        return"admin/adminHome";
    }

    @GetMapping("/admin/showusers")
    public String showUsers(Model model){
        List<Account> users = accountService.getAll();
        model.addAttribute("users",users);
        return "admin/showUsers";
    }

    @GetMapping("/admin/trash")
    public String showTrash(Model model){
        List<BookDetails> raw = bookService.getAll();
        List<BookDetails> deletedBooks = new ArrayList<>();

        for(BookDetails books: raw){
            if (books.getIs_delete()==0){
                continue;
            }else {
                deletedBooks.add(books);
            }
        }
        model.addAttribute("deletedBooks",deletedBooks);
        return "admin/trashPage";
    }

    @GetMapping("/disable/{book_id}")
    public String disable(@PathVariable int book_id){
        bookService.disable(book_id);
        return "redirect:/admin/home";
    }

    @GetMapping("/restore/{book_id}")
    public String restore(@PathVariable int book_id){
        bookService.restore(book_id);
        return "redirect:/admin/trash";
    }

}