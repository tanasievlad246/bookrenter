package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DAO.DatabaseConnection;

public class Book {
    private String title;
    private String description;
    private String author;
    private String coverImage;
    private DatabaseConnection db;

    public Book() {
        this.db = new DatabaseConnection();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    //implement create book function
    public void createBook() {
        try {
            Statement stmt = db.connect.createStatement();
            stmt.executeUpdate("USE bookrenter");
            String sql = "INSERT INTO books (title, description, author, image) VALUES('"+title+"','"+description+ "','"+author+"',?)";
            PreparedStatement p = db.connect.prepareStatement(sql);
            p.setString(1,coverImage);
            p.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //implement get books model
    public ResultSet getRentedBooks() {
        try {
            Statement stmt = this.db.connect.createStatement();
            String sql = "SELECT * FROM rented_books";
            stmt.executeUpdate("USE bookrenter");
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public ResultSet getRentedByUser(String user_id) {
        try {
            String sql = "SELECT * FROM rented_books WHERE user_id="+user_id;
            Statement stmt = this.db.connect.createStatement();
            stmt.executeUpdate("USE bookrenter");
            return stmt.executeQuery(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public ResultSet getAllBooks() {
        try {
            String sql = "SELECT * FROM books";
            Statement stmt = this.db.connect.createStatement();
            stmt.executeUpdate("USE bookrenter");
            return stmt.executeQuery(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    //implement rent book
    public void rentBook(int bookId, int userId, String bookTitle, String username) throws SQLException {
        //prepared statement 4 indexes
        String sql = "INSERT INTO rented_books (user_id, book_id, username, book_title) VALUES(?, ?, ?, ?)";
        PreparedStatement preparedStatement = this.db.connect.prepareStatement(sql);
        preparedStatement.setInt(1,userId);
        preparedStatement.setInt(2,bookId);
        preparedStatement.setString(3,username);
        preparedStatement.setString(4,bookTitle);
        preparedStatement.execute();
    }

    public static void unrentBook(String bookId, String userId) {
        try {
            DatabaseConnection db = new DatabaseConnection();
            String sql = "DELETE FROM rented_books WHERE user_id='"+userId+"'AND book_id='"+bookId+"'";
            Statement stmt = db.connect.createStatement();
            stmt.executeUpdate("USE bookrenter");
            stmt.execute(sql);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
