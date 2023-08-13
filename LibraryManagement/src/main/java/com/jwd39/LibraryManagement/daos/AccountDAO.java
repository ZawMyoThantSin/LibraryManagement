package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.models.Accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    private Connection con;
    private Accounts user;

    //Account Login
    //---------------------------------------------------------------------------------------------------------------
    public Accounts acLogIn(Accounts acc) throws SQLException {

        String query = "SELECT * FROM accounts WHERE usrname = ? AND password = ?;";
        con = DBHelper.getInstance().getCon();
        try {
            PreparedStatement pstt = con.prepareStatement(query);
            pstt.setString(1, acc.getUsername());
            pstt.setString(2, acc.getPassword());
            ResultSet rs = pstt.executeQuery();
            while (rs.next()) {
                this.user = new Accounts(
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

        DBHelper.getInstance().closeConnection();
        return this.user;
    }

    //Account Register
    //-----------------------------------------------------------------------------------------------------------------
    public int acRegister(Accounts acc) throws SQLException {

        con = DBHelper.getInstance().getCon();
        int status = 0;
        String query = "INSERT INTO accounts (usrname,password,email,role_id,created_date,updated_date) VALUES (?,?,?,?,CURDATE(),CURDATE());";
        PreparedStatement pstt = con.prepareStatement(query);
        pstt.setNString(1, acc.getUsername());
        pstt.setNString(2, acc.getPassword());
        pstt.setNString(3, acc.getEmail());
        pstt.setInt(4, acc.getRole_id());

        status = pstt.executeUpdate();

        DBHelper.getInstance().closeConnection();

        return status;
    }

    //Get All Account Data
    //------------------------------------------------------------------------------------------------------------------
    public List<Accounts> allACData() throws SQLException {
        List<Accounts> accs = new ArrayList<>();
        con = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM accounts;";
        PreparedStatement pstt = con.prepareStatement(query);
        ResultSet rs = pstt.executeQuery();
        while (rs.next()) {
            user = new Accounts(
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
        DBHelper.getInstance().closeConnection();
        return accs;
    }

    //Get Account Data by ID
    //------------------------------------------------------------------------------------------------------------------
    public Accounts acDataByID(int id) throws SQLException {
        con = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM accounts WHERE id = ?;";
        PreparedStatement pstt = con.prepareStatement(query);
        pstt.setInt(1, id);
        ResultSet rs = pstt.executeQuery();
        while (rs.next()) {
            user = new Accounts(
                    rs.getInt("id"),
                    rs.getInt("role_id"),
                    rs.getNString("usrname"),
                    rs.getNString("password"),
                    rs.getNString("email"),
                    rs.getDate("created_date"),
                    rs.getDate("updated_date")
            );
        }
        DBHelper.getInstance().closeConnection();
        return user;
    }

    // Account Data Updating
    //------------------------------------------------------------------------------------------------------------------
    public int updateAC(Accounts acc) throws SQLException {
        int status = 0;
        con = DBHelper.getInstance().getCon();
        String query = "UPDATE accounts username, password, email, role_id, updated_date SET username=?,password=?,email=?,updated_data=CURDATE() WHERE id = ?;";
        PreparedStatement pstt = con.prepareStatement(query);
        pstt.setNString(1,acc.getUsername());
        pstt.setNString(2,acc.getPassword());
        pstt.setNString(3,acc.getEmail());
        pstt.setInt(4,acc.getId());
        status = pstt.executeUpdate();

        DBHelper.getInstance().getCon();
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

        DBHelper.getInstance().closeConnection();
        return status;
    }
}
