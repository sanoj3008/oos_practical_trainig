package BankAccount;

public interface Account {
    public void addTransaction(Transaction transaction);
    public void removeTransaction(Transaction transaction);
    public boolean containsTransaction(Transaction transaction);
    public double calculateAccountBalance();
}
