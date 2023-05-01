package com.example.demo.dto;

import lombok.Data;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
@Data
public class AuthorDTO {
    private String name;
    private String email;
    private String password;
    public String getUniqueKey() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }
    public LocalDateTime getTimeNow(){
        LocalDateTime now = LocalDateTime.now();
        return now;
    }
}
