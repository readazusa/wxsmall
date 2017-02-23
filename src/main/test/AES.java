import org.apache.commons.crypto.cipher.CryptoCipher;
import org.apache.commons.crypto.cipher.CryptoCipherFactory;
import org.apache.commons.crypto.utils.Utils;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by 念梓  on 2017/2/23.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class AES {

    private static byte[] getUTF8Bytes(String input) {
        return input.getBytes(StandardCharsets.UTF_8);
    }

    @Test
    public void testAes() {
        final SecretKeySpec key = new SecretKeySpec(getUTF8Bytes("1234567890123456"), "AES");
        final IvParameterSpec iv = new IvParameterSpec(getUTF8Bytes("1234567890123456"));

        Properties properties = new Properties();
        properties.setProperty(CryptoCipherFactory.CLASSES_KEY, CryptoCipherFactory.CipherProvider.JCE.getClassName());
        //Creates a CryptoCipher instance with the transformation and properties.
        final String transform = "AES/CBC/PKCS5Padding";
        CryptoCipher encipher = null;
        try {
            encipher = Utils.getCipherInstance(transform, properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Cipher:  " + encipher.getClass().getCanonicalName());

        final String sampleInput = "hello world!";
        System.out.println("input:  " + sampleInput);

        byte[] input = getUTF8Bytes(sampleInput);
        byte[] output = new byte[32];

        //Initializes the cipher with ENCRYPT_MODE, key and iv.
        try {
            encipher.init(Cipher.ENCRYPT_MODE, key, iv);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        //Continues a multiple-part encryption/decryption operation for byte array.
        int updateBytes = 0;
        try {
            updateBytes = encipher.update(input, 0, input.length, output, 0);
        } catch (ShortBufferException e) {
            e.printStackTrace();
        }
        System.out.println("ss: "+ updateBytes);
        //We must call doFinal at the end of encryption/decryption.
        int finalBytes = 0;
        try {
            finalBytes = encipher.doFinal(input, 0, 0, output, updateBytes);
        } catch (ShortBufferException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        System.out.println(finalBytes);
        //Closes the cipher.
        try {
            encipher.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(Arrays.copyOf(output, updateBytes + finalBytes)));

        // Now reverse the process using a different implementation with the same settings
        properties.setProperty(CryptoCipherFactory.CLASSES_KEY, CryptoCipherFactory.CipherProvider.JCE.getClassName());
        CryptoCipher decipher = null;
        try {
            decipher = Utils.getCipherInstance(transform, properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Cipher:  " + encipher.getClass().getCanonicalName());

        try {
            decipher.init(Cipher.DECRYPT_MODE, key, iv);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        byte[] decoded = new byte[32];
        try {
            decipher.doFinal(output, 0, updateBytes + finalBytes, decoded, 0);
        } catch (ShortBufferException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        System.out.println("output: " + new String(decoded, StandardCharsets.UTF_8));
    }
}
