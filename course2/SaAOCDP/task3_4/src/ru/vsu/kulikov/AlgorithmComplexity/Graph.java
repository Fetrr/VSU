package ru.vsu.kulikov.AlgorithmComplexity;

import javax.swing.*;
import java.awt.*;

public class Graph {
    public void paintGraph(int x, int y, final int[] coord) {
        // coord[] like [x1, y1, x2, y2, ..., xn, yn]
        JFrame frame = new JFrame();
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                int x1 = x;
                int y1 = y;

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
