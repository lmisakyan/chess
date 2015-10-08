package com.misakyanls.chess.piece;

public class Knight extends ChessPiece {

	@Override
	public void markTakePositions(int[][] board, boolean remove) {
		int inc = remove ? -1 : 1;
		if (row - 2 >= 0) {
			if (col - 1 >= 0)
				board[row - 2][col - 1] = board[row - 2][col - 1] + inc;
			if (col + 1 < board[row - 2].length)
				board[row - 2][col + 1] = board[row - 2][col + 1] + inc;
		}
		if (row - 1 >= 0) {
			if (col - 2 >= 0)
				board[row - 1][col - 2] = board[row - 1][col - 2] + inc;
			if (col + 2 < board[row - 1].length)
				board[row - 1][col + 2] = board[row - 1][col + 2] + inc;
		}
		if (row + 2 < board.length) {
			if (col - 1 >= 0)
				board[row + 2][col - 1] = board[row + 2][col - 1] + inc;
			if (col + 1 < board[row + 2].length)
				board[row + 2][col + 1] = board[row + 2][col + 1] + inc;
		}
		if (row + 1 < board.length) {
			if (col - 2 >= 0)
				board[row + 1][col - 2] = board[row + 1][col - 2] + inc;
			if (col + 2 < board[row + 1].length)
				board[row + 1][col + 2] = board[row + 1][col + 2] + inc;
		}

	}

	@Override
	public boolean attackAnybody(int[][] board, int row, int col) {
		if (row - 2 >= 0) {
			if (col - 1 >= 0)
				if (board[row - 2][col - 1] < 0)
					return true;
			if (col + 1 < board[row - 2].length)
				if (board[row - 2][col + 1] < 0)
					return true;
		}
		if (row - 1 >= 0) {
			if (col - 2 >= 0)
				if (board[row - 1][col - 2] < 0)
					return true;
			if (col + 2 < board[row - 1].length)
				if (board[row - 1][col + 2] < 0)
					return true;
		}
		if (row + 2 < board.length) {
			if (col - 1 >= 0)
				if (board[row + 2][col - 1] < 0)
					return true;
			if (col + 1 < board[row + 2].length)
				if (board[row + 2][col + 1] < 0)
					return true;
		}
		if (row + 1 < board.length) {
			if (col - 2 >= 0)
				if (board[row + 1][col - 2] < 0)
					return true;
			if (col + 2 < board[row + 1].length)
				if (board[row + 1][col + 2] < 0)
					return true;
		}
		return super.attackAnybody(board, row, col);
	}

}
