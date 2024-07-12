package task_2;

public class MyMatrix {
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		int[][] result = new int[a.length][a[0].length];
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[0].length; col++) {
				result[row][col] = a[row][col] + b[row][col];
			}
		}
		return result;
	}

	// subtract 2 matrices
	public static int[][] subtract(int[][] a, int[][] b) {
		int[][] result = new int[a.length][a[0].length];
		if (a.length == b.length && a[0].length == b[0].length) {
			for (int row = 0; row < a.length; row++) {
				for (int col = 0; col < a[0].length; col++) {
					result[row][col] = a[row][col] - b[row][col];
				}
			}
			return result;
		}
		return null;
	}

	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		int[][] result = new int[a.length][b[0].length];
		if (a[0].length == b.length) {
			for (int row = 0; row < a.length; row++) {
				for (int col = 0; col < b.length; col++) {
					result[row][col] = a[row][col] * b[col][row];
				}
			}
			return result;
		}
		return null;
	}

	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		int[][] result = new int[a[0].length][a.length];
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[0].length; col++) {
				result[col][row] = a[row][col];
			}
		}
		return result;
	}

	public static void printMatrix(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 } };

		int[][] matrix2 = { { 7, 8, 9 }, { 10, 11, 12 } };
		int[][] matrix3 = { { 2, 3, 4 }, { -1, 7, 4 }, { 2, -7, 1 } };
		printMatrix(matrix1);
		printMatrix(matrix2);
		printMatrix(matrix3);

		System.out.print("sum: ");
		int[][] sum = add(matrix1, matrix2);
		printMatrix(sum);

		System.out.println("subtract: ");
		int[][] subtract = subtract(matrix2, matrix1);
		printMatrix(subtract);

		System.out.println("multiply: ");
		int[][] multiply = multiply(matrix1, matrix3);
		printMatrix(multiply);

		System.out.println("transpose: ");
		int[][] transpose = transpose(matrix1);
		printMatrix(transpose);
	}
}
