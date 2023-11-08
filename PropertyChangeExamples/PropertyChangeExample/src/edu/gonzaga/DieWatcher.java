package edu.gonzaga;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class DieWatcher implements PropertyChangeListener {
    public DieWatcher(Die dieToWatch) {
        dieToWatch.addPropertyChangeListener(this);
    }

    public void propertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if ("dievalue".equals(propertyName)) {
            System.out.println("Die Watcher has propertyChange called for a new value of: " + e.getNewValue());
        }
    }


}
