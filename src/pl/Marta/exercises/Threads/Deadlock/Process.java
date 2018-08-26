package pl.Marta.exercises.Threads.Deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Process {

    Account account1 = new Account();
    Account account2 = new Account();

    //creating locks to syncchronize the proccess;

    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();


    //a method to lock the threads and to prevent a deadlock

    private void getLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
        //getting locks

        boolean gotFirstLock = false;
        boolean gotSecondLock = false;

        while (true) {
            try {
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();

            } finally {
                if (gotFirstLock && gotSecondLock) {
                    return;
                }
                if (gotFirstLock) {
                    firstLock.unlock();
                }
                if (gotSecondLock) {
                    secondLock.unlock();
                }
            }

            //not getting locks
            Thread.sleep(10);
        }
    }


    //transfers random amount of money from the first account to  the second one

    public void doSomething1() throws InterruptedException {

        for (int i = 0; i < 100; i++) {

           getLocks(lock1, lock2);

            try {
                Random random = new Random();
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {

                lock1.unlock();
                lock2.unlock();
            }
        }

    }

//transfers random amount of money from the second account to  the first one

    public void doSomething2() throws InterruptedException {


        for (int i = 0; i < 100; i++) {

            getLocks(lock2,lock1);

            try {
                Random random = new Random();

                Account.transfer(account2, account1, random.nextInt(100));

            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        }

    }


    public void printResult() {
        System.out.println("The amount on Account 1 is : " + account1.getBalance());
        System.out.println("The amount on Account 2 is : " + account2.getBalance());
        System.out.println(account1.getBalance() + account2.getBalance());
    }
}
