import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// ** Core Model class for our game to store player information
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

    public void setName(String newName) {
        String oldName = this.name;
        this.name = newName;
        propertyChangeSupport.firePropertyChange("name", oldName, newName);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}

// ** Observer classes to listen for changes in the Player class
// ** and Inform the views to update themselves
class TopScoresList implements PropertyChangeListener {
    private List<Player> players;
    private PropertyChangeSupport propertyChangeSupport;

    public TopScoresList() {
        propertyChangeSupport = new PropertyChangeSupport(this);
        players = new ArrayList<>();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.addPropertyChangeListener(this);
        sortPlayersByScore(); // Update the scores list
    }

    // Sort the players by score in descending order
    private void sortPlayersByScore() {
        Collections.sort(players, Comparator.comparing(Player::getScore).reversed());

        // Note: you don't *have* to send old and new values in the event
        propertyChangeSupport.firePropertyChange("TopScoreListUpdated", null, null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("score".equals(evt.getPropertyName())) {
            sortPlayersByScore();
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


// ** Views to display the information to the user
// ** For the sake of simplicity, we are just printing the information to the console
// ** In a more UI-oriented system, you would have a GUI or Web interface to display the information
class TopScoreListTerminalView implements PropertyChangeListener {
    private TopScoresList topScoresList;

    public TopScoreListTerminalView(TopScoresList topScoresList) {
        this.topScoresList = topScoresList;
        topScoresList.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("TopScoreListUpdated".equals(evt.getPropertyName())) {
            System.out.println(topScoresList);
        }
    }
}

// ** Another view to display the total score of all players
class TotalPlayersScoreView implements PropertyChangeListener {
    private ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
        player.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("score".equals(evt.getPropertyName())) {
            Integer totalScore = 0;
            for (Player player : players) {
                totalScore += player.getScore();
            }
            System.out.println("Total score view updated to: " + totalScore);
        }
    }
}

// ** Controller class to drive the game
class GameDriverController {
    private ArrayList<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" ********************* Next game round! ********************* ");
            System.out.print("Enter player name: ");
            String name = scanner.nextLine();
            if (name.equals("exit")) {
                break;
            }

            for (Player player : players) {
                if (player.getName().equals(name)) {
                    System.out.print("Enter player's new score: ");
                    int score = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after the int
                    player.setScore(score);
                }
            }
        }
        scanner.close();
    }

}

// ******************************************************************************* //
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Alice", 100);
        Player player2 = new Player("Bob", 75);
        Player player3 = new Player("Charlie", 120);
        Player player4 = new Player("David", 90);

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        // ** Create a TopScoresList and add the players to it
        TopScoresList topScoresList = new TopScoresList();
        for (Player player : players) {
            topScoresList.addPlayer(player);
        }

        System.out.println(topScoresList);

        // Creates a view to display the top scores list with every change
        // TopScoreListTerminalView topScoreListTerminalView = new TopScoreListTerminalView(topScoresList);

        // ** Adding TotalScoreView to display the total score of all players with every score change
        /*
        System.out.println(" ** Adding TotalScoreView");
        TotalPlayersScoreView totalScoreView = new TotalPlayersScoreView();
        for (Player player : players) {
            totalScoreView.addPlayer(player);
        }
         */

        // Change some player scores
        player1.setScore(110);
        System.out.println(topScoresList);

        player4.setScore(130);
        System.out.println(topScoresList);


        /* Uncomment this block to run the game
        GameDriverController gameDriverController = new GameDriverController();
        for (Player player : players) {
            gameDriverController.addPlayer(player);
        }

        gameDriverController.runGame();
        */
    }
}
