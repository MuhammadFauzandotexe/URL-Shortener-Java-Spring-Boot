package com.example.demo.utility;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class ClearClass {
    private final JsonObject jsonObject;
    private final PayLoadEncoder payLoadEncoder;
    private final Gson gson;
    public String encodeJson(String uniqueKey,String username, String email){
        jsonObject.addProperty("uniqueKey",uniqueKey);
        jsonObject.addProperty("username",username);
        jsonObject.addProperty("email",email);
        String jsonEncoded = payLoadEncoder.encode(String.valueOf(jsonObject));
        return jsonEncoded;
    }
    public JsonObject decodeJson(String payload){
        JsonObject jsonObject = gson.fromJson(payLoadEncoder.decode(payload), JsonElement.class).getAsJsonObject();
        return jsonObject;
    }
}
