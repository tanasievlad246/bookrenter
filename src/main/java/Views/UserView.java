package Views;

import javax.swing.*;

public class UserView {
    private JFrame f;

    public UserView() {
        this.f = new JFrame("User view");
        this.f.setSize(500,500);
        this.f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.f.setLocationRelativeTo(null);
        this.f.setVisible(true);
    }
}
