package edu.gonzaga;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class CustomListener implements ActionListener {
    Integer numClicks = 0;
    JTextField myField = null;

    public CustomListener(JTextField theField) {
        myField = theField;
    }

    public void actionPerformed(ActionEvent e) {
        numClicks++;
        myField.setText("Click# " + numClicks.toString());
    }
}

public class ButtonCustomListener {
    public static void main(String[] args) {
        JFrame f=new JFrame("Button Example with Listener");

        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 150,20);

        final JTextField tf2=new JTextField();
        tf2.setBounds(250,50, 150,20);
        CustomListener specialListener = new CustomListener(tf2);

        JButton b=new JButton("Click Here");
        b.setBounds(50,100,200,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // NOTE: e contains information about *what* action was performed
                tf.setText("You Clicked it!");
                b.setText(("Why did you do that!?!"));
            }
        });
        b.addActionListener(specialListener);       // See custom listener object above

        // Add components to the frame (window)
        f.add(b);
        f.add(tf);
        f.add(tf2);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
}