package Controllers;

import Models.Book;
import Models.User;
import Views.AdminView;
import Views.CreateUserView;
import Views.RentedBooksView;

import java.awt.event.ActionListener;

public class AdminController {
    private AdminView adminView;

    public AdminController(AdminView adminView) {
        this.adminView = adminView;

        this.init();
    }

    private ActionListener createUser() {
        return e -> {
            new UserController();
        };
    }

    //implement add User
    private void init() {
        this.adminView.addActionListener(this.createUser(), this.adminView.getCreateUserButton());
        this.adminView.addActionListener(this.addBook(), this.adminView.getAddBookButton());
        this.adminView.addActionListener(this.viewRentedBooks(), this.adminView.getViewRentedBooksButton());
    }

    //implement add book
    public ActionListener addBook() {
        return e -> {
            new BookController();
        };
    }

    //implement view rented books
    public ActionListener viewRentedBooks() {
        return e -> {
            new BookController(new RentedBooksView());
        };
    }
}
