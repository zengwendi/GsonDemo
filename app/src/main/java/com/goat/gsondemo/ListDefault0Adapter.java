package com.goat.gsondemo;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Created by zengwendi on 2017/7/11.
 */

public class ListDefault0Adapter implements JsonDeserializer<List> {
    @Override
    public List deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            if (json.isJsonArray()) {
                Gson newGson = new Gson();
                return newGson.fromJson(json, typeOfT);
            }
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
        return Collections.EMPTY_LIST;
    }

}