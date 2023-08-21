package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.models.Genre;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GenreDao {
    int save(Genre genre);

    List<Genre> getAll();

    int delete(int id);

}
