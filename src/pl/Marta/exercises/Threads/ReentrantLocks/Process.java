package pl.Marta.exercises.Threads.ReentrantLocks;


import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Process {


    private int number;
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private void increment() {
        for (int i = 0; i < 1000; i++) {
            number++;
        }
    }


    public void addNumber1() throws InterruptedException {

        lock.lock();

        //make thread waiting

        System.out.println("I'm waiting");
        condition.await();
        System.out.println("I'm working again..");

        try {
            increment();

        } catch (Exception e) {
            e.getStackTrace();
        } finally {

            lock.unlock();
        }
    }


    public void addNumber2() throws InterruptedException {

        //Making sure that the thread starts as a second one
        Thread.sleep(500);
        lock.lock();

        //notify the other thread

        System.out.println("To wake the other hit return: ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("Got the return key!");
        condition.signal();

        try {
            increment();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {

            lock.unlock();
        }
    }


    public void writeSum() {
        System.out.println("The number is: " + number);
    }
}
