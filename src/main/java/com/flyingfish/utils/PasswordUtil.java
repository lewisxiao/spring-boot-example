package com.flyingfish.utils;

import com.flyingfish.enums.Algorithm;
import org.springframework.util.Assert;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtil {

    public static String md5(String password) {
        Assert.notNull("Password can't be empty.", password);
        String encryptedPassword = null;

        try {
            MessageDigest digest = MessageDigest.getInstance(Algorithm.MD5.toString());
            digest.update(password.getBytes(), 0, password.length());
            encryptedPassword = new BigInteger(1, digest.digest()).toString(16);

        } catch (NoSuchAlgorithmException ex) {
            // ignore the exception, let it pass
        }

        return encryptedPassword;
    }

    public static String md5WithSalt(String password, String salt) {
        return md5(password + salt);
    }

    /**
     * Returns a random salt to be used to hash a password.
     *
     * @return a 16 bytes random salt
     */
    public static String getRandomSalt() {
        String salt = null;
        byte[] saltByte = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(saltByte);
        salt = Base64.getEncoder().encodeToString(saltByte);

        return salt;
    }
}
