package com.example.demo;

import com.example.demo.utility.JsonParser;
import com.example.demo.utility.PayLoadEncoder;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
@AllArgsConstructor
public class MakeObjectJsonTest {
    @Test
    void testJsonObejct() {
        PayLoadEncoder payLoadEncoder = new PayLoadEncoder();
        JsonObject jsonObject = new JsonObject();

        String uniqueKey = "asasasasasasasas";
        String username = "fauzan";
        String email = "mafauzan51087@gmail.com";

        jsonObject.addProperty("uniqueKey",uniqueKey);
        jsonObject.addProperty("username",username);
        jsonObject.addProperty("email",email);

        String jsonEncoded = payLoadEncoder.encode(String.valueOf(jsonObject));
        System.err.println(jsonEncoded);

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject1 = new JsonObject();
        jsonObject1 = jsonParser.decodeToJson(payLoadEncoder.decode(jsonEncoded));
        System.err.println(jsonObject1);


    }
}
