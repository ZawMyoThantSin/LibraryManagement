package com.jwd39.LibraryManagement.models;

import org.hibernate.sql.Delete;

import java.sql.Timestamp;

public class Books {
    private int id;
    private String bookname;
    private String description;
    private int genreid;
    private int authorid;
    private String cover_image_name;
    private Timestamp create_date;
    private Timestamp updated_date;
    private Delete is_delete;

    public Books(int id, String bookname, String description, int genreid, int authorid, String cover_image_name, Timestamp created_date, Timestamp updated_date) {
    }

    public Books() {

    }

    public Books(String bookname) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getCover_image_name() {
        return cover_image_name;
    }

    public void setCover_image_name(String cover_image_name) {
        this.cover_image_name = cover_image_name;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Timestamp getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Timestamp updated_date) {
        this.updated_date = updated_date;
    }

    public Delete getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Delete is_delete) {
        this.is_delete = is_delete;
    }

    public Books(int id, String bookname, String description, int genreid, int authorid, String cover_image_name, Timestamp create_date, Timestamp updated_date, Delete is_delete) {
        this.id = id;
        this.bookname = bookname;
        this.description = description;
        this.genreid = genreid;
        this.authorid = authorid;
        this.cover_image_name = cover_image_name;
        this.create_date = create_date;
        this.updated_date = updated_date;
        this.is_delete = is_delete;
    }
}
