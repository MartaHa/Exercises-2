package pl.Marta.exercises.Threads.Callable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) {




        ExecutorService executor = Executors.newFixedThreadPool(1);

           Future<Integer> number = executor.submit(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {

                    System.out.println("I'm working");


                    Random random = new Random();
                    int randomNumber = random.nextInt(1111);


                    if (randomNumber > 400){
                        throw new Exception("Oops  the number is too high");
                    }
                    return randomNumber;

                }

            });
        try {
            System.out.println(number.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        executor.shutdown();
        try {
            executor.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
