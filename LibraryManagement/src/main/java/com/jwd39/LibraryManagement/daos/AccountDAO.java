package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    private Connection con;
    private Account user;

    //Account Login
    //---------------------------------------------------------------------------------------------------------------
    public Account userValidate(String username, String password) {
        Connection connection = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM accounts WHERE usrname = ? AND password = ?";
        try (
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Account user = new Account();
                    user.setId(rs.getInt("id"));
                    user.setRole_id(rs.getInt("role_id"));
                    user.setUsrname(rs.getString("usrname"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setCreated_date(rs.getDate("created_date"));
                    user.setUpdated_date(rs.getDate("updated_date"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account acLogIn(String userName,String password)
            throws SQLException {
        String query = "SELECT * FROM accounts WHERE usrname = ? AND password = ?";
        con = DBHelper.getInstance().getCon();
        try {
            PreparedStatement pstt = con.prepareStatement(query);
            pstt.setString(1,userName);
            pstt.setString(2, password);
            ResultSet rs = pstt.executeQuery();
            while (rs.next()) {
                this.user = new Account(
                        rs.getInt("id"),
                        rs.getInt("role_id"),
                        rs.getNString("usrname"),
                        rs.getNString("password"),
                        rs.getNString("email"),
                        rs.getDate("created_date"),
                        rs.getDate("updated_date")
                );
            }
        } catch (SQLException e) {

        }

        return this.user;
    }

    //Account Register
    //-----------------------------------------------------------------------------------------------------------------
    public int acRegister(Account acc) throws SQLException {

        con = DBHelper.getInstance().getCon();
        int status = 0;
        String query = "INSERT INTO accounts (usrname,password,email,role_id,created_date,updated_date) VALUES (?,?,?,?,CURDATE(),CURDATE());";
        PreparedStatement pstt = con.prepareStatement(query);
        pstt.setNString(1, acc.getUsrname());
        pstt.setNString(2, acc.getPassword());
        pstt.setNString(3, acc.getEmail());
        pstt.setInt(4, acc.getRole_id());

        status = pstt.executeUpdate();
        return status;
    }

    //Get All Account Data
    //------------------------------------------------------------------------------------------------------------------
    public List<Account> allACData() throws SQLException {
        List<Account> accs = new ArrayList<>();
        con = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM accounts;";
        PreparedStatement pstt = con.prepareStatement(query);
        ResultSet rs = pstt.executeQuery();
        while (rs.next()) {
            user = new Account(
                    rs.getInt("id"),
                    rs.getInt("role_id"),
                    rs.getNString("usrname"),
                    rs.getNString("password"),
                    rs.getNString("email"),
                    rs.getDate("created_date"),
                    rs.getDate("updated_date")
            );
            accs.add(user);
        }
        return accs;
    }

    //Get Account Data by ID
    //------------------------------------------------------------------------------------------------------------------
    public Account acDataByID(int id) throws SQLException {
        con = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM accounts WHERE id = ?;";
        PreparedStatement pstt = con.prepareStatement(query);
        pstt.setInt(1, id);
        ResultSet rs = pstt.executeQuery();
        while (rs.next()) {
            user = new Account(
                    rs.getInt("id"),
                    rs.getInt("role_id"),
                    rs.getNString("usrname"),
                    rs.getNString("password"),
                    rs.getNString("email"),
                    rs.getDate("created_date"),
                    rs.getDate("updated_date")
            );
        }
        return user;
    }

    // Account Data Updating
    //------------------------------------------------------------------------------------------------------------------
    public int updateAC(Account acc) throws SQLException {
        int status = 0;
        con = DBHelper.getInstance().getCon();
        String query = "UPDATE accounts usrname, password, email, role_id, updated_date SET usrname=?,password=?,email=?,updated_data=CURDATE() WHERE id = ?;";
        PreparedStatement pstt = con.prepareStatement(query);
        pstt.setNString(1,acc.getUsrname());
        pstt.setNString(2,acc.getPassword());
        pstt.setNString(3,acc.getEmail());
        pstt.setInt(4,acc.getId());
        status = pstt.executeUpdate();

        return status;
    }

    //Account Deleting
    //------------------------------------------------------------------------------------------------------------------
    public int deleteAC(int id) throws SQLException {
        con = DBHelper.getInstance().getCon();
        int status = 0;
        String query = "DELETE FROM accounts WHERE id = ?;";
        PreparedStatement pstt= con.prepareStatement(query);
        pstt.setInt(1,id);
        status = pstt.executeUpdate();

        return status;
    }
}
