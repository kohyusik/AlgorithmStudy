package step001.datastructure.stack;

import java.util.Arrays;

/**
 * @author yusik
 * @date 03/07/2018
 */

public class Stack<E> {

    static int pos = 0;

    Object[] elements;

    public Stack(int size) {
        this.elements = new Object[size];
    }

    public boolean isEmpty() {

        if (elements.length == 0) {
            return true;
        } else {
            return false;
        }

    }

    public void push(E element) {

        elements[pos++] = element;

    }

    public E pop() {
        return (E) elements[--pos];

    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>(10);

        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(9);
        stack.push(6);


        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);

    }

}
