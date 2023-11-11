package BezierCurve;

import java.awt.*;

public class Curve {

    private int[] curvePointsX = new int[100], curvePointsY = new int[100], basePointsX, basePointsY;
    private int nPoints = 0;
    private final Color clr;

    public Curve(Color clr) {
        this.clr = clr;
    }

    public void setNPoints(int nPoints) {
        this.nPoints = nPoints;
    }

    public void setBasePointsX(int[] basePointsX) {
        this.basePointsX = basePointsX;
    }

    public void setBasePointsY(int[] basePointsY) {
        this.basePointsY = basePointsY;
    }

    public double[] recursiveCalculatePointCoords(double[] tempPointsForCurveX, double[] tempPointsForCurveY,
                                                         double step, int nPoints) {
        nPoints -= 1;
        double[] aX = new double[nPoints];
        double[] aY = new double[nPoints];

        for (int i = 0; i < nPoints; i++) {
            aX[i] = tempPointsForCurveX[i] + step*(tempPointsForCurveX[i + 1] - tempPointsForCurveX[i]);
            aY[i] = tempPointsForCurveY[i] + step*(tempPointsForCurveY[i + 1] - tempPointsForCurveY[i]);
        }

        if (nPoints > 1) {
            return recursiveCalculatePointCoords(aX, aY, step, nPoints);
        } else {
            return new double[]{aX[0], aY[0]};
        }
    }

    public int[] getPointCoords(int[] basePointsX, int[] basePointsY, double step, int nPoints) {
        double[] basePointsXInDouble = new double[nPoints];
        double[] basePointsYInDouble = new double[nPoints];

        for (int i = 0; i < nPoints; i++) {
            basePointsXInDouble[i] = basePointsX[i];
            basePointsYInDouble[i] = basePointsY[i];
        }
        double[] pointCoordInDouble =
                recursiveCalculatePointCoords(basePointsXInDouble, basePointsYInDouble, step, nPoints);
        return new int[]{(int) Math.round(pointCoordInDouble[0]), (int) Math.round(pointCoordInDouble[1])};
    }

    public void calculatePointsCoords() {
        int[] temp;
        for (int i = 0; i < 100; i++) {
            temp = getPointCoords(basePointsX, basePointsY, i*0.01, nPoints);
            curvePointsX[i] = temp[0];
            curvePointsY[i] = temp[1];
        }
    }

    public void draw(Graphics2D g2d) {
        Color old_color = g2d.getColor();
        Stroke old_stroke = g2d.getStroke();
        g2d.setColor(clr);
        /**/

        if (nPoints > 1 && basePointsX != null && basePointsY != null) {
            calculatePointsCoords();
            g2d.drawPolyline(curvePointsX, curvePointsY, 100);
        }

        /**/
        g2d.setStroke(old_stroke);
        g2d.setColor(old_color);
    }
}
