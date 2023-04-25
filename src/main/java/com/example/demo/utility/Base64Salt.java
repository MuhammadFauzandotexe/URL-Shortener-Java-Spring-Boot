package com.example.demo.utility;

import lombok.Data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
@Data
public class Base64Salt {
    public static void main(String[] args) {
        String payLoad = "dE4yYjVNYktoMHVrWmhZNWhveEF1QT09Jj0mPWZhdXphbndlJj0mPW1mYXV6YW41MTA4N0BnbWFpbC5jb20=";
        String decodedString = new String(Base64.getDecoder().decode(payLoad));
        System.err.println(decodedString);
    }
    private static String generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }
    private static String hashWithSalt(String plainText, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] saltBytes = Base64.getDecoder().decode(salt);
        md.update(saltBytes);
        byte[] hashedBytes = md.digest(plainText.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    }
    private static String encodeWithSalt(String plainText, String salt) {
        String textWithSalt = plainText + salt;
        return Base64.getEncoder().encodeToString(textWithSalt.getBytes());
    }
}
