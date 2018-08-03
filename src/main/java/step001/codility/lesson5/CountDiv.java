package step001.codility.lesson5;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-07-26
 * @description :
 */

public class CountDiv {
    
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
        CountDiv maxCounters = new CountDiv();
    
        // test case 1
        int n1 = 5;
        int[] input1 = new int[] {3, 4, 4, 6, 1, 4, 4};
//        int n1 = 5;
//        int[] input1 = new int[] {1, 6, 6, 6, 6, 6, 6};
//        int n1 = 1;
//        int[] input1 = new int[] {2, 1, 1};
        System.out.println("N : " + n1);
        System.out.print("arr : ");
        printArray(input1);
        int[] counter = maxCounters.solution(n1, input1);
    
        printArray(counter);
        
    }
    
    public int[] solution(int N, int[] A) {
        int max = 0;
        int adder = 0;
        int[] counter = new int[N];
        
        for (int i = 0, l1 = A.length; i < l1; i++) {
            int n = A[i];
    
            if (n == N + 1) {
                
                adder += max;
                max = 0;
                counter = new int[N];
                
            } else {
                
                counter[n - 1] += 1;
                
                // set max
                if (counter[n - 1] > max) {
                    max = counter[n - 1];
                }
            }
        }
    
        for (int j = 0, l2 = counter.length; j < l2; j++) {
            counter[j] += adder;
        }
        
        return counter;
    }
    
    public static void printArray(int[] array) {
        System.out.print("{ ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }
    
    
}
