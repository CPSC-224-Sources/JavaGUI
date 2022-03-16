package edu.gonzaga;

import javax.swing.*;
public class ButtonExample {
    public static void main(String[] args) {
        JFrame mainWindowFrame = new JFrame("Button Example");
        JButton demoButton1 = new JButton("Click Here");

        mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWindowFrame.add(demoButton1);

        mainWindowFrame.pack();

        mainWindowFrame.setVisible(true); // Start mainloop
    }
}

        // b.setBounds(50,100,95,30);
        //f.setSize(400,400);
        // f.setLayout(null);