package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import bank_structure.Transaction;

public class Serializer<T extends Transaction> {
    public JsonElement serialize(T input) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeHierarchyAdapter(Transaction.class, new TransactionAdapter());
        Gson gson = builder.create();
        return gson.toJsonTree(input);
    }

    public T deserialize(JsonElement input, Class<T> classType) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeHierarchyAdapter(Transaction.class, new TransactionAdapter());
        Gson gson = builder.create();
        return (T) gson.fromJson(input, Transaction.class);
    }
}
