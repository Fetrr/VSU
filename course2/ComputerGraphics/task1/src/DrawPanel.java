import elements.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel {
    Sun sun;
    Cloud cloud1, cloud2, cloud3, cloud4;
    Bird bird1, bird2, bird3, bird4, bird5, bird6;
    Ocean ocean;
    Ground ground;
    Road road;
    Castle castle;
    Ship ship1, ship2;
    Pier pier1, pier2;
    public DrawPanel() {
        ocean = new Ocean(300, 800, 600-300, new Color(28, 170, 214));
        sun = new Sun(30, 30, 50, 80, 16, 3, Color.orange);

        cloud1 = new Cloud(0, 50, 1, 0, Color.white);
        cloud1.setRandomValues(50, 40);
        cloud2 = new Cloud(500, 40, 1, 0, Color.white);
        cloud2.setRandomValues(50, 40);
        cloud3 = new Cloud(190, 25, 1, 0, Color.white);
        cloud3.setRandomValues(50, 40);
        cloud4 = new Cloud(600, 60, 1, 0, Color.white);
        cloud4.setRandomValues(50, 40);

        bird1 = new Bird(0, 50, 4, 0, 15, 15, 7, 20, Color.black);
        bird2 = new Bird(50, 65, 4, 0, 14, 15, 7, 20, Color.black);
        bird3 = new Bird(350, 80, 5, 0, 15, 15, 7, 20, Color.black);
        bird4 = new Bird(100, 20, 4, 0, 14, 15, 7, 20, Color.black);
        bird5 = new Bird(400, 100, 5, 0, 16, 15, 7, 20, Color.black);
        bird6 = new Bird(470, 60, 4, 0, 13, 15, 7, 20, Color.black);

        ground = new Ground(350, 350, 800 - 350, 600 - 250, Color.GREEN);
        road = new Road(490, 350, 150, 600 - 350, new Color(122, 85, 12));
        castle = new Castle(450, 150, 350, 200, 25, 50, 7, 6, 100, 120, Color.GRAY);

        ship1 = new Ship(0, 350, 3, 3, new Color(152, 118, 84));
        ship1.setRandomValues(120, 50);
        ship2 = new Ship(0, 470, 3, 10, new Color(152, 118, 84));
        ship2.setRandomValues(120, 50);

        pier1 = new Pier(350 - 100, 370, 100, 10, 2, 10, 15, new Color(101, 67, 33));
        pier2 = new Pier(350 - 100, 500, 100, 10, 2, 10, 15, new Color(101, 67, 33));

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sun.move();

                cloud1.move();
                cloud2.move();
                cloud3.move();
                cloud4.move();

                bird1.move();
                bird1.moveWings();
                bird2.move();
                bird2.moveWings();
                bird3.move();
                bird3.moveWings();
                bird4.move();
                bird4.moveWings();
                bird5.move();
                bird5.moveWings();
                bird6.move();
                bird6.moveWings();

                ship1.move();
                ship2.move();

                repaint();
            }
        };
        Timer timer = new Timer(33, listener);
        timer.start();
    }
    //общие замечания - сгладить углы у земли (ground), оформить замок (castle) из кирпичей (расчертить сетку)
    // и добавить окон в стену, добавить к пирсу (pier) заборчики +- в 1 пиксель

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        this.setBackground(new Color(135, 206, 235));
        ocean.draw(g2d);
        sun.draw(g2d);

        cloud1.draw(g2d);
        cloud2.draw(g2d);
        cloud3.draw(g2d);
        cloud4.draw(g2d);

        bird1.draw(g2d);
        bird2.draw(g2d);
        bird3.draw(g2d);
        bird4.draw(g2d);
        bird5.draw(g2d);
        bird6.draw(g2d);

        ground.draw(g2d);
        road.draw(g2d);
        castle.draw(g2d);

        ship1.draw(g2d);
        ship2.draw(g2d);

        pier1.draw(g2d);
        pier2.draw(g2d);
    }
}
