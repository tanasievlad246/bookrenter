package Views;

import javax.swing.*;
import java.sql.ResultSet;

public class UserBooksView {
    private JDialog f;
    private ResultSet books;

    public UserBooksView() {
        this.f = new JDialog();
        this.f.setTitle("Books available");
        this.f.setSize(500,500);
        this.f.setLocationRelativeTo(null);
        this.f.setResizable(false);
        this.f.setVisible(true);
    }


    public void setBooks(ResultSet books) {
        this.books = books;
    }
}
