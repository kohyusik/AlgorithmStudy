package step001.kao;

import java.util.ArrayDeque;
import java.util.Queue;

public class Test03 {

    public static void main(String[] args) {

        Queue<String> queue = new ArrayDeque<>(2);

        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        System.out.println(queue);



        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll()); // remove
        System.out.println(queue);
        System.out.println(queue.contains("B"));



    }
}
