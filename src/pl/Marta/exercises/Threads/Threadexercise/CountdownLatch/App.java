package pl.Marta.exercises.Threads.Threadexercise.CountdownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {

    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Starting to work");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latch.countDown();
    }

}


public class App {
    public static void main(String[] args) {

        //creating Threads

        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService executor = Executors.newFixedThreadPool(5);


        //creating Processes

        for (int i = 0; i < 5; i++) {
            executor.submit(new Processor(latch));

        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed");
    }
}
