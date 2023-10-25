package task_2;

public class TicTacToeTest {
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();

		// Các bước chơi ví dụ
		game.makeMove(0, 0, 'X');
		game.makeMove(0, 1, 'O');
		game.makeMove(1, 0, 'X');
		game.makeMove(1, 1, 'O');
		game.makeMove(2, 0, 'X');

		// In ra trạng thái cuối cùng của bàn cờ
		System.out.println("TIC TAC TOE Game");
		game.printBoard();

		// Kiểm tra xem người chơi X hoặc O đã chiến thắng
		if (game.checkRows('X') || game.checkColumns('X') || game.checkDiagonals('X')) {
			System.out.println("Người chơi X thắng!");
		} else if (game.checkRows('O') || game.checkColumns('O') || game.checkDiagonals('O')) {
			System.out.println("Người chơi O thắng!");
		} else {
			System.out.println("Hòa!");
		}
	}
}
