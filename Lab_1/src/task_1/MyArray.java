package task_1;

import java.util.Arrays;

public class MyArray {

	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		int n = array.length;
		int[] kq = new int[n * 2];
		for (int i = 0; i < n; i++) {
			kq[i] = array[i];
			kq[n + i] = array[n - i - 1];
		}

		return kq;
	}
	// Input: 1 3 5 1 3 7 9 8
	// Output: 1 3 5 7 9 8

	public int[] removeDuplicates() {
		int n = array.length;
		int kq[] = new int[n];
		int new_Size = 0;
		kq[new_Size++] = array[0];

		for (int i = 1; i < n; i++) {
			boolean trung_Lap = false;
			for (int j = 0; j < kq.length; j++) {
				if (array[i] == kq[j]) {
					trung_Lap = true;
					break;
				}
			}
			if (!trung_Lap) {
				kq[new_Size++] = array[i];
			}

		}
		int result[] = new int[new_Size];
		System.arraycopy(kq, 0, result, 0, new_Size);
		return result;
	}

	// Input: 10 11 12 13 14 16 17 19 20
	// Output: 15 18
	public int[] getMissingValues() {
		// Xác định khoảng giá trị dự kiến trong mảng đầu vào
		int minValue = array[0];
		int maxValue = array[array.length - 1];

		// Khởi tạo một mảng boolean để đánh dấu các giá trị đã xuất hiện
		boolean[] danh_Dau = new boolean[maxValue - minValue + 1];

		// Đánh dấu các giá trị đã xuất hiện trong mảng đầu vào
		for (int value : array) {
			danh_Dau[value - minValue] = true;
		}

		// Tìm các giá trị thiếu và đếm chúng
		int missingCount = 0;
		for (int i = 0; i < danh_Dau.length; i++) {
			if (!danh_Dau[i]) {
				missingCount++;
			}
		}

		// Khởi tạo mảng kết quả và lưu trữ các giá trị thiếu
		int[] result = new int[missingCount];
		int index = 0;
		for (int i = 0; i < danh_Dau.length; i++) {
			if (!danh_Dau[i]) {
				result[index++] = minValue + i;
			}
		}

		return result;
	}

	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 16 17 19 20

	public int[] fillMissingValues(int k) {
		// Kiểm tra đầu vào
		if (array == null || array.length == 0) {
			return array;
		}

		// Tạo một mảng kết quả
		int[] result = new int[array.length];

		// Duyệt qua mảng
		for (int i = 0; i < array.length; i++) {
			if (array[i] == -1) {
				// Tính giá trị trung bình
				int sum = 0;
				int count = 0;
				for (int j = Math.max(i - k, 0); j <= Math.min(i + k, array.length - 1); j++) {
					if (array[j] != -1) {
						sum += array[j];
						count++;
					}
				}

				// Điền giá trị trung bình vào mảng kết quả
				if (count > 0) {
					result[i] = sum / count;
				} else {
					result[i] = -1; // Nếu không có giá trị khả dụng để tính trung bình
				}
			} else {
				result[i] = array[i];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		MyArray myArray = new MyArray(arr);
		int task1[] = myArray.mirror();
		System.out.println("mảng ban đầu:" + Arrays.toString(arr) + "\nmảng sau khi thực hiện phương thức:"
				+ Arrays.toString(task1));
		int brr[] = { 1, 3, 5, 1, 3, 7, 9, 8 };
		MyArray myBrray = new MyArray(brr);
		int task2[] = myBrray.removeDuplicates();
		System.out.println("mảng ban đầu:" + Arrays.toString(brr) + "\nmảng sau khi xóa các phần tử trùng lặp:"
				+ Arrays.toString(task2));
		int crr[] = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		MyArray myCrray = new MyArray(crr);
		int task3[] = myCrray.getMissingValues();
		System.out.println("mảng ban đầu:" + Arrays.toString(crr) + "\nmảng sau khi thực hiện phương thức:"
				+ Arrays.toString(task3));
		int k = 3;
		int[] drr = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };
		MyArray myDrray = new MyArray(drr);
		int task4[] = myDrray.fillMissingValues(k);
		System.out.println("mảng ban đầu:" + Arrays.toString(drr) + "\nmảng sau khi thực hiện phương thức:"
				+ Arrays.toString(task4));

	}

}
