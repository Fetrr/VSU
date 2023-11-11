package elements;

import java.awt.*;

public class Road {
    private final int x, y, width, height;
    private final Color clr;

    public Road(int x, int y, int width, int height, Color clr) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.clr = clr;
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        Stroke old_stroke = g2d.getStroke();
        g2d.setColor(clr);
        /**/

        g2d.fillRect(x, y, width, height);

        g2d.setColor(new Color(94, 32, 4));
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(x, y, x, y + height);
        g2d.drawLine(x + width, y, x + width, y + height);

        /**/
        g2d.setStroke(old_stroke);
        g2d.setColor(old_color);
    }
}