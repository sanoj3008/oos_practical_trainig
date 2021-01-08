package bank_account;

import exceptions.TransactionDoesExistException;
import exceptions.TransactionDoesNotExistException;

public interface Account {
    public void addTransaction(Transaction transaction) throws TransactionDoesExistException;
    public void removeTransaction(Transaction transaction) throws TransactionDoesNotExistException;
    public boolean containsTransaction(Transaction transaction);
    public double calculateAccountBalance();
}
