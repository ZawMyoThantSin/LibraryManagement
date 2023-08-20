package com.jwd39.LibraryManagement.models;

import java.util.Date;


public class Accounts {

    private int id,role_id;
    private String usrname,password,email;
    private Date created_date,updated_date;

    public Accounts() {
    }

    public Accounts(int id, int role_id, String usrname, String password, String email, Date created_date, Date updated_date) {
        this.id = id;
        this.role_id = role_id;
        this.usrname = usrname;
        this.password = password;
        this.email = email;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public Accounts(String usrname, String password, String email, int role_id) {
        this.usrname = usrname;
        this.password = password;
        this.email = email;
        this.role_id= role_id;
    }

    public Accounts(int id, int role_id, String usrname, String password, String email) {
        this.id = id;
        this.role_id = role_id;
        this.usrname = usrname;
        this.password = password;
        this.email = email;
    }

    public Accounts(String usrname, String password, String email) {
        this.usrname = usrname;
        this.password = password;
        this.email = email;
    }

    public Accounts(String usrname, String password) {
        this.usrname = usrname;
        this.password = password;
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

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
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
                ", usrname='" + usrname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", created_date=" + created_date +
                ", updated_date=" + updated_date +
                '}';
    }
}
