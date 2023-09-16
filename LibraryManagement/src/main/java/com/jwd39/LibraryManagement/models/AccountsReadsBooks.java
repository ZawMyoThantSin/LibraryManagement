package com.jwd39.LibraryManagement.models;

import java.util.Date;

public class AccountsReadsBooks {

    private int account_id,book_id,rate,user_id;
    private Date created_date,updated_date;
    private String author_name, book_name;

    public AccountsReadsBooks() {
    }

    public AccountsReadsBooks(int account_id, int book_id, Date created_date, Date updated_date) {
        this.account_id = account_id;
        this.book_id = book_id;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public AccountsReadsBooks(int account_id, int book_id) {
        this.account_id = account_id;
        this.book_id = book_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
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

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
