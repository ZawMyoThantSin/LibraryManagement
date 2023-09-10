package com.jwd39.LibraryManagement.services;

import com.jwd39.LibraryManagement.daos.BookDao;
import com.jwd39.LibraryManagement.models.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
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
        List<BookDetails> raw = bookDao.getAll();
        List<BookDetails> filter = new ArrayList<>();
         for(BookDetails books: raw){
            if (books.getIs_delete()==1){
                continue;
            }else {
                filter.add(books);
            }
        }
        return filter;
    }

    public List<BookDetails> getDeletedBooks(){
        List<BookDetails> raw = bookDao.getAll();
        List<BookDetails> deletedBooks = new ArrayList<>();
        for(BookDetails books: raw){
            if (books.getIs_delete()==0){
                continue;
            }else {
                deletedBooks.add(books);
            }
        }
        return deletedBooks;
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
