package com.passmanager.demo;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final String ALGORITHM = "AES";

    public void prepareSecretKey(String propKey){
        MessageDigest sha = null;
        try{
            key = propKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            this.secretKey = new SecretKeySpec(key, ALGORITHM);
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    public String encrypt(String strToEncrypt, String secret){
        try{
            prepareSecretKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            String encoded = Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
            System.out.println(encoded);
            return encoded;
        }catch (Exception e){
            System.out.println("Error encrypting string : " + e.toString());
        }
        return null;
    }

    public String decrypt(String strToDecrypt, String secret){
        try{
            prepareSecretKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }catch (Exception e){
            System.out.println("Error decrypting string : " + e.toString());
        }
        return null;
    }
}
