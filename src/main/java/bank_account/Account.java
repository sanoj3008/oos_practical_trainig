package bank_account;

import exceptions.TransactionDoesExistException;

import java.util.ArrayList;

public interface Account {
    public void addTransaction(Transaction transaction) throws TransactionDoesExistException;
    public boolean containsTransaction(Transaction transaction);
    public double calculateAccountBalance();
    public ArrayList<Transaction> getTransactionsSorted(boolean asc);
    public ArrayList<Transaction> getTransactionsByType(boolean positiv);
}
