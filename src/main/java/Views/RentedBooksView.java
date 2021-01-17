package Views;

import javax.swing.*;
import java.sql.ResultSet;

public class RentedBooksView {
    private JDialog f;
    private JTable booksTable;
    private ResultSet rentedBooks;

    public RentedBooksView() {
        this.f = new JDialog();
        this.booksTable = new JTable();

        this.booksTable.setBounds(0,100,500,400);

        this.f.setTitle("Rented books");
        this.f.setSize(500,500);
        this.f.setLocationRelativeTo(null);
        this.f.setResizable(false);
        this.f.setLayout(null);

        this.f.add(this.booksTable);

        this.f.setVisible(true);
    }
}
