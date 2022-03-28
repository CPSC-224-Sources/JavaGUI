package edu.gonzaga;

import java.util.logging.*;
import java.util.ArrayList;

class Die {

    private Logger logger;

    public Die() {
        logger = Logger.getLogger("Die");
        // logger.setLevel(Level.OFF);
        logger.info("Instantiating a die");
    }
}

public class Main {
    // Obtain a suitable logger.
    private Logger logger;
    private FileHandler fh; 

    public Main() {
        logger = Logger.getLogger("edu.gonzaga.HelloWorldDemo");
        try {
            fh = new FileHandler("mylog.txt");
        } catch ( Exception ex ) {
            logger.log(Level.SEVERE, "Could not open log file", ex);
        }

        //Level.FINEST;
        //Level.INFO;
        //Level.OFF;
        //Level.ALL;

        logger.setLevel(Level.ALL);     // Level.ALL

        logger.addHandler(fh);
        logger.info("This is informational / status stuff");

        logger.warning("This is for when a recoverable/ignorable error happened");

        ArrayList<Die> dice = new ArrayList<>();
        for(int dieCounter = 0; dieCounter < 5; dieCounter++) {
            dice.add(new Die());
        }

        // Log a FINE tracing message
        logger.fine("done -- kinda like to know it ended.");

    }

    public static void main(String[] args) {
        System.out.println("Running software logging demo.");
        Main myDemo = new Main();
    }
}

