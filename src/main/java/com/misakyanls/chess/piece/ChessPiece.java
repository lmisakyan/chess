package com.misakyanls.chess.piece;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ChessPiece {
	protected int row = -1, col = -1;
	private Collection<Position> takePositions = new ArrayList<Position>(30);

	public void markTakePositions(int[][] board, boolean remove) {
		int inc = remove ? -1 : 1;
		for (Position p : getTakePositions())
			board[p.getRow()][p.getCol()] = board[p.getRow()][p.getCol()] + inc;

	}

	public void remove(int[][] board) {
		if (row == -1)
			return;
		board[row][col] = 0;
		setCol(-1);
		setRow(-1);
	}

	public boolean set(int[][] board, int row, int col) {
		this.col = col;
		this.row = row;
		markTakePositions(board, false);
		board[row][col] = -1;
		return true;
	}

	public Collection<Position> getTakePositions() {
		return takePositions;
	}

	public void setTakePositions(Collection<Position> takePositions) {
		this.takePositions = takePositions;
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
