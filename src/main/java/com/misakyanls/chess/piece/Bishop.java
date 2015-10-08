package com.misakyanls.chess.piece;

public class Bishop extends ChessPiece {

	@Override
	public void markTakePositions(int[][] board, boolean remove) {
		int inc = remove ? -1 : 1;
		// mark diagonal
		for (int i = 0; i < board[row].length; ++i) {
			int offset = Math.abs(col - i);
			if (row - offset >= 0)
				board[row - offset][i] = board[row - offset][i] + inc;
			if (row + offset < board.length)
				board[row + offset][i] = board[row + offset][i] + inc;
		}

	}

	@Override
	public boolean attackAnybody(int[][] board, int row, int col) {
		for (int i = 0; i < board[row].length; ++i) {
			int offset = Math.abs(col - i);
			if (row - offset >= 0)
				if (board[row - offset][i] < 0)
					return true;
			if (row + offset < board.length)
				if (board[row + offset][i] < 0)
					return true;
		}
		return super.attackAnybody(board, row, col);
	}
}
