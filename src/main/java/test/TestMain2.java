/**
 *
 */
package test;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

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
    
//        System.out.println(renamedFileName.substring(renamedFileName.lastIndexOf('$') + 1));
        
    }
    
}

