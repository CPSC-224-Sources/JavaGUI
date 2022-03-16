package edu.gonzaga;

import java.awt.*;
import javax.swing.*;

public class InheritedFrameDemo
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            InheritedMainJFrame frame = new InheritedMainJFrame();          // SimpleFrame isa JFrame

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("This is Crandall's Title");
            frame.setVisible(true);
        });
    }
}

class InheritedMainJFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public InheritedMainJFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}