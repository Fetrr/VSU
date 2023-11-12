package ru.vsu.kulikov;

import javax.swing.*;
import java.awt.*;

public class Graph {
    public void paintGraph(final int[] coord) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                int x1 = 0;
                int y1 = this.getHeight();

                for(int i = 0; i < coord.length; i += 2) {
                    int x2 = coord[i];
                    int y2 = this.getHeight() - coord[i + 1];
                    g.drawLine(x1, y1, x2, y2);
                    x1 = x2;
                    y1 = y2;
                }

            }
        };
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
