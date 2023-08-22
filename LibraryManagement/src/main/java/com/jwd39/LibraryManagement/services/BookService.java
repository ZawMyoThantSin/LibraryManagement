package com.jwd39.LibraryManagement.services;

import com.jwd39.LibraryManagement.daos.BookDao;
import com.jwd39.LibraryManagement.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService<BookDao> {
    private final BookDao bookDao;

    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int save(Book book){
        return bookDao.save(book);
    }

    public int update(Book book){
        return bookDao.update(book);
    }
    public List<Book> getAll(){
        return bookDao.getAll();
    }
    public Book getById(int id){
        return bookDao.getById(id);
    }
    public int delete(int id){
        return bookDao.delete(id);
    }
}
