package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.helpers.MD5Helper;
import com.jwd39.LibraryManagement.models.Account;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        String pass = MD5Helper.encrypt("123hello");
        System.out.println(pass);
        AccountDAO dao = new AccountDAO();
        Account user = dao.acLogIn("Htet","H222");
        System.out.println(user);
    }
}
