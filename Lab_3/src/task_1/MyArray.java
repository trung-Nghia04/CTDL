package task_1;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target)
				return i;

		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearch(target, 0);
	}

	private int recursiveLinearSearch(int target, int index) {
		if (index >= array.length) {
			return -1;
		}

		if (array[index] == target) {
			return index;
		}

		return recursiveLinearSearch(target, index + 1);
	}

	// To find the index of the target in the sorted array. If the target is not
	// found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == array[mid]) {
				return mid;
			} else if (target < array[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}

		return -1;
	}

	// To find the index of the target in the sorted array. If the target is not
	// found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target, int low, int high) {

		if (low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if (target == array[mid])
				return mid;
			else if (target < array[mid])
				return recursiveBinarySearch(target, low, mid - 1);
			else
				return recursiveBinarySearch(target, mid + 1, high);

		}
	}

	public static void main(String[] args) {
		System.out.println("Task 1.1: ");

		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		MyArray myArray = new MyArray(array);

		System.out.println("IterativeLinearSearch: ");
		int a = myArray.iterativeLinearSearch(45);
		System.out.println("Output: " + a);

		System.out.println("RecursiveLinearSearch: ");
		int b = myArray.recursiveLinearSearch(15);
		System.out.println("Output: " + b);

		System.out.println("Task 1.2: ");
		System.out.println("IterativeBinarySearch: ");
		int c = myArray.iterativeBinarySearch(15);
		System.out.println("Output: " + c);

		System.out.println("RecursiveBinarySearch: ");
		int d = myArray.iterativeBinarySearch(15);
		System.out.println("Output: " + d);
	}
}