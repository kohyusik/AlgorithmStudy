package step001.bit;

import java.text.DecimalFormat;
import java.util.Stack;

public class BitTest {

    public static void main(String[] args) {

        System.out.println("6 & 5 :" + (6 & 5));// 0110 & 0101
        System.out.println("6 | 5 :" + (6 | 5));
        System.out.println("6 ^ 5 :" + (6 ^ 5));
        System.out.println("~ 6   :" + (~6));


        //  1011 0010 = 178
        Stack stack = decimalToBinaryString(178, null);


        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());

    }

    public static Stack decimalToBinaryString(int decimal, Stack stack) {
        if (stack == null) {
            stack = new Stack();
        }

        int quotient = decimal / 2;
        int remainder = decimal % 2;

        stack.push(remainder);

        if (quotient == 1 || quotient == 0) {
            stack.push(quotient);
        } else {
            decimalToBinaryString(quotient, stack);
        }

        return stack;

    }

}
