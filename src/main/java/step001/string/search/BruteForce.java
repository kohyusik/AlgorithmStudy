package step001.string.search;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-07-25
 * @description :
 */
public class BruteForce {
    
    public static void main(String[] args) {
        String total = "ZABCCBCABCABCABEIBCZ";
        String search = "ABCDF";
        
        System.out.println(searchString(total, search));
        
    }
    
    public static int searchString(String text, String search) {
        char[] source = text.toCharArray();
        char[] target = search.toCharArray();
    
        System.out.println(source[0]);
        System.out.println((int)source[1]);
    
        System.out.println(source[1] == 65);
        byte[] b = "AaBCD".getBytes();
        
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
        
        byte bt = 0xF;
        System.out.println(bt);
        System.out.println(0xFF);
        System.out.println(017);
        
        
        
        int t = text.indexOf(search);
        return t;
    }
}
