package org.example;

import org.example.GameElements.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// ToDo: Game Field != Draw Panel, bc game field may be larger or smaller than visible window
//  => this class need refactoring
public class GameField extends JPanel {
    // fields here ->
    public static final int WIDTH = 800, HEIGHT = 600;

    // Tank tank;
    // TankShell tankShell;
    Landscape landscape = new Landscape(7, 0, 800, 0, 600);
    MovingRectangle mr = new MovingRectangle(50, 50, 50, 30);

    // array of all landscapes, n = 10: max num of landscapes
    static Landscape[] l = new Landscape[10];

    public GameField() {
        gameInit();
    }

    private void gameInit() {
        // constructors here ->
        landscape.setCoordsX(new int[]{10, 200, 400, 600, 800, WIDTH, 10});
        landscape.setCoordsY(new int[]{300, 100, 400, 300, 200, HEIGHT, HEIGHT});
        l[0] = landscape;

        addKeyListener(new MyKeyListener());
        setFocusable(true);
        frameUpdate();
    }

    public static boolean checkOutOfBounds(int[] coordsX, int[] coordsY) {
        boolean result = false;
        for (int i = 0; i < l.length; i++) {
            if (l[i] == null) {
                continue;
            }
            for (int j = 0; j < coordsX.length; j++) {
                result = result || l[i].isPointInLandscape(coordsX[j], coordsY[j]);
            }
        }
        System.out.println(result);
        return result;
    }

    public void frameUpdate() {
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                mr.inLand =
//                        landscape.isPointInLandscape(mr.x, mr.y) ||
//                        landscape.isPointInLandscape(mr.x, mr.y + mr.height) ||
//                        landscape.isPointInLandscape(mr.x + mr.width, mr.y) ||
//                        landscape.isPointInLandscape(mr.x + mr.width, mr.y
//                                + mr.height);

                mr.moveRectangle();

                repaint();
            }
        };
        Timer timer = new Timer(33, listener);
        timer.start();
    }

    private class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                mr.leftKeyPressed = true;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                mr.rightKeyPressed = true;
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                mr.upKeyPressed = true;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                mr.downKeyPressed = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                mr.leftKeyPressed = false;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                mr.rightKeyPressed = false;
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                mr.upKeyPressed = false;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                mr.downKeyPressed = false;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.white);
        Graphics2D g2d = (Graphics2D) g;

        landscape.draw(g2d);
        mr.draw(g2d);
    }
}
