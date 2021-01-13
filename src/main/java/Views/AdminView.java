package Views;

import javax.swing.*;

public class AdminView {
    private JFrame f;

    public AdminView() {
        this.f = new JFrame("Admin view");
        this.f.setSize(500,500);
        this.f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.f.setLocationRelativeTo(null);
        this.f.setVisible(true);
    }
}
