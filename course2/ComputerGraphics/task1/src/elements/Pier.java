package elements;

import java.awt.*;

public class Pier {
    private final int x, y, length, thickness, n_piles, fence_height, fence_n;
    private final Color clr;

    public Pier(int x, int y, int length, int thickness, int n_piles, int fence_height, int fence_n, Color clr) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.thickness = thickness;
        this.n_piles = n_piles;
        this.fence_height = fence_height;
        this.fence_n = fence_n;
        this.clr = clr;
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        g2d.setColor(clr);
        /**/
        g2d.fillRect(x, y, length, thickness);
        g2d.drawLine(x, y - fence_height, x + length + 25, y - fence_height);

        int fence_step = (int)(length - 15)/fence_n;
        for(int curr_step = 15; curr_step < length - 15; curr_step+=fence_step) {
            g2d.drawLine(x + curr_step, y - fence_height, x + curr_step, y);
        }
        for(int i = 1; i < n_piles + 1; i++) {
            g2d.fillRect(x + i*length/(n_piles + 1), y + thickness, thickness, 2*thickness);
        }
        /**/
        g2d.setColor(old_color);
    }
}
