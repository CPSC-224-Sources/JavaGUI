package edu.gonzaga;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class PCSModel {

    Integer counter = 0;            // This could be *anything*, but a counter is simple

     private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

     public void addPropertyChangeListener(PropertyChangeListener listener) {
         pcs.addPropertyChangeListener(listener);
     }

     public void removePropertyChangeListener(PropertyChangeListener listener) {
         pcs.removePropertyChangeListener(listener);
     }

    public PCSModel() {
         counter = 0;
    }

    public void increment() {
        Integer oldValue = counter;
        counter++;
        pcs.firePropertyChange("PCSModel.counter", oldValue, counter);
    }
}
