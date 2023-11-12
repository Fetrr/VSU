package ru.vsu.kulikov.AlgorithmComplexity;

import javax.swing.*;
import java.awt.*;

public class Graph {
    public void paintGraph(int startX, int startY, int width, int height, final int[] coord) {
        // coord[] like [x1, y1, x2, y2, ..., xn, yn]
        if (coord.length == 2) {
            return;
        }

        JFrame frame = new JFrame();
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                //int startX = width, startY = height;
                int x1 = startX, y1 = startY;

                for(int i = 0; i < coord.length; i += 2) {
                    int x2 = startX + coord[i];
                    int y2 = startY + height - coord[i + 1];
                    g.drawLine(x1, y1, x2, y2);
                    x1 = x2;
                    y1 = y2;
                }
            }
        };
        frame.add(panel);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

