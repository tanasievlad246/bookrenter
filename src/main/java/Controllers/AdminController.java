package Controllers;

import Models.Book;
import Models.User;
import Views.AdminView;
import Views.CreateUserView;

import java.awt.event.ActionListener;

public class AdminController {
    private AdminView adminView;
    private Book bookModel;
    private User userModel;

    public AdminController(AdminView adminView) {
        this.adminView = adminView;

        this.addUser();
    }

    private ActionListener createUser() {
        return e -> {
            new UserController();
        };
    }

    //implement add User
    public void addUser() {
        this.adminView.addActionListener(this.createUser(), this.adminView.getCreateUserButton());
    }

    //implement add book
    public void addBook() {

    }

    //implement view rented books
    public void viewRentedBooks() {

    }
}
