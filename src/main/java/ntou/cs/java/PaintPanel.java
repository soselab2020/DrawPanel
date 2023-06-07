package ntou.cs.java;

//Rewriting Fig. 11.34
//Using class MouseMotionAdapter.

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {

    ArrayList<ColorPoint> points = new ArrayList<ColorPoint>();
	PointReader reader;
	PointWriter writer;

    // set up GUI and register mouse event handler
    public PaintPanel(PointReader reader, PointWriter writer) {
		this.reader = reader;
		this.writer = writer;
        // handle frame mouse motion event
        addMouseMotionListener(

                new MouseMotionAdapter() {
                    // store drag coordinates and repaint
                    public void mouseDragged(MouseEvent event) {

                        ColorPoint point = new ColorPoint();

                        point.setX(event.getPoint().x);
                        point.setY(event.getPoint().y);
                        // set the color of the current point
                        if (event.isControlDown()) {
                            point.setColor("r");
                        } else if (event.isAltDown()) {
                            point.setColor("g");
                        } else if (event.isShiftDown()) {
                            point.setColor("m");
                        } else // left mouse button
                            point.setColor("b");
                        points.add(point);

                        repaint(); // repaint JFrame

                    } // end method mouseDragged
                } // end anonymous inner class
        ); // end call to addMouseMotionListener
    } // end PaintPanel constructor

    // draw oval in a 4-by-4 bounding box at specified location on window
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // clears drawing area

        // draw all points in array
        for (ColorPoint point : points) {

            switch (point.getColor()) {
                case "r":
                    g.setColor(Color.RED);
                    break;
                case "g":
                    g.setColor(Color.GREEN);
                    break;
                case "b":
                    g.setColor(Color.BLUE);
                    break;
                case "m":
                    g.setColor(Color.MAGENTA);
            }
            g.fillOval(point.getX(), point.getY(), 4, 4);
        }
    } // end method paint

    public void load() {
        points.clear();

        reader.openFile();
        reader.readPoints();
        reader.closeFile();

        points = reader.getPoints();
        repaint();
    }

    public void save() {

        writer.openFile();
        writer.writePoints(points);
        writer.closeFile();

    }
} // end class PaintPanel
