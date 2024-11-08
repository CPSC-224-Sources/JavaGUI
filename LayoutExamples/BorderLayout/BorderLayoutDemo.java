import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

public class BorderLayoutDemo extends JFrame {
    
    public BorderLayoutDemo() {
        // Set up the frame
        setTitle("BorderLayout Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Top (North) - JMenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(quitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // West - JTree with three items
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Items");
        root.add(new DefaultMutableTreeNode("Item 1"));
        root.add(new DefaultMutableTreeNode("Item 2"));
        root.add(new DefaultMutableTreeNode("Item 3"));
        JTree tree = new JTree(root);
        JPanel westPanel = new JPanel(new BorderLayout());
        westPanel.setBorder(BorderFactory.createTitledBorder("West"));
        westPanel.add(new JScrollPane(tree), BorderLayout.CENTER);
        add(westPanel, BorderLayout.WEST);

        // Center - JButton with Yeti icon
        JButton centerButton = new JButton();
        try {
            ImageIcon yetiIcon = new ImageIcon("YetiIcon.png");
            centerButton.setIcon(yetiIcon);
        } catch (Exception e) {
            centerButton.setText("Image not found");
        }
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Center"));
        centerPanel.add(centerButton, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // East - JTextArea with text
        JTextArea textArea = new JTextArea("This is text output");
        textArea.setEditable(false);
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.setBorder(BorderFactory.createTitledBorder("East"));
        eastPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(eastPanel, BorderLayout.EAST);

        // South - JButton
        JButton southButton = new JButton("South click");
        southButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(BorderLayoutDemo.this, "South button clicked!");
            }
        });
        JPanel southPanel = new JPanel();
        southPanel.setBorder(BorderFactory.createTitledBorder("South"));
        southPanel.add(southButton);
        add(southPanel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BorderLayoutDemo::new);
    }
}
