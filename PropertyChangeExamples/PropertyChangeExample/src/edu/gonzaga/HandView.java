package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.border.Border;

public class HandView {
    JPanel myPanel;
    ArrayList<DieView> dieViews;
    JButton rollButton;
    Hand hand;

    void setupPanel() {
        myPanel = new JPanel();
        Border blackline = BorderFactory.createLineBorder(Color.black);
        myPanel.setLayout(new FlowLayout());
        myPanel.setSize(600, 100);
        myPanel.setBorder(blackline);
    }

    void setupDiceViews() {
        for( int i = 0; i < 5; i++ ) {
            DieView newView = new DieView();
            newView.setDieToView(hand.getDieAt(i));
            dieViews.add(newView);
            myPanel.add(newView);
        }
    }

    void setupRollButton() {
        rollButton = new JButton("Roll!");
        rollButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Button pressed to roll");
                    hand.roll();
                }
            }
        );
        myPanel.add(rollButton);
    }

    HandView(Hand newHand) {
        hand = newHand;
        dieViews = new ArrayList<>();

        setupPanel();
        setupDiceViews();
        setupRollButton();

    }

    public JPanel getPanel() {
        return myPanel;
    }
}
