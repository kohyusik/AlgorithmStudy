package step001.search.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-10-25
 * @description :
 */
@Slf4j
public class SelectionSort {
    
    public static void sort(int[] array) {
    
        for (int i = 0; i < array.length - 1; i++) {
            
            int minIndex = i;
            
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[minIndex] > array[j]? j : minIndex;
            }
            
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
    
    @Test
    public void testSort() {
        int[] testArray = new int[] {7, 5, 6, 2, 1, 9, 8, 22, 66, 16, 27, 53, 29};
//        int[] testArray = new int[] {4, 3, 2, 1, 5};
        int[] testArraySorted = new int[] {7, 5, 6, 2, 1, 9, 8, 22, 66, 16, 27, 53, 29};
    
        System.out.println(Arrays.toString(testArray));
        Arrays.sort(testArraySorted);
        sort(testArray);
        System.out.println(Arrays.toString(testArray));
    
        assertArrayEquals(testArraySorted, testArray);
    }
    
}
