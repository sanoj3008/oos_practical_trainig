package helpers;

import com.google.gson.*;
import java.lang.reflect.Type;

import bank_structure.Payment;
import bank_structure.Transaction;
import bank_structure.Transfer;

public class TransactionAdapter implements JsonSerializer<Transaction>, JsonDeserializer<Transaction> {
    private static final String CLASSNAME = "CLASSNAME";
    private static final String PROPERTIES = "INSTANCE";
    @Override
    public Transaction deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get(CLASSNAME).getAsString();
        JsonElement element = jsonObject.get(PROPERTIES);

        switch (type) {
            case "Payment":
                return new Gson().fromJson(element, Payment.class);
            case "Transfer":
                return new Gson().fromJson(element, Transfer.class);
            default:
                throw new JsonParseException("Unknown element type: " + type);
        }
    }

    @Override
    public JsonElement serialize(Transaction transaction, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add(CLASSNAME, new JsonPrimitive(transaction.getClass().getSimpleName()));
//        result.add("properties", context.serialize(transaction, transaction.getClass()));
//        JsonElement properties = context.serialize(transaction);
        result.add(PROPERTIES, new Gson().toJsonTree(transaction, type));

        return result;
    }
}
