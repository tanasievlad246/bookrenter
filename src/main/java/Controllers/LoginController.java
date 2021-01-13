package Controllers;

import Models.LoginModel;
import Views.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginController(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;

        loginView.addLoginAction(login());
    }

    //implement login function
    private ActionListener login() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginView.getUsername();
                String password = loginView.getPasswrod();

                if (username.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER A USERNAME OR PASSWORD");
                } else {
                    ResultSet rs = loginModel.getUserForLogin(username,password);
                    try {
                        if (!rs.next()) {
                            JOptionPane.showMessageDialog(null,"WRONG USERNAME OR PASSWORD");
                        } else {
                            rs.beforeFirst();
                            while (rs.next()) {
                                if (rs.getString("admin").equals("1")) {
                                    loginView.endView("admin");
                                } else {
                                    loginView.endView("user");
                                }
                            }
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                }
            }
        };
    }
}
