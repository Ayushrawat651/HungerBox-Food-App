package com.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
    public String encryptPassword(String password) {
        try {
            
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            
            byte[] hashedBytes = messageDigest.digest(password.getBytes());

       
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b); 
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error: SHA-256 algorithm not found!", e);
        }
    }
}