package Views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CreateUserView {
    private JFrame f;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField username;
    private JPasswordField password;
    private JRadioButton adminOption;
    private JButton createButton;

    public CreateUserView() {
        this.f = new JFrame("Create new user");
        this.usernameLabel = new JLabel("Username");
        this.passwordLabel = new JLabel("Password");
        this.username = new JTextField();
        this.password = new JPasswordField();
        this.adminOption = new JRadioButton();
        this.createButton = new JButton("Create");

        this.adminOption.setText("Admin");

        int labelWidth = 100, labelHeight = 30;
        int textFieldWidth = 200, textFieldHeight = 30;

        this.usernameLabel.setBounds(30,15,labelWidth,labelHeight);
        this.username.setBounds(140,15,textFieldWidth,textFieldHeight);
        this.passwordLabel.setBounds(30,50,labelWidth,labelHeight);
        this.password.setBounds(140,50,textFieldWidth,textFieldHeight);
        this.adminOption.setBounds(140,85,100,25);
        this.createButton.setBounds(150,120,100,25);

        this.f.add(usernameLabel);
        this.f.add(username);
        this.f.add(passwordLabel);
        this.f.add(password);
        this.f.add(adminOption);
        this.f.add(createButton);

        this.f.setSize(400,200);
        this.f.setLayout(null);
        this.f.setResizable(false);
        this.f.setLocationRelativeTo(null);
        this.f.setVisible(true);
    }

    public void setCreateButtonAction(ActionListener actionListener) {
        this.createButton.addActionListener(actionListener);
    }

    public String getUsernameText() {
        return this.username.getText();
    }

    public String getUserPassword() {
        return this.password.getText();
    }

    public boolean getRadioButtonValue() {
        return this.adminOption.isSelected();
    }
}
