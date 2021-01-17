package Controllers;

import Models.Book;
import Views.AddBookView;
import Views.RentedBooksView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookController {
    private RentedBooksView rentedBooksView;
    private AddBookView addBookView;
    private Book bookModel;

    public BookController() {
        this.addBookView = new AddBookView();
        this.bookModel = new Book();

        this.addBookView.addBookActionListener(this.addNewBook());
    }

    public BookController(RentedBooksView rentedBooksView) {
        this.rentedBooksView = rentedBooksView;
        this.bookModel = new Book();
    }

    //implement add new book
    public ActionListener addNewBook() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = addBookView.getTitle(),
                        description = addBookView.getDescription(),
                        coverImagePath = addBookView.getCoverImageFilePath(),
                        author = addBookView.getAuthor();

                bookModel.setTitle(title);
                bookModel.setDescription(description);
                bookModel.setAuthor(author);
                bookModel.setCoverImage(coverImagePath);

                bookModel.createBook();
            }
        };
    }
}
