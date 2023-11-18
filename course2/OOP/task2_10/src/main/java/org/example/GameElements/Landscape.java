package org.example.GameElements;

import java.awt.*;
import java.util.Random;

// Landscape is polygon
public class Landscape {
    private final int detalization; // num of points in polygon
    private final int minX, maxX, minY, maxY; // bounds
    private int[] coordsX, coordsY;

    public Landscape(int detalization, int minX, int maxX, int minY, int maxY) {
        this.detalization = detalization;
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        coordsX = coordsY = new int[detalization];
    }

    public void setCoordsX(int[] coordsX) {
        this.coordsX = coordsX;
    }

    public void setCoordsY(int[] coordsY) {
        this.coordsY = coordsY;
    }

    /**
     * Generate values for two arrays: coordsX and coordsY.
     * coordsX: equally split X coords by (detalization - 2), (- 2) because landscape is polygon and need bounds points.
     * coordsY: init var swing that is proportional to the length of segment, then random(sum, subtract or not change)
     * this var and last Y coord. Loop for (detalization - 2) times.
     * Last 2 points is bound points so that the edges of polygon dont intersect.
     */
    public void generateRandomLandscape() {
        Random random = new Random();

        // get X coords
        // +2 const point for bounds
        // d = 7:
        // [0, 200, 400, 600, 800, , ]
        for (int i = 0; i < detalization - 2; i++) {
            coordsX[i] = minX + i*((maxX - minX)/(detalization - 3));
        }
        // [0, 200, 400, 600, 800, 800, 0]
        coordsX[detalization - 2] = maxX - minX;
        coordsX[detalization - 1] = 0;

        // generate Y coords
        int swingY = (maxY - minY)/(2*detalization);
        coordsY[0] = (int) (minY + Math.random()*maxY);

        int nextStep;

        for (int i = 1; i < detalization - 2; i++) {
            // prev coord + negative or positive swingY
            nextStep = coordsY[i - 1] + swingY*(random.nextInt(3)*2 - 1);

            // out of bounds check
            if (nextStep > maxY) {
                nextStep = coordsY[i - 1] - swingY;
            } else if (nextStep < minY) {
                nextStep = coordsY[i - 1] + swingY;
            }

            coordsY[i] = nextStep;
        }
        coordsY[detalization - 2] = maxY;
        coordsY[detalization - 1] = maxY;
    }
    public boolean isPointInLandscape(int x1, int y1) {
        return countIntersections(x1, y1) % 2 != 0;
    }

    private int countIntersections(int x1, int y1) {
        int intersections = 0;

        int x2 = x1 + 100;
        int y2 = y1 + 100;

        for (int i = 0; i < detalization; i++) {
            int currX = coordsX[i];
            int currY = coordsY[i];

            int nextX;
            int nextY;

            if (i == detalization - 1) {
                nextX = coordsX[0];
                nextY = coordsY[0];
            } else {
                nextX = coordsX[i + 1];
                nextY = coordsY[i + 1];
            }

            // Проверяем, если луч пересекает границу многоугольника
            if ((currY >= y1 && nextY < y1) || (currY < y1 && nextY >= y1)) {
                double xIntersection = (y1 - currY) * (nextX - currX) / (nextY - currY) + currX;

                // Проверяем, если точка пересечения находится правее x1
                if (xIntersection > x1) {
                    intersections++;
                }
            }
        }

        return intersections;
    }

/*
    public boolean isPointInLandscape(int x1, int y1) {
        return countIntersections(x1, y1) % 2 != 0;
    }

    /**
     * First, build ray for point(x, y) and straight line for segment, then find their point of intersection and
     * check if this point in the segment. Loop for one ray and all segments.
     *
     * @param x1 ray coord X1
     * @param y1 ray coord Y1
     * @return nums of intersections ray(x, y) and line segment
     */
    /*
    private int countIntersections(int x1, int y1) {
        int intersections = 0;

        // init ray x2, y2
        // set random values, but they must be the same for all segments in loop
        int x2 = x1 + 100;
        int y2 = y1 + 100;

        // calculate slope coefficient and constant term

        double k1 = (y2 - y1)/(x2 - x1);
        double k2;
        double b1 = y1 - k1*x1;
        double b2;

        int currX, currY, nextX, nextY;
        for (int i = 0; i < detalization; i++) {
            if (i - 1 < 0) {
                currX = coordsX[detalization - 1];
                currY = coordsY[detalization - 1];
                nextX = coordsX[0];
                nextY = coordsY[0];
            } else {
                currX = coordsX[i - 1];
                currY = coordsY[i - 1];
                nextX = coordsX[i];
                nextY = coordsY[i];
            }

            if (nextX == currX) {
                double x = nextX;
                double y = k1*x + b1;
                if (y <= Math.max(nextY, currY) && y >= Math.min(nextY, currY) && x > x1 && y > y1) {
                    intersections++;
                }
                continue;
            } else {
                k2 = (nextY - currY) / (nextX - currX);
                b2 = currY - k2*currX;
            }

            // if lines are parallel
            if (k1 == k2) {
                if (b1 == b2) {
                    ++intersections; // on the same line
                    continue;
                }
                continue;
            }

            // calc coords of the intersection point
            // y1 = y2 => k1*x + b1 = k2*x + b2 => x(k1 - k2) = b2 - b1 => x = (b2 - b1)/(k1 - k2)
            double x = (b2 - b1)/(k1 - k2); // k1 != k2
            double y = k1*x + b1;

            // check if this point of ray or straight line
            if (x < x1 || y < y1) {
                continue;
            }

            // check if this point of the segment
            if (x <= Math.max(nextX, currX) && x >= Math.min(nextX, currX) &&
                    y <= Math.max(nextY, currY) && y >= Math.min(nextY, currY)) {
                intersections++;
                System.out.println("\tsegment X1: " + currX + "; segment Y1: " + currY +
                        "; segment X2: " + nextX + "; segment Y2: " + nextY + ";");
                System.out.println("\tpoint X1: " + x1 + "; point Y1: " + y1 + "; point X2: " + x2 +
                        "; point Y2: " + y2 + "; intrstr point X: " + x + "; intstr point Y: " + y);
            }
            System.out.println(intersections);
        }
        return intersections;
    }
    */

    public double getAngle(int i, int j) {
        return Math.atan((coordsX[i] - coordsX[j])/(coordsY[i] - coordsY[j]));
    }

    public void draw(Graphics2D g2d) {
        g2d.drawPolygon(coordsX, coordsY, detalization);
    }
}
