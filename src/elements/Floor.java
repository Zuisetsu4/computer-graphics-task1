package elements;

import java.awt.*;

public class Floor {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color c;
    public Floor(int x, int y, int width, int height, Color c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
    }
    public void draw(Graphics2D g) {
        drawFloor(g, x, y, width, height, c);
    }
    public static void drawFloor (Graphics2D g, int x, int y, int width, int height, Color c) {
        g.setColor(c);
        g.fillRect(x,y, width, height);
        g.setColor(Color.black);
        while (x < 1920) {
            g.drawLine(x, y + 120, x + 50, y + 3);
            x+= 100;
        }
    }
}
