import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Player {
    private int score;
    private String name;
    private PropertyChangeSupport propertyChangeSupport;

    public Player(String name, int initialScore) {
        this.name = name;
        this.score = initialScore;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setScore(int newScore) {
        int oldScore = this.score;
        this.score = newScore;
        propertyChangeSupport.firePropertyChange("score", oldScore, newScore);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}

class TopScoresList implements PropertyChangeListener {
    private List<Player> players;
    private JTextArea textArea;

    public TopScoresList() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("score".equals(evt.getPropertyName())) {
            // Sort the players by score in descending order
            Collections.sort(players, Comparator.comparing(Player::getScore).reversed());

            StringBuilder topPlayersText = new StringBuilder();
            int rank = 1;
            for (Player player : players) {
                topPlayersText.append("#").append(rank).append(" - ").append(player.getName()).append(": ").append(player.getScore()).append("\n");
                rank++;
            }
            textArea.setText(topPlayersText.toString());
        }
    }

    public void setDisplayArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Alice", 100);
        Player player2 = new Player("Bob", 75);
        Player player3 = new Player("Charlie", 120);
        Player player4 = new Player("David", 90);

        TopScoresList topScoresList = new TopScoresList();
        topScoresList.addPlayer(player1);
        topScoresList.addPlayer(player2);
        topScoresList.addPlayer(player3);
        topScoresList.addPlayer(player4);

        // Create a simple Swing interface
        SwingUtilities.invokeLater(() -> createAndShowGUI(topScoresList));
    }

    private static void createAndShowGUI(TopScoresList topScoresList) {
        JFrame frame = new JFrame("Top Scores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 200));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        JButton updateButton = new JButton("Update Scores");
        updateButton.addActionListener(e -> {
            // Simulate score updates
            topScoresList.addPlayer(new Player("Eve", 140));
            topScoresList.addPlayer(new Player("Frank", 85));
        });

        topScoresList.setDisplayArea(textArea);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(updateButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

