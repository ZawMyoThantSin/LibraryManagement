package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.models.Genres;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenresDAO {

    private Connection con;

    //Create
    public int genresCreate(Genres genres){
        int status=0;
        con = DBHelper.getInstance().getCon();
        String query="INSERT INTO library.genres (genre_name) VALUE (?)";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,genres.getGenre_name());
            status=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    //getAll
    public List<Genres> getAllGenres(){
        List<Genres> genres=new ArrayList<>();
        ResultSet rs;
        con=DBHelper.getInstance().getCon();
        String query="SELECT * FROM library.genres";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()){
                Genres genre=new Genres();
                genre.setGenre_id(rs.getInt("genre_id"));
                genre.setGenre_name(rs.getString("genre_name"));
                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

}
