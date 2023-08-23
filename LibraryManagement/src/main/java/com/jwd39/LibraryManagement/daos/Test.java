package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.helpers.MD5Helper;
import com.jwd39.LibraryManagement.helpers.SHA_256Helper;
import com.jwd39.LibraryManagement.impls.AccountDaoImpl;
import com.jwd39.LibraryManagement.impls.BookDaoImpl;
import com.jwd39.LibraryManagement.models.Account;
import com.jwd39.LibraryManagement.models.Book;
import com.jwd39.LibraryManagement.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {

        List<Book> books = new BookDaoImpl().getAll();
        for (Book bc :books){
            System.out.println(bc.getFileName() + bc.getBookName());
        }
    }
}
