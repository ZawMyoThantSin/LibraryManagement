package com.jwd39.LibraryManagement.models;

import java.sql.Timestamp;
import java.util.Date;

public class Genres {
    private int genre_id;
    private String genre_name;
    private Timestamp created_date,updated_date;

    public Genres() {
    }

    public Genres(String genre_name) {
        this.genre_name = genre_name;
    }

    public Genres(int genre_id, String genre_name, Date created_date, Date updated_date) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
        this.created_date = (Timestamp) created_date;
        this.updated_date = (Timestamp) updated_date;
    }

    public Genres(int genre_id, String genre_name) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
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

    public void setCreated_date(Date create_date) {
        this.created_date = (Timestamp) create_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = (Timestamp) updated_date;
    }
}
