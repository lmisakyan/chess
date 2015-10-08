package com.misakyanls.chess.piece;

public class Rook extends ChessPiece {

	@Override
	public void markTakePositions(int[][] board, boolean remove) {
		int inc = remove ? -1 : 1;
		// mark row
		for (int i = 0; i < board[row].length; ++i) {
			board[row][i] = board[row][i] + inc;
		}

		// mark column
		for (int i = 0; i < board.length; ++i) {
			board[i][col] = board[i][col] + inc;
		}
	}

}
