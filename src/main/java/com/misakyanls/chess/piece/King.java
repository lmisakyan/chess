package com.misakyanls.chess.piece;


public class King extends ChessPiece {
	private static final int[] dr = { -1, 0, 1 };
	private static final int[] dc = { -1, 0, 1 };

	@Override
	public boolean set(int[][] board, int row, int col) {
		getTakePositions().clear();
		for (int r : dr)
			for (int c : dc) {
				int nr = row + r, nc = col + c;
				if (nr >= 0 && nr < board.length && nc >= 0
						&& nc < board[nr].length)
					if (board[nr][nc] < 0)
						return false;
					else
						getTakePositions().add(new Position(nr, nc));
			}
		return super.set(board, row, col);
	}

}
