package com.jwd39.LibraryManagement.impls;

import com.jwd39.LibraryManagement.daos.AccountDao;
import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.models.Account;
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
public class AccountDaoImpl implements AccountDao {

    private Connection connection;
    private Account account;

    @Override
    public int save(Account account) {
        connection = DBHelper.getInstance().getCon();
        int status=0;
        String query= "INSERT INTO accounts (username,password,email,role_id,created_date,updated_date) VALUES (?,MD5(?),?,?,CURDATE(),CURDATE())";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setNString(1, account.getUsername());
            statement.setNString(2, account.getPassword());
            statement.setNString(3, account.getEmail());
            statement.setInt(4, account.getRole_id());
            status = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<Account> getAll()  {
        connection = DBHelper.getInstance().getCon();
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM accounts;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet set = statement.executeQuery();

        while (set.next()) {
            account = new Account(
                    set.getInt("id"),
                    set.getInt("role_id"),
                    set.getNString("username"),
                    set.getNString("password"),
                    set.getNString("email"),
                    set.getDate("created_date"),
                    set.getDate("updated_date")
            );
            accounts.add(account);
        }
        } catch (SQLException e) {
                e.printStackTrace();
            }
        return accounts;
    }

    @Override
    public int update(Account account) {
        connection = DBHelper.getInstance().getCon();
        int status=0;
        String query = "UPDATE accounts SET username=?,password=MD5(?),email=?,updated_date=CURDATE() WHERE id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setNString(1,account.getUsername());
            statement.setNString(2,account.getPassword());
            statement.setNString(3,account.getEmail());
            statement.setInt(4,account.getId());
            status = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public Account findById(int id) {
        connection = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM accounts WHERE id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet set = statement.executeQuery();
            if(set.next()) {
                account = new Account(
                        set.getInt("id"),
                        set.getInt("role_id"),
                        set.getNString("username"),
                        set.getNString("password"),
                        set.getNString("email"),
                        set.getDate("created_date"),
                        set.getDate("updated_date")
                );
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int disable(int id) {
        int status=0;
        String query = "DELETE FROM accounts WHERE id = ?";
        connection = DBHelper.getInstance().getCon();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            status= statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public Account validate(String email,String password) {
        connection = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM accounts WHERE email = ? AND password = MD5(?)";
        try (
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Account user = new Account();
                    user.setId(rs.getInt("id"));
                    user.setRole_id(rs.getInt("role_id"));
                    user.setUsername(rs.getString("username"));
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

    @Override
    public int delete(int id) {
        int status=0;
        String query = "DELETE FROM accounts WHERE id = ?";
        connection = DBHelper.getInstance().getCon();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            status= statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

}
