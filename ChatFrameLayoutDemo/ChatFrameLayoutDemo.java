//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;

class ChatFrameLayoutDemo {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame mainWindowFrame = new JFrame("Chat Frame");
        mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindowFrame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar menuBarWidget = new JMenuBar();

        JMenu menuFile = new JMenu("FILE");
        JMenu menuHelp = new JMenu("Help");
        menuBarWidget.add(menuFile);
        menuBarWidget.add(menuHelp);

        JMenuItem menuFileOpenOption = new JMenuItem("Open");
        JMenuItem menuFileSaveAsOption = new JMenuItem("Save as");
        menuFile.add(menuFileOpenOption);
        menuFile.add(menuFileSaveAsOption);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");

        JTextField messageTextEntryField = new JTextField(10); // accepts upto 10 characters

        JButton sendButton = new JButton("Send");
        JButton resetButton = new JButton("Reset");

        panel.add(label); // Components Added using Flow Layout (left to right)
        panel.add(messageTextEntryField);
        panel.add(sendButton);
        panel.add(resetButton);

        // Text Area at the Center
        JTextArea textAreaLogView = new JTextArea();

        //Adding Components to the frame.
        mainWindowFrame.getContentPane().add(BorderLayout.SOUTH, panel);
        mainWindowFrame.getContentPane().add(BorderLayout.NORTH, menuBarWidget);
        mainWindowFrame.getContentPane().add(BorderLayout.CENTER, textAreaLogView);
        mainWindowFrame.setVisible(true);
    }
}
