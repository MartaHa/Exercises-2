package pl.Marta.exercises.Threads.Deadlock;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        final Process process = new Process();


        //Thrread1

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.doSomething1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //Thrread1

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.doSomething2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        process.printResult();
    }
}
