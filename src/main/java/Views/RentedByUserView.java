package Views;

import Models.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RentedByUserView {
    private JFrame f;
    private ResultSet rentedBooks;
    private JScrollPane scrollPane;

    public RentedByUserView() {
        this.f = new JFrame();
        this.f.setTitle("Rented books");
        this.f.setSize(500,500);
        this.f.setLocationRelativeTo(null);
        this.f.setLayout(new FlowLayout());
        this.f.setResizable(false);
        this.f.setVisible(true);
    }

    public void setRentedBooks(ResultSet rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public void createBooksComponents() {
        JPanel pnl = new JPanel();
        pnl.setLayout(new FlowLayout());
        pnl.setPreferredSize(new Dimension(450, 450));

        JButton unrent;
        JLabel title;

        try {
            while (this.rentedBooks.next()) {
                System.out.println(this.rentedBooks.getString("username"));
                JPanel comp = new JPanel();
                unrent = new JButton("Unrent");
                title = new JLabel("Rented: "+this.rentedBooks.getString("book_title"));

                String bookId = this.rentedBooks.getString("book_id");
                String userId = this.rentedBooks.getString("user_id");

                unrent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Book.unrentBook(bookId, userId);
                        f.repaint();
                        f.revalidate();
                    }
                });

                comp.add(title);
                comp.add(unrent);
                pnl.add(comp);
            }
            this.scrollPane = new JScrollPane(pnl);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.getVerticalScrollBar().setUnitIncrement(20);
            this.f.add(this.scrollPane);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
