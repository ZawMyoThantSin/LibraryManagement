package com.jwd39.LibraryManagement.controllers;

import com.jwd39.LibraryManagement.models.Author;
import com.jwd39.LibraryManagement.models.BookDetails;
import com.jwd39.LibraryManagement.models.Genre;
import com.jwd39.LibraryManagement.services.AuthorService;
import com.jwd39.LibraryManagement.services.BookService;
import com.jwd39.LibraryManagement.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Book;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

    @GetMapping("/showbooks")
    public String showAllBooks(Model model){
        List<BookDetails> books = bookService.getAll();

        model.addAttribute("books",books);
        return "user/showBooks";
    }

    @GetMapping("/create/book")
    public String createBooks(Model model){

        List<Author> authors = authorService.getAll();
        List<Genre> genres = genreService.getAll();

        model.addAttribute("authors",authors);
        model.addAttribute("genres",genres);
        return "admin/createBook";
    }

    @PostMapping("/create/book")
    public String createBooks(@RequestParam String bookName, int author_id, int genre_id,String description,
                              MultipartFile coverImage,MultipartFile bookFile ){
        String imageName = coverImage.getOriginalFilename();
        String bookFileName = bookFile.getOriginalFilename();
        Path bookDirectory = Paths.get("src/main/resources/static/uploads/");
        try {
            Files.createDirectories(bookDirectory);

            Files.write(bookDirectory.resolve(imageName), coverImage.getBytes());
            Files.write(bookDirectory.resolve(bookFileName), bookFile.getBytes());

            BookDetails books = new BookDetails(bookName,description,genre_id,author_id,imageName,bookFileName);
            int status = bookService.save(books);
            if (status==1){
                return "redirect:/admin/home";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "errorPage";
        }
        return "admin/createBook";
    }

    @GetMapping("/book/details/{book_id}")
    public String detailPage(@PathVariable int book_id,Model model){
        BookDetails book = bookService.findById(book_id);

        model.addAttribute("book", book);
        return "user/bookDetails";
    }

    @GetMapping("/book/delete/{book_id}")
    public String deleteBook(@PathVariable int book_id) {
        BookDetails book = bookService.findById(book_id);
        if (book != null) {
            Path bookDirectory = Paths.get("src/main/resources/static/uploads/", book.getBookName());
            try {

                Files.deleteIfExists(bookDirectory.resolve(book.getImageName()));
                Files.deleteIfExists(bookDirectory.resolve(book.getFileName()));
                bookService.delete(book_id);

                return "redirect:/admin/home";
            } catch (IOException e) {
                e.printStackTrace();
                return "errorPage";
            }
        } else {
            return "errorPage";
        }
    }

    @GetMapping("/book/edit/{book_id}")
    public String editBook(@PathVariable int book_id, Model model){
        BookDetails book = bookService.findById(book_id);
        List<Author> authors = authorService.getAll();
        List<Genre> genres = genreService.getAll();

        model.addAttribute("authors",authors);
        model.addAttribute("genres",genres);
        model.addAttribute("book",book);
        return "admin/updateBook";
    }

    @PostMapping("/book/update/{book_id}")
    public String updateBook(){
        return "null";
    }
}