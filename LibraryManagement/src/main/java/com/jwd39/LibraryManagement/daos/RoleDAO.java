package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.models.Roles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {

    private Connection con;
    private Roles role;

    //Role Create
    //------------------------------------------------------------------------------------------------------------------
    public int roleCreate(Roles role) throws SQLException {
        int status = 0;
        String query = "INSERT INTO roles (rolename,created_date,updated_date) VALUES (?,CURDATE(),CURDATE()_;";
        con = DBHelper.getInstance().getCon();
        PreparedStatement pstt = con.prepareStatement(query);
        pstt.setNString(1, role.getRolename());
        status = pstt.executeUpdate();
        DBHelper.getInstance().closeConnection();
        return status;
    }

    //Get All Role Data
    //------------------------------------------------------------------------------------------------------------------
    public List<Roles> allRoleData() throws SQLException {

        List<Roles> roles = new ArrayList<>();
        con = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM roles;";
        PreparedStatement pstt = con.prepareStatement(query);
        ResultSet rs = pstt.executeQuery();
        while (rs.next()) {
            role = new Roles(
                    rs.getInt("role_id"),
                    rs.getNString("rolename"),
                    rs.getDate("created_date"),
                    rs.getDate("updated_date")
            );
            roles.add(role);
        }
        DBHelper.getInstance().closeConnection();
        return roles;
    }

    //Get Role Data By ID
    //------------------------------------------------------------------------------------------------------------------
    public Roles roleDataById(int id) throws SQLException {
        con = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM roles WHERE role_id = ?;";
        PreparedStatement pstt = con.prepareStatement(query);
        ResultSet rs = pstt.executeQuery();
        while (rs.next()) {
            role = new Roles(
                    rs.getInt("role_id"),
                    rs.getNString("rolename"),
                    rs.getDate("created_date"),
                    rs.getDate("updated_date")
            );
        }
        DBHelper.getInstance().getCon();
        return role;
    }

    //Role Update
    //------------------------------------------------------------------------------------------------------------------
    public int updateRole(Roles role) throws SQLException {
        int status = 0;
        con = DBHelper.getInstance().getCon();
        String query = "UPDATE roles rolename,updated_date SET rolename = ?, updated_date = CURDATE() WHERE role_id = ?;";
        PreparedStatement pstt = con.prepareStatement(query);
        pstt.setNString(1,role.getRolename());
        pstt.setInt(2,role.getRole_id());
        status = pstt.executeUpdate();
        DBHelper.getInstance().closeConnection();
        return status;
    }

    //Role Delete
    //------------------------------------------------------------------------------------------------------------------
    public int deleteRole(int id) throws SQLException {
        con = DBHelper.getInstance().getCon();
        String query = "DELETE FROM roles WHERE role_id = ?;";
        int status = 0;
        PreparedStatement pstt = con.prepareStatement(query);
        pstt.setInt(1,id);
        status = pstt.executeUpdate();

        DBHelper.getInstance().closeConnection();
        return status;
    }
}
