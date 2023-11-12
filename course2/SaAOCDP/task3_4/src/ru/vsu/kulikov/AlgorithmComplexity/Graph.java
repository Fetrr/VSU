package ru.vsu.kulikov.AlgorithmComplexity;

import javax.swing.*;
import java.awt.*;

public class Graph {
    private final int[] coordsX, coordsY;
    private final Color clr;
    private final int nPoints;

    public Graph(int startX, int startY, int width, int height, int[] coordsX, int[] coordsY, Color clr, int nPoints) {
        this.clr = clr;
        this.nPoints = nPoints;

        this.coordsX = coordsX;
        this.coordsY = coordsY;

        int minX = coordsX[0], maxX = coordsY[0];
        int minY = coordsX[nPoints - 1], maxY = coordsY[nPoints - 1];
        for (int i = 0; i < nPoints; ++i) {
            /**
             * coordsX[i] = startX + convertedCoordsX[i]
             * coordsY[i] = startY + (height - convertedCoordsY[i])
             */
            coordsX[i] = startX + ((coordsX[i] - minX) * width / (maxX - minX));
            coordsY[i] = startY + (height - ((coordsY[i] - minY) * 600 / (maxY - minY)));
        }
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        Stroke old_stroke = g2d.getStroke();
        g2d.setColor(clr);
        /**/

        for (int i = 0; i < nPoints; i++) {
            g2d.fillOval(coordsX[i] - 5, coordsY[i] - 5,10, 10);
        }
        g2d.drawPolyline(coordsX, coordsY, nPoints);

        /**/
        g2d.setStroke(old_stroke);
        g2d.setColor(old_color);
    }
}

