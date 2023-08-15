package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.models.Accounts;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        Accounts user = new Accounts("Test","Test","pa@gmail.com",2);
        int status = new AccountDAO().acRegister(user);
        if(status==1){
            System.out.println("success");
        }else System.out.println("fail");
    }
}
