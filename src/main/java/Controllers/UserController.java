package Controllers;

import Models.User;
import Views.CreateUserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController {
    private CreateUserView createUserView;
    private User userModel;

    public UserController() {
        this.createUserView = new CreateUserView();
        this.userModel = new User();
//        String username = createUserView.getUsernameText();
//        String password = createUserView.getUserPassword();
//        boolean adminStatus = createUserView.getRadioButtonValue().equals("") ? false : true;
        this.createUserView.setCreateButtonAction(createUser());
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
            }
        };
    }
}
