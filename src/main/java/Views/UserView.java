package Views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class UserView {
    private JFrame f;
    private JButton rentBooks;
    private JButton viewRented;
    private String username;
    private String user_id;

    public UserView(String username, String user_id) {
        this.username = username;
        this.user_id = user_id;

        this.f = new JFrame("User view");
        this.rentBooks = new JButton("View books");
        this.viewRented = new JButton("View rented books");

        int btnWidth = 150, btnHeight = 50;

        this.rentBooks.setBounds(50,15,btnWidth,btnHeight);
        this.viewRented.setBounds(50,75,btnWidth,btnHeight);

        this.f.add(rentBooks);
        this.f.add(viewRented);

        this.f.setSize(250,190);
        this.f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.f.setLocationRelativeTo(null);
        this.f.setLayout(null);
        this.f.setResizable(false);
        this.f.setVisible(true);
    }

    private void setActionListener(ActionListener actionListener, JButton button) {
        button.addActionListener(actionListener);
    }

    public JButton getRentBooks() {
        return rentBooks;
    }

    public JButton getViewRented() {
        return viewRented;
    }

    public String getUsername() {
        return username;
    }

    public String getUser_id() {
        return user_id;
    }
}
