package pl.Marta.exercises.Threads.ProducerConsumerWithWaitNotify;

import static pl.Marta.exercises.Threads.ProducerConsumer.App.consumer;
import static pl.Marta.exercises.Threads.ProducerConsumer.App.producer;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        //Thread1

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

        //Thread1

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

        thread1.join();
        thread2.join();


    }
}
