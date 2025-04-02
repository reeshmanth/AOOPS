package multitasking;

class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(String name, int amount) {
        System.out.println(name + " is trying to withdraw $" + amount);
        
        if (balance >= amount) {
            System.out.println(name + " is withdrawing $" + amount);
            balance -= amount;
            System.out.println(name + " successfully withdrew. Remaining balance: $" + balance);
        } else {
            System.out.println(name + " cannot withdraw. Insufficient balance!");
        }
    }
}
