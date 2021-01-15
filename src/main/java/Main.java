import Controllers.LoginController;
import Models.LoginModel;
import Models.User;
import Views.*;

public class Main {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        LoginModel loginModel = new LoginModel();
        new LoginController(loginView, loginModel);

//        new AdminView();
//        new AddBookView();
//        new CreateUserView();
    }
}
