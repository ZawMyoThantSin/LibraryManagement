package com.jwd39.LibraryManagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id,genre_id,author_id;
    private String book_name,cover_image_name,is_delete;
    private Date create_date,updated_date;

    public Books() {
    }

    public Books(int id, int genre_id, int author_id, String book_name, String cover_image_name, String is_delete, Date create_date, Date updated_date) {
        this.id = id;
        this.genre_id = genre_id;
        this.author_id = author_id;
        this.book_name = book_name;
        this.cover_image_name = cover_image_name;
        this.is_delete = is_delete;
        this.create_date = create_date;
        this.updated_date = updated_date;
    }

    public Books(int genre_id, int author_id, String book_name, String cover_image_name, String is_delete, Date create_date, Date updated_date) {
        this.genre_id = genre_id;
        this.author_id = author_id;
        this.book_name = book_name;
        this.cover_image_name = cover_image_name;
        this.is_delete = is_delete;
        this.create_date = create_date;
        this.updated_date = updated_date;
    }

    public Books(String book_name, String cover_image_name, String is_delete) {
        this.book_name = book_name;
        this.cover_image_name = cover_image_name;
        this.is_delete = is_delete;
    }

    public Books(String book_name, String cover_image_name, String is_delete, Date create_date, Date updated_date) {
        this.book_name = book_name;
        this.cover_image_name = cover_image_name;
        this.is_delete = is_delete;
        this.create_date = create_date;
        this.updated_date = updated_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getCover_image_name() {
        return cover_image_name;
    }

    public void setCover_image_name(String cover_image_name) {
        this.cover_image_name = cover_image_name;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }
}
