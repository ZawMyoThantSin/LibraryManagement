package com.jwd39.LibraryManagement.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static DBHelper instance;
    private static Connection con;

    private DBHelper(){
        try {
            Class.forName(DRIVER);
            con= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBHelper getInstance(){
        if(instance==null){
            instance=new DBHelper();
        }

        return instance;
    }

    public static Connection getCon(){
        return con;
    }
}
