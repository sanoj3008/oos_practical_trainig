package bank_account;

import bank_structure.Account;
import bank_structure.Transaction;
import exceptions.TransactionDoesNotExistException;

import java.util.ArrayList;

public class AccountHolder implements Account {
    private String accountId;
    private ArrayList<Transaction> transactions;

    public AccountHolder(String id) {
        this.accountId = id;
    }

    public void getTransactions() {
        // make a request and init your transaction list
    }

    public void login() {
        this.login(this.accountId);
    }

    @Override
    public void login(String accountId) {
        try {
            // request server
            this.getTransactions();
        } catch (Exception e) {

        }
    }

    @Override
    public void logout() {
        // request server
        this.transactions = null;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        try {
            // request server to add a transaction
        } catch (Exception e) {
            // display error if transaction already exists
        } finally {
            // request server to receive all transactions
            this.getTransactions();
        }
    }

    @Override
    public void removeTransaction(Transaction transaction) throws TransactionDoesNotExistException {
        try {
            // request server to remove a transaction
        } catch (Exception e) {
            // display error if transaction does not exist
        } finally {
            // request server to receive all transactions
            this.getTransactions();
        }
    }

    public double calculateAccountBalance() {
        // request server for result
        return 0;
    }

    @Override
    public ArrayList<Transaction> getTransactionsSorted(boolean asc) {
        // request server for result
       return null;
    }

    @Override
    public ArrayList<Transaction> getTransactionsByType(boolean positiv) {
        // request server for result
        return null;
    }
}
