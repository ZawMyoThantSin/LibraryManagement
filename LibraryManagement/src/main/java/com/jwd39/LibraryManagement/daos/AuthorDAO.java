package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.models.Author;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface AuthorDAO {
    int save(Author author);

    List<Author> getAll();

    Author findById(int id);

    int delete(int id);

}
