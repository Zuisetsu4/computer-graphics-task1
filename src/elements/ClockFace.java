package elements;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ClockFace {
    private final int x;
    private final int y;
    private final int r;
    private double time;

    private final Color c;

    public ClockFace(int x, int y, int r, double time, Color c) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.time = time;
        this.c = c;
    }

    public void draw(Graphics2D g) {
        drawClockFace(g, x, y, r, time, c);
    }
    public void setTime(double time) {
        this.time = this.time + time;
    }

    public static void drawClockFace(Graphics2D g, int x, int y, int r, double time, Color c) {
        Color oldColor = g.getColor();
        g.setColor(Color.black);
        Color strokeColor = new Color(178, 34, 34);
        g.setColor(c);
        g.fillOval(x - r, y - r, r + r, r + r);
        g.setStroke(new BasicStroke(7));
        g.setColor(strokeColor);
        g.drawOval(x - r, y - r, r + r, r + r);
        g.setColor(Color.WHITE);
        g.fillOval(x - (r / 2), y - (r / 2), (r + r) / 2, (r + r) / 2);
        g.setColor(Color.black);
        g.setFont(new Font("Constantine", Font.PLAIN, 22));
        String[] numb = new String[]{"III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "I", "II"};
        for (int i = 0; i < 12; i++) {
            if ((Math.PI / 6) * i > Math.PI && (Math.PI / 6) * i < 2 * Math.PI) {
                if (numb[i].equals("X")) {
                    g.drawString(numb[i], (int) (x + g.getFont().getSize() / 6 + r * Math.cos((Math.PI / 6) * i)), (int) (y + g.getFont().getSize() + r * Math.sin((Math.PI / 6) * i)));
                } else if (numb[i].equals("XI")) {
                    g.drawString(numb[i], (int) (x - g.getFont().getSize() / 5 + r * Math.cos((Math.PI / 6) * i)), (int) (y + g.getFont().getSize() * 1.1 + r * Math.sin((Math.PI / 6) * i)));
                } else if (numb[i].equals("I")) {
                    g.drawString(numb[i], (int) (x - g.getFont().getSize() / 5 + r * Math.cos((Math.PI / 6) * i)), (int) (y + g.getFont().getSize() * 1.2 + r * Math.sin((Math.PI / 6) * i)));
                } else {
                    g.drawString(numb[i], (int) ((x - (g.getFont().getSize() / 2)) + r * Math.cos((Math.PI / 6) * i)), (int) (y + g.getFont().getSize() + r * Math.sin((Math.PI / 6) * i)));
                }
            } else if ((Math.PI / 6) * i > 0 && (Math.PI / 6) * i < Math.PI) {
                if (numb[i].equals("IV")) {
                    g.drawString(numb[i], (int) (x - g.getFont().getSize() + r * Math.cos((Math.PI / 6) * i)), (int) (y + r * Math.sin((Math.PI / 6) * i)));
                }
                if (numb[i].equals("VII")) {
                    g.drawString(numb[i], (int) (x - g.getFont().getSize() / 3 + r * Math.cos((Math.PI / 6) * i)), (int) (y - g.getFont().getSize() / 4 + r * Math.sin((Math.PI / 6) * i)));
                }
                if (numb[i].equals("VIII")) {
                    g.drawString(numb[i], (int) (x + r * Math.cos((Math.PI / 6) * i)), (int) (y + r * Math.sin((Math.PI / 6) * i)));
                } else if (numb[i].equals("V") || numb[i].equals("VI")) {
                    g.drawString(numb[i], (int) (x - g.getFont().getSize() / 3 + r * Math.cos((Math.PI / 6) * i)), (int) (y - g.getFont().getSize() * 0.2 + r * Math.sin((Math.PI / 6) * i)));
                }
            } else if (((Math.PI / 6) * i == 0) || ((Math.PI / 6) * i == Math.PI)) {
                if (numb[i].equals("IX")) {
                    g.drawString(numb[i], (int) ((x + (g.getFont().getSize() / 4)) + r * Math.cos((Math.PI / 6) * i)), (int) (y + (g.getFont().getSize() / 2) + r * Math.sin((Math.PI / 6) * i)));
                } else {
                    g.drawString(numb[i], (int) ((x - (g.getFont().getSize()) * 1.1) + r * Math.cos((Math.PI / 6) * i)), (int) (y + (g.getFont().getSize() / 2) + r * Math.sin((Math.PI / 6) * i)));
                }
            }
        }
        g.setFont(new Font("Constantine", Font.BOLD, 16));
        g.drawString("TIME", x - g.getFont().getSize() * 4 / 3, y - r / 3);
        g.fillOval(x - (r / 14), y - (r / 14), (r + r) / 14, (r + r) / 14);
        AffineTransform reset = g.getTransform();
        g.rotate(Math.toRadians(180 + time), x + 3, y);
        g.fillRect(x + 3, y, g.getFont().getSize() / 4, g.getFont().getSize() * 3);
        g.setTransform(reset);
        AffineTransform old = g.getTransform();
        g.rotate(Math.toRadians(time / 60 + 168), x + 3, y);
        g.fillRect(x + 3, y, g.getFont().getSize() / 3, g.getFont().getSize() * 2);
        g.setTransform(old);
        g.setColor(oldColor);
    }
}

