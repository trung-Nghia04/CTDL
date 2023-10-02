package task_1;

public class Test {
	public static void fillMissingValues(int[] arr, int n, int k) {
		  // Tạo một mảng để lưu trữ các giá trị k liền kề
		  int[] window = new int[k];

		  // Khởi tạo các giá trị ban đầu
		  for (int i = 0; i < k; i++) {
		    window[i] = arr[i];
		  }

		  // Duyệt qua mảng
		  for (int i = k; i < n; i++) {
		    // Nếu giá trị tại vị trí hiện tại là thiếu
		    if (arr[i] == -1) {
		      // Tính giá trị trung bình của các giá trị k liền kề
		      int mean = 0;
		      for (int j = i - k + 1; j <= i; j++) {
		        mean += window[j - i + 1];
		      }
		      mean /= k;

		      // Thay thế giá trị thiếu bằng giá trị trung bình
		      arr[i] = mean;
		    }

		    // Cập nhật mảng window
		    window[i % k] = arr[i];
		  }
		}
	public class Main {

		  public static void main(String[] args) {
		    int[] arr = {10, 11, 12, -1, 14, 10, 17, 19, 20};
		    int n = arr.length;

		    // Điền các giá trị thiếu với giá trị trung bình của các giá trị k liền kề
		    int k = 3;
		    fillMissingValues(arr, n, k);

		    // In ra mảng
		    for (int i = 0; i < n; i++) {
		      System.out.print(arr[i] + " ");
		    }
		  }

		}

}
