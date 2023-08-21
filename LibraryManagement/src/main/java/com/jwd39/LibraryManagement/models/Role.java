package com.jwd39.LibraryManagement.models;

import java.util.Date;

public class Role {
    private int role_id;
    private String rolename;
    private Date created_date, updated_date;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
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

    public Role() {
    }

    public Role(int role_id, String rolename, Date created_date, Date updated_date) {
        this.role_id = role_id;
        this.rolename = rolename;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public Role(String rolename, Date created_date, Date updated_date) {
        this.rolename = rolename;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public Role(int role_id, String rolename) {
        this.role_id = role_id;
        this.rolename = rolename;
    }
}
