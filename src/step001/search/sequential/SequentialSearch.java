package step001.search.sequential;

/**
 * @author yusik
 * @date 02/27/2018
 *
 */

public class SequentialSearch {

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

		System.out.println(sequentialCount);

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
