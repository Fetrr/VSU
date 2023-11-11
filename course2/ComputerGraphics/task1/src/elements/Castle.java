package elements;

import java.awt.*;

public class Castle {
    private int x, y, width, height, parapet_w, parapet_h, parapet_n, windows_n, gate_w, gate_h;
    private Color clr;

    public Castle(int x, int y, int width, int height, int parapet_w, int parapet_h, int parapet_n, int windows_n, int gate_w, int gate_h, Color clr) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.parapet_w = parapet_w;
        this.parapet_h = parapet_h;
        this.parapet_n = parapet_n;
        this.windows_n = windows_n;
        this.gate_w = gate_w;
        this.gate_h = gate_h;
        this.clr = clr;
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        Stroke old_stroke = g2d.getStroke();
        g2d.setColor(clr);

        /*  стены замка и парапет  */
        g2d.fillRect(x, y + parapet_h, width, height);
        for(int i = 0; i < parapet_n; i++) {
            int x1 = x + parapet_w*2*i;
            g2d.setColor(clr);
            g2d.fillRect(x1, y, parapet_w, parapet_h);

            g2d.setColor(new Color(102, 102, 102));
            g2d.setStroke(new BasicStroke(6));
            g2d.drawRect(x1, y, parapet_w, parapet_h);
            g2d.setStroke(old_stroke);
        }

        /*  стена из кирпичей  */
        int brick_width = 40;
        int brick_height = 20;
        int brick_x, brick_y;
        g2d.setStroke(new BasicStroke(5));

        for(int i = 0; i < height/brick_height; i+=2) {
            brick_y = y + parapet_h + i*brick_height;
            g2d.drawLine(x, brick_y, x + width, brick_y);
            for(int j = 0; j <= width/brick_width; j++) {
                brick_x = x + j*brick_width;
                g2d.drawLine(brick_x, brick_y, brick_x, brick_y + brick_height);
            }
        }
        for(int i = 1; i < (height/brick_height) - 1; i+=2) {
            brick_y = y + parapet_h + i*brick_height;
            g2d.drawLine(x, brick_y, x + width, brick_y);
            for(int j = 0; j < (width/brick_width); j++) {
                brick_x = (int)(0.5*brick_width) + x + j*brick_width;
                g2d.drawLine(brick_x, brick_y, brick_x, brick_y + brick_height);
            }
        }
        brick_y = y + parapet_h + height - brick_height;
        g2d.drawLine(x, brick_y, x + width, brick_y);
        for(int j = 0; j < (width/brick_width); j++) {
            brick_x = (int)(0.5*brick_width) + x + j*brick_width;
            g2d.drawLine(brick_x, brick_y, brick_x, y + parapet_h + height - 3);
        }
        g2d.drawLine(x, y + parapet_h + height - 3, x + width, y + parapet_h + height - 3);
        g2d.setStroke(old_stroke);

        /*  окна в стене  */
        g2d.setColor(Color.WHITE);
        int win_x, win_y = (int)(y + parapet_h*1.3);
        int win_w = 15, win_h = 25;
        for(int i = 1; i <= windows_n; i++) {
            win_x = x + (i*(int)(width/(windows_n + 1)));
            // т.к. рисуется полуокр., то высота прямоугольника, в который вписывается эллипс,
            // равна двум расстоянием до прямоугольного окна

            g2d.fillArc(win_x, win_y - 10, win_w, 20, 0, 180);
            g2d.fillRect(win_x, win_y, win_w, win_h);

            g2d.setStroke(new BasicStroke(5));
            g2d.setColor(new Color(117, 90, 87));

            g2d.drawArc(win_x, win_y - 10, win_w, 20, 0, 180);
            g2d.drawLine(win_x, win_y, win_x, win_y + win_h);
            g2d.drawLine(win_x + win_w, win_y, win_x + win_w, win_y + win_h);
            g2d.drawLine(win_x, win_y + win_h, win_x + win_w, win_y + win_h);
            g2d.setColor(Color.WHITE);
        }

        /*  ворота  */
        // координаты ворот считаются от левого верхнего угла прямоугольника, начальная точка x1 задана пропорциями
        int gate_x = (int)(x + width*0.18), gate_y = y + parapet_h + height - gate_h;
        g2d.setColor(Color.WHITE);
        g2d.fillArc(gate_x, gate_y - 20, gate_w, 40, 0, 180);
        g2d.fillRect(gate_x, gate_y, gate_w, gate_h);

        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(new Color(117, 90, 87));

        g2d.drawArc(gate_x, gate_y - 20, gate_w, 40, 0, 180);
        g2d.drawLine(gate_x, gate_y, gate_x, gate_y + gate_h);
        g2d.drawLine(gate_x + gate_w, gate_y, gate_x + gate_w, gate_y + gate_h);

        /**/
        g2d.setStroke(old_stroke);
        g2d.setColor(old_color);
    }
}
