import com.google.gson.JsonElement;
import exceptions.TransactionDoesExistException;

import java.io.IOException;
import java.util.ArrayList;

import bank_account.Bank;
import bank_structure.Payment;
import bank_structure.Transaction;
import bank_structure.Transfer;
import exceptions.TransactionDoesNotExistException;
import helpers.Serializer;

public class Main {
    public static void main(String[] args) {
        Bank accountHolder = new Bank(0.12, 0.10);
        try {
            accountHolder.login("jonas");
            accountHolder.addTransaction(new Payment("14.1.2021", -150.5, "Abheben", 0.015, 0.01));
            /*accountHolder.addTransaction(new Payment("02.02.2021", 150.5, "Einzahlen", 0.015, 0.01));
            accountHolder.addTransaction(new Payment("12.12.2020", 150.5, "Einzahlen", 0.015, 0.01));
            accountHolder.addTransaction(new Transfer("09.01.2021", 120, "Überweisung", "Jonas", "Timo"));*/
//            accountHolder.removeTransaction(new Transfer("09.01.2021", 120, "Überweisung", "Jonas", "Timo"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(accountHolder.getTransactionsSorted(true));
    }
}
