/**
 * 
 */
package test;

import java.util.ArrayList;

/**
 * @author yusik
 *
 */
public class TestMain {

	static int cnt1 = 0;
	static int cnt2 = 0;
	public static void main(String[] args) {
		
		

		ArrayList<Integer> test = new ArrayList();

		test.add(1);
		test.indexOf(1);

		int priceCount = 4000;

		// 가격정보 배열
		int[] priceArray = new int[priceCount];
		for (int priceArrayIdx = 1; priceArrayIdx < priceCount; priceArrayIdx++) {
			priceArray[priceArrayIdx - 1] = priceArrayIdx * 1000;
		}
		System.out.println(priceArray[3998]);
		System.out.println("가격의 배열인덱스 : " + getSearchPriceArrayIntex(priceArray, 3999000));//3999000
		System.out.println("가격의 배열인덱스 : " + getSearchPriceArrayIndex2(priceArray, 3999000));
		
		System.out.println(cnt1);
		System.out.println(cnt2);

	}

	private static int getSearchPriceArrayIntex(int[] priceArray, int searchPrice) {
		int middle;
		int left = 0;
		int right = priceArray.length - 1;
		int resultIndex = 0;

		while (right >= left) {
			cnt1++;
			middle = (right + left) / 2;

			if (searchPrice == priceArray[middle]) {
				resultIndex = middle;
				break;
			}

			if (searchPrice < priceArray[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}

		}
		return resultIndex;
	}
	
	private static int getSearchPriceArrayIndex2(int[] priceArray, int searchPrice) {
		int resultIndex = 0;
		for (int j = 0; j < priceArray.length; j++) {

			cnt2++;
			if (priceArray[j] == searchPrice) {
				resultIndex = j;
				break;
			}
		}
		return resultIndex;
	}

}
