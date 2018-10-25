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
public class QuickSort {
    
    public static void sort(int[] array) {
        
        sort(array, 0, array.length - 1);
        
    }
    
    public static void sort(int[] array, int left, int right) {
        int l = left;
        int r = right;
        int pivot = array[(left + right) / 2];
    
        while (l <= r) {
            
            
            while(array[l] < pivot) l++;
            while(array[r] > pivot) r--;
            if (l <= r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                l++; r--;
                System.out.println(Arrays.toString(array));
            }
            
        }
        
        if (left < r) {
            sort(array, left, r);
        }
        
        if (l< right) {
            sort(array, l, right);
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
