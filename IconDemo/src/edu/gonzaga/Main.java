package edu.gonzaga;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.*;

public class Main {

    public static void main(String[] args) {
        JFrame f=new JFrame("Button Example with Listener");

        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 280,20);

        JButton b=new JButton("Click Here");

        ImageIcon yetiIcon = new ImageIcon("./YetiIcon.png");
        f.setIconImage(yetiIcon.getImage());

        // The new bit
        BufferedImage yetiPicture;
        JLabel picLabel = null;
        try {
            yetiPicture = ImageIO.read(new File("./YetiIcon.png"));
            // picLabel = new JLabel(new ImageIcon(yetiPicture));
             picLabel = new JLabel("hello world");
            picLabel.setBounds(50, 130, 100, 150);
            f.add(picLabel);                    // Add picture
        } catch(IOException e) {
            e.printStackTrace();
        }

        //JLabel yetiLabel = new JLabel(yetiIcon);      // Make yeti chase you!
        // Need to hook to mouseEvent tracking. :-)

        Timer yetiTimer = new Timer(5000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setIconImage(null);
                tf.setText("It's gone now. I guess we're safe");
                b.setText("Just... not again.");
                picLabel.setText("gone");
            }
        });

        b.setBounds(50,100,200,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // NOTE: e contains information about *what* action was performed
                tf.setText("It's a 5 second yeti! RUN!");
                b.setText(("Why did you do that!?!"));
                f.setIconImage(yetiIcon.getImage());
                picLabel.setIcon(yetiIcon);
                yetiTimer.start();                          // Start the Yeti timer
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
