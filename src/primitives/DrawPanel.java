package primitives;

import elements.*;
import elements.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPanel extends JPanel implements ActionListener {
    Window window;
    BookShelf bs;
    Floor floor;
    Background bgd;
    BalanceWheel bw;
    ClockFace cf;
    ClockStand cs;
    Books books;
    Timer timer;
    int n = 0;
    public DrawPanel() {
        floor = new Floor(0, 900, 1920, 120, new Color(241, 175,9));
        bgd = new Background(0, 0, 1920, 900, new Color(219,194, 171));
        cf = new ClockFace(1200, 400, 70, 720, new Color(211, 211, 211));
        int xBalanceWheel = 1200;
        int yBalanceWheel = 488;
        int R = 1200;
        final int r = 90;
        bw = new BalanceWheel(xBalanceWheel, yBalanceWheel, 0,  r, R, new Color(255, 123, 0));
        cs = new ClockStand(1100, 270, 200, 650, new Color(102, 51, 0));
        window = new Window(1450, 220, 300, 325, Color.white);
        bs = new BookShelf(600, 300, 350, 15, new Color(130,68, 1));
        books = new Books(605, 300, 10, 10, new Color(92, 55, 15));
        timer = new Timer(20, this);
        timer.start();
    }
    @Override
    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        bgd.draw(g);
        window.draw(g);
        floor.draw(g);
        cs.draw(g);
        cf.draw(g);
        books.draw(g);
        bs.draw(g);
        bw.draw(g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        bw.update(0.05);
        cf.setTime(0.02);
        repaint();
    }
}
