package ru.vsu.kulikov;

import ru.vsu.kulikov.AlgorithmComplexity.*;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    // create objects
    Graph graph;
    CreateCoordsForGraph createCoordsForGraph;
    public DrawPanel () {
        // construct objects
        createCoordsForGraph = new CreateCoordsForGraph();
        createCoordsForGraph.timetable(1000, 10, 10, 1000, false);
        graph = new Graph(0, 0, 800, 600,
                createCoordsForGraph.getCoordsX(), createCoordsForGraph.getCoordsY(),
                new Color(0, 0, 0), createCoordsForGraph.getnPoints());
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
