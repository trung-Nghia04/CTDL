package task_1;

public class Fibonacci {
	// get the nth value of the Fibonacci series
	public static int getFibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return getFibonacci(n - 1) + getFibonacci(n - 2);
	}

	// This method is used to display a Fibonaccci series based on
	// the parameter n.Ex.n=10==>0 1 1 2 3 5 8 13 21 34
	public static void printFibonacci(int n) {
		if (n == 0) {
			return;
		}
		printFibonacci(n - 1);
		System.out.print(getFibonacci(n - 1) + " ");
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.print("Dãy số Fibonacci: ");
		printFibonacci(n);
	}
}
