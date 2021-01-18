package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddBookView {
    private JFrame f;
    private JLabel bookTitleLabel;
    private JLabel bookDescriptionLabel;
    private JLabel authorLabel;
    private JTextField bookTitle;
    private JTextField bookDescription;
    private JTextField author;
    private JButton selectImage;
    private JButton addBook;
    private JLabel imagePreview;
    private String coverImageFilePath;

    public AddBookView() {
        this.f = new JFrame("Add Book");
        this.bookTitleLabel = new JLabel("Book title");
        this.bookDescriptionLabel = new JLabel("Book description");
        this.authorLabel = new JLabel("Author");
        this.bookTitle = new JTextField();
        this.bookDescription = new JTextField();
        this.author = new JTextField();
        this.selectImage = new JButton("Select book cover");
        this.addBook = new JButton("Add book");



        int labelWidth = 100, labelHeight = 30;
        int textFieldWidth = 200, textFieldHeight = 30;

        this.bookTitleLabel.setBounds(30,15,labelWidth,labelHeight);
        this.bookTitle.setBounds(140,15,textFieldWidth,textFieldHeight);
        this.bookDescriptionLabel.setBounds(30,50,labelWidth,labelHeight);
        this.bookDescription.setBounds(140,50,textFieldWidth,textFieldHeight);
        this.authorLabel.setBounds(30,85,labelWidth,labelHeight);
        this.author.setBounds(140,85,textFieldWidth,textFieldHeight);
        this.selectImage.setBounds(160, 120, 150, 25);
        this.addBook.setBounds(50,120,100,25);

        this.selectImage.addActionListener(this.bookCoverFilePath());

        imagePreview = new JLabel();
        imagePreview.setBounds(350,-50, 300,300);

        this.f.add(imagePreview);
        this.f.add(bookTitleLabel);
        this.f.add(bookTitle);
        this.f.add(bookDescriptionLabel);
        this.f.add(bookDescription);
        this.f.add(authorLabel);
        this.f.add(author);
        this.f.add(selectImage);
        this.f.add(addBook);

        this.f.setSize(650,300);
        this.f.setLayout(null);
        this.f.setResizable(false);
        this.f.setLocationRelativeTo(null);
        this.f.setVisible(true);
    }

    public void addBookActionListener(ActionListener actionListener) {
        this.addBook.addActionListener(actionListener);
    }

    private ActionListener bookCoverFilePath() {
        return e -> {
            int response;
            File file;
            JFileChooser fileChooser = new JFileChooser(".");

            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                coverImageFilePath = file.getAbsolutePath();
                imagePreview.setIcon(this.createPreviewImage(coverImageFilePath));
                System.out.println(coverImageFilePath);
            } else {
                coverImageFilePath = "";
            }
        };
    }

    public String getCoverImageFilePath() {
        return this.coverImageFilePath;
    }

    public String getTitle() {
        return this.bookTitle.getText();
    }

    public String getDescription() {
        return this.bookDescription.getText();
    }

    public String getAuthor() {
        return this.author.getText();
    }

    public void emptyInputs() {
        this.bookTitle.setText("");
        this.bookDescription.setText("");
        this.author.setText("");
        this.imagePreview.setIcon(null);
    }

    private ImageIcon createPreviewImage(String imagePath) {
        ImageIcon img = new ImageIcon(imagePath);
        Image getImage = img.getImage();
        Image newImg = getImage.getScaledInstance(250,200,Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}
