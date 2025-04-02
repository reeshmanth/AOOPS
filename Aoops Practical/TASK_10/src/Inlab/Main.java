package Inlab;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1001, 5000); 

        Thread t1 = new Thread(new TransactionRunnable(account, 1000, true), "Thread-R1"); 
        Thread t2 = new Thread(new TransactionRunnable(account, 2000, false), "Thread-R2"); 

        Thread t3 = new TransactionThread(account, 1500, true); 
        Thread t4 = new TransactionThread(account, 3000, false); 
        t3.setName("Thread-T1");
        t4.setName("Thread-T2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Account Balance: " + account.getBalance());
    }
}
