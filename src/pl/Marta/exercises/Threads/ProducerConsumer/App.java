package pl.Marta.exercises.Threads.ProducerConsumer;


import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    //quene class

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    //producer

    public static void producer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            queue.put(random.nextInt(100));
        }

    }
    //consumer

    public static void consumer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 0) {
                Integer value = queue.take();
                System.out.println("The taken value is: " + value);
                System.out.println("Queue value is: " + queue.size());
            }
        }
    }

    public static void main(String[] args) {


        //Thread1 producer
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //Thread2 consumer
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
