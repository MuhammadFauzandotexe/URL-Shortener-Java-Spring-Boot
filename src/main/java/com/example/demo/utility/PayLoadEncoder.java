package com.example.demo.utility;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@AllArgsConstructor
public class PayLoadEncoder {
    private final JsonObject jsonObject;
    public String encode(String uniqueKey, String name, String email){
        jsonObject.addProperty("uniqueKey",uniqueKey);
        jsonObject.addProperty("name",name);
        jsonObject.addProperty("email",email);
        return jsonObject.toString();
    }
    public String decode(String payload){
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(payload);
            String decodedPayload = new String(decodedBytes);
            return decodedPayload.toString();
        }
        catch (IllegalArgumentException e){
            return e.toString();
        }
    }
}

