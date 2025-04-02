package bank;

class UserTransaction extends Thread {
    private BankAccount account;
    private boolean isDeposit;
    private double amount;

    public UserTransaction(BankAccount account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}

