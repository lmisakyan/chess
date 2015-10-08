package com.misakyanls.chess.piece;

public class Queen extends ChessPiece {

	@Override
	public void markTakePositions(int[][] board, boolean remove) {
		int inc = remove ? -1 : 1;
		// mark row and diagonal
		for (int i = 0; i < board[row].length; ++i) {
			board[row][i] = board[row][i] + inc;
			int offset = Math.abs(col - i);
			if (row - offset >= 0)
				board[row - offset][i] = board[row - offset][i] + inc;
			if (row + offset < board.length)
				board[row + offset][i] = board[row + offset][i] + inc;
		}

		// mark column
		for (int i = 0; i < board.length; ++i) {
			board[i][col] = board[i][col] + inc;
		}
	}
}
