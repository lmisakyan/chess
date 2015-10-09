package com.misakyanls.chess.piece;


public class Knight extends ChessPiece {
	private static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	private static int[] dc = { -2, -1, 1, 2, -2, -1, 1, 2 };

	@Override
	public boolean set(int[][] board, int row, int col) {
		getTakePositions().clear();

		for (int i = 0; i < dr.length; ++i) {
			int r = row + dr[i], c = col + dc[i];
			if (r >= 0 && r < board.length && c >= 0 && c < board[r].length)
				if (board[r][c] < 0)
					return false;
				else
					getTakePositions().add(new Position(r, c));
		}

		return super.set(board, row, col);
	}

}
