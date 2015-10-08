package com.misakyanls.chess.piece;

public class King extends ChessPiece {
	private static final int[] dr = { -1, 0, 1 };
	private static final int[] dc = { -1, 0, 1 };

	@Override
	public void markTakePositions(int[][] board, boolean remove) {
		int inc = remove ? -1 : 1;
		for (int r : dr)
			for (int c : dc) {
				int nr = row + r, nc = col + c;
				if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[nr].length)
					board[nr][nc] = board[nr][nc] + inc;
			}
	}

	@Override
	public boolean attackAnybody(int[][] board, int row, int col) {
		for (int r : dr)
			for (int c : dc) {
				int nr = row + r, nc = col + c;
				if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[nr].length)
					if (board[nr][nc] < 0)
						return true;
			}
		return super.attackAnybody(board, row, col);
	}

}
