package Views;

import Controllers.UserController;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AdminView {
    private JFrame f;
    private JButton addBook;
    private JButton createUser;
    private JButton viewRented;


    public AdminView() {
        this.f = new JFrame("Admin view");

        this.addBook = new JButton("Add book");
        this.createUser = new JButton("Create user");
        this.viewRented = new JButton("View rented books");

        int btnWidth = 150, btnHeight = 50;

        this.addBook.setBounds(50,15,btnWidth,btnHeight);
        this.createUser.setBounds(50,75,btnWidth,btnHeight);
        this.viewRented.setBounds(50,135,btnWidth,btnHeight);

        this.f.add(this.addBook);
        this.f.add(this.createUser);
        this.f.add(this.viewRented);
        this.f.setLayout(null);
        this.f.setSize(260,250);
        this.f.setResizable(false);
        this.f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.f.setLocationRelativeTo(null);
        this.f.setVisible(true);
    }

    public void addActionListener(ActionListener actionListener, JButton button) {
        button.addActionListener(actionListener);
    }

    public JButton getCreateUserButton() {
        return this.createUser;
    }
}
