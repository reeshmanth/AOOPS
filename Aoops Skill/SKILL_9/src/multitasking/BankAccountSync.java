package multitasking;

public class BankAccountSync {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);

        AccountHolder user1 = new AccountHolder(account, "Reeshmanth", 300);
        AccountHolder user2 = new AccountHolder(account, "Kusumitha", 200);
        AccountHolder user3 = new AccountHolder(account, "Sasank", 400);

        user1.start();
        user2.start();
        user3.start();
    }
}