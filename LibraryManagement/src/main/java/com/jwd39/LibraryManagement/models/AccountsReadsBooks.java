package com.jwd39.LibraryManagement.models;

import java.util.Date;

public class AccountsReadsBooks {

    private int account_id,book_id;
    private Date created_date,updated_date;

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
}
