package task_1;

import java.util.Arrays;

public class PascalTriangle {

	// This method is used to display a Pascal triangle based
	// on the parameter n.
	// Where n represents the number of rows
	public static void printPascalTriangle(int row) {
		// Base case
		if (row == 0) {
			System.out.println(1);
			return;
		}

		// Recursive case
		printPascalTriangle(row - 1);

		// Generate the current row
		int[] currentRow = getPascalTriangle(row);

		// Print the current row
		for (int element : currentRow) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	// get the nth row.
	// For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		// Base case
		if (n == 0) {
			return new int[] { 1 };
		}

		// Recursive case
		int[] previousRow = getPascalTriangle(n - 1);
		int[] currentRow = generateNextRow(previousRow);

		return currentRow;
	}

	// generate the next row based on the previous row
	// Ex. prevRow = {1} ==> nextRow = {1, 1}
	// Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int[] previousRow) {
		int[] currentRow = new int[previousRow.length + 1];

		// Fill in the first and last elements of the current row
		currentRow[0] = 1;
		currentRow[currentRow.length - 1] = 1;

		// Fill in the middle elements of the current row
		for (int i = 1; i < currentRow.length - 1; i++) {
			currentRow[i] = previousRow[i - 1] + previousRow[i];
		}

		return currentRow;
	}

	public static void main(String[] args) {

		printPascalTriangle(5);
		System.out.println(Arrays.toString(getPascalTriangle(4)));
		int[] previousRow = { 1, 2, 1 };
		System.out.println(Arrays.toString(generateNextRow(previousRow)));
	}
}
