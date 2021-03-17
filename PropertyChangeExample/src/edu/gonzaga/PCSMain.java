package edu.gonzaga;

public class PCSMain {
    public static void main(String args[]) {
        System.out.println("----------------- PCS General Example ------------------------");
        PCSModel model = new PCSModel();
        PCSListener listener = new PCSListener("Theresa");
        listener.addPCSModelToListenTo(model);

        model.increment();      // This could be extended to a controller module/interface
        model.increment();
        model.increment();

        PCSListener listener2 = new PCSListener("Suzie");
        listener2.addPCSModelToListenTo(model);

        model.increment();
        model.increment();
    }
}
