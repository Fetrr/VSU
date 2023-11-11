package elements;

import java.awt.*;

public class Ground {
    private final int x, y, width, height;
    private final Color clr;

    public Ground(int x, int y, int width, int height, Color clr) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.clr = clr;
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        g2d.setColor(clr);
        /**/
        g2d.fillRect(x, y, width, height);
        g2d.fillArc(x, y - 30, width, 60, 90, 90);
        /**/
        g2d.setColor(old_color);
    }
}
