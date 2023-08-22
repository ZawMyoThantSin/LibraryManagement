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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
    public String createBooks(@RequestParam String bookName, int author_id, int genre_id,String description,
                              MultipartFile coverImg,MultipartFile bookFile )  {
        String imageName = coverImg.getOriginalFilename();
        String bookFileName = bookFile.getOriginalFilename();
        Path bookDirectory = Paths.get("src/main/resources/static/uploads/covers/", bookName);
        try {
            Files.createDirectories(bookDirectory);

            Files.write(bookDirectory.resolve(imageName), coverImg.getBytes());
            Files.write(bookDirectory.resolve(bookFileName), bookFile.getBytes());

            Book books = new Book(bookName,description,genre_id,author_id,imageName,bookFileName);
            int status = new BookDaoImpl().save(books);
            if (status==1){
                return "redirect:admin/admin.home";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "errorPage"; // Redirect to an error page
        }
        return "admin/createBook";
    }

    @RequestMapping("/getAll")
    public String getAll(Model model){
        List<Book> books = bookService.getAll();

        model.addAttribute("books",books);
        return "test";
    }

}

