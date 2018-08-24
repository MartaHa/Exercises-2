package pl.Marta.exercises.Threads.Threadexercise.AwaitNotifyEx;

import java.util.Scanner;

public class App {


    public void doSomething1() throws InterruptedException {
        synchronized (this) {
            System.out.println("I'am running");
            wait();
            System.out.println("I'm running again");
        }
    }

    public void doSomething2() throws InterruptedException {

        synchronized (this) {
            //this thread starts as second
            Thread.sleep(2000);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Hit return to wake up the first thread!");
            scanner.nextLine();
            notify();
        }
    }
}