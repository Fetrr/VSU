package elements;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Ship {
    private int x, y, width, height, park;
    private final int velocity_x, park_delay;
    private final Color clr;

    public Ship(int x, int y, int velocity_x, int park_delay, Color clr) {
        this.x = x;
        this.y = y;
        this.velocity_x = velocity_x;
        this.park_delay = park_delay*(1000/33); // sec
        park = 0;
        this.clr = clr;
    }

    public void setRandomValues(int width, int height) {
        this.width = (int) (80 + Math.random()*(width - 80));
        this.height = (int) (25 + Math.random()*(height - 25));
    }

    public void move() {
        if (x <= 350 - width && park < park_delay) {
            x += velocity_x;
        } else {
            park += 1;
        } if (park > park_delay) {
            x -= velocity_x;
        } if (x <= -3*width) { //set start position
            park = 0;
        }
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        Stroke old_stroke = g2d.getStroke();
        g2d.setColor(clr);
        /**/

        // корпус
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(new Color(112, 90, 73));
        g2d.drawArc(x, y, width, height, 0, -180);
        g2d.setColor(clr);
        g2d.fillArc(x, y, width, height, 0, -180);
        g2d.setColor(new Color(112, 90, 73));
        g2d.drawLine(x - 1, y + height/2, x + width + 1, y + height/2);

        // мачта
        g2d.setColor(new Color(84, 73, 57));
        g2d.drawLine(x + width/2, y + height/2, x + width/2, y - 30);

        // паруса
        g2d.setColor(new Color(204, 204, 204));
        GeneralPath triangle1 = new GeneralPath();
        triangle1.moveTo(x + width/2 + 6, y + height/2 - 5);
        triangle1.lineTo(x + width/2 + 40, y + height/2 - 5);
        triangle1.lineTo(x + width/2 + 5, y - 30);
        triangle1.closePath();
        g2d.draw(triangle1);

        GeneralPath triangle2 = new GeneralPath();
        triangle2.moveTo(x + width/2 - 6, y + height/2 - 5);
        triangle2.lineTo(x + width/2 - 30, y + height/2 - 5);
        triangle2.lineTo(x + width/2 - 6, y - 20);
        triangle2.closePath();
        g2d.draw(triangle2);

        g2d.setColor(Color.white);
        g2d.fill(triangle1);
        g2d.fill(triangle2);

        /**/
        g2d.setStroke(old_stroke);
        g2d.setColor(old_color);
    }
}