package pl.Marta.exercises.Threads.Deadlock;

public class Account {

    private int balance = 1000;

    public void withdraw(int money){
        balance += money;

    }

    public void deposit(int money){
        balance -= money;

    }

    public static  void transfer(Account account1, Account account2, int money){
        account1.withdraw(money);
        account2.deposit(money);
    }


    public int getBalance() {
        return balance;
    }


}
