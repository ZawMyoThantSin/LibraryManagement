package com.jwd39.LibraryManagement.impls;

import com.jwd39.LibraryManagement.daos.BookDao;
import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.models.BookDetails;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {
    private Connection connection;
    private BookDetails book;


    @Override
    public int save(BookDetails book) {
        connection = DBHelper.getInstance().getCon();
        int status= 0;
        String query ="INSERT INTO books (bookname,description,genre_id,author_id,cover_image_name,book_file_name,created_date,updated_date) VALUES (?,?,?,?,?,?,CURDATE(),CURDATE());";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,book.getBookName());
            statement.setString(2,book.getDescription());
            statement.setInt(3,book.getGenreId());
            statement.setInt(4,book.getAuthorId());
            statement.setString(5,book.getImageName());
            statement.setString(6,book.getFileName());
            status =statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int update(BookDetails book) {
        connection = DBHelper.getInstance().getCon();
        int status=0;
        String query="UPDATE books SET bookname =?, description=?,genreid=?,authorid=?,cover_image_name=?,updated_date= CURDATE() WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setNString(1,book.getBookName());
            statement.setNString(2,book.getDescription());
            statement.setInt(3,book.getGenreId());
            statement.setInt(4,book.getAuthorId());
            statement.setString(5,book.getImageName());
            statement.setInt(6,book.getBookId());

            status =statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public List<BookDetails> getAll() {
        connection = DBHelper.getInstance().getCon();
        List<BookDetails> books = new ArrayList<>();
        String query= "SELECT * FROM books INNER JOIN genres ON books.genre_id=genres.genre_id INNER JOIN authors ON books.author_id=authors.author_id";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs= statement.executeQuery();
            while (rs.next()) {
                BookDetails book = new BookDetails();
                book.setBookId( rs.getInt("book_id"));
                book.setBookName( rs.getNString("bookname"));
                book.setDescription(rs.getNString("description"));
                book.setGenreId(rs.getInt("genre_id"));
                book.setGenreName(rs.getString("genre_name"));
                book.setAuthorId(rs.getInt("author_id"));
                book.setAuthorName(rs.getString("authorname"));
                book.setImageName(rs.getNString("cover_image_name"));
                book.setFileName(rs.getNString("book_file_name"));
                book.setCreated_date(rs.getDate("created_date"));
                book.setUpdated_date( rs.getDate("updated_date"));
                book.setIs_delete(rs.getByte("is_delete"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public BookDetails findById(int id) {
        connection = DBHelper.getInstance().getCon();
        String query= "SELECT * FROM books INNER JOIN genres ON books.genre_id=genres.genre_id INNER JOIN authors ON books.author_id=authors.author_id WHERE book_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                book = new BookDetails(
                        rs.getInt("book_id"),
                        rs.getNString("bookname"),
                        rs.getNString("description"),
                        rs.getNString("cover_image_name"),
                        rs.getString("book_file_name"),
                        rs.getInt("genre_id"),
                        rs.getInt("author_id"),
                        rs.getString("genre_name"),
                        rs.getString("authorname"),
                        rs.getDate("created_date"),
                        rs.getDate("updated_date"),
                        rs.getInt("is_delete")
                );
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int disable(int id) {
        connection = DBHelper.getInstance().getCon();
        int status=0;
        String query="UPDATE books SET is_delete=1,updated_date= CURDATE() WHERE book_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            status =statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int restoreAll() {
        return 0;
    }

    @Override
    public int restore(int id) {
        connection = DBHelper.getInstance().getCon();
        int status=0;
        String query="UPDATE books SET is_delete=0,updated_date= CURDATE() WHERE book_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            status =statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int delete(int id) {
        connection = DBHelper.getInstance().getCon();
        int status = 0;
        String query = "DELETE FROM books where book_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            status=  statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
