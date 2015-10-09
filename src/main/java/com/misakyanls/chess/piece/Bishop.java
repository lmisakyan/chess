package com.misakyanls.chess.piece;


public class Bishop extends ChessPiece {

	@Override
	public boolean set(int[][] board, int row, int col) {
		getTakePositions().clear();
		for (int i = 0; i < board[row].length; ++i) {
			int offset = Math.abs(col - i);
			if (row - offset >= 0)
				if (board[row - offset][i] < 0)
					return false;
				else
					getTakePositions().add(new Position(row - offset, i));
			if (row + offset < board.length)
				if (board[row + offset][i] < 0)
					return false;
				else
					getTakePositions().add(new Position(row + offset, i));
		}
		return super.set(board, row, col);
	}
}
