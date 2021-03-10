package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Die die = new Die();
        die.roll();
        System.out.println(die);

        DieView button = new DieView();
        button.setDieToView(die);

        System.out.println("Rolling the die now");
        die.roll();
        System.out.println("Die rolled a what? " + die.getValue());

        System.out.println("Done");


        /*
        Hand hand = new Hand();
        hand.roll();
        System.out.println(hand.toString());

        DiceImages diceImages = new DiceImages("src/media/");
        */

        Yahtzee yahtzee = new Yahtzee();
    }
}
