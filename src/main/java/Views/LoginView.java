package Views;

import Controllers.LoginController;

import javax.swing.*;

public class LoginView {
    private LoginController loginController;
    private JFrame f;

    public LoginView (LoginController loginController) {
        this.loginController = loginController;
        this.f = new JFrame("Login Controller");
        f.setSize(370,200);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void init() {
        constructLoginForm();
        f.setVisible(true);
    }

    private void constructLoginForm() {
        JLabel username, password;

        username = new JLabel("username");
        username.setBounds(30,15,100,30);

        password = new JLabel("Password");
        password.setBounds(30,50,100,30);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(110, 15, 200, 30);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(110, 50, 200, 30);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(130,90,80,25);
        loginButton.addActionListener(this.loginController.login());

        f.add(username);
        f.add(usernameField);
        f.add(password);
        f.add(passwordField);
        f.add(loginButton);
    }
}
