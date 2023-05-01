package com.example.demo.utility;
import org.apache.commons.codec.digest.DigestUtils;

public class MD5Example {
    public static void main(String[] args) {
        String text = "Hello World";
        String md5Hex = DigestUtils.md5Hex(text);

        System.out.println("Text: " + text);
        System.out.println("MD5 Hash: " + md5Hex);
    }
}

