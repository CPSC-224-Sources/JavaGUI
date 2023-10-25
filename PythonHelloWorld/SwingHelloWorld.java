import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingHelloWorld {
    private int counter = 0;
    private JLabel counterLabel;

    public SwingHelloWorld() {
        JFrame frame = new JFrame("Swing Hello, World!");

        // Create a panel for the counter
        JPanel counterPanel = new JPanel();
        frame.add(counterPanel);

        counterLabel = new JLabel("Counter: " + counter);
        counterPanel.add(counterLabel);

        JButton incrementButton = new JButton("Increment");
        counterPanel.add(incrementButton);

        // Create a panel for the second frame with label, button, and checkboxes
        JPanel frame2Panel = new JPanel();
        frame.add(frame2Panel);

        JLabel label2 = new JLabel("Frame 2");
        frame2Panel.add(label2);

        JButton button2 = new JButton("Button 2");
        frame2Panel.add(button2);

        JCheckBox checkbox1 = new JCheckBox("Checkbox 1");
        frame2Panel.add(checkbox1);

        JCheckBox checkbox2 = new JCheckBox("Checkbox 2");
        frame2Panel.add(checkbox2);

        JCheckBox checkbox3 = new JCheckBox("Checkbox 3");
        frame2Panel.add(checkbox3);

        // Add action listener to the increment button
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                counterLabel.setText("Counter: " + counter);
            }
        });

        frame.setLayout(new GridLayout(2, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingHelloWorld();
            }
        });
    }
}

