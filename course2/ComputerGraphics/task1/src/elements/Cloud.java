package elements;

import java.awt.*;

public class Cloud {
    private int x, y, width, height;
    private final int velocity_x, velocity_y;
    private final Color clr;

    public Cloud(int x, int y, int velocity_x, int velocity_y, Color clr) {
        this.x = x;
        this.y = y;
        this.velocity_x = velocity_x;
        this.velocity_y = velocity_y;
        this.clr = clr;
    }

    public void setRandomValues(int width, int height) {
        this.width = (int) (50 + Math.random()*(width - 50));
        this.height = (int) (40 + Math.random()*(height - 40));
    }

    public void move() {
        if (x <= 800 && y <= 600) {
            x += velocity_x;
            y += velocity_y;
        } else {
            //set start position
            int start_x = -width * 2;
            int start_y = (int) (Math.random() * 250);
            x = start_x;
            y = start_y;
        }
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        Stroke old_stroke = g2d.getStroke();
        g2d.setColor(clr);
        /**/

        g2d.setStroke(new BasicStroke(8));
        g2d.setColor(new Color(200, 200, 200));
        g2d.drawOval(x, y, width, height);
        g2d.drawOval(x + width/2, (int) (y + height*0.2), width, height);
        g2d.drawOval(x + width, y, width, height);

        g2d.setColor(clr);
        g2d.fillOval(x, y, width, height);
        g2d.fillOval(x + width/2, (int) (y + height*0.2), width, height);
        g2d.fillOval(x + width, y, width, height);

        /**/
        g2d.setStroke(old_stroke);
        g2d.setColor(old_color);
    }
}
