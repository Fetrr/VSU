package BezierCurve;

import java.awt.*;

public class Points {
    private int[] pointsX, pointsY, oldPointsX, oldPointsY;
    private int nPoints = 0;
    private final Color clr;
    private final boolean lineBetweenPoints;

    public Points(Color clr, boolean lineBetweenPoints) {
        this.clr = clr;
        this.lineBetweenPoints = lineBetweenPoints;
    }

    public int getNPoints() {
        return nPoints;
    }

    public int[] getPointsX() {
        return pointsX;
    }

    public int[] getPointsY() {
        return pointsY;
    }

    public void addPoint(int pointX, int pointY) {
        nPoints += 1;
        if (pointsX == null && pointsY == null) {
            pointsX = new int[1];
            pointsY = new int[1];

            pointsX[0] = pointX;
            pointsY[0] = pointY;
        } else {
            oldPointsX = pointsX;
            oldPointsY = pointsY;

            pointsX = new int[nPoints];
            pointsY = new int[nPoints];

            for (int i = 0; i < nPoints - 1; i++) {
                pointsX[i] = oldPointsX[i];
                pointsY[i] = oldPointsY[i];
            }
            pointsX[nPoints - 1] = pointX;
            pointsY[nPoints - 1] = pointY;
        }
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        Stroke old_stroke = g2d.getStroke();
        g2d.setColor(clr);
        /**/
        for (int i = 0; i < nPoints; i++) {
            g2d.fillOval(pointsX[i] - 5, pointsY[i] - 5,10, 10);
        }
        if (lineBetweenPoints && nPoints > 1) {
            g2d.drawPolyline(pointsX, pointsY, nPoints);
        }
        /**/
        g2d.setStroke(old_stroke);
        g2d.setColor(old_color);
    }
}
