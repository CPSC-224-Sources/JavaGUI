package edu.gonzaga;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class PCSListener implements PropertyChangeListener {
    String myName = "none";
    public PCSListener(String newName) {
        myName = newName;
    }

    public void addPCSModelToListenTo(PCSModel model) {
        model.addPropertyChangeListener(this);
    }

    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        System.out.println("PCSListener " + myName + " has propertyChange called by " + propertyName + " that changed from: " + e.getOldValue() + " to: " + e.getNewValue());
    }
}

