package step001.string.search;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-07-25
 * @description :
 */
public class BruteForce {
    
    public static void main(String[] args) {
        String total = "ZABBCABCEIBCZ";
        String search = "ABC";
    
        System.out.println(searchString(total, search));
    }
    
    public static int searchString(String text, String search) {
        return text.indexOf(search);
    }
}
