package elements;

import java.awt.*;

public class Ocean {
    private int y, window_width, window_height;
    private Color clr;

    public Ocean(int y, int window_width, int window_height, Color clr) {
        this.y = y;
        this.window_width = window_width;
        this.window_height = window_height;
        this.clr = clr;
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        g2d.setColor(clr);
        /**/
        g2d.fillRect(0, y, window_width, window_height);
        /**/
        g2d.setColor(old_color);
    }
}
