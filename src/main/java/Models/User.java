package Models;

import DAO.DatabaseConnection;
import java.sql.Statement;

public class User {
    private String username;
    private String password;
    private boolean adminStatus;
    private DatabaseConnection db;
    private String userId;

    public User() {
        this.db = new DatabaseConnection();
    }

    //implement create admin if admin
    public void createUser() {
        try {
            Statement stmt = db.connect.createStatement();
            stmt.executeUpdate("USE bookrenter");
            String sql = "INSERT INTO users (username, password, admin) VALUES('"+this.username+"', '"+this.password+"',"+this.adminStatus+")";
            stmt.execute(sql);
            System.out.println("user created");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdminStatus(boolean status) {
        this.adminStatus = status;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdminStatus() {
        return adminStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
