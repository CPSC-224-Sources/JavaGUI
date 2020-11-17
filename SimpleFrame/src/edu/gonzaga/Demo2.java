package edu.gonzaga;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class Demo2 {

    public static void main(String args[])
    {
        Demo2 demo = new Demo2();

    }

    public Demo2() {
        PanelExample();
    }

    public void PanelExample()
    {
        JFrame f = new JFrame();
        f.setTitle("Yahtzee");
        f.setSize(1024, 768);
        f.setVisible(true);

        Container contentPane = f.getContentPane();
        contentPane.setLayout(new FlowLayout());

        JPanel panel=new JPanel();
        panel.setBounds(40,80,200,200);
        panel.setBackground(Color.gray);
        JButton b1=new JButton("Button 1");
        // b1.setBounds(50,100,80,30);
        b1.setBackground(Color.yellow);
        Border heldBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        Border heldBorder2 = BorderFactory.createLineBorder(Color.red, 5, true);
        b1.setBorder(heldBorder2);
        JButton b2=new JButton("Button 2");
        // b2.setBounds(100,100,80,30);
        b2.setBackground(Color.green);
        b2.setBorder(heldBorder);
        panel.add(b1); panel.add(b2);
        panel.setVisible(false);
        f.add(panel);
        // f.add(b1);
        // f.add(b2);
        f.setSize(400,400);
        // f.setLayout(null);
        f.setVisible(true);
    }
}
