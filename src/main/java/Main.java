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
        JsonElement elements = seriallizer.serialize(accountHolder.getTransactionsSorted(true));
        System.out.println(elements);
        for(Transaction elem: seriallizer.deserialize(elements.toString())) {
            System.out.println(elem.getClass() + " - " + elem.getDescription() + "+ " + elem.getAmount() + " + " + elem.calculate());
        }
    }
}
