package step002.web.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
                .sorted()
                .forEach(System.out::println);
    
        System.out.println(myList.hashCode());
        System.out.println(Objects.hash("kohyusik"));
        System.out.println("kohyusik".hashCode());
        
    }
    
}
