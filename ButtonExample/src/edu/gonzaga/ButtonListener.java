package edu.gonzaga;

import java.awt.event.*;
import javax.swing.*;

public class ButtonListener {
    public static void main(String[] args) {
        JFrame f=new JFrame("Button Example with Listener");

        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 150,20);

        JButton b=new JButton("Click Here");
        b.setBounds(50,100,200,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // NOTE: e contains information about *what* action was performed
                tf.setText("You Clicked it!");
                b.setText(("Why did you do that!?!"));
            }
        });

        // Add components to the frame (window)
        f.add(b);
        f.add(tf);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
}