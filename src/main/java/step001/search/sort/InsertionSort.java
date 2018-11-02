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
public class InsertionSort {
    
    public static void sort(int[] array) {
        
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j;
            for (j = i- 1; j >= 0 && array[j] > key; j--) {
                array[j + 1] = array[j];
            }
            
            array[j + 1] = key;
        }
    }
    
    @Test
    public void testSort() {
        int[] testArray = new int[] {7, 5, 6, 2, 1, 9, 8, 22, 66, 16, 27, 53, 29};
        int[] testArraySorted = new int[] {7, 5, 6, 2, 1, 9, 8, 22, 66, 16, 27, 53, 29};
    
//        System.out.println(Arrays.toString(testArray));
        Arrays.sort(testArraySorted);
        sort(testArray);
        System.out.println(Arrays.toString(testArray));
    
        assertArrayEquals(testArraySorted, testArray);
    }
    
}
