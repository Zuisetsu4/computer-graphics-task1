package elements;

import java.awt.*;

public class BookShelf {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color c;
    public BookShelf(int x, int y, int width, int height, Color c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
    }
    public void draw(Graphics2D g) {
        drawBookShelf(g, x, y, width, height, c);
    }
    public static void drawBookShelf(Graphics2D g, int x, int y, int width, int height, Color c) {
        g.setColor(c);
        g.fillRect(x, y, width, height);
        g.fillRect(x, y + 80, width, height);
        g.fillRect(x, y + 160, width, height);
    }
}
