package step001.codility.lesson6;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-08-07
 * @description :
 */
public class NumberOfDiscIntersections {

    public static void main(String[] args) {
        NumberOfDiscIntersections numberOfDiscIntersections = new NumberOfDiscIntersections();

        // test case 1
        int[] A1 = new int[] {1, 5, 2, 1, 4, 0};
        int ans1 = numberOfDiscIntersections.solution(A1);
        System.out.println("Answer : " + ans1);

    }

    public int solution(int[] A) {
    
        int interCount = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = i + 1; j < A.length; j++) {
    
                // (i - A[i], i + A[i])
                // (j - A[j], j + A[j])
                
                if (i + A[i] > j) {
                    interCount++;
                } else if (i + A[i] == j) {
                    if (A[j] > 0) interCount++;
                } else {
                    if (i + A[i] > j - A[j]) {
                        interCount++;
                    }
                }
                
                if (interCount > 10000000) return -1;
            }
        }
        
        return interCount;
    }

}
