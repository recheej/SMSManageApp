package com.example.rechee.smsmanage.http;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Rechee on 5/29/2017.
 */

/**
 * Toggl's JSON responses has top level element 'data':
 * Example: {'data': { 'someBool': 'true' } }
 * We don't need the top level element so let's just get data and deserialize it
 * @param <T>
 */
class ToggleResponseSerializer<T> implements JsonDeserializer<T> {

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Get the "content" element from the parsed JSON

        Gson gson = new GsonBuilder()
                //convert java objects with casing, fieldName to Toggl's format of field_name
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer

        JsonElement content = json.getAsJsonObject().get("data");

        if(content == null){
            //If there's no data root object, just parse as usual.
            return gson.fromJson(json, typeOfT);
        }

        return gson.fromJson(content, typeOfT);
    }
}
