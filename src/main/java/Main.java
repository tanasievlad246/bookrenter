import Controllers.LoginController;
import Views.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView loginView = new LoginView(new LoginController());
        loginView.init();
    }
}
