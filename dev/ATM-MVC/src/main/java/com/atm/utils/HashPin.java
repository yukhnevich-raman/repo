package com.atm.utils;

import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/29/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class HashPin {
    /**
     * Hashing pin code
     * @param pin
     * @param id
     * @return
     */
    public static Integer hash(Integer pin, Integer id) {
        long TRUNCATE_MASK = 0x7FFFFFFF;
        long MOD = 1000000;
        try {
            SecretKeySpec keySpec = new SecretKeySpec(pin.toString().getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(keySpec);
            byte[] result = mac.doFinal(id.toString().getBytes());
            String hash = Long.toString((new BigInteger(1, result).intValue() & TRUNCATE_MASK) % MOD);
            return Integer.parseInt(hash);
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (InvalidKeyException e) {
            return null;
        }
    }
}
