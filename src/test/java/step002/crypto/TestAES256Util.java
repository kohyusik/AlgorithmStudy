package step002.crypto;

import org.junit.Test;

import javax.crypto.KeyGenerator;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static junit.framework.TestCase.assertEquals;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-09-27
 * @description :
 */


public class TestAES256Util {
    
    @Test
    public void keyGenerate() {
    
        KeyGenerator generator = null;
        try {
            generator = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
    
            generator.init(128, random);
            Key secureKey = generator.generateKey();
    
            assertEquals(secureKey.getAlgorithm(), "AES");
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void getUtilInstance() {
    
        try {
            AES256Util aes256Util = new AES256Util("abcdefghijklmnop");
            
            String plainText = "12351235235aklshjzxc.v/123515!@#%!@";
            
            String encrypted = aes256Util.encrypt(plainText);
            System.out.printf("%d :\t%s\n", plainText.length(), plainText);
            
            String decrypted = aes256Util.decrypt(encrypted);
            System.out.printf("%d :\t%s\n", encrypted.length(), encrypted);
            
            assertEquals(decrypted, plainText);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
