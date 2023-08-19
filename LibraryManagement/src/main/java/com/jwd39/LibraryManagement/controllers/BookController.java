package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.daos.BookDAO;
import com.jwd39.LibraryManagement.models.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("/books")
    public String createBooks(Model model){
        List<Books> books = new ArrayList<>();
        model.addAttribute("books", books);
        return "admin/admin.home";
    }

    @PostMapping("/books")
    public String createBooks(Model model, @RequestParam String bookname) throws SQLException {
        if (bookname != null){
            Books books = new Books(bookname);
            int status= new BookDAO().addBook(books);
            if (status == 1)
                return "admin/admin.home";
        }
        return "admin/admin.home";
    }

    // Read all books
    @GetMapping()
    public String getAllBooks(Model model) {
    List<Books> books = new ArrayList<>();
    model.addAttribute("books",books);
        return "admin/admin.home";
    }
}

