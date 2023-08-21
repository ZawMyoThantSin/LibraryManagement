package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.daos.BookDAO;
import com.jwd39.LibraryManagement.models.Books;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("/books")
    public String createBooks(Model model){
        List<Books> books = new ArrayList<>();
        model.addAttribute("books", books);
        return "admin/createBook";
    }

    @PostMapping("/books")
    public String createBooks(@RequestParam String bookName,String author, String genre,String description, MultipartFile cover) throws SQLException, IOException {
        String fileName = cover.getOriginalFilename();
        String uploadPath ="C:\\Users\\HUAWEI\\Desktop\\LibraryManagement\\LibraryManagement\\LibraryManagement\\src\\main\\resources\\static\\images";
        String filePath= uploadPath+File.separator+fileName;

        cover.transferTo(new File(filePath));


        Books books = new Books(bookName,description,genre,author,filePath);
        int status = new BookDAO().addBook(books);
        if (status ==1){
            return "admin/admin.home";
        }
        return "book/create";
    }





}