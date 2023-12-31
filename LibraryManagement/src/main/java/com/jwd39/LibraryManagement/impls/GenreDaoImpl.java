package com.jwd39.LibraryManagement.impls;

import com.jwd39.LibraryManagement.daos.GenreDao;
import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.models.Genre;
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
public class GenreDaoImpl implements GenreDao {
    private Connection connection;
    private Genre genre;

    @Override
    public int save(Genre genre) {
        connection = DBHelper.getInstance().getCon();
        int status =0;
        String query="INSERT INTO genres (genre_name,created_date,updated_date) VALUES (?,CURRENT_DATE,CURRENT_DATE)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,genre.getGenre_name());
            status=statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> genres = new ArrayList<>();
        connection = DBHelper.getInstance().getCon();
        String query="SELECT * FROM genres";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                genre = new Genre();
                genre.setGenre_id(rs.getInt("genre_id"));
                genre.setGenre_name(rs.getString("genre_name"));
                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    @Override
    public int delete(int id) {
        connection = DBHelper.getInstance().getCon();
        int status =0;
        String query="DELETE FROM genres WHERE genre_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            status=statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public Genre findById(int id) {
        connection = DBHelper.getInstance().getCon();
        String query = "SELECT * FROM genres WHERE id =?";
        ResultSet set;
        try {
            PreparedStatement statement= connection.prepareStatement(query);
            set = statement.executeQuery();
            while (set.next()){
                genre.setGenre_id(set.getInt("genre_id"));
                genre.setGenre_name(set.getString("genre_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genre;
    }
}
