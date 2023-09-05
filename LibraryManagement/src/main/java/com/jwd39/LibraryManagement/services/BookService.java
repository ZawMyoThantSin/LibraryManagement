package com.jwd39.LibraryManagement.services;

import com.jwd39.LibraryManagement.daos.BookDao;
import com.jwd39.LibraryManagement.models.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookDao bookDao;
    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int save(BookDetails book){
        return bookDao.save(book);
    }

    public int update(BookDetails book){
        return bookDao.update(book);
    }

    public List<BookDetails> getAll(){

        return bookDao.getAll();
    }

    public BookDetails findById(int id){
        return bookDao.findById(id);
    }

    public int disable(int id){
        return bookDao.disable(id);
    }

    public int restore(int id){
        return bookDao.restore(id);
    }

    public int delete(int id){
        return bookDao.delete(id);
    }
}
