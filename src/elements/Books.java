package elements;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Books {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color c;
    public Books(int x, int y, int width, int height, Color c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
    }
    public void draw(Graphics2D g) {
        drawBooks(g, x, y, width, height, c);
    }
    public static void drawBooks(Graphics2D g, int x, int y, int width, int height, Color c) {
        while (x < 940 && y < 480) {
            g.setColor(c);
            if (y == 380) {
                g.setColor(new Color(204, 143, 78));
            }
            else if (y == 460) {
                g.setColor(new Color(26,18,10));
            }
            g.setStroke(new BasicStroke(5));
            GeneralPath path = new GeneralPath();
            path.moveTo(x, y);
            path.lineTo(x + 3, y - 48);
            path.lineTo(x + 20, y - 48);
            path.lineTo(x + 17, y);
            path.lineTo(x, y);
            g.fill(path);
            g.setStroke(new BasicStroke(7));
            g.drawArc(x + 7, y - 55, width, height, 0, -180);
            g.setStroke(new BasicStroke(5));
            g.drawLine(x + 5, y - 50, x + 10, y - 75);
            g.setStroke(new BasicStroke(3));
            g.drawLine(x + 10, y - 75, x + 20, y - 75);
            g.setStroke(new BasicStroke(5));
            g.drawLine(x + 22, y - 75, x + 18, y - 50);
            x+= 20;
            if (x < 940 && x > 910) {
                x = 605;
                y += 80;
            }
        }
    }
}

