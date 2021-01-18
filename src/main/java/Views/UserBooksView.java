package Views;

import Models.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UserBooksView {
    private JDialog f;
    private ResultSet books;
    private String userId;
    private String username;
    private JScrollPane scrollPane;

    public UserBooksView() {
        this.f = new JDialog();
        this.f.setTitle("Books available");
        this.f.setSize(800,500);
        this.f.setLocationRelativeTo(null);
        this.f.setLayout(new FlowLayout());
        this.f.setResizable(false);
        this.f.setVisible(true);
    }


    public void setBooks(ResultSet books) {
        this.books = books;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void createBooksComponent() {
        JPanel pnl = new JPanel();
        int pnlHeight = 800, pnlWidth = 500;
        pnl.setLayout(new FlowLayout());
        pnl.setPreferredSize(new Dimension(pnlWidth, pnlHeight));

        JButton rent;
        JLabel title;
        JLabel desc;
        JLabel preview;
        ImageIcon img;

        try {
            while (this.books.next()) {
                JPanel comp = new JPanel();
                rent = new JButton("Rent");
                title = new JLabel(this.books.getString("title"));
                desc = new JLabel(this.books.getString("description"));
                img = this.createPreviewImage(this.books.getString("image"));
                preview = new JLabel();
                preview.setIcon(img);
                preview.setPreferredSize(new Dimension(300,300));

                String bookId = this.books.getString("book_id");
                String userId = this.userId;
                String username = this.username;
                String bookTitle = this.books.getString("title");

                //Grows the scrolling area in order to see all books
                pnlHeight += 200;

                rent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Book.rentBook(bookId, userId, bookTitle, username);
                    }
                });

                comp.setLayout(new FlowLayout(FlowLayout.LEADING));
                comp.add(title);
                comp.add(desc);
                comp.add(preview);
                comp.add(rent);
                pnl.add(comp);
            }
            this.scrollPane = new JScrollPane(pnl);
            scrollPane.setPreferredSize(new Dimension(800,500));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.getVerticalScrollBar().setUnitIncrement(20);
            this.f.add(this.scrollPane);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private ImageIcon createPreviewImage(String imagePath) {
        ImageIcon img = new ImageIcon(imagePath);
        Image getImage = img.getImage();
        Image newImg = getImage.getScaledInstance(250,200,Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}
