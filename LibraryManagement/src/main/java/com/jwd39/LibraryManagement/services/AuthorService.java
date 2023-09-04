package com.jwd39.LibraryManagement.services;

import com.jwd39.LibraryManagement.daos.AuthorDAO;
import com.jwd39.LibraryManagement.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorService(AuthorDAO authorDAO){
        this.authorDAO = authorDAO;
    }

    public int save(Author author){
        return authorDAO.save(author);
    }

    public List<Author> getAll(){
        return authorDAO.getAll();
    }

    public Author findById(int id){
        return authorDAO.findById(id);
    }

    public int delete(int id){
        return authorDAO.delete(id);

    }
}
