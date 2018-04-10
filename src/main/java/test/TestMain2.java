/**
 *
 */
package test;

/**
 * @author yusik
 */
public class TestMain2 {
    
    public static void main(String[] args) {
        String renamedFileName = "ABC_123_15";
    
        System.out.println(renamedFileName.substring(renamedFileName.lastIndexOf('$') + 1));
        
    }
    
}

