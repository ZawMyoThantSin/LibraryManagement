package com.jwd39.LibraryManagement.impls;

import com.jwd39.LibraryManagement.daos.AuthorDAO;
import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.models.Author;
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
public class AuthorDAOImpl implements AuthorDAO {
    private Connection connection;
    private Author author;
    @Override
    public int save(Author author) {
        int status =0;
        connection = DBHelper.getInstance().getCon();
        String query = "INSERT INTO authors(author_name,created_date,updated_date,is_delete) VALUES(?,CURDATE(),CURDATE(),0)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,author.getAuthor_name());
            status = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Author> getAll() {
        connection = DBHelper.getInstance().getCon();
        List<Author> authors = new ArrayList<>();
        String query = "SELECT * FROM authors;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                author = new Author(
                        set.getInt("author_id"),
                        set.getNString("authorname"),
                        set.getDate("created_date"),
                        set.getDate("updated_date"),
                        set.getInt("is_delete")
                );
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public Author findById(int id) {
        connection = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM authors WHERE authors.author_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            if(set.next()) {
                author = new Author(
                        set.getInt("author_id"),
                        set.getString("authorname"),
                        set.getDate("created_date"),
                        set.getDate("updated_date"),
                        set.getInt("is_delete")
                );
                return author;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
