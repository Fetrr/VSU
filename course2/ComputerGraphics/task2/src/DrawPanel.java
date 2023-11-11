import BezierCurve.Curve;
import BezierCurve.Points;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends JPanel {
    // create objects
    Curve curve;
    Points points;

    public DrawPanel () {
        // construct objects
        curve = new Curve(new Color(0, 0, 0));
        points = new Points(new Color(255, 0, 0, 70), true);

        MouseListener listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                points.addPoint(e.getX(), e.getY());
                curve.setNPoints(points.getNPoints());
                curve.setBasePointsX(points.getPointsX());
                curve.setBasePointsY(points.getPointsY());

                repaint();
                System.out.println("click");
            }
        };
        addMouseListener(listener);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        this.setBackground(new Color(255, 255, 255));

        // paint functions
        curve.draw(g2d);
        points.draw(g2d);
    }
}
