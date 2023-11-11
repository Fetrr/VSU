package elements;

import java.awt.*;

public class Bird {
    private int x, y, a = 60;
    private boolean reverse_move;
    private final int velocity_x, velocity_y, velocity_a, width, height, wings_length;
    private final Color clr;

    public Bird(int x, int y, int velocity_x, int velocity_y, int velocity_a, int width, int height, int wings_length, Color clr) {
        this.x = x;
        this.y = y;
        this.velocity_x = velocity_x;
        this.velocity_y = velocity_y;
        this.velocity_a = velocity_a;
        this.width = width;
        this.height = height;
        this.wings_length = wings_length;
        this.clr = clr;
    }

    public void moveWings() {
        if (a <= 60 && !reverse_move) {
            a += velocity_a;
        } else {
            reverse_move = true;
            a -= velocity_a;
        }
        if (a <= -60) {
            reverse_move = false;
        }
    }
    public void move() {
        if (x <= 800 && y <= 600) {
            x += velocity_x;
            y += velocity_y;
        } else {
            //set start position
            int start_x = -width - wings_length;
            int start_y = (int) (Math.random() * 150);
            x = start_x;
            y = start_y;
        }
    }

    public double toRad(double angle) {
        return angle*0.0174533;
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        Stroke old_stroke = g2d.getStroke();
        g2d.setColor(clr);
        /**/

        g2d.fillOval(x, y, width, height);

        g2d.setStroke(new BasicStroke(2));
        int wing1_x = (int) (x + width/2 + wings_length*Math.cos(toRad(a)));
        int wing1_y = (int) (y + height/2 + wings_length*Math.sin(toRad(a)));
        int wing2_x = (int) (x + width/2 + wings_length*Math.cos(toRad(180 - a)));
        int wing2_y = (int) (y + height/2 + wings_length*Math.sin(toRad(180 - a)));
        g2d.drawLine(x + width/2, y + height/2, wing1_x, wing1_y);
        g2d.drawLine(x + width/2, y + height/2, wing2_x, wing2_y);

        /**/
        g2d.setStroke(old_stroke);
        g2d.setColor(old_color);
    }
}
