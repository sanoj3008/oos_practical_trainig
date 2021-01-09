package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.json.*;
import java.util.ArrayList;

import bank_structure.Transaction;

public class Serializer<T extends Transaction> {
    private Class<T> type;
    GsonBuilder gsonBuilder;

    public Serializer(Class<T> type) {
        this.type = type;

        this.gsonBuilder = new GsonBuilder();
        this.gsonBuilder.registerTypeHierarchyAdapter(Transaction.class, new TransactionAdapter());
    }

    public JsonElement serialize(ArrayList<T> input) {
        Gson gson = this.gsonBuilder.create();
        return gson.toJsonTree(input);
    }

    // that is nott the best practice, but i do not know no a better way :-\
    public ArrayList<T> deserialize(String input) {
        Gson gson = this.gsonBuilder.create();
        JSONArray array = new JSONArray(input);
        ArrayList<T> result = new ArrayList<>();
        for(Object elem: array) {
            result.add((T) gson.fromJson(elem.toString(), type));
        }
        return result;
    }
}
