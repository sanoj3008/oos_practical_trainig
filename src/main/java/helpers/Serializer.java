package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import org.json.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import bank_structure.Transaction;

public class Serializer<T, R> {
    private Class<T> type;
    GsonBuilder gsonBuilder;

    public Serializer(Class<T> type, R adapter) {
        this.type = type;
        this.gsonBuilder = new GsonBuilder();
        this.gsonBuilder.registerTypeHierarchyAdapter(this.type, adapter);
    }

    public JsonElement serialize(ArrayList<T> input) {
        Gson gson = this.gsonBuilder.create();
        return gson.toJsonTree(input);
    }

    // that is not the best practice, but i do not know no a better way :-\
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
