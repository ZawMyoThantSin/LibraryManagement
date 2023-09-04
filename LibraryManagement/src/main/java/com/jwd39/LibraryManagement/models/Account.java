package com.jwd39.LibraryManagement.models;

import java.sql.Date;

public class Account {

    private int id,role_id;
    private String username,password,email;
    private Date created_date,updated_date;

    public Account() {
    }

    public Account(int id, int role_id, String username, String password, String email, Date created_date, Date updated_date) {
        this.id = id;
        this.role_id = role_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public Account(String username,  String email,String password, int role_id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role_id= role_id;
    }

    public Account(int id, int role_id, String username, String password, String email) {
        this.id = id;
        this.role_id = role_id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(int id, int role_id, String username, String email, Date created_date) {
        this.id = id;
        this.role_id = role_id;
        this.username = username;
        this.email = email;
        this.created_date = created_date;
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", created_date=" + created_date +
                ", updated_date=" + updated_date +
                '}';
    }
}