package com.misakyanls.chess.piece;

public abstract class ChessPiece {
	protected int row = -1, col = -1;
	protected int[][] board;

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public abstract void markTakePositions(int[][] board, boolean remove);

	public void remove() {
		if (row == -1)
			return;
		board[row][col] = 0;
		setCol(-1);
		setRow(-1);
	}

	public void set(int[][] board, int row, int col) {
		this.col = col;
		this.row = row;
		markTakePositions(board, false);
		board[row][col] = -1;
	}

	public boolean attackAnybody(int[][] board, int row, int col) {
		return false;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
