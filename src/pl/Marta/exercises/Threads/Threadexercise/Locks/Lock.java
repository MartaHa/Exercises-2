package pl.Marta.exercises.Threads.Threadexercise.Locks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lock {

    //locks

    private Object lock1 = new Object();
    private Object lock2 = new Object();


    Random random = new Random();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();


    private void doSomething1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt());
        }
    }


    private void doSomething2() {
        synchronized (lock2) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt());
        }

    }

    private void process() {
        for (int i = 0; i < 1000; i++) {
            doSomething1();
            doSomething2();
        }
    }

    public static void main(String[] args) {

        System.out.println("Starting the process: ");

        long start = System.currentTimeMillis();

        //1 thread -1 list

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        //Thread2 - 2 list

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.start();
        thread2.start();


        long end = System.currentTimeMillis();

        System.out.println("Process started " + start + " It ended: " + end);
        System.out.println(("Process lasted " + (end - start)));
    }

}
