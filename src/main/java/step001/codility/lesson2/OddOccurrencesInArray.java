package step001.codility.lesson2;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-08-10
 * @description :
 */

public class OddOccurrencesInArray {
    
    
    public static void main(String[] args) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
    
        // test case 1
        int[] t1 = new int[]{9, 3, 9, 3, 9, 7, 9};
        int solution = oddOccurrencesInArray.solution(t1);
        System.out.println(solution);
        
        
    }
    
    public int solution(int[] A) {

        ArrayList<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < A.length - 1; i++) {
            if (indexList.contains(i)) {
                continue;
            }
            for (int j = i + 1; j < A.length; j++) {
                if (!indexList.contains(i) && (A[i] == A[j])) {
                    indexList.add(i);
                    indexList.add(j);
                }
            }
        }

        List<Integer> result = indexList.stream()
                .sorted()
                .collect(toList());


        int s = 0;
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i + 1) - result.get(i) > 1) {
                s = i + 1;
            }
        }
        System.out.println(result);
    
        return A[s];
    }
    
}
