package com.jwd39.LibraryManagement.impls;

import com.jwd39.LibraryManagement.helpers.DBHelper;
import com.jwd39.LibraryManagement.models.AccountsReadsBooks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRecent {
    private Connection con;

    public List<AccountsReadsBooks> getRecentList(int user_id){
        con = DBHelper.getInstance().getCon();
        List<AccountsReadsBooks> recents = new ArrayList<>();
        String query = "SELECT r.created_date,b.book_id,b.bookname,a.author_id,a.authorname,r.rate FROM accounts_read_books r INNER JOIN books b ON r.book_id = b.book_id INNER JOIN authors a ON a.author_id = b.author_id WHERE user_id = ? ORDER BY r.created_date DESC;";

        try {
            PreparedStatement pstt = con.prepareStatement(query);
            pstt.setInt(1,user_id);
            ResultSet rs = pstt.executeQuery();
            while(rs.next()){
                AccountsReadsBooks recent = new AccountsReadsBooks();
                recent.setCreated_date(rs.getDate("created_date"));
                recent.setBook_id(rs.getInt("book_id"));
                recent.setBook_name(rs.getString("bookname"));
                recent.setAccount_id(rs.getInt("author_id"));
                recent.setAuthor_name(rs.getString("authorname"));
                recent.setRate(rs.getInt("rate"));
                recents.add(recent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recents;
    }
    public boolean saveTransaction(AccountsReadsBooks recent){
        boolean result = false;
        con = DBHelper.getInstance().getCon();
        String query = "INSERT INTO accounts_read_books (book_id,rate,created_date,updated_date,user_id) VALUES (?,?,CURDATE(),CURDATE(),?);";
        try {
            PreparedStatement pstt = con.prepareStatement(query);
            pstt.setInt(1,recent.getBook_id());
            pstt.setInt(2,recent.getRate());
            pstt.setInt(3,recent.getUser_id());

            int status = pstt.executeUpdate();
            if(status > 0){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
