package Controllers;

import Models.Book;
import Models.User;
import Views.AdminView;

public class AdminController {
    private AdminView adminView;
    private Book bookModel;
    private User userModel;

    public AdminController(AdminView adminView, Book bookModel, User userModel) {
        this.adminView = adminView;
        this.bookModel = bookModel;
        this.userModel = userModel;
    }

    //implement add User

    //implement add book

    //implement view rented books
}
