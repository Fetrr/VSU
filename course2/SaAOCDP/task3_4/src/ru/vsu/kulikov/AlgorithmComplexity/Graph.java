package ru.vsu.kulikov.AlgorithmComplexity;

import java.awt.*;

public class Graph {
    private final int[] coordsX1, coordsY1;
    private final Color clr;
    private final int nPoints;

    public Graph(int startX, int startY, int width, int height, int[] coordsX, int[] coordsY, Color clr, int nPoints) {
        this.clr = clr;
        this.nPoints = nPoints;

        coordsX1 = new int[nPoints];
        coordsY1 = new int[nPoints];

        int minX = coordsX[0];
        for (int i = 1; i < coordsX.length; i++) {
            if (coordsX[i] < minX) {
                minX = coordsX[i];
            }
        }
        int maxX = coordsX[0];
        for (int i = 1; i < coordsX.length; i++) {
            if (coordsX[i] > maxX) {
                maxX = coordsX[i];
            }
        }
        int minY = coordsY[0];
        for (int i = 1; i < coordsY.length; i++) {
            if (coordsY[i] < minY) {
                minY = coordsY[i];
            }
        }
        int maxY = coordsY[0];
        for (int i = 1; i < coordsY.length; i++) {
            if (coordsY[i] > maxY) {
                maxY = coordsY[i];
            }
        }
        //System.out.println("minX = " + minX + " maxX = " + maxX + " minY = " + minY + " maxY = " + maxY);
        for (int i = 0; i < nPoints; ++i) {
            /**
             * coordsX[i] = startX + convertedCoordsX[i]
             * coordsY[i] = startY + (height - convertedCoordsY[i])
             */
            //System.out.print("old: " + coordsX[i] + " " + coordsY[i] + "; ");

            coordsX1[i] = startX + ((coordsX[i] - minX) * (width - startX) / (maxX - minX));
            coordsY1[i] = startY + height - (int)(((long)coordsY[i] - minY) * (height - startY) / (maxY - minY));

            //System.out.println("new " + coordsX1[i] + " " + coordsY1[i] + " i = " + i + " n = " + nPoints);
        }
        //System.out.println("minX = " + minX + " maxX = " + maxX + " minY = " + minY + " maxY = " + maxY);
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        Stroke old_stroke = g2d.getStroke();
        g2d.setColor(clr);
        /**/

        for (int i = 0; i < nPoints; i++) {
            g2d.fillOval(coordsX1[i] - 2, coordsY1[i] - 2,4, 4);
        }
        g2d.drawPolyline(coordsX1, coordsY1, nPoints);

        /**/
        g2d.setStroke(old_stroke);
        g2d.setColor(old_color);
    }
}

