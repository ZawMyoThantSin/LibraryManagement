package com.jwd39.LibraryManagement.impls;

import com.jwd39.LibraryManagement.daos.BookDao;
import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.models.Book;
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
public class BookDaoImpl implements BookDao {
    private Connection connection;
    private Book book;
    @Override
    public int save(Book book) {
        connection = DBHelper.getInstance().getCon();
        int status= 0;
        String query ="INSERT INTO books (bookname,description,genre_id,author_id,cover_image_name,created_date,updated_date) VALUES (?,?,?,?,?,CURDATE(),CURDATE());";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,book.getBookName());
            statement.setString(2,book.getDescription());
            statement.setInt(3,book.getGenre_id());
            statement.setInt(4,book.getAuthor_id());
            statement.setString(5,book.getImageName());
            status =statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int update(Book book) {
        connection = DBHelper.getInstance().getCon();
        int status=0;
        String query="UPDATE books SET bookname =?, description=?,genreid=?,authorid=?,cover_image_name=?,updated_date= CURDATE() WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setNString(1,book.getBookName());
            statement.setNString(2,book.getDescription());
            statement.setInt(3,book.getGenre_id());
            statement.setInt(4,book.getAuthor_id());
            statement.setString(5,book.getImageName());
            statement.setInt(6,book.getBook_id());

            status =statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public List<Book> getAll() {
        connection = DBHelper.getInstance().getCon();
        List<Book> books = new ArrayList<>();
        String query= "SELECT * FROM books";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs= statement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBook_id( rs.getInt("book_id"));
                book.setBookName( rs.getNString("bookname"));
                book.setDescription(rs.getNString("description"));
                book.setGenre_id(rs.getInt("genre_id"));
                book.setAuthor_id(rs.getInt("author_id"));
                book.setImageName(rs.getNString("cover_image_name"));
                book.setCreated_date(rs.getTimestamp("created_date"));
                book.setUpdated_date( rs.getTimestamp("updated_date"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book getById(int id) {
        connection = DBHelper.getInstance().getCon();
        String  query = "SELECT * FROM books WHERE book_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                book = new Book(
                        rs.getInt("book_id"),
                        rs.getInt("genre_id"),
                        rs.getInt("author_id"),
                        rs.getNString("bookname"),
                        rs.getNString("description"),
                        rs.getNString("cover_image_name"),
                        rs.getTimestamp("create_date"),
                        rs.getTimestamp("updated_date")
                );
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
