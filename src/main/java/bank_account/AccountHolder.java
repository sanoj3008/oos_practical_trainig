package bank_account;

import bank_structure.Account;
import bank_structure.Payment;
import bank_structure.Transaction;
import exceptions.TransactionDoesExistException;
import exceptions.TransactionDoesNotExistException;

import java.util.ArrayList;

public class AccountHolder implements Account {
    private String holder;
    private ArrayList<Transaction> transactions;

    public AccountHolder(String holder) {
        this.holder = holder;
        this.transactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    @Override
    public void addTransaction(Transaction transaction) throws TransactionDoesExistException {
        if(!this.containsTransaction(transaction)) {
            this.transactions.add(transaction);
            this.calculateAccountBalance();
        } else {
            throw new TransactionDoesExistException();
        }
    }

    @Override
    public void removeTransaction(Transaction transaction) throws TransactionDoesNotExistException {
        if(this.containsTransaction(transaction)) {
            this.transactions.remove(transaction);
            this.calculateAccountBalance();
        } else {
            throw new TransactionDoesNotExistException();
        }
    }

    @Override
    public boolean containsTransaction(Transaction transaction) {
        return this.transactions.contains(transaction);
    }

    public double calculateAccountBalance() {
        double overdraftInterest = 0.15;

        double res = 0;
        int cnt = 0;
        while (cnt < this.transactions.size()-1) {
            res += this.transactions.get(cnt).calculate();
            cnt++;
        }

        Transaction lastTransaction = this.transactions.get(cnt);
        if(res < 0 && lastTransaction.calculate() > 0) {
            double overdraft = res * overdraftInterest;
            Payment overdraftPayment = new Payment("08.01.2021", overdraft, "overdraft", 0, 0);
            this.transactions.add(overdraftPayment);
            res += overdraft;
        }

        res += lastTransaction.calculate();
        return Math.round(res * 100.0) / 100.0;
    }

    @Override
    public ArrayList<Transaction> getTransactionsSorted(boolean asc) {
        ArrayList<Transaction> sortedList = new ArrayList<>(this.transactions);
        if(asc) sortedList.sort((t1, t2) -> (int) (t1.calculate()*100 - t2.calculate()*100));
        else sortedList.sort((t1, t2) -> (int) (t2.calculate() - t1.calculate()));
        return sortedList;
    }

    @Override
    public ArrayList<Transaction> getTransactionsByType(boolean positiv) {
        ArrayList<Transaction> filtered = new ArrayList<>(this.transactions);
        if(positiv) filtered.removeIf(t -> t.calculate() >= 0);
        else filtered.removeIf(t -> t.calculate() < 0);
        return filtered;
    }
}
