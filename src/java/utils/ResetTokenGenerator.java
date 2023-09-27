/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

/**
 *
 * @author admin
 */
public class ResetTokenGenerator {
    
    private static final int TOKEN_LENGTH = 32; // Length of the reset token
    private static final long TOKEN_EXPIRATION_MS = 3600000; // Token expiration time (1 hour)

    public static String generateToken() {
        SecureRandom random = new SecureRandom();
        byte[] tokenBytes = new byte[TOKEN_LENGTH];
        random.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }

    public static boolean isTokenExpired(Date tokenCreationDate) {
        Date now = new Date();
        return now.getTime() - tokenCreationDate.getTime() > TOKEN_EXPIRATION_MS;
    }
}