package pl.Marta.exercises.Threads.Threadexercise.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Processor implements Runnable{

    private int id;


    public Processor(int id) {
        this.id = id;
    }

    public void run(){
        System.out.println("Starting..." + id);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ending.." + id);
    }

    public static void main(String[] args) {

        //defining the executor for 3 tasks

        ExecutorService executor = Executors.newFixedThreadPool(3);

        //creating 5 instances of Processor

        for(int i=0; i<5; i++){
            executor.submit(new Processor(i));
        }

        //ending the work after finishing

        executor.shutdown();

        //awaiting with termination for 1 Day

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
