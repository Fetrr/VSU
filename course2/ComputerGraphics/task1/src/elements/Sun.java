package elements;

import java.awt.*;

public class Sun {
    private int ray_length;
    private boolean reverse_move;
    private final int x, y, r, R, n, velocity;
    private Color clr;

    public Sun(int x, int y, int r, int R, int n, int velocity, Color clr) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.R = R;
        this.n = n;
        this.velocity = velocity;
        this.clr = clr;

        reverse_move = false;
        ray_length = r;
    }

    public void move() {
        if (ray_length <= R && !reverse_move) {
            ray_length += velocity;
        } else {
            reverse_move = true;
            ray_length -= velocity;
        }
        if (ray_length <= 20) {
            reverse_move = false;
        }
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        Stroke old_stroke = g2d.getStroke();
        g2d.setColor(clr);
        /**/
        g2d.fillOval(x - r, y - r, r + r, r + r);

        g2d.setStroke(new BasicStroke(2));
        double a_step = 2*Math.PI/n;
        for(int i = 0; i < n; i++) {
            double curr_a = a_step*i;
            double x1 = x + r*Math.cos(curr_a);
            double y1 = y + r*Math.sin(curr_a);
            double x2 = x + (r + ray_length)*Math.cos(curr_a);
            double y2 = y + (r + ray_length)*Math.sin(curr_a);
            g2d.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        }
        /**/
        g2d.setStroke(old_stroke);
        g2d.setColor(old_color);
    }
}
