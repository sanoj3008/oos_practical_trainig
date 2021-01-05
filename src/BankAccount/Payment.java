package BankAccount;

public class Payment extends Transaction {
    private double incomingInterest;
    private double outgoingInterest;

    public Payment(int date, double amount, String desc, double incoming, double outgoing) {
        super(date, amount, desc);
        this.incomingInterest = incoming;
        this.outgoingInterest = outgoing;
    }

    @Override
    public double calculate() {
        if(this.amount > 0) {
            return this.amount - (this.amount * this.incomingInterest);
        } else {
            return this.amount + (this.amount * this.outgoingInterest);
        }
    }

    @Override
    public String toString() {
        return "Bill: {" +
                super.toString() +
                '}';
    }

    @Override
    protected Transaction clone() {
        return new Payment(this.date, this.amount, this.getDescription(), this.incomingInterest, this.outgoingInterest);
    }
}
