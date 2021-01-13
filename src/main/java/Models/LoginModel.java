package Models;

import DAO.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginModel {
    private DatabaseConnection db;

    public LoginModel() {
        this.db = new DatabaseConnection();
    }

    //implement login check data
    public ResultSet getUserForLogin(String username, String password) {
        try {
            Statement stmt = db.connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate("USE bookrenter");
            String query = "SELECT * FROM users WHERE username ='"+username+"' AND password ='"+password+"'";
            ResultSet rs = stmt.executeQuery(query);

            return rs;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
