package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Die die = new Die();
        die.roll();
        System.out.println(die);

        DieWatcher watcher1 = new DieWatcher(die);
        DieWatcher watcher2 = new DieWatcher(die);

        System.out.println("Rolling the die now - all watchers shall be informed");
        die.roll();
        die.roll();
        die.roll();
        die.roll();
        die.roll();
        die.roll();
        DieWatcher watcher3 = new DieWatcher(die);
        die.roll();
        die.roll();




        System.out.println("Die rolled a what? " + die.getValue());



        /*
        Hand hand = new Hand();
        hand.roll();
        System.out.println(hand.toString());

        DiceImages diceImages = new DiceImages("src/media/");
        */
/*
        Yahtzee yahtzee = new Yahtzee();

 */
    }
}
