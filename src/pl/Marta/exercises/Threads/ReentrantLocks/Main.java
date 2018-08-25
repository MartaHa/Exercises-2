package pl.Marta.exercises.Threads.ReentrantLocks;

public class Main {


    public static void main(String[] args) throws InterruptedException {


        final Process process = new Process();

        //Thread1

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.addNumber1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        //Thread2

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.addNumber2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        process.writeSum();

    }
}
