package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.impls.BookDaoImpl;
import com.jwd39.LibraryManagement.models.BookDetails;

public class Test {
    public static void main(String[] args) {
        BookDetails book = new BookDaoImpl().findById(1);
        System.out.println(book.getAuthorName());
        System.out.println(book.getBookName());
    }
}
