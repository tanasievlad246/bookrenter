package Views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AddBookView {
    private JFrame f;
    private JLabel bookTitleLabel;
    private JLabel bookDescriptionLabel;
    private JTextField bookTitle;
    private JTextField bookDescription;
    private JButton addBook;

    public AddBookView() {
        this.f = new JFrame("Add Book");
        this.bookTitleLabel = new JLabel("Book title");
        this.bookDescriptionLabel = new JLabel("Book description");
        this.bookTitle = new JTextField();
        this.bookDescription = new JTextField();
        this.addBook = new JButton("Add book");

        int labelWidth = 100, labelHeight = 30;
        int textFieldWidth = 200, textFieldHeight = 30;

        this.bookTitleLabel.setBounds(30,15,labelWidth,labelHeight);
        this.bookTitle.setBounds(140,15,textFieldWidth,textFieldHeight);
        this.bookDescriptionLabel.setBounds(30,50,labelWidth,labelHeight);
        this.bookDescription.setBounds(140,50,textFieldWidth,textFieldHeight);
        this.addBook.setBounds(150,90,100,25);

        this.f.add(bookTitleLabel);
        this.f.add(bookTitle);
        this.f.add(bookDescriptionLabel);
        this.f.add(bookDescription);
        this.f.add(addBook);

        this.f.setSize(400,200);
        this.f.setLayout(null);
        this.f.setResizable(false);
        this.f.setLocationRelativeTo(null);
        this.f.setVisible(true);
    }

    public void addBookActionListener(ActionListener actionListener) {
        this.addBook.addActionListener(actionListener);
    }
}
