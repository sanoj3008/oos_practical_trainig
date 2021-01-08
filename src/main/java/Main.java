import bank_account.AccountHolder;
import bank_account.Payment;
import bank_account.Transaction;
import exceptions.TransactionDoesExistException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws TransactionDoesExistException {
        AccountHolder accountHolder = new AccountHolder("Jonas");
        accountHolder.addTransaction(new Payment("15.1.2021", -150.5, "Abheben", 0.015, 0.01));
        accountHolder.addTransaction(new Payment("02.02.2021", 150.5, "Einzahlen", 0.015, 0.01));
        accountHolder.addTransaction(new Payment("12.12.2020", 150.5, "Einzahlen", 0.015, 0.01));
        for(Transaction transaction: accountHolder.getTransactions()) {
            System.out.println(transaction);
        }
        System.out.println(accountHolder.calculateAccountBalance());
    }
}
