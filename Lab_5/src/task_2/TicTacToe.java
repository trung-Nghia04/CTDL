package task_2;

public class TicTacToe {
	private static final char EMPTY = ' ';// một hằng số dùng để đại diện cho ô trống trên bàn cờ.
	private char[][] board;

	public TicTacToe() {
		board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

// kiểm tra xem một người chơi có chiến thắng dựa trên kiểm tra các hàng trên bàn cờ
	public boolean checkRows(char player) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
				return true;
			}
		}
		return false;
	}

//kiểm tra xem một người chơi có chiến thắng dựa trên kiểm tra các cột trên bàn cờ
	public boolean checkColumns(char player) {
		for (int i = 0; i < board.length; i++) {
			if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
				return true;
			}
		}
		return false;
	}

//kiểm tra xem một người chơi có chiến thắng dựa trên kiểm tra cả hai đường chéo trên bàn cờ
	public boolean checkDiagonals(char player) {
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player
				|| board[2][0] == player && board[1][1] == player && board[0][2] == player) {
			return true;
		}

		return false;
	}

	/*
	 * Phương thức này cho phép một người chơi thực hiện một nước đi trên bàn cờ
	 * bằng cách cung cấp dòng (row), cột (col) và người chơi (player). Nếu nước đi
	 * hợp lệ (trong khoảng 0-2 và ô đó trống), nó sẽ đặt giá trị người chơi vào ô
	 * đó trên bàn cờ.
	 */
	public void makeMove(int row, int col, char player) {
		if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY) {
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
}