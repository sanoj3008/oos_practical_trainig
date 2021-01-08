package bank_account;

public class Transfer extends Transaction {
    private String sender;
    private String recipient;

    public Transfer(String date, double amount, String desc, String sender, String recipient) {
        super(date, amount, desc);
        this.sender = sender;
        this.recipient = recipient;
    }

    @Override
    public double calculate() {
        return Math.round(this.amount * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Bill: {"
                + "Sender: " + this.sender
                + "Recipiet: " + this.recipient
                + super.toString()
                +'}';
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj) && obj instanceof Transfer) {
            Transfer transfer = (Transfer) obj;
            return transfer.sender.equals(this.sender) && transfer.recipient.equals(this.recipient);
        }
        return false;
    }

    @Override
    protected Transaction clone() {
        return new Transfer(this.getDate(), this.amount, this.getDescription(), this.sender, this.recipient);
    }
}
