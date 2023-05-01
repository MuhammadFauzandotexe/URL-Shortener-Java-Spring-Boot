package com.example.demo.utility;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Base64;
@Service
@AllArgsConstructor
public class PayLoadEncoder {
    public String encode(String payload){
        String payLoadEncode = Base64.getEncoder().encodeToString(payload.getBytes());
        return payLoadEncode;
    }
    public String decode(String payload){
        try {
            byte[] data = Base64.getDecoder().decode(payload.getBytes());
            String payloadDecode = new String(data);
            return payloadDecode;
        }catch (IllegalArgumentException e){
            return "IllegalArgument";
        }
    }
}

