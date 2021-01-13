package DAO;

import java.sql.*;

public class DatabaseConnection {
    public Connection connect;

    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connect = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root");
        }catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}
