package com.jwd39.LibraryManagement.models;

import java.util.Date;

public class BookDetails {
    private int bookId;
    private String bookName,description,imageName,fileName;
    private int genreId,authorId;
    private String genreName,authorName;
    private Date created_date,updated_date;
    private int is_delete;

    public BookDetails() {
    }

    public BookDetails(String bookName,String description,int genreId,int authorId,String imageName,String fileName) {
        this.bookName = bookName;
        this.description = description;
        this.genreId = genreId;
        this.authorId = authorId;
        this.imageName = imageName;
        this.fileName = fileName;
    }
    public BookDetails(int bookId, String bookName, String description, String imageName, String fileName, int genreId, int authorId, String genreName, String authorName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.description = description;
        this.imageName = imageName;
        this.fileName = fileName;
        this.genreId = genreId;
        this.authorId = authorId;
        this.genreName = genreName;
        this.authorName = authorName;
    }
    public BookDetails(int bookId, String bookName, String description, String imageName, String fileName, int genreId, int authorId, String genreName, String authorName,Date created_date,Date updated_date,int is_delete) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.description = description;
        this.imageName = imageName;
        this.fileName = fileName;
        this.genreId = genreId;
        this.authorId = authorId;
        this.genreName = genreName;
        this.authorName = authorName;
        this.created_date = created_date;
        this.updated_date = updated_date;
        this.is_delete = is_delete;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }
}
