package com.jwd39.LibraryManagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String genre_name;
    private Date created_date,updated_date;

    public Genres() {
    }

    public Genres(int id, String genre_name, Date created_date, Date updated_date) {
        this.id = id;
        this.genre_name = genre_name;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public Genres(String genre_name, Date created_date, Date updated_date) {
        this.genre_name = genre_name;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public Genres(int id, String genre_name) {
        this.id = id;
        this.genre_name = genre_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
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
}
