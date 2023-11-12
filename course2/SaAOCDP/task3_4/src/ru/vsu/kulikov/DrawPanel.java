package ru.vsu.kulikov;

import ru.vsu.kulikov.AlgorithmComplexity.*;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    // create objects
    Graph graph;
    public DrawPanel () {
        // construct objects
    }

    public void setGraph(int startX, int startY, int width, int height,
                         int[] coordsX, int[] coordsY, Color clr, int nPoints) {
        graph = new Graph(startX, startY, width, height, coordsX, coordsY, clr, nPoints);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        this.setBackground(new Color(255, 255, 255));

        // paint functions
        graph.draw(g2d);
    }
}
