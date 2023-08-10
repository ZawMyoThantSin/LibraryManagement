package com.jwd39.LibraryManagement.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id,role_id;
    private String username,password,email;
    private Date created_date,updated_date;

    public Accounts() {
    }

    public Accounts(int id, int role_id, String username, String password, String email, Date created_date, Date updated_date) {
        this.id = id;
        this.role_id = role_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public Accounts(String username, String password, String email, Date created_date, Date updated_date) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public Accounts(int id, int role_id, String username, String password, String email) {
        this.id = id;
        this.role_id = role_id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Accounts(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
