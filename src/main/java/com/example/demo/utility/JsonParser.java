package com.example.demo.utility;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
@Service
public class JsonParser {
    public JsonObject decodeToJson(String payload){
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(payload, JsonElement.class).getAsJsonObject();
        return jsonObject;
    }
}
