package task_1;

public class TowersOfHanoi {

	public static void moveTower(int disk, char source, char auxiliary, char destination) {
		if (disk == 0) {
			// Di chuyển đĩa 1 từ trục nguồn đến trục đích
			System.out.println("Di chuyển đĩa " + disk + " từ trục " + source + " đến trục " + destination);
			return;
		}

		// Di chuyển `disk - 1` đĩa đầu tiên từ trục nguồn đến trục phụ
		moveTower(disk - 1, source, destination, auxiliary);

		// Di chuyển đĩa hiện tại từ trục nguồn đến trục đích
		System.out.println("Di chuyển đĩa " + disk + " từ trục " + source + " đến trục " + destination);

		// Di chuyển `disk - 1` đĩa cuối cùng từ trục phụ đến trục đích
		moveTower(disk - 1, auxiliary, source, destination);
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println("Hướng dẫn chơi tháp Hà Nội "+n+" đĩa");
		moveTower(n, 'A', 'B', 'C');
	}
}
