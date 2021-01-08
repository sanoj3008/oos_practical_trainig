import bank_account.AccountHolder;
import bank_account.Payment;
import bank_account.Transaction;

public class Main {
    public static void main(String[] args) {
        AccountHolder accountHolder = new AccountHolder("Jonas");
        accountHolder.addTransaction(new Payment(20200101, -150.5, "Abheben", 0.015, 0.01));
        accountHolder.addTransaction(new Payment(20200101, 150.5, "Einzahlen", 0.015, 0.01));
//        accountHolder.addTransaction(new Payment(20200101, -150.5, "Abheben", 0.015, 0.01));
//        accountHolder.addTransaction(new Payment(20200101, -150.5, "Abheben", 0.015, 0.01));
        System.out.println(accountHolder.calculateAccountBalance());
        for(Transaction transaction: accountHolder.getTransactions()) {
            System.out.println(transaction);
        }
    }
}
