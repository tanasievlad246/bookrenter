package Views;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

public class RentedBooksView {
    private JDialog f;
    private ResultSet rentedBooks;

    public RentedBooksView() {
        this.f = new JDialog();

        this.f.setTitle("Rented books");
        this.f.setSize(500,500);
        this.f.setLocationRelativeTo(null);
        this.f.setResizable(false);
        this.f.setVisible(true);
    }

    public void setRentedBooks(ResultSet rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public void renderBooks() throws SQLException {
        JTable bookList = new JTable();
        bookList.setModel(DbUtils.resultSetToTableModel(this.rentedBooks));
        JScrollPane scrollPane = new JScrollPane(bookList);
        this.f.add(scrollPane);
    }
}
