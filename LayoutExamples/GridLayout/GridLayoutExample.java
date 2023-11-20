import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutExample extends JFrame {
    public GridLayoutExample() {
        // Set up the JFrame
        super("GridLayout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        // Create a JPanel with GridLayout
        JPanel panel = new JPanel(new GridLayout(5, 5));

        // Create buttons for the top row
        for (int i = 0; i < 5; i++) {
            JButton button = new JButton("Button " + (i + 1));
            panel.add(button);

            final Integer buttonNum = i;
            // Add ActionListener to each button
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Button " + (buttonNum + 1) + " pressed!");
                }
            });
        }

        // Create text labels for the rest of the grid
        for (int i = 0; i < 20; i++) {
            JLabel label = new JLabel("Label " + (i + 1), SwingConstants.CENTER);
            panel.add(label);
        }

        // Set the content pane of the JFrame
        setContentPane(panel);

        // Make the JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GridLayoutExample();
            }
        });
    }
}

