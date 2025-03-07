package io.github.matheusalencar23.schoolsync.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class CryptUtils {
    public static boolean verify(String value, String hashedValue) {
        BCrypt.Result result = BCrypt.verifyer().verify(value.toCharArray(), hashedValue);
        return result.verified;
    }

    public static String encrypt(String value) {
        return BCrypt.withDefaults().hashToString(12, value.toCharArray());
    }
}
