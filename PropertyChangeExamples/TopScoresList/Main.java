import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        System.out.println(this.name + " new score: " + newScore);
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

            System.out.println(this.toString()); // Print the top scores list
        }
    }

    @Override
    public String toString() {
        String ret = "Top Scores List: \n";
        int rank = 1;
        for (Player player : players) {
            ret += "#" + rank + " - " + player.getName() + ": " + player.getScore() + "\n";
            rank++;
        }
        return ret;
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

        System.out.println(topScoresList);

        // Change some player scores
        player1.setScore(110);
        player4.setScore(130);
    }
}
