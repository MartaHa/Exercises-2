package pl.Marta.exercises.Threads.Threadexercise.SimpleThreadEx;

public class Main {

    public static void main(String[] args) {


        Runnable[] run = new Runnable[10];
        Thread[] threads = new Thread[10];


        //creating classes runner for number 0-9
        for (int i = 0; i < 10; i++) {
            run[i] = new Runner(i);
        }
        //creating Threads
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(run[i]);
        }
        //starting Threads
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        //stoppping thread a join() method

        if (Thread.currentThread() == threads[9]) {
            try {
                threads[9].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //change 1 to deemon

        if (Thread.currentThread() == threads[1]) {
                threads[1].setDaemon(true);

        }
    }
}
