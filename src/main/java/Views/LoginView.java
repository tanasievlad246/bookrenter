package Views;

import Controllers.LoginController;

import javax.swing.*;

public class LoginView {
//    private LoginController loginController;
    private JFrame f;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JTextField passwordField;
    public JButton loginButton;


    public LoginView () {
        this.f = new JFrame("Login Controller");

        this.usernameLabel = new JLabel("Username");
        this.usernameLabel.setBounds(30,15,100,30);
        this.passwordLabel = new JLabel("Password");
        this.passwordLabel.setBounds(30,50,100,30);

        this.usernameField = new JTextField();
        this.usernameField.setBounds(110, 15, 200, 30);
        this.passwordField = new JTextField();
        this.passwordField.setBounds(110, 50, 200, 30);

        this.loginButton = new JButton("Login");
        this.loginButton.setBounds(130,90,80,25);

        f.setSize(370,200);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        f.add(this.usernameLabel);
        f.add(this.usernameField);
        f.add(this.passwordField);
        f.add(this.passwordField);
        f.add(this.loginButton);
        f.setVisible(true);
    }
}
