import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
  // count the number of points
  private int pointCounter = 0;
  // array of 10000 Point references
  private Point[] points = new Point[10000];

  // make GUI and register the mouse event handler
  public PaintPanel() {
    // handles frame mouse motion event
    addMouseMotionListener(new MouseMotionAdapter() {
      // store the drag coordinates and repaint
      @Override
      public void mouseDragged(MouseEvent event) {
        if (pointCounter < points.length) {
          // find points
          points[pointCounter] = event.getPoint();
          // increment point's number in the array
          ++pointCounter;
          // repaint JFrame
          repaint();
        } // end if
      } // end mouseDragged method
    } // end anonymous inner class
    ); // end call to the addMouseMotionListener
  } // end PaintPanel constructor

  /*
  draw oval in a 5 by 5 bounding box at the given location
  on the window
  */
  @Override
  public void paintComponent(Graphics g) {
    // clear drawing area
    super.paintComponent(g);
    // draw all points that we have in array
    for (int i = 0; i < pointCounter; i++) g.fillOval(points[i].x, points[i].y, 5, 5);
  } // end paintComponent method
} // end PaintPanel Class
