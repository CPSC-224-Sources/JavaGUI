package edu.gonzaga;

import java.util.Scanner;

public class PCSMain {
    public static void main(String args[]) {
        System.out.println("----------------- PCS General Example ------------------------");
        PCSModel model = new PCSModel();        // Create our subject object (the model)

        // Create an observer to "listen" to our subject
        PCSListener listener = new PCSListener("Theresa");
        listener.addPCSModelToListenTo(model);

        // Now, have the model change for some reason
        model.increment();      // This could be extended to a controller module/interface
        model.increment();
        model.increment();

        PCSListener listener2 = new PCSListener("Suzie");
        listener2.addPCSModelToListenTo(model);

        // Cause a few more events.
        // Note that both listeners are informed of the model counter property change
        model.increment();
        model.increment();

        /*
        Scanner userInputScanner = new Scanner(System.in);
        String userInput = "";
        while(!userInput.equals("n")) {
            System.out.print("Should we increment? (y/n) ");
            userInput = userInputScanner.nextLine();
            if(userInput.equals("y")) {
                model.increment();
            }
        }
        */
    }
}
