package com.jwd39.LibraryManagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role_name;
    private Date create_date,updated_date;

    public Roles() {
    }

    public Roles(int id, String role_name, Date create_date, Date updated_date) {
        this.id = id;
        this.role_name = role_name;
        this.create_date = create_date;
        this.updated_date = updated_date;
    }

    public Roles(String role_name, Date create_date, Date updated_date) {
        this.role_name = role_name;
        this.create_date = create_date;
        this.updated_date = updated_date;
    }

    public Roles(int id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
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
