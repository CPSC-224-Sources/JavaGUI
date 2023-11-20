import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingExample extends JFrame {
    private JLabel label;
    private JTextField textField;

    public SwingExample() {
        // Set up the JFrame
        super("Swing Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        // Create a JPanel with FlowLayout
        JPanel panel = new JPanel(new FlowLayout());

        // Create buttons
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        // Create label and text field
        label = new JLabel("Enter text:");
        textField = new JTextField(15);

        // Add ActionListener to button1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button 1 pressed!");
            }
        });

        // Add ActionListener to button2
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button 2 pressed!");
            }
        });

        // Add ActionListener to button3
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button 3 pressed!");
            }
        });

        // Add components to the panel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(label);
        panel.add(textField);

        // Set the content pane of the JFrame
        setContentPane(panel);

        // Make the JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingExample();
            }
        });
    }
}
