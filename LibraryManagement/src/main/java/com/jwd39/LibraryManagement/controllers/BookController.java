package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.impls.BookDaoImpl;
import com.jwd39.LibraryManagement.models.Book;
import com.jwd39.LibraryManagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/create/book")
    public String createBooks(Model model){
        List<Book> books = new ArrayList<>();
        model.addAttribute("books", books);
        return "admin/createBook";
    }


    @PostMapping("/create/book")
    public String createBooks(@RequestParam String bookName, int author_id, int genre_id,String description, MultipartFile photo) throws SQLException, IOException {
        String fileName= photo.getOriginalFilename();

        String uploadPath =System.getProperty("user.dir")+"";
        System.out.println(uploadPath);
         String filePath = uploadPath+ File.separator +fileName;
         photo.transferTo(new File(filePath));

         Book books = new Book();
         books.setBookName(bookName);
         books.setAuthor_id(author_id);
         books.setGenre_id(genre_id);
         books.setDescription(description);
         books.setImageName(filePath);
         int status  = new BookDaoImpl().save(books);
        System.out.println(status==1? "success": "Fail");


        return "admin/admin.home";
    }

    @RequestMapping("/getAll")
    public String getAll(Model model){
        List<Book> books = bookService.getAll();
        for (Book bo : books){
            System.out.println(bo.getImageName()+bo.getBookName());
        }
        model.addAttribute("books",books);
        return "test";
    }

}

