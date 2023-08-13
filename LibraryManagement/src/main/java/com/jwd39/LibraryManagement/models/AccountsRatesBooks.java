package com.jwd39.LibraryManagement.models;

import java.util.Date;

public class AccountsRatesBooks {

    private int account_id,book_id,rate;
    private Date created_date,updated_date;

    public AccountsRatesBooks() {
    }

    public AccountsRatesBooks(int account_id, int book_id, int rate, Date created_date, Date updated_date) {
        this.account_id = account_id;
        this.book_id = book_id;
        this.rate = rate;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public AccountsRatesBooks(int account_id, int book_id, int rate) {
        this.account_id = account_id;
        this.book_id = book_id;
        this.rate = rate;
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
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
