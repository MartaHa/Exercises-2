package pl.Marta.exercises.Threads.StatePattern;

public class CarriageUnavailable implements CarriageState {
    @Override
    public void reportStatus(Carriage carriage) {
        System.out.println("the carriage is already in use");
    }
}
