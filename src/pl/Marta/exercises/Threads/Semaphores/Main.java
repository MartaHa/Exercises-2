package pl.Marta.exercises.Threads.Semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {

        //cretang lots of threads

        ExecutorService executor = Executors.newFixedThreadPool(100);



        for (int i = 0; i < 100; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {

                        Connect.getInstance().aquireSemaphore();

                }
            });
        }
        //closing all threads when they end
        executor.shutdown();

        //await termination for 1 day
        executor.awaitTermination(1, TimeUnit.DAYS);

    }
}
