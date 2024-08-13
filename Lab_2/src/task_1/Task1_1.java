package task_1;

public class Task1_1 {
	// S(n)=1-2+3-4+...+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		}
		return (int) Math.pow(-1, n + 1) * n + getSn1(n - 1);
	}

	// S(n)=1+1.2+1.2.3+...+1.2.3...n, n>0
	public static int getSn2(int n) {
		if (n == 1)
			return 1;
		return helpGetSn2(n) + getSn2(n - 1);
	}

	// tinh giai thua
	private static int helpGetSn2(int n) {
		if (n == 1)
			return 1;
		return helpGetSn2(n - 1) * n;
	}

	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n == 1)
			return 1;
		return n * n + getSn3(n - 1);
	}

	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+...+1/(2.4.6.2n), n>=0
	public static double getSn4(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n phải không âm");
		} else if (n == 0) {
			return 1.0;
		} else {
			return getSn4(n - 1) + 1.0 / helpGetSn4(n);
		}
	}

	private static double helpGetSn4(int n) {
		if (n == 0) {
			return 1.0;
		} else {
			return helpGetSn4(n - 1) * 2 * n;
		}
	}

	public static void main(String[] args) {
		System.out.println("S1: " + getSn1(3));
		System.out.println("S2: " + getSn2(3));
		System.out.println("S3: " + getSn3(3));
		System.out.println("S4: " + getSn4(2));
	}

}
