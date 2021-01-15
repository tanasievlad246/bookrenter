package Models;

import DAO.DatabaseConnection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class User {
    private String username;
    private String password;
    private boolean adminStatus;
    private DatabaseConnection db;

    public User() {
        this.db = new DatabaseConnection();
    }

    //implement create user if admin
    public void createAdmin() {

    }

    //implement create admin if admin
    public void createUser() {
        //implement create user logic
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
}
