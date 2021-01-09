package bank_structure;

import exceptions.TransactionDoesExistException;
import exceptions.TransactionDoesNotExistException;

import java.io.IOException;
import java.util.ArrayList;

public interface Account {
    public void addTransaction(Transaction transaction) throws TransactionDoesExistException, IOException;
    public void removeTransaction(Transaction transaction) throws TransactionDoesNotExistException, IOException;
    public double calculateAccountBalance();
    public ArrayList<Transaction> getTransactionsSorted(boolean asc);
    public ArrayList<Transaction> getTransactionsByType(boolean positive);
    public void login(String accountId) throws IOException;
    public void logout();
}
