package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class Yahtzee {
    static GraphicsConfiguration gc;
    JFrame mainWindow;

    Hand hand;
    HandView handView;

    void setupMainWindow() {
        mainWindow = new JFrame(gc);
        mainWindow.setTitle("Yahtzee game by Crandall");
        mainWindow.setSize(600, 400);
        mainWindow.setLocation(200,200);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void startGUI() {
        mainWindow.setVisible(true);
    }

    void setupHand() {
        hand = new Hand();
    }

    void setupHandView() {
        handView = new HandView(hand);
    }

    public Yahtzee() {
        setupHand();
        setupHandView();
        setupMainWindow();

        DieView dv = new DieView();
        dv.setDieToView(hand.getDieAt(0));

        Die die = hand.getDieAt(0);
        die.roll();

        mainWindow.add(handView.getPanel());

        startGUI();
    }
}
