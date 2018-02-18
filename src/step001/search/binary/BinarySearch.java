package step001.search.binary;

/**
 * @author yusik
 * @date 02/18/2018
 *
 */

public class BinarySearch {

	static int sequentialCount = 0;
	static int binaryCount = 0;

	public static void main(String[] args) {

		int indexCount = 5000;

		int[] valueArray = new int[indexCount];
		for (int i = 1; i <= indexCount; i++) {
			valueArray[i - 1] = i * 1000;
		}
		System.out.println(valueArray[4999]);
		System.out.println("array index : " + getSequentialSearchIndex(valueArray, 4099000));
		System.out.println("array index : " + getBinarySearchIndex(valueArray, 4099000));

		System.out.println(sequentialCount);
		System.out.println(binaryCount);

	}

	private static int getBinarySearchIndex(int[] priceArray, int searchPrice) {
		int middle;
		int left = 0;
		int right = priceArray.length - 1;
		int resultIndex = 0;

		while (right >= left) {
			sequentialCount++;
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

	private static int getSequentialSearchIndex(int[] priceArray, int searchPrice) {
		int resultIndex = 0;
		for (int j = 0; j < priceArray.length; j++) {
			binaryCount++;
			if (priceArray[j] == searchPrice) {
				resultIndex = j;
				break;
			}
		}
		return resultIndex;
	}

}
