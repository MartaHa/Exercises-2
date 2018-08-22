package pl.Marta.exercises.Threads.Threadexercise.ThreadEx;

public class MyRun implements Runnable {

    private int number;

    public MyRun(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Running " + number);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
