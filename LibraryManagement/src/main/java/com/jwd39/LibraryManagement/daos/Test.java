package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.impls.BookDaoImpl;
import com.jwd39.LibraryManagement.models.BookDetails;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<BookDetails> raw = new BookDaoImpl().getAll();
        List<BookDetails> deletedBooks = new ArrayList<>();
        for(BookDetails books: raw){
            if (books.getIs_delete()==0){
                continue;
            }else {
                deletedBooks.add(books);
            }

        }
        for (BookDetails bc: deletedBooks){
            System.out.println(bc.getBookName());
        }
;
    }
}
