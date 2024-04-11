/*
 * Simple Canvas Example using Java Swing
 *
 *  Found from here: https://www.delftstack.com/howto/java/create-canvas-using-java-swing/
 * 
 */

import java.awt.BorderLayout;
import java.awt.Label;
import javax.swing.JFrame;

public class Canvas {
  public static void main(String[] args) {
    // create JFrame Object
    JFrame jFrame = new JFrame("Canvas Using Java Swing");
    // create PaintPanel Object
    PaintPanel paintPanel = new PaintPanel();
    // add paintPanel in center
    jFrame.add(paintPanel, BorderLayout.CENTER);
    // place the created label in the south of BorderLayout
    jFrame.add(new Label("Drag the mouse to draw"), BorderLayout.SOUTH);
    // exit on close
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // set frame size
    jFrame.setSize(500, 400);
    // set jFrame location to center of the screen
    jFrame.setLocationRelativeTo(null);
    // display frame
    jFrame.setVisible(true);
  }
}
