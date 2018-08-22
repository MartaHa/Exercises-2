package pl.Marta.exercises.Threads.Threadexercise.SimpleThreadEx;

public class Runner implements Runnable {


    private int threadNumber;

    public Runner(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {

        for (int i=0; i< 10; i++ )
        System.out.println(i * 10 + threadNumber);

    }
}
