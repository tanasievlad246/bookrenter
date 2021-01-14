package Models;

public class User {
    private String username;
    private String password;
    private boolean adminStatus = false;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(boolean adminStatus) {
        this.adminStatus = adminStatus;
    }

    //implement create user if admin
    public void createAdmin() {

    }

    //implement create admin if admin
    public void createUser() {

    }
}
