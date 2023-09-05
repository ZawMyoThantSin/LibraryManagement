package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.models.BookDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookDao {
    int save(BookDetails book);

    int update(BookDetails book);

    List<BookDetails> getAll();

    BookDetails findById(int id);

    int disable(int id);

    int restore(int id);

    int delete(int id);


}