package task_1;

import java.util.Arrays;

public class PascalTriangle {
	// This method is used to display a Pascal triangle based on the parameter n.
	// Where n represents the number of rows
	public static void printPascalTriangle(int rows) {
		int maxRowLength = 2 * rows - 1;
		hamXuLy(rows, 1, maxRowLength, 0);
	}

	private static void hamXuLy(int rows, int currentRow, int maxRowLength, int colIndex) {
		if (currentRow > rows) {
			return;
		}
		int spaces = (maxRowLength - (2 * currentRow - 1)) / 2;
		if (colIndex < spaces) {
			System.out.print(" ");
			hamXuLy(rows, currentRow, maxRowLength, colIndex + 1);
			return;
		}
		System.out.print(getPascalTriangle(currentRow)[colIndex - spaces] + " ");
		if (colIndex - spaces < currentRow - 1) {
			hamXuLy(rows, currentRow, maxRowLength, colIndex + 1);
		} else {
			System.out.println();
			hamXuLy(rows, currentRow + 1, maxRowLength, 0);
		}
	}

	// get the nth row.
	// For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		if (n == 1) {
			return new int[] { 1 };
		}
		int[] prevRow = getPascalTriangle(n - 1);
		int[] re = generateNextRow(prevRow);

		return re;
	}

	// generate the next row based on the previous row
	// Ex. prevRow = {1} ==> nextRow = {1, 1}
	// Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int[] prevRow) {
		int[] re = new int[prevRow.length + 1];
		re[0] = re[re.length - 1] = 1;
		for (int i = 1; i < prevRow.length; i++) {
			re[i] = prevRow[i - 1] + prevRow[i];
		}
		return re;
	}

	public static void main(String[] args) {
		printPascalTriangle(5);
		System.out.println("lấy ra dòng thứ 3");
		System.out.println(Arrays.toString(getPascalTriangle(3)));
		int[] previousRow = { 1, 2, 1 };
		System.out.println("lấy ra dòng tiếp theo của dòng: " + Arrays.toString(previousRow));
		System.out.println(Arrays.toString(generateNextRow(previousRow)));
	}
}
