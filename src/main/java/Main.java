import com.google.gson.JsonElement;
import exceptions.TransactionDoesExistException;
import java.util.ArrayList;

import bank_account.Bank;
import bank_structure.Payment;
import bank_structure.Transaction;
import bank_structure.Transfer;
import helpers.Serializer;

public class Main {
    public static void main(String[] args) throws TransactionDoesExistException {
        Bank accountHolder = new Bank(0.12, 0.10);
        accountHolder.addTransaction(new Payment("15.1.2021", -150.5, "Abheben", 0.015, 0.01));
        accountHolder.addTransaction(new Payment("02.02.2021", 150.5, "Einzahlen", 0.015, 0.01));
        accountHolder.addTransaction(new Payment("12.12.2020", 150.5, "Einzahlen", 0.015, 0.01));
        accountHolder.addTransaction(new Transfer("09.01.2021", 120, "Überweisung", "Jonas", "Timo"));
        for(Transaction transaction: accountHolder.getTransactionsSorted(true)) {
            System.out.println(transaction);
        }
        System.out.println(accountHolder.calculateAccountBalance());
        Serializer<Transaction> seriallizer = new Serializer<>();
        ArrayList<JsonElement> elements = new ArrayList<>();
        for(Transaction trans: accountHolder.getTransactionsSorted(true)) {
            elements.add(seriallizer.serialize(trans));
        }
        for(JsonElement elem: elements) {
            System.out.println(seriallizer.deserialize(elem, Transaction.class).getClass());
        }
    }
}
