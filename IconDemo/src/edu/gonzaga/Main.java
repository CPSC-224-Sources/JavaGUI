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
            picLabel = new JLabel(new ImageIcon(yetiPicture));
            picLabel.setBounds(50, 130, 100, 150);
            f.add(picLabel);                    // Add picture
            picLabel.setVisible(false);
        } catch(IOException e) {
            e.printStackTrace();
        }

        //JLabel yetiLabel = new JLabel(yetiIcon);      // Make yeti chase you!
        // Need to hook to mouseEvent tracking. :-)

        final JLabel finalPicLabel = picLabel;
        Timer yetiTimer = new Timer(5000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setIconImage(null);
                tf.setText("It's gone now. I guess we're safe");
                b.setText("Just... not again.");
                finalPicLabel.setVisible(false);
            }
        });

        b.setBounds(50,100,200,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // NOTE: e contains information about *what* action was performed
                tf.setText("It's a 5 second yeti! RUN!");
                b.setText(("Why did you do that!?!"));
                f.setIconImage(yetiIcon.getImage());
                finalPicLabel.setVisible(true);
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

class GUIDie extends JLabel {
    GUIDie() {
        Die myDie = new Die();
    }

    void updateImage() {

    }
}

class Hand {
    ArrayList<Die> dice = new ArrayList<>();
    JPanel myPanel;

    Hand() {
        //make_the_dice;
        //gen_panel();
    }

    void gen_panel() {
        myPanel = new JPanel();
        //for ( die : dice ) {
        //    myPanel.add(layoutHOOHA(die.get_label()));
        // Add in checkboxes
        // Add in roll button
        //}
    }

    void get_panel() {
        //return myPanel;
    }

}

class Die {
    JLabel myLabel;
    int currVal = 1;
    Die() {
        myLabel = new JLabel();
    }

    void roll() {
        //currVal = rand();
        //updateImage();
    }

   // BufferedImage get_image() { return new BufferedImage("bassed on my currVal"); }

    //void updateImage() { myLabel.setIcon(get_image()); }

   // JLabel get_label() { return myLabel; }
}