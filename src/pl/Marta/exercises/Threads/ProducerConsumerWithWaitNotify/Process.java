package pl.Marta.exercises.Threads.ProducerConsumerWithWaitNotify;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Process {

    List<Integer> products = new ArrayList<>();

    private Object lock = new Object();


    public void producer() throws InterruptedException {


        while (true) {

            synchronized (lock) {


                while (products.size() == 10) {
                    lock.wait();
                }


                Random random = new Random(10);
                products.add(random.nextInt());
                lock.notify();


            }
        }
    }

    public void consumer() throws InterruptedException {

        while (true) {
            synchronized (lock) {
                while (products.size() == 0) {
                    lock.wait();
                }

                int value = products.remove(0);
                System.out.println("I removed" + value);
                System.out.println("List size: " + products.size());
                lock.notify();
            }

            Thread.sleep(100);
        }
    }
}
