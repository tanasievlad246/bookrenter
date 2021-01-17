package Views;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentedBooksView {
    private JDialog f;
    private JScrollPane scrollPane;
    private ResultSet rentedBooks;

    public RentedBooksView() {

        this.f = new JDialog();
        this.scrollPane = new JScrollPane();
        this.scrollPane.setSize(500,500);

        this.f.setTitle("Rented books");
        this.f.setSize(500,500);
        this.f.setLocationRelativeTo(null);
        this.f.setResizable(false);
        this.f.setLayout(null);

        this.f.add(this.scrollPane);
        this.f.setVisible(true);
    }

    public void setRentedBooks(ResultSet rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public void renderBooks() throws SQLException {
        while (this.rentedBooks.next()) {
            JPanel pane = new JPanel();
            JLabel title = new JLabel();
            JLabel username = new JLabel();
            pane.setSize(100,100);
            title.setText("Book title ->" + this.rentedBooks.getString("book_title"));
            username.setText("Rented by ->" + this.rentedBooks.getString("username"));
            pane.add(title);
            pane.add(username);
            this.f.add(pane);
        }
    }
}
