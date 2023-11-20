package edu.gonzaga.MVCSwingPerson;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.Test;

public class PersonTest {

    @Test
    public void testSetScore() {
        // Arrange
        Person person = new Person("TestPerson", 0);

        // Act
        TestPropertyChangeListener listener = new TestPropertyChangeListener();
        person.addPropertyChangeListener(listener);
        person.setScore(10);

        // Assert
        assertEquals(10, person.getScore());
        assertTrue(listener.propertyChangeCalled);
        assertEquals("score", listener.propertyChangeEvent.getPropertyName());
        assertEquals(0, listener.propertyChangeEvent.getOldValue());
        assertEquals(10, listener.propertyChangeEvent.getNewValue());
    }

    @Test
    public void testAddRemovePropertyChangeListener() {
        // Arrange
        Person person = new Person("TestPerson", 0);
        TestPropertyChangeListener listener = new TestPropertyChangeListener();

        // Act
        person.addPropertyChangeListener(listener);
        person.setScore(5);

        // Assert
        assertTrue(listener.propertyChangeCalled);

        // Act
        listener.reset();
        person.removePropertyChangeListener(listener);
        person.setScore(10);

        // Assert
        assertFalse(listener.propertyChangeCalled);
    }

    private static class TestPropertyChangeListener implements PropertyChangeListener {
        private boolean propertyChangeCalled = false;
        private PropertyChangeEvent propertyChangeEvent;

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            propertyChangeCalled = true;
            propertyChangeEvent = evt;
        }

        public void reset() {
            propertyChangeCalled = false;
            propertyChangeEvent = null;
        }
    }
}
