package bank_account;

public abstract class Transaction implements CalculateBill {
    protected int date;
    protected double amount;
    private String description;

    public Transaction(String date, double amount, String desc) throws IllegalArgumentException {
        this.date = createDate(date);
        this.amount = amount;
        this.description = desc;
    }

    private int createDate(String date) throws IllegalArgumentException {
        int result;
        try {
            String[] dateArray = date.split("\\.");
            result = Integer.parseInt(dateArray[2]) * 10000 + Integer.parseInt(dateArray[1]) * 100 + Integer.parseInt(dateArray[0]);
            if (result <= 9999999) throw new IllegalArgumentException();
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("date is malformed");
        }
        return result;
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
