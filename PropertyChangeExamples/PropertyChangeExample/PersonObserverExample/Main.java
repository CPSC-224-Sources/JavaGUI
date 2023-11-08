import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

class Person {
    private String name;
    private int age;
    private PropertyChangeSupport propertyChangeSupport;

    public Person() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange("name", oldValue, name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        int oldValue = this.age;
        this.age = age;
        propertyChangeSupport.firePropertyChange("age", oldValue, age);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}

class PersonView implements PropertyChangeListener {
    public PersonView(Person person) {
        person.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        if ("name".equals(propertyName)) {
            System.out.println("Name changed to: " + evt.getNewValue());
        } else if ("age".equals(propertyName)) {
            System.out.println("Age changed to: " + evt.getNewValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        PersonView view = new PersonView(person);

        // Make changes to the person object
        person.setName("Alice");
        person.setAge(30);

        // The PersonView object will be notified of these changes
    }
}

