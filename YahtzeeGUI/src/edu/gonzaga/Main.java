package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import edu.wsu.WSUDice;

public class Main {

    public static void main(String[] args) {
        /*
        Die die = new Die();
        die.roll();
        System.out.println(die);

        Hand hand = new Hand();
        hand.roll();
        System.out.println(hand.toString());

        DiceImages diceImages = new DiceImages("src/media/");
        */

        WSUDice crimsonDie = new WSUDice();

        Yahtzee yahtzee = new Yahtzee();
    }
}
