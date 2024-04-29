package com.at.dev_project.controllers;

import java.nio.charset.Charset;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class StringEncrypter
{ 
    private static final String DES_ENCRYPTION_SCHEME = "DES";
    private static final String DEFAULT_ENCRYPTION_KEY = "bi4tbi4t";
    private static KeySpec keySpec;
    private static SecretKeyFactory keyFactory;
    private static Cipher cipher;
    private static final String UNICODE_FORMAT = "UTF-8";

    private static void init()
    {
        try
        {
            byte[] keyAsBytes = DEFAULT_ENCRYPTION_KEY.getBytes(UNICODE_FORMAT);
            keySpec = new DESKeySpec(keyAsBytes);
            keyFactory = SecretKeyFactory.getInstance(DES_ENCRYPTION_SCHEME);
            cipher = Cipher.getInstance(DES_ENCRYPTION_SCHEME);
        } 
        catch (Exception e){ e.printStackTrace();}

    }

    public static String encrypt(String unencryptedString)
    {
        //on verifie que la chaine a crypter n'est pas vide ou nulle
        if (!(unencryptedString == null || unencryptedString.trim().length() == 0))
        {
            //on initialise les variables
            init();
            try
            {
                //on crypte la chaine de caracteres
                SecretKey key = keyFactory.generateSecret(keySpec);
                cipher.init(Cipher.ENCRYPT_MODE, key);
                byte[] cleartext = unencryptedString.getBytes(UNICODE_FORMAT);
                byte[] ciphertext = cipher.doFinal(cleartext);

                BASE64Encoder base64encoder = new BASE64Encoder();
                return base64encoder.encode(ciphertext);
            } catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
        } 
        else return null; //si la chaine a crypter est nulle ou vide, on retourne null
    }

    public static String decrypt(String encryptedString)
    {
        if (!(encryptedString == null || encryptedString.trim().length() <= 0))
        {
            init();
            try
            {
                SecretKey key = keyFactory.generateSecret(keySpec);
                cipher.init(Cipher.DECRYPT_MODE, key);
                BASE64Decoder base64decoder = new BASE64Decoder();
                byte[] cleartext = base64decoder.decodeBuffer(encryptedString);
                byte[] ciphertext = cipher.doFinal(cleartext);
                return new String(ciphertext, Charset.forName(UNICODE_FORMAT));
            } catch (Exception ex)
            {
                ex.printStackTrace();
                return null;
            }
        } 
        else return null;
    }
}