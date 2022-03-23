package edu.gonzaga;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        JFrame mainWindowFrame = new JFrame("Button Example with Listener");
        mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextField userViewTextField = new JTextField();
        userViewTextField.setBounds(50,50, 280,20);

        JButton yetiInvokeButton = new JButton("Click Here");

        ImageIcon yetiIcon = new ImageIcon("./YetiIcon.png");
        mainWindowFrame.setIconImage(yetiIcon.getImage());

        // The new bit
        BufferedImage yetiPicture;
        JLabel picLabel = null;
        try {
            yetiPicture = ImageIO.read(new File("./YetiIcon.png"));
            picLabel = new JLabel(new ImageIcon(yetiPicture));
            picLabel.setBounds(50, 130, 100, 150);
            mainWindowFrame.add(picLabel);                    // Add picture for menu bar
            picLabel.setVisible(false);
        } catch(IOException e) {
            e.printStackTrace();
        }

        //JLabel yetiLabel = new JLabel(yetiIcon);      // Make yeti chase you!
        // Need to hook to mouseEvent tracking. :-)

        final JLabel finalPicLabel = picLabel;
        Timer yetiTimer = new Timer(5000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainWindowFrame.setIconImage(null);
                userViewTextField.setText("It's gone now. I guess we're safe");
                yetiInvokeButton.setText("Just... not again.");
                finalPicLabel.setVisible(false);
            }
        });

        yetiInvokeButton.setBounds(50,100,200,30);
        yetiInvokeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // NOTE: e contains information about *what* action was performed
                userViewTextField.setText("It's a 5 second yeti! RUN!");
                yetiInvokeButton.setText(("Why did you do that!?!"));
                mainWindowFrame.setIconImage(yetiIcon.getImage());
                finalPicLabel.setVisible(true);
                yetiTimer.start();                          // Start the Yeti timer
            }
        });

        // Add components to the frame (window)
        mainWindowFrame.add(yetiInvokeButton);
        mainWindowFrame.add(userViewTextField);
        mainWindowFrame.setSize(400,400);
        mainWindowFrame.setLayout(null);
        mainWindowFrame.setVisible(true);
    }
}