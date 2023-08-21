package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.models.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookDao {
    int save(Book book);

    int update(Book book);

    List<Book> getAll();

    Book getById(int id);

    int delete(int id);


}
