package com.misakyanls.chess.piece;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BishopTest {
	Bishop bishop = new Bishop();

	@Test
	public void takePositionsTLCornerTest() {
		int[][] board = new int[4][4];
		assertThat(bishop.set(board, 0, 0), is(true));
		assertThat(board[0], is(new int[] { -1, 0, 0, 0 }));
		assertThat(board[1], is(new int[] { 0, 1, 0, 0 }));
		assertThat(board[2], is(new int[] { 0, 0, 1, 0 }));
		assertThat(board[3], is(new int[] { 0, 0, 0, 1 }));

		bishop.markTakePositions(board, true);
		bishop.remove(board);
		assertThat(bishop.set(board, 0, 1), is(true));
		assertThat(board[0], is(new int[] { 0, -1, 0, 0 }));
		assertThat(board[1], is(new int[] { 1, 0, 1, 0 }));
		assertThat(board[2], is(new int[] { 0, 0, 0, 1 }));
		assertThat(board[3], is(new int[] { 0, 0, 0, 0 }));
	}
	
	@Test
	public void takePositionsUnderThreatTest() {
		int[][] board = new int[4][4];
		board[2][1] = -1;
		assertThat(bishop.set(board, 0, 3), is(false));

		board[2][1] = 0;
		board[1][2] = -1;
		assertThat(bishop.set(board, 3, 0), is(false));
	}

}
