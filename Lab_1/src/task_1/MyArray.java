package task_1;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// Method mirror that outputs the contents of an array in a
	// reverse order like a mirror
	// Ví dụ: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		int n = array.length;
		int[] result = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i];
			result[n + i] = array[n - i - 1];
		}
		return result;
	}

	// removes all duplicate elements from an array and returns a
	// new array
	// Input: 1 3 5 1 3 7 9 8
	// Output: 1 3 5 7 9 8

	public int[] removeDuplicates() {
		int[] kq = new int[array.length];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (!contains(array[i], kq, k)) {
				kq[k++] = array[i];
			}
		}
		int result[] = new int[k];
		System.arraycopy(kq, 0, result, 0, k);
		return result;
	}

	private boolean contains(int e, int[] arr, int k) {
		for (int i = 0; i <= k; i++) {
			if (arr[i] == e) {
				return true;
			}
		}
		return false;
	}

	// determine missing values from a sorted array.
	// Input: 10 11 12 13 14 16 17 19 20
	// Output: 15 18
	public int[] getMissingValues() {
		int[] result = new int[array[array.length - 1] - array[0] + 1 - array.length];
		int newSize = 0;
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i + 1] - array[i] > 1) {
				for (int c = array[i] + 1; c < array[i + 1]; c++) {
					result[newSize++] = c;
				}
			}
		}
		return result;
	}

	// Fill missing data by the minimal average of its k
	// neighbors
	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 16 17 19 20
	public int[] fillMissingValues(int k) {
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i] == -1) {
				int sum = 0;
				int count = 0;
				for (int j = 0; j < k; j++) {
					if ((i - 1) >= 0 && array[i - j] != -1) {
						sum += array[i - j];
						count++;
					}
					if ((i + j) < array.length && array[i + j] != -1) {
						sum += array[i + j];
						count++;
					}
				}
				if (count == k) {
					result[i] = sum / count;
				}
			} else {
				result[i] = array[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		int[] arr3 = { 10, 11, 12, 13, 16, 17, 19, 20 };
		int[] arr4 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };

		MyArray myArray1 = new MyArray(arr1);
		MyArray myArray2 = new MyArray(arr2);
		MyArray myArray3 = new MyArray(arr3);
		MyArray myArray4 = new MyArray(arr4);

		System.out.println("Task1.1");
		System.out.println("input: " + Arrays.toString(arr1));
		System.out.println("Mirror: " + Arrays.toString(myArray1.mirror()));
		System.out.println("input: " + Arrays.toString(arr2));
		System.out.println("RemoveDuplicates: " + Arrays.toString(myArray2.removeDuplicates()));

		System.out.println("task1.2");
		System.out.println("input: " + Arrays.toString(arr3));
		System.out.println("getMissingValues: " + Arrays.toString(myArray3.getMissingValues()));
		System.out.println("input: " + Arrays.toString(arr4));
		System.out.println("fillMissingValues: " + Arrays.toString(myArray4.fillMissingValues(2)));

	}
}
