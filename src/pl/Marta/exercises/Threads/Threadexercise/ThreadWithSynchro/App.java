package pl.Marta.exercises.Threads.Threadexercise.ThreadWithSynchro;

import java.util.Scanner;

class Processor extends Thread {

    private volatile boolean running = true;

    @Override
    public void run() {

        while (running) {
            System.out.println("I'am running");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class App {


    public static void main(String[] args) {

        Processor processor1 = new Processor();
        processor1.start();


        System.out.println("Hit return to stop");
        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();

        processor1.shutdown();


    }
}
