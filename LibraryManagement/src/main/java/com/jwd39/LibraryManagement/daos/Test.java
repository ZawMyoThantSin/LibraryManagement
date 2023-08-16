package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.helpers.MD5Helper;
import com.jwd39.LibraryManagement.models.Account;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        Account user = new Account("Admin","123","zm@gmail.com",1);
        int status =new AccountDAO().acRegister(user);
        System.out.println(status==1?"success": "fail");
    }
}
