package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
public class GsonTest {
    @Test
    void testGson(){
        String jsonStr = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        Gson gson = new Gson();
        JsonObject jsonElement = gson.fromJson(jsonStr, JsonElement.class).getAsJsonObject();
        System.err.println(jsonElement);
    }
}
