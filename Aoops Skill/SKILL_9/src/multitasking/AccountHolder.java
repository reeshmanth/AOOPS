package multitasking;

class AccountHolder extends Thread {
    private BankAccount account;
    private String name;
    private int withdrawAmount;

    public AccountHolder(BankAccount account, String name, int withdrawAmount) {
        this.account = account;
        this.name = name;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        account.withdraw(name, withdrawAmount);
    }
}
