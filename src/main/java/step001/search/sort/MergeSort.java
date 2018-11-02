package step001.search.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class MergeSort {
    
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }
    
    private static void sort(int[] array, int left, int right) {
    }
    
    @Test
    public void testSort() {
        
        int[] testArray = new int[] { 7, 5, 6, 2, 1, 9, 8, 22, 66, 16, 27, 53, 29 };
        int[] testArraySorted = new int[] { 7, 5, 6, 2, 1, 9, 8, 22, 66, 16, 27, 53, 29 };
        
        System.out.println(Arrays.toString(testArray));
        QuickSort.sort(testArraySorted);
        sort(testArray);
        System.out.println(Arrays.toString(testArray));
        
//        assertArrayEquals(testArraySorted, testArray);
    }
}