package com.example.demo.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Base64SaltExample {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String plainText = "Hello World";
        String salt = generateSalt();
        String hashedText = hashWithSalt(plainText, salt);
        String encodedText = encodeWithSalt(plainText, salt);

        System.out.println("Plain Text: " + plainText);
        System.out.println("Salt: " + salt);
        System.out.println("Hashed Text: " + hashedText);
        System.out.println("Encoded Text: " + encodedText);
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
