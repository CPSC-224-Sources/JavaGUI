import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class FlowButtons {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame mainWindowFrame = new JFrame("Panel of Buttons");
        mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindowFrame.setSize(400, 400);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Hover Buttons");

        ArrayList<JButton> buttons = new ArrayList<>();
        Integer numColumns = 7;
        for( int buttonNumber = 0; buttonNumber < numColumns; buttonNumber++ ) {
            JButton newButton = new JButton();
            newButton.addMouseListener(new MouseAdapter() {
                Color defaultColor = newButton.getBackground();
                public void mouseEntered(MouseEvent me) {
                    defaultColor = newButton.getForeground();
                    newButton.setBackground(Color.green); // change the color to green when mouse over a button
                }
                public void mouseExited(MouseEvent me) {
                    newButton.setBackground(defaultColor);
                }
            });
            buttons.add(newButton);
        }

        panel.add(label); // Components Added using Flow Layout (left to right)
        for( JButton currButton : buttons ) {
            panel.add(currButton);
        }


        mainWindowFrame.getContentPane().add(BorderLayout.NORTH, panel);
        mainWindowFrame.setLocation(100, 100);
        mainWindowFrame.setVisible(true);
    }
}
