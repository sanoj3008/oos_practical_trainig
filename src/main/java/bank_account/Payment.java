package bank_account;

public class Payment extends Transaction {
    private double incomingInterest;
    private double outgoingInterest;

    // Der Nutzer kenn die Zinsen nicht -> er benötigt einen Konstruktor, der dies berücksichtigt
    public Payment(String date, double amount, String desc) {
        super(date, amount, desc);
    }

    public Payment(String date, double amount, String desc, double incoming, double outgoing) {
        super(date, amount, desc);
        this.incomingInterest = incoming;
        this.outgoingInterest = outgoing;
    }

    public void setIncomingInterest(double incoming) {
        this.incomingInterest = incoming;
    }

    public void setOutgoingInterest(double outgoing) {
        this.outgoingInterest = outgoing;
    }

    @Override
    public double calculate() {
        double result = 0;
        if(this.amount > 0) {
            result =  this.amount - (this.amount * this.incomingInterest);
        } else {
           result =  this.amount + (this.amount * this.outgoingInterest);
        }
        return Math.round(result * 100.0) / 100.0; // nur zwei Nachkommastellen
    }

    @Override
    public String toString() {
        return "Bill: {" +
                super.toString() +
                '}';
    }

    @Override
    protected Transaction clone() {
        return new Payment(this.getDate(), this.amount, this.getDescription(), this.incomingInterest, this.outgoingInterest);
    }
}
