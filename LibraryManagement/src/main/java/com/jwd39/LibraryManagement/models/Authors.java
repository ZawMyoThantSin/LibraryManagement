package com.jwd39.LibraryManagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author_name,is_delete;
    private Date created_date,updated_date;

    public Authors() {
    }

    public Authors(int id, String author_name, String is_delete, Date created_date, Date updated_date) {
        this.id = id;
        this.author_name = author_name;
        this.is_delete = is_delete;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public Authors(String author_name, String is_delete, Date created_date, Date updated_date) {
        this.author_name = author_name;
        this.is_delete = is_delete;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public Authors(int id, String author_name, String is_delete) {
        this.id = id;
        this.author_name = author_name;
        this.is_delete = is_delete;
    }

    public Authors(int id, String author_name) {
        this.id = id;
        this.author_name = author_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
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