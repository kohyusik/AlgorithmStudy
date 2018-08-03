package step001.string.search;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-07-25
 * @description :
 */
public class BruteForce {
    
    static int cnt = 0;
    
    public static void main(String[] args) {
        String string = "AAABCABZABCCBCABCABXABCABDIBCZ"; // length : 30
        String pattern = "ABCABD"; // length : 6
    
        int test = string.indexOf(pattern);
        System.out.println(test);
    
        int test2 = searchString(string, pattern);
        System.out.println(test2);
        System.out.println(cnt);
    
//        String atest = StringUtils.
//        System.out.println(atest);
        
    }
    
    public static int searchString(String string, String pattern) {
        char[] source = string.toCharArray();
        char[] target = pattern.toCharArray();
        int posSource = 0;
        int result = -1;
        
        while (posSource <= source.length - target.length) {
    
            int posTarget = 0;
            if (source[posSource] == target[posTarget]) {
    
                for (; posTarget < target.length; posSource++, posTarget++) {
                    cnt++;
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
