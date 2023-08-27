package com.jwd39.LibraryManagement.models;

import java.util.Date;

public class Book {
    private int book_id,genre_id,author_id;
    private String bookName,description,imageName,fileName;
    private Date created_date,updated_date;
    private boolean isDelete;

    public Book(String bookName,String description,int genre_id,int author_id,String imageName,String fileName) {
        this.bookName = bookName;
        this.description = description;
        this.genre_id = genre_id;
        this.author_id = author_id;
        this.imageName = imageName;
        this.fileName = fileName;
    }

    public Book(int book_id, int genre_id, int author_id, String bookName, String description, String imageName,String fileName, Date created_date, Date updated_date) {
        this.book_id = book_id;
        this.genre_id = genre_id;
        this.author_id = author_id;
        this.bookName = bookName;
        this.description = description;
        this.imageName = imageName;
        this.fileName = fileName;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }


    public Book() {
    }

    public Book(int genre_id, int author_id, String bookName, String description, String imageName) {
        this.genre_id = genre_id;
        this.author_id = author_id;
        this.bookName = bookName;
        this.description = description;
        this.imageName = imageName;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
