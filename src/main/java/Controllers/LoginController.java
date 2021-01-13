package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    public ActionListener login() {
        ActionListener loginAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login was triggered");
            }
        };
        return loginAction;
    }
}
