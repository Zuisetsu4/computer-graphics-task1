package elements;

import java.awt.*;

public class Window {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color c;
    public Window(int x, int y, int width, int height, Color c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
    }
    public void draw(Graphics2D g) {
        drawWindow(g, x, y, width, height, c);
    }
    public static void drawWindow (Graphics2D g, int x, int y, int width, int height, Color c) {
        g.setColor(c);
        g.fillRect(x,y,width,height);
        g.setColor(new Color(52, 137, 235));
        g.fillRect(x + 10, y + 10, width - 20, height - 20);
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(6));
        g.drawLine(x + width / 2, y + 13, x + width / 2, y + height - 13);
        g.drawLine(x + 13, y + height / 2, x + width - 13, y + height / 2 );
    }
}
