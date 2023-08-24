package com.jwd39.LibraryManagement.services;

import com.jwd39.LibraryManagement.daos.AccountDao;
import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.helpers.DateHelper;
import com.jwd39.LibraryManagement.helpers.SHA_256Helper;
import com.jwd39.LibraryManagement.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    private final AccountDao accountDao;
    private Connection con;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public int save(Account account){
       /*String hashed = SHA_256Helper.encrypt(account.getPassword());
       account.setPassword(hashed);*/
       int status = 0;
       con = DBHelper.getInstance().getCon();
       String query = "INSERT INTO accounts (username,password,email,role_id,created_date,updated_date) VALUES (?,MD5(?),?,2,CURDATE(),CURDATE());";
        try {
            PreparedStatement pstt = con.prepareStatement(query);
            pstt.setNString(1,account.getUsername());
            pstt.setNString(2,account.getPassword());
            pstt.setNString(3,account.getEmail());

            status = pstt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<Account> getAll(){
        List<Account> accs = new ArrayList<>();
        Account acc;
        con = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM accounts;";
        try {
            PreparedStatement pstt = con.prepareStatement(query);
            ResultSet rs = pstt.executeQuery();
            while (rs.next()){
               acc = new Account(
                        rs.getInt("id"),
                        rs.getInt("role_id"),
                        rs.getNString("username"),
                        rs.getNString("email"),
                        rs.getDate("created_date")
                );
               accs.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accs;
    }

    public int update(Account account){
        con = DBHelper.getInstance().getCon();
        int status = 0;
        String query = "Update accounts SET username = ?,password = MD5(?), email = ?, updated_date = CURDATE() WHERE id = ?;";
        try {
            PreparedStatement pstt = con.prepareStatement(query);
            pstt.setNString(1,account.getUsername());
            pstt.setNString(2,account.getPassword());
            pstt.setNString(3,account.getPassword());
            pstt.setInt(4,account.getId());
            status = pstt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public Account getById(int id){
        con = DBHelper.getInstance().getCon();
        Account acc = null;
        String query = "SELECT * FROM accounts WHERE id = ?;";
        try {
            PreparedStatement pstt = con.prepareStatement(query);
            pstt.setInt(1,id);
            ResultSet rs = pstt.executeQuery();
            while (rs.next()){
                acc = new Account(
                        id,
                        rs.getInt("role_id"),
                        rs.getNString("username"),
                        rs.getNString("email"),
                        rs.getDate("created_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }

    public int delete(int id) throws SQLException {
        int status = 0;
        con = DBHelper.getInstance().getCon();
        String query = "DELETE FROM accounts WHERE id = ?;";
        PreparedStatement pstt = con.prepareStatement(query);
        pstt.setInt(1,id);
        status = pstt.executeUpdate();

        return status;
    }

    public Account validate(String username,String password) throws SQLException {
        Account acc = null;
        int status = 0;
        con = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM accounts WHERE username = ? AND password = MD5(?);";
        PreparedStatement pstt = con.prepareStatement(query);
        pstt.setNString(1,username);
        pstt.setNString(2,password);
        ResultSet rs = pstt.executeQuery();
        while (rs.next()){
            acc = new Account(
                    rs.getInt("id"),
                    rs.getInt("role_id"),
                    rs.getNString("username"),
                    rs.getNString("email"),
                    rs.getDate("created_date")
            );
        }

        return acc;
    }


}
