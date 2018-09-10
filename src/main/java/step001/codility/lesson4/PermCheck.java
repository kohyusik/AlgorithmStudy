package step001.codility.lesson4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-08-04
 * @description :
 */
public class PermCheck {

    public static void main(String[] args) {
        PermCheck permCheck = new PermCheck();

        // test case 1
<<<<<<< HEAD
        int[] test1 = new int[]{4, 1, 2, 3};
        int count = permCheck.solution(test1);
        System.out.println("Answer : " + count);

=======
        int[] test1 = new int[] {0, 1, 0, 1, 1};
        int count = permCheck.solution(test1);
        System.out.println("Answer : " + count);

        int[] test2 = new int[] {0, 0, 0, 1, 1};
        int count2 = permCheck.solution(test2);
        System.out.println("Answer : " + count2);

        int[] test3 = new int[] {0, 1, 1, 0, 1, 0, 1};
        int count3 = permCheck.solution(test3);
        System.out.println("Answer : " + count3);

>>>>>>> 96dd19a0a32c08357135a246cd4453dfe4d8124d
    }

    public int solution(int[] A) {


        List<Integer> cache = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] > A.length) {
                return 0;
            } else {

                if (cache.indexOf(A[i]) != -1) {
                    return 0;
                }
                cache.add(A[i]);
            }


        }

        return 1;
    }
}
