package step002.web.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-08-14
 * @description :
 */
public class StreamTest {
    
    public static void main(String[] args) {
        
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
    
        System.out.println(myList.hashCode());
    
        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    
        System.out.println(myList);
    
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> twoEvenSquares =
                numbers.stream()
                        .filter(n -> {
                            System.out.println("filtering " + n);
                            return n % 2 == 0;
                        })
                        .map(n -> {
                            System.out.println("mapping " + n);
                            return n * n;
                        })
                        .limit(3)
                        .collect(toList());
        System.out.println(twoEvenSquares);
    
    }
    
}
