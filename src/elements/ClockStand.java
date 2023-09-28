package elements;

import java.awt.*;

public class ClockStand {
    private final int x;
    private final int y;
    private  final int width;
    private final int height;
    private final Color c;
    public ClockStand (int x, int y, int width, int height, Color c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
    }
    public void draw (Graphics2D g) {
        drawClockStand(g, x, y, width, height, c);
    }

    public static void drawClockStand (Graphics2D g, int x, int y, int width, int height, Color c) {
        Color oldColor = g.getColor();
        Color strokeColor = new Color(156, 76, 0);
        g.setColor(strokeColor);
        g.fillRect(x, y, width, height);
        g.setColor(c);
        g.fillRect(x + 10, y + 10, width - 20, height - 20);
        g.setColor(new Color(255, 215, 0));
        g.fillRect(x + 20 , y + 55, width - 40, width - 50);
        g.setColor(c);
        Polygon triangle1 = new Polygon();
        Polygon triangle2 = new Polygon();
        Polygon triangle3 = new Polygon();
        Polygon triangle4 = new Polygon();
        int[] triangle1X = new int[]{x + 20, x + 20, x + 40};
        int[] triangle1Y = new int[]{y + 70, y + 55, y + 55};
        int[] triangle2X = new int[]{x + 180, x + 180, x + 160};
        int[] triangle2Y = new int[]{y + 55, y + 70, y + 55};
        int[] triangle3X = new int[]{x + 180, x + 180, x + 160};
        int[] triangle3Y = new int[]{y + 205, y + 190, y + 205};
        int[] triangle4X = new int[]{x + 20, x + 20, x + 40};
        int[] triangle4Y = new int[]{y + 205, y + 190, y + 205};
        g.setColor(Color.black);
        for (int i = 0; i < 3; i++) {
            triangle1.addPoint(triangle1X[i], triangle1Y[i]);
            triangle2.addPoint(triangle2X[i], triangle2Y[i]);
            triangle3.addPoint(triangle3X[i], triangle3Y[i]);
            triangle4.addPoint(triangle4X[i], triangle4Y[i]);
        }
        g.fillPolygon(triangle1);
        g.fillPolygon(triangle2);
        g.fillPolygon(triangle3);
        g.fillPolygon(triangle4);
        g.setColor(c);
        g.fillArc(x, y - (width / 2), width, width + 10, 0, 180);
        g.fillRect(x - 20, y + height, width + 40, 20);
        g.setColor(new Color(106, 138, 168));
        g.fillRect(x + 20, y + height / 3, width - 40, 415);
        g.setColor(oldColor);
    }
}
