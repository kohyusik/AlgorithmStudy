package step001.string.search;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-07-25
 * @description :
 */
public class BruteForce {
    
    public static void main(String[] args) {
        String total = "ZABCCBCABCABXABCABDIBCZ"; // 23
        String search = "ABCABD"; // 6
    
        int test = total.indexOf(search);
        System.out.println(test);
    
        int test2 = searchString(total, search);
        System.out.println(test2);
        
    }
    
    public static int searchString(String text, String search) {
        char[] source = text.toCharArray();
        char[] target = search.toCharArray();
        int posSource = 0;
        int result = -1;
        
        while (posSource <= source.length - target.length) {
    
            int posTarget = 0;
            if (source[posSource] == target[posTarget]) {
    
                for (; posTarget < target.length; posSource++, posTarget++) {
                    if (source[posSource] != target[posTarget]) {
                        break;
                    }
                }
                
                if (posTarget == target.length) {
                    result = posSource - posTarget;
                    break;
                }
            
            }
            posSource++;
        }
        
        return result;
    }
}
