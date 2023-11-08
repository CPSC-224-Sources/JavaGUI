package edu.gonzaga;

import java.util.ArrayList;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Hand implements PropertyChangeListener {
    ArrayList<Die> dice;
    int dieCount = 6;

    public Hand() {
        dice = new ArrayList<>();
        for (int i = 0; i < dieCount; i++ ) {
            Die currDie = new Die();
            dice.add(currDie);
            currDie.addPropertyChangeListener(this::propertyChange);
        }
    }

    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if ("dievalue".equals(propertyName)) {
            System.out.println(("Die changed to: " + e.getNewValue()));
        }
        // } else if ("focusedWindow".equals(propertyName) {
        //    ...
        // }
    }

    public Die getDieAt(int index) {
        return dice.get(index);
    }

    public void roll() {
        for( Die die : dice ) {
            die.roll();
        }
    }

    public String toString() {
        String ret = "";
        ret += "Hand: ";
        for( Die die : dice ) {
            ret += die.toString() + " | ";
        }
        return ret;
    }
}
