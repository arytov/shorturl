package ru.arytov.shorturl.endpoings;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.GregorianCalendar;

public class Generator {
    public String generate(String originalUrl) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(originalUrl.getBytes());
            digest.update(GregorianCalendar.getInstance().toString().getBytes());
            String base64 = Base64.getEncoder().encodeToString(digest.digest());
            return base64;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    
}
