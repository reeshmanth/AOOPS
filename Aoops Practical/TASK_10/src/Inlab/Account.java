package Inlab;

class Account {
    private double balance;

    public Account(int accountNumber, double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", New Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", New Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " - Insufficient Balance!");
        }
    }

    public double getBalance() {
        return balance;
    }
}