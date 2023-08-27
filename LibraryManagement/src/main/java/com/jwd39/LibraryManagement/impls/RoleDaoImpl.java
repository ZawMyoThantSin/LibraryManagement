package com.jwd39.LibraryManagement.impls;

import com.jwd39.LibraryManagement.daos.RoleDao;
import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.models.Role;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
    private Connection connection;
    private Role role;


    @Override
    public int save(Role role) {
        int status = 0;
        connection =DBHelper.getInstance().getCon();
        String query = "INSERT INTO roles (rolename,created_date,updated_date) VALUES (?,CURDATE(),CURDATE()_;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setNString(1, role.getRolename());
            status = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Role> getAll() {
        connection = DBHelper.getInstance().getCon();
        List<Role> roles = new ArrayList<>();
        String query = "SELECT * FROM roles";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                role = new Role(
                        rs.getInt("role_id"),
                        rs.getNString("rolename"),
                        rs.getDate("created_date"),
                        rs.getDate("updated_date")
                );
                roles.add(role);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public int update(Role role) {
        int status =0;
        connection =DBHelper.getInstance().getCon();
        String query = "UPDATE roles rolename,updated_date SET rolename = ?, updated_date = CURDATE() WHERE role_id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,role.getRolename());
            statement.setInt(2,role.getRole_id());
            status = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public Role getById(int id) {
        connection =DBHelper.getInstance().getCon();
        String query = "SELECT * FROM roles WHERE role_id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                role = new Role(
                        rs.getInt("role_id"),
                        rs.getString("rolename"),
                        rs.getDate("created_date"),
                        rs.getDate("updated_date")
                );
            }
//           return role;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }

    @Override
    public int delete(int id) {
        int status = 0;
        connection = DBHelper.getInstance().getCon();
        String query = "DELETE FROM roles WHERE role_id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            status = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }
}
