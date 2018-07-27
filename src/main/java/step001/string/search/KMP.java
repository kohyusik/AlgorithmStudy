package step001.string.search;

import java.util.ArrayList;
import java.util.List;
 
public class KMP {
    
    private String string;
 
    private String pattern;
    
    static int cnt = 0;
    
    public static void main(String[] args) {
        KMP kmp = new KMP("AAABCABZABCCBCABCABXABCABDIBCZ", "ABCABD");
        System.out.println(kmp.search());
        System.out.println(cnt);
    }
 
    /**
     * 길이가 N 인 문자열 S(string) 에서 길이가 M 인 문자열 P(pattern) 를 탐색한다.<br/>
     * 시간복잡도는 O(N+M) 이다.<br/>
     *
     * @param string  원본 문자열
     * @param pattern 찾을 문자열
     */
    public KMP(String string, String pattern) {
        this.string = string;
        this.pattern = pattern;
    }
 
    public void setString(String string) {
        this.string = string;
    }
 
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
 
    /**
     * @return 문자열이 일치하는 index 의 배열
     */
    public List<Integer> search() {
        List<Integer> searchIndex = new ArrayList<>();
 
        char[] s = string.toCharArray();
        char[] p = pattern.toCharArray();
        int[] pi = getPI();
        int n = string.length();
        int m = pattern.length();
        int j = 0;
 
        for (int i = 0; i < n; i++) {
            while (j > 0 && s[i] != p[j]) {// j > 0 : 한 글자 라도 일치한 것이 있는지
                j = pi[j - 1];cnt++;
            }
            if (s[i] == p[j]) {
                if (j == m - 1) {
                    searchIndex.add(i - m + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
 
        return searchIndex;
    }
 
    /**
     * 탐색 실패 시 i번째까지 일치 할 경우 몇글자를 건너뛰어야 하는지 알려주는 pi 배열을 구한다.<br/>
     * pi 배열을 구할 때도 search 방식을 적용하여 O(M) 의 시간복잡도를 갖는다.<br/>
     *
     * @return pi 배열
     */
    public int[] getPI() {
        int m = pattern.length();
        int j = 0;
        char[] p = pattern.toCharArray();
        int[] pi = new int[m];
 
        for (int i = 1; i < m; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = pi[j - 1];
            }
            if (p[i] == p[j]) {
                pi[i] = ++j;
            }
        }
 
        return pi;
    }
}