package com.jwd39.LibraryManagement.services;

import com.jwd39.LibraryManagement.daos.GenreDao;
import com.jwd39.LibraryManagement.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreDao genreDao;

    @Autowired
    public GenreService(GenreDao genreDao){
        this.genreDao =genreDao;
    }

    public int save(Genre genre){
        return genreDao.save(genre);
    }
    public List<Genre> getAll(){
        return genreDao.getAll();
    }
    public int delete(int id){
        return genreDao.delete(id);
    }
    public Genre findById(int id){
        return genreDao.findById(id);
    }
}
