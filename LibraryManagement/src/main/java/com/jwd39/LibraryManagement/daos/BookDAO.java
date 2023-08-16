package com.jwd39.LibraryManagement.daos;

import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.models.Books;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private Connection con;
    private Books book;

    //Book Create
    //---------------------------------------------------------------------
    public int addBook(Books book) throws SQLException {
        int status = 0;
        String query = "INSERT INTO books (bookname,description,genre_id,author_id,cover_image_name,created_date,updated_date) VALUES (?,?,?,?,?,CURDATE(),CURDATE());";
        con = DBHelper.getInstance().getCon();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,book.getBookname());
        ps.setString(2,book.getDescription());
        ps.setInt(3,book.getGenre_id());
        ps.setInt(4,book.getAuthor_id());
        ps.setString(5,book.getCover_image_name());

        status =ps.executeUpdate();

        return status;
    }

    //GetBookID
    //---------------------------------------------------------
    public Books getBookById(int id) throws SQLException {
        con=DBHelper.getInstance().getCon();
        String query = "SELECT * FROM books WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            book = new Books(
                    rs.getInt("id"),
                    rs.getNString("bookname"),
                    rs.getNString("description"),
                    rs.getInt("genre_id"),
                    rs.getInt("author_id"),
                    rs.getNString("cover_image_name"),
                    rs.getTimestamp("create_date"),
                    rs.getTimestamp("updated_date")
            );

        }
        return book;
    }

    //GetAllBook
    //------------------------------------------
    public List<Books> getAllBook() throws SQLException {
        List<Books> books = new ArrayList<>();
        con= DBHelper.getInstance().getCon();
        String query= "SELECT * FROM books";
        PreparedStatement ps= con.prepareStatement(query);
        ResultSet rs= ps.executeQuery();
        while (rs.next()) {
            book = new Books(
                    rs.getInt("id"),
                    rs.getNString("bookname"),
                    rs.getNString("description"),
                    rs.getInt("genre_id"),
                    rs.getInt("author_id"),
                    rs.getNString("cover_image_name"),
                    rs.getTimestamp("created_date"),
                    rs.getTimestamp("updated_date"));
            books.add(book);
        }
        return books;
    }

    //Updatebooks
    public int updateBook() throws SQLException {
       int status = 0;
       con = DBHelper.getInstance().getCon();
       String query="UPDATE books bookname,description,genreid,authorid,cover_image_name,updated_date SET bookname =?, description=?,genreid=?,authorid=?,cover_image_name=?,updated_date= CURDATE() WHERE id=?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setNString(1,book.getBookname());
        ps.setNString(2,book.getDescription());
        ps.setInt(3,book.getGenre_id());
        ps.setInt(4,book.getAuthor_id());
        ps.setString(5,book.getCover_image_name());
        ps.setInt(6,book.getId());

        status =ps.executeUpdate();
        return status;
    }

    //BookDelete
    public int deleteBook(int id) throws SQLException {
        con= DBHelper.getInstance().getCon();
        String query = "DELETE FROM books where id=?";
        int status=0;
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1,id);
        status=  ps.executeUpdate();

        return status;
    }



}
