package edu.gonzaga;

import java.util.Random;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class Die {
    int value = 0;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
          this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    public void roll() {
        Random rand = new Random(); //instance of random class
        int upperbound = 6;
        this.setValue( rand.nextInt(upperbound) + 1 );
    }

    private void setValue(int newValue) {
        int oldValue = this.value;
        this.value = newValue;
        this.pcs.firePropertyChange("dievalue", oldValue, newValue);
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "Die value: " + value;
    }
}
