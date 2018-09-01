package pl.Marta.exercises.Threads.Semaphores;
//Singleton

import java.util.concurrent.Semaphore;

public class Connect {


    //number of connections
    private int number = 0;

    //private constructor
    private Connect() {
    }

    //instance of class
    private static Connect instance = new Connect();

    //getting the instance of the class

    public static Connect getInstance() {
        return instance;
    }

    //limiting the number of threads using a semaphore

    Semaphore semaphore = new Semaphore(13);


    //aquiring connections safer then putting them into the method

    public void aquireSemaphore(){

        try{
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                connect();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            semaphore.release();
        }
    }




    // method

    public void connect() throws InterruptedException {



        synchronized (this) {
            number++;
            System.out.println("Connection: " + number);
        }
        System.out.println("I'm sleeping now");
        Thread.sleep(500);

        synchronized (this) {
            number--;
        }

    }

}


