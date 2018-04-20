package step001.kko.test;

public class Solution4 {

    static int solve(String str) {
        String programmer = "programmer";

    	String test = programmer;

    	int i = 0;
    	// programmer
        for (; i < str.length(); i++) {
            int pIndex = test.indexOf(str.charAt(i));
            if (pIndex != -1) {
                test = test.substring(0, pIndex).concat(test.substring(pIndex + 1));
            }

            if (test.length() == 0) {
                i++;
                break;
            }
        }

    	String test2 = programmer;

    	int j = str.length() - 1;
    	// programmer
        for (; j >= 0; j--) {
            int pIndex = test2.indexOf(str.charAt(j));
            if (pIndex != -1) {
                test2 = test2.substring(0, pIndex).concat(test2.substring(pIndex + 1));
            }

            if (test2.length() == 0) {
                j--;
                break;
            }
        }

        System.out.println(test);
        System.out.println(i);
        System.out.println(j);


		return j - i + 1;
    }


    public static void main(String[] args) {
        System.out.println(solve("progxrammerrxproxgrammer"));
        System.out.println(solve("progxrammerrxproxgrammerprogxrammerrxproxgrammer"));
    }
}
