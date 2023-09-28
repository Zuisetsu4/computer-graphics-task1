package primitives;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mw.setSize(1920,1060);
        mw.setLocationRelativeTo(null);
        mw.setVisible(true);
    }
}