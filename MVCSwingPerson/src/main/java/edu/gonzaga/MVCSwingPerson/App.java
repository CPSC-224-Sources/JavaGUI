package edu.gonzaga.MVCSwingPerson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**
 * The {@code Person} class represents a person with a name and a game score.
 * It uses the MVC (Model-View-Controller) architecture and includes support
 * for property change events.
 */
class Person {
    private String name;
    private int score;
    private PropertyChangeSupport propertyChangeSupport;

    /**
     * Constructs a new {@code Person} object with the specified name and score.
     *
     * @param name  the name of the person
     * @param score the initial game score of the person
     */
    public Person(String name, int score) {
        this.name = name;
        this.score = score;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    /**
     * Gets the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the game score of the person.
     *
     * @return the game score of the person
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the game score of the person and notifies registered listeners
     * about the change using property change events.
     *
     * @param score the new game score of the person
     */
    public void setScore(int score) {
        int oldScore = this.score;
        this.score = score;
        propertyChangeSupport.firePropertyChange("score", oldScore, score);
    }

    /**
     * Adds a property change listener to be notified of changes in the person's properties.
     *
     * @param listener the property change listener to be added
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Removes a property change listener from the list of listeners.
     *
     * @param listener the property change listener to be removed
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}


/**
 * The {@code ScoreView} class is a Swing JFrame that implements the PropertyChangeListener interface.
 * It is responsible for displaying and updating the game score in a JTextField.
 */
class ScoreView extends JFrame implements PropertyChangeListener {
    private JTextField scoreTextField;

    /**
     * Constructs a new {@code ScoreView} with the specified JTextField for displaying the score.
     *
     * @param scoreTextField the JTextField to display and update the game score
     */
    public ScoreView(JTextField scoreTextField) {
        super("Score View");
        this.scoreTextField = scoreTextField;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);

        setVisible(true);
    }

    /**
     * Called when a bound property is changed on the observed object.
     * Updates the score displayed in the JTextField when the "score" property changes.
     *
     * @param evt the property change event
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("score".equals(evt.getPropertyName())) {
            int newScore = (int) evt.getNewValue();
            scoreTextField.setText("Score: " + newScore);
            System.out.println("Score changed: " + newScore);
        }
    }
}


/**
 * The {@code PersonController} class is a controller that handles user interactions for a Person in the MVC architecture.
 * It connects user interface components (JTextField and JButtons) to the underlying Person model.
 */
class PersonController {
    private Person model;
    private JTextField nameTextField;
    private JButton increaseButton;
    private JButton decreaseButton;

    /**
     * Constructs a new {@code PersonController} with the specified model and user interface components.
     * It sets up action listeners for the increaseButton, decreaseButton, and nameTextField to update the model accordingly.
     *
     * @param model            the Person model to be controlled
     * @param nameTextField    the JTextField for entering or displaying the name
     * @param increaseButton   the JButton to increase the score
     * @param decreaseButton   the JButton to decrease the score
     */
    public PersonController(Person model, JTextField nameTextField, JButton increaseButton, JButton decreaseButton) {
        this.model = model;
        this.nameTextField = nameTextField;
        this.increaseButton = increaseButton;
        this.decreaseButton = decreaseButton;

        final Person thePerson = model;
        final JTextField theTextField = nameTextField;

        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentScore = thePerson.getScore();
                thePerson.setScore(currentScore + 1);
            }
        });

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentScore = thePerson.getScore();
                thePerson.setScore(currentScore - 1);
            }
        });

        nameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thePerson.setScore(Integer.parseInt(theTextField.getText()));
            }
        });
    }
}


public class App {
    public static void main(String[] args) {
        Person person = new Person("Player1", 0);

        JTextField nameTextField = new JTextField();
        JButton increaseButton = new JButton("Increase Score");
        JButton decreaseButton = new JButton("Decrease Score");
        JTextField scoreTextField = new JTextField("0");
        scoreTextField.setHorizontalAlignment(JLabel.CENTER);

        ScoreView scoreView = new ScoreView(scoreTextField);

        PersonController controller = new PersonController(person, nameTextField, increaseButton, decreaseButton);
        person.addPropertyChangeListener(scoreView);

        JFrame frame = new JFrame("MVC Swing Example");
        frame.setLayout(new GridLayout(4, 1));

        frame.add(new JLabel("Player Name:"));
        frame.add(nameTextField);
        frame.add(increaseButton);
        frame.add(decreaseButton);
        frame.add(scoreTextField);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
