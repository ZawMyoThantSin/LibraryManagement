package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.models.*;
import com.jwd39.LibraryManagement.services.AccountService;
import com.jwd39.LibraryManagement.services.AuthorService;
import com.jwd39.LibraryManagement.services.BookService;
import com.jwd39.LibraryManagement.services.GenreService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
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
    @Autowired
    private AuthorService authorService;

    @GetMapping("/admin/home")
    public String adminHome(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Account  account = (Account) session.getAttribute("account");
            if (account!=null){
                if (account.getRole_id()==1){
                    List<Account> users = accountService.getAll();
                    List<Genre> genres = genreService.getAll();
                    List<BookDetails> books = bookService.getAll();
                    List<Author> authors = authorService.getAll();

                    model.addAttribute("authors",authors);
                    model.addAttribute("genres", genres);
                    model.addAttribute("books", books);
                    model.addAttribute("users", users);
                    return "admin/adminHome";
                }else{
                    return "redirect:/user/home";
                }
            }else{
                model.addAttribute("message","You Must Login First!");
                return "user/userLogin";
            }

    }

    @GetMapping("/admin/showusers")
    public String showUsers(Model model){
        List<Account> users = accountService.getAll();
        List<BookDetails> books=bookService.getAll();
        List<Author> authors = authorService.getAll();

        model.addAttribute("authors",authors);
        model.addAttribute("users",users);
        model.addAttribute("books",books);
        return "admin/showUsers";
    }

    @GetMapping("/admin/trash")
    public String showTrash(Model model){
        List<BookDetails> deletedBooks =bookService.getDeletedBooks() ;

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