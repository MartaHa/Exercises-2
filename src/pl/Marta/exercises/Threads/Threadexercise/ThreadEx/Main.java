package pl.Marta.exercises.Threads.Threadexercise.ThreadEx;

public class Main {

    public static void main(String[] args) {

        //check
        System.out.println("działa");

        //Threads
        Runnable[] runners = new Runnable[10];
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            runners[i] = new MyRun(i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runners[i]);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }

}

