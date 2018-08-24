package pl.Marta.exercises.Threads.Threadexercise.AwaitNotifyEx;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final App app = new App();

        //1 Thread - 1 process running

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    app.doSomething1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        //2 Thread - 2 process running

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    app.doSomething2();
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
