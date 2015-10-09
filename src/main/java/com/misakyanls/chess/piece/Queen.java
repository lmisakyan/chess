package com.misakyanls.chess.piece;


public class Queen extends ChessPiece {

	@Override
	public boolean set(int[][] board, int row, int col) {
		getTakePositions().clear();
		// mark row and diagonal
		for (int i = 0; i < board[row].length; ++i) {
			if (board[row][i] < 0)
				return false;
			else
				getTakePositions().add(new Position(row, i));
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

		// mark column
		for (int i = 0; i < board.length; ++i) {
			if (board[i][col] < 0)
				return false;
			else
				getTakePositions().add(new Position(i, col));
		}

		return super.set(board, row, col);
	}
}
