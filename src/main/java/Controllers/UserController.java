package Controllers;

import Models.Book;
import Models.User;
import Views.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController {
    private CreateUserView createUserView;
    private UserView userView;
    private Book bookModel;
    private User userModel;

    public UserController() {
        this.createUserView = new CreateUserView();
        this.userModel = new User();
        this.createUserView.setCreateButtonAction(createUser());
    }

    public UserController(UserView userView) {
        this.userView = userView;
        this.bookModel = new Book();
        this.userModel = new User();

        this.userView.getRentBooks().addActionListener(this.rentBooks());
        this.userView.getViewRented().addActionListener(this.viewBooks());
    }

    private ActionListener createUser() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = createUserView.getUsernameText();
                String password = createUserView.getUserPassword();
                boolean adminStatus = createUserView.getRadioButtonValue();

                userModel.setUsername(username);
                userModel.setPassword(password);
                userModel.setAdminStatus(adminStatus);

                userModel.createUser();
                createUserView.closeView();
            }
        };
    }

    private ActionListener rentBooks() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 UserBooksView userBooksView = new UserBooksView();
                 userBooksView.setBooks(bookModel.getAllBooks());
                 userBooksView.setUserId(userView.getUser_id());
                 userBooksView.setUsername(userView.getUsername());
                 userBooksView.createBooksComponent();
            }
        };
    }

    private ActionListener viewBooks() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RentedByUserView rentBookView = new RentedByUserView();
                rentBookView.setRentedBooks(bookModel.getRentedByUser(userView.getUser_id()));
                rentBookView.createBooksComponents();
            }
        };
    }


}
