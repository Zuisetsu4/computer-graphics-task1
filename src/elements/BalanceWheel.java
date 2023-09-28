package elements;

import java.awt.*;
public class BalanceWheel {
    private final int x;
    private final int y;
    private final int r;
    private final int R;
    private final Color c;
    private double time;

    public BalanceWheel(int x, int y, double time, int r, int R, Color c) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.r = r;
        this.R = R;
        this.c = c;
    }
    public void draw(Graphics2D g) {
        double angle = (Math.PI / 120) * Math.sin(time ) + Math.PI / 2;
        drawBalanceWheel(g, x, y, angle, r, R, c);
    }
    public void update(double time) {
        this.time += time;
    }

    public static void drawBalanceWheel(Graphics2D g, int x, int y, double angle, int r, int R, Color c) {
        g.setColor(c);
        g.drawLine(x, y, (int) (x + R  * Math.cos(angle)), (int) (y + (R - 900) * Math.sin(angle)));
        g.fillOval((int) (x - (r / 2) + R  * Math.cos(angle)), (int) (y + (R - 900) * Math.sin(angle)) , r, r);
    }
}
