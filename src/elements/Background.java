package elements;

import java.awt.*;

public class Background {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color c;
    public Background(int x, int y, int width, int height, Color c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
    }
    public void draw(Graphics2D g) {
        drawBackground(g, x, y, width, height, c);
    }
    public static void drawBackground(Graphics2D g, int x, int y, int width, int height, Color c) {
        g.setColor(c);
        g.fillRect(x, y, width, height);
        g.setColor(Color.white);
        g.setStroke(new BasicStroke(2));
        y = y + 5;
        x = x + 15;
        while (x < 1920 && y < 870) {
            g.drawLine(x + 10, y, x + 20, y);
            g.drawLine(x + 20, y, x + 20, y + 10);
            g.drawRoundRect(x + 20, y + 10, 10, 10, 10, 10);
            g.setColor(c);
            g.drawRect(x + 7, y + 12, 15, 6);
            g.setColor(Color.white);
            g.drawLine(x + 20, y + 20, x + 20, y + 30);
            g.drawLine(x + 20, y + 30, x + 10, y + 30);
            g.drawLine(x + 10, y + 30, x + 10, y + 20);
            g.drawRoundRect(x, y + 10, 10, 10, 10, 10);
            g.setColor(c);
            g.drawRect(x + 10, y + 10, 10, 6);
            g.setColor(Color.white);
            g.drawLine(x + 10, y + 10, x + 10, y);
            x+= 60;
            if (x > 1920) {
                x = 15;
                y+= 60;
            }
        }
    }
}
