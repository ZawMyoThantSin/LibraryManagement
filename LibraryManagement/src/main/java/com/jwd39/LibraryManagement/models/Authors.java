package com.jwd39.LibraryManagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String author_name,is_delete;
    private Date created_date,updated_date;
}
