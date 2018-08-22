package pl.Marta.exercises.Threads.Threadexercise.ThreadWithSynchro;

public class App2 {

    public int number = 0;


    public synchronized void increment(){
        number++;
    }

    public void work() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();


        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The number is: " + number);


    }


    public static void main(String[] args) {
        App2 app2 = new App2();
        app2.work();

    }
}
