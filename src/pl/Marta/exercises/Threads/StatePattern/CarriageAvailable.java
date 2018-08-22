package pl.Marta.exercises.Threads.StatePattern;

public class CarriageAvailable implements CarriageState {
    @Override
    public void reportStatus(Carriage carriage) {
        System.out.println("The carriage is available");
    }
}
