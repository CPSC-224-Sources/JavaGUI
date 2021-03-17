package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Die die = new Die();
        die.roll();
        System.out.println(die);

        DieWatcher watcher1 = new DieWatcher(die);

        System.out.println("Rolling the die now");
        die.roll();
        System.out.println("Die rolled a what? " + die.getValue());




        System.out.println("----------------- PCS General Example ------------------------");
        PCSModel model = new PCSModel();
        PCSListener listener = new PCSListener("Theresa");
        listener.addPCSModelToListenTo(model);

        model.increment();      // This could be extended to a controller module/interface
        model.increment();
        model.increment();

        PCSListener listener2 = new PCSListener("Suzie");
        listener2.addPCSModelToListenTo(model);

        model.increment();
        model.increment();

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
