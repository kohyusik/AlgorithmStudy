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

	private static int getBinarySearchIndex(int[] valueArray, int searchValue) {

		int searchIndex = 0;
		int mid = 0;
		int left = 0;
		int right = valueArray.length - 1;

		while (left <= right) {

			mid = (left + right) / 2;
			if (searchValue == valueArray[mid]) {
				searchIndex = mid;
				break;
			}

			if (searchValue >= valueArray[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}

		return searchIndex;
	}

	private static int getSequentialSearchIndex(int[] valueArray, int searchValue) {
		int resultIndex = 0;
		for (int j = 0; j < valueArray.length; j++) {
			binaryCount++;
			if (valueArray[j] == searchValue) {
				resultIndex = j;
				break;
			}
		}
		return resultIndex;
	}

}
