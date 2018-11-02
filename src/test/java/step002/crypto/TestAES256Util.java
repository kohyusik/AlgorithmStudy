package step002.crypto;

import org.junit.Test;

import javax.crypto.KeyGenerator;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
            System.out.println(secureKey.getFormat());
            System.out.println(secureKey.getEncoded());
    
            assertEquals(secureKey.getAlgorithm(), "AES");
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void getUtilInstance() {
    
        try {
            AES256Util aes256Util = new AES256Util("t+rU_M_pi-A_dE+v");
            
            String plainText = "12351235235aklshjzxc.v/123515!@#%!@";
            String plainTextt = "6 6 3 7 2 11 12 ";
            
            String encrypted = aes256Util.encrypt(plainText);
            System.out.println(String.format("%d :\t%s", plainText.length(), plainText));
            
            String decrypted = aes256Util.decrypt(encrypted);
            System.out.println(String.format("%d :\t%s", encrypted.length(), encrypted));
            
            assertEquals(decrypted, plainText);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void dateTimeTest() {
    
        LocalDateTime now = LocalDateTime.now();
        //        LocalDateTime now = LocalDateTime.of(2018, 10, 16, 15, 07, 06);
        //        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.SSS", Locale.KOREA);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
    
        String nowString = now.format(dateTimeFormatter);
        System.out.println(nowString);
    }
}
