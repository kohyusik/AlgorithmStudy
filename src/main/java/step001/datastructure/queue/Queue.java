package step001.datastructure.queue;

import java.util.Arrays;

public class Queue<E> {

    int start = 0;
    int end = 0;

    Object[] elements;

    public Queue(int size) {

        this.elements = new Object[size];

    }

    public boolean isEmpty() {

        if (start == end) {
            return true;
        } else {
            return false;
        }

    }

    public void push(E element) {

        elements[end++] = element;

    }

    public E pop() {

        return (E) elements[start++];

    }

    @Override
    public String toString() {

        return Arrays.toString(elements);

    }

    public static void main(String[] s) {

        Queue<String> queue = new Queue<>(20);

        System.out.println(queue.isEmpty());
        queue.push("1");
        System.out.println(queue.isEmpty());
        queue.push("2");
        queue.push("3");
        System.out.println(queue.pop());
        queue.push("4");
        queue.push("6");
        System.out.println(queue.pop());
        queue.push("7");
        queue.push("9");

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue);

    }

}
