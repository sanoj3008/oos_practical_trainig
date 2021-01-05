package BankAccount;

public abstract class Transaction implements CalculateBill {
    protected int date;
    protected double amount;
    private String description;

    public Transaction(int date, double amount, String desc) {
        this.date = date;
        this.amount = amount;
        this.description = desc;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDescription() {
        return this.description;
    }

    protected String getDate() {
        int year = this.date / 10000;
        int month = (this.date - (year * 10000)) / 100;
        int day = this.date - (year * 10000) - (month * 100);
        return day + "." + month + "." + year;
    }

    @Override
    public String toString() {
        return
                "Date: " + this.getDate() + ", "
                + "Amount: " + this.calculate() + ", "
                + "Description: " + this.description;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj instanceof Transaction) {
            Transaction transaction = (Transaction) obj;
            return transaction.date == this.date && transaction.amount == this.amount;
        }

        return false;
    }

    @Override
    protected abstract Transaction clone();
}
