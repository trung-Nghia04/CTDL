package task_1;

import java.util.Arrays;

public class My_Sorting_Algorithms {
	// sort by descending order
	public static void selectionSort(int[] array) {
		int max_idx;
		for (int i = 0; i <= array.length - 1; i++) {
			max_idx = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[max_idx]) {
					max_idx = j;
				}
			}
			swapArray(array, max_idx, i);
		}
		System.out.println(Arrays.toString(array));
	}

	public static void swapArray(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					swapArray(array, j, j + 1);
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i <= array.length - 1; i++) {
			int j = i;
			while (j > 0 && array[j] <= array[j - 1]) {
				swapArray(array, j, j - 1);
				j--;
			}
		}
		System.out.println(Arrays.toString(array));
	}

	public static void insertionSort2(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		System.out.println(Arrays.toString(arr));

	}

	public static void main(String[] args) {
		int arr[] = { 64, 25, 12, 22, 11 };
		selectionSort(arr);
		insertionSort2(arr);
		bubbleSort(arr);
	}
}
