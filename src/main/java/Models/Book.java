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
    public ResultSet getBooks() {
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

    //implement rent book
    public static void rentBook(int bookId, int userId){
        //implement renting book logic
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
