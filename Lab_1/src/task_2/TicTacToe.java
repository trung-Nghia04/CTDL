package task_2;

public class TicTacToe {
	private static final char EMPTY = ' ';// một hằng số dùng để đại diện cho ô trống trên bàn cờ.
	private char[][] board;
	private int size;

	public TicTacToe(int size) {
		board = new char[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

// kiểm tra xem một người chơi có chiến thắng dựa trên kiểm tra các hàng trên bàn cờ
	public boolean checkRows() {

		for (int row = 0; row < board.length; row++) {
			char c = board[row][0];
			if (c != EMPTY) {
				int count = 0;
				for (int col = 0; col < board[row].length; col++) {
					if (c == board[row][col]) {
						count++;
					}
				}
				if (count == board.length) {
					return true;
				}
			}
		}
		return false;
	}

//kiểm tra xem một người chơi có chiến thắng dựa trên kiểm tra các cột trên bàn cờ
	public boolean checkColumns() {
		for (int col = 0; col < board.length; col++) {
			char c = board[0][col];
			if (c != EMPTY) {
				int count = 0;
				for (int row = 0; row < board.length; row++) {
					if (c == board[row][col]) {
						count++;
					}
				}
				if (count == board.length) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkDiagonals() {
		char c = board[0][0];
		if (c != EMPTY) {
			int count = 0;
			for (int row = 0; row < board.length; row++) {
				if (board[row][row] == c) {
					count++;
				}
			}
			if (count == board.length)
				return true;
			c = board[0][board.length - 1];
			int count2 = 0;
			for (int row = 0; row < board.length; row++) {
				if (board[row][board.length - 1 - row] == c) {
					count2++;
				}
			}
			if (count2 == board.length)
				return true;
		}
		return false;
	}

	// Kiểm tra các nước đi trên bàn cờ
	public void moreTurns(int row, int col, char player) {
		if (board[row][col] == EMPTY) {
			board[row][col] = player;
		}
	}

// in ra trạng thái hiện tại của bàn cờ, bao gồm các ô đã được điền bởi người chơi.
	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
				if (j < 2) {
					System.out.print(" | ");
				}
			}
			System.out.println();
			if (i < 2) {
				System.out.println("---------");
			}
		}
		System.out.println();
	}

	public void chekWinner() {
		if (checkRows()) {
			System.out.println("thắng theo hàng ngang");
		} else if (checkColumns()) {
			System.out.println("thắng theo hàng dọc");
		} else if (checkDiagonals()) {
			System.out.println("thắng theo hàng chéo");
		}
	}

	public static void main(String[] args) {
		TicTacToe board1 = new TicTacToe(3);
		TicTacToe board2 = new TicTacToe(3);
		TicTacToe board3 = new TicTacToe(3);
		TicTacToe board4 = new TicTacToe(3);

		board1.moreTurns(0, 0, 'X');
		board1.moreTurns(0, 1, 'X');
		board1.moreTurns(1, 0, 'O');
		board1.moreTurns(1, 1, 'O');
		board1.moreTurns(0, 2, 'X');
		board1.printBoard();
		board1.chekWinner();

		board2.moreTurns(0, 0, 'O');
		board2.moreTurns(0, 1, 'X');
		board2.moreTurns(1, 0, 'O');
		board2.moreTurns(1, 1, 'X');
		board2.moreTurns(2, 0, 'O');
		board2.printBoard();
		board2.chekWinner();

		board3.moreTurns(0, 0, 'X');
		board3.moreTurns(0, 1, 'O');
		board3.moreTurns(1, 1, 'X');
		board3.moreTurns(0, 2, 'O');
		board3.moreTurns(2, 2, 'X');
		board3.printBoard();
		board3.chekWinner();

		board4.moreTurns(0, 0, 'O');
		board4.moreTurns(0, 2, 'X');
		board4.moreTurns(0, 1, 'O');
		board4.moreTurns(2, 0, 'X');
		board4.moreTurns(2, 1, 'O');
		board4.moreTurns(1, 1, 'X');
		board4.printBoard();
		board4.chekWinner();
	}
}
