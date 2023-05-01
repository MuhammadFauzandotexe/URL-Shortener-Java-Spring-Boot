package com.example.demo.utility;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import java.util.Base64;
@Service
@AllArgsConstructor
public class PayLoadEncoder {
    private final JsonObject jsonObject;
    @SneakyThrows
    public String encode(String uniqueKey, String name, String email){
        String payLoad = uniqueKey+"&="+name+"&="+email;
        String payLoadEncode = Base64.getEncoder().encodeToString(payLoad.getBytes());
        return payLoadEncode;
    }
    public String decode(String payload){
        try {
            byte[] data = Base64.getDecoder().decode(payload.getBytes());
            String payloadDecode = new String(data);
            return payloadDecode;
        }catch (IllegalArgumentException e){
            return "oops some things wrongs";
        }
    }
}

