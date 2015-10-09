package com.misakyanls.chess.piece;


public class Rook extends ChessPiece {

	@Override
	public boolean set(int[][] board, int row, int col) {
		getTakePositions().clear();
		for (int i = 0; i < board[row].length; ++i) {
			if (board[row][i] < 0)
				return false;
			else
				getTakePositions().add(new Position(row, i));
		}

		for (int i = 0; i < board.length; ++i) {
			if (board[i][col] < 0)
				return false;
			else
				getTakePositions().add(new Position(i, col));
		}
		return super.set(board, row, col);
	}

}
