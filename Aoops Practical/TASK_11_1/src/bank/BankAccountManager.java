package bank;

public class BankAccountManager {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1000.0);

        Thread user1 = new UserTransaction(sharedAccount, true, 500.0);
        Thread user2 = new UserTransaction(sharedAccount, false, 200.0);
        Thread user3 = new UserTransaction(sharedAccount, true, 300.0);
        Thread user4 = new UserTransaction(sharedAccount, false, 1000.0);

        user1.start();
        user2.start();
        user3.start();
        user4.start();

        try {
            user1.join();
            user2.join();
            user3.join();
            user4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Account Balance: " + sharedAccount.getBalance());
    }
}
