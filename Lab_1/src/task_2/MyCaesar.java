package task_2;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Mã hóa một ký tự theo số bước dịch chuyển đã cho.
	// Mã hóa: En(x) = (x + n) mod 26. x đại diện cho chỉ số của c trong mảng
	// ALPHABET
	//
	public char encryptChar(char c) {
		// Tìm chỉ số của ký tự trong mảng ALPHABET
		int index = indexOf(c);
		if (index == -1) {
			// Nếu ký tự không có trong bảng chữ cái, trả về chính nó
			return c;
		}

		// Tính chỉ số của ký tự được mã hóa
		int encryptedIndex = (index + n) % ALPHABET.length;

		// Trả về ký tự được mã hóa
		return ALPHABET[encryptedIndex];
	}

	// Mã hóa một văn bản bằng cách sử dụng hàm mã hóa ký tự ở trên.
	public String encrypt(String input) {
		// Tạo một chuỗi kết quả
		StringBuilder encryptedText = new StringBuilder();

		// Duyệt qua văn bản
		for (char c : input.toCharArray()) {
			// Mã hóa mỗi ký tự
			encryptedText.append(encryptChar(c));
		}

		// Trả về chuỗi kết quả
		return encryptedText.toString();
	}

	// Giải mã một ký tự theo số bước dịch chuyển đã cho.
	// Giải mã: Dn(x) = (x – n) mod 26. x đại diện cho chỉ số của c trong mảng
	// ALPHABET
	//
	public char decryptChar(char c) {
		// Tìm chỉ số của ký tự trong mảng ALPHABET
		int index = indexOf(c);
		if (index == -1) {
			// Nếu ký tự không có trong bảng chữ cái, trả về chính nó
			return c;
		}

		// Tính chỉ số của ký tự được giải mã
		int decryptedIndex = (index - n) % ALPHABET.length;

		// Nếu chỉ số âm, thêm chiều dài của mảng ALPHABET
		if (decryptedIndex < 0) {
			decryptedIndex += ALPHABET.length;
		}

		// Trả về ký tự được giải mã
		return ALPHABET[decryptedIndex];
	}

	// Giải mã một văn bản được mã hóa bằng cách sử dụng hàm giải mã ký tự ở trên.
	public String decrypt(String input) {
		// Tạo một chuỗi kết quả
		StringBuilder decryptedText = new StringBuilder();

		// Duyệt qua văn bản được mã hóa
		for (char c : input.toCharArray()) {
			// Giải mã mỗi ký tự
			decryptedText.append(decryptChar(c));
		}

		// Trả về chuỗi kết quả
		return decryptedText.toString();
	}

	// Trả về chỉ số của một ký tự trong mảng ALPHABET.
	// Nếu ký tự không có trong bảng chữ cái, trả về -1.
	//
	private int indexOf(char c) {
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// Create a MyCaesar object with a shift of 3.
		MyCaesar caesar = new MyCaesar(3);

		// Encrypt a text.
		String encryptedText = caesar.encrypt("HELLO, WORLD!");

		// Decrypt the encrypted text.
		String decryptedText = caesar.decrypt(encryptedText);

		// Print the encrypted and decrypted text.
		System.out.println("Encrypted text: " + encryptedText);
		System.out.println("Decrypted text: " + decryptedText);

	}

}
