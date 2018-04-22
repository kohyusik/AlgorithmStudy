/**
 *
 */
package test;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yusik
 */
public class TestMain2 {
    
    public static void main(String[] args) throws IOException {
        String renamedFileName = "ABC_123_15";
    
//        File file = File.createTempFile("0javaTest", ".txt");
        File file = new File("C:\\git\\AlgorithmStudy\\src\\main\\webapp\\study\\reactjs\\react004.js");
    
        System.out.println(file.toURI());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.length());
        SecureRandom sr = new SecureRandom();
        System.out.println(sr.getAlgorithm());



        String EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z0-9]*[.][a-zA-Z]*$";
        String MOBILE = "(01[012679])(d{3,4})(d{4})";


        String EMAIL_PATTERN	= "^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$";
        String PHONE_PATTERN	= "(01[016789])(\\d{3,4})(\\d{4})";

        Matcher m = Pattern.compile(EMAIL).matcher("@aa.a");
        System.out.println(m.matches());
        Matcher m2 = Pattern.compile(MOBILE).matcher("0101223450123");
        System.out.println(m2.matches());
        Matcher m3 = Pattern.compile(EMAIL_PATTERN).matcher("new090AA@aa.a");
        System.out.println(m3.matches());
        Matcher m4 = Pattern.compile(PHONE_PATTERN).matcher("01063757314");
        System.out.println(m4.matches());




    
//        System.out.println(renamedFileName.substring(renamedFileName.lastIndexOf('$') + 1));
        
    }
    
}

