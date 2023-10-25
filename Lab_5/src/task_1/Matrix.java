package task_1;

public class Matrix {
	// task 1.1
	public static int[][] add(int[][] a, int[][] b) {
		int rows = a.length;
		int cols = a[0].length;
		int[][] result = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		return result;
	}

	// task 1.2
	public static int[][] subtract(int[][] a, int[][] b) {
		int rows = a.length;
		int cols = a[0].length;
		int[][] result = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = a[i][j] - b[i][j];
			}
		}
		return result;
	}

	public static void printfMatrix(int[][] a, String b) {
		System.out.println("matrix: " + b);
		for (int[] row : a) {
			for (int element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	// task 1.3
	public static int[][] multiply(int[][] a, int[][] b) {
		// Kiểm tra điều kiện dòng bằng cột
		if (a[0].length != b.length) {
			// Hai ma trận không tương thích
			throw new IllegalArgumentException("Hai ma trận không tương thích.");
		}
		int rows = a.length;
		int cols = b[0].length;
		// Tạo ma trận mới để lưu trữ tích của hai ma trận.
		int[][] product = new int[rows][cols];
		// Duyệt qua các hàng và cột của hai ma trận, nhân các phần tử tương ứng của mỗi
		// ma trận và lưu trữ tích trong ma trận mới.
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int sum = 0;
				for (int k = 0; k < a[0].length; k++) {
					sum += a[i][k] * b[k][j];
				}
				product[i][j] = sum;
			}
		}
		// Trả về ma trận mới.
		return product;
	}

	// task 1.4
	public static int[][] transpose(int[][] a) {
		int rows = a.length;
		int cols = a[0].length;
		int[][] result = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[j][i] = a[i][j];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] a = { { 7, 2 }, { 5, 3 } };
		int[][] b = { { 2, 1 }, { 3, 1 } };
		int[][] c = { { 7, 2, 3 }, { 5, 3, 1 } };
		int[][] d = { { 2, 1, 1 }, { 1, 1, 3 }, { 1, 4, 2 } };

		int[][] cong = add(a, b);
		int[][] tru = subtract(a, b);
		int[][] tich = multiply(c, d);
		int[][] chuyen_Vi = transpose(a);
		printfMatrix(a, "a");
		printfMatrix(b, "b");
		printfMatrix(cong, "tổng a,b");
		printfMatrix(tru, "hiệu a,b");
		printfMatrix(tich, "tích");
		printfMatrix(chuyen_Vi, "chuyển vị a");
	}
}
