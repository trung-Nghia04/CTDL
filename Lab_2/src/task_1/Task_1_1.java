package task_1;

public class Task_1_1 {
	// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		} else if (n > 1) {
			return (int) Math.pow(-1, n + 1) * n;
		}
		return getSn1(n - 1) + n;
	}

	// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		}
		return helpGetSn2(n) + getSn2(n - 1);
	}

	// hàm tính giai thừa
	public static int helpGetSn2(int n) {
		if (n == 1) {
			return 1;
		}
		return n * helpGetSn2(n - 1);
	}

	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		}
		return n * n + getSn3(n - 1);
	}

	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>=0
	public static double getSn4(int n) {
		if (n == 0) {
			return 1;
		}
		return getSn4(n - 2) + 1.0 / helpGetSn4(n);
	}

	// hàm lấy mẫu số
	public static double helpGetSn4(int n) {
		if (n == 2) {
			return 2;
		}
		return n * helpGetSn4(n - 2);
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println("Tổng 1: " + getSn1(n));
		System.out.println("Tổng 2: " + getSn2(n));
		System.out.println("Tổng 3: " + getSn3(n));
		System.out.println("Tổng 4: " + getSn4(n));
	}

}
