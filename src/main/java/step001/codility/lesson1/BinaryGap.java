package step001.codility.lesson1;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-07-26
 * @description :
 */

public class BinaryGap {
    
    /**
     *Write a function:
     *
     * class Solution { public int solution(int A, int B, int K); }
     *
     * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
     *
     * { i : A ≤ i ≤ B, i mod K = 0 }
     *
     * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
     *
     * Assume that:
     *
     * A and B are integers within the range [0..2,000,000,000];
     * K is an integer within the range [1..2,000,000,000];
     * A ≤ B.
     * Complexity:
     *
     * expected worst-case time complexity is O(1);
     * expected worst-case space complexity is O(1).
     * Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
     */
    
    public static void main(String[] args) {
        BinaryGap countDiv = new BinaryGap();
    
        // test case 1
        int count = countDiv.solution(6, 11, 2);
        System.out.println(count);
    
        int count2 = countDiv.solution(4, 11, 3);
        System.out.println(count2);
        int count3 = countDiv.solution(3, 11, 2);
        System.out.println(count3);
    
        
    }
    
    public int solution(int A, int B, int K) {
        
        if (A % K > 0) {
            return B / K - A / K;
        }
        
        return B / K - A / K + 1;
    }

    
}
