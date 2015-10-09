package com.misakyanls.chess.piece;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KingTest {
	King king = new King();

	@Test
	public void takePositionsTest() {
		int[][] board = new int[3][3];
		assertTrue(king.set(board, 1, 1));
		
		assertThat(board[0], is(new int[] { 1, 1, 1 }));
		assertThat(board[1], is(new int[] { 1, -1, 1 }));
		assertThat(board[2], is(new int[] { 1, 1, 1 }));
	}

	@Test
	public void takePositionsTLCornerTest() {
		int[][] board = new int[3][3];
		assertTrue(king.set(board, 0, 0));
		assertThat(board[0], is(new int[] { -1, 1, 0 }));
		assertThat(board[1], is(new int[] { 1, 1, 0 }));
		assertThat(board[2], is(new int[] { 0, 0, 0 }));
	}

	@Test
	public void takePositionsDRCornerTest() {
		int[][] board = new int[3][3];
		assertTrue(king.set(board, 2, 2));
		assertThat(board[0], is(new int[] { 0, 0, 0 }));
		assertThat(board[1], is(new int[] { 0, 1, 1 }));
		assertThat(board[2], is(new int[] { 0, 1, -1 }));
	}
	
	@Test
	public void takePositionsUnderThreatTest() {
		int[][] board = new int[3][3];
		board[1][1] = -1;
		assertThat(king.set(board, 0, 0), is(false));

		board[1][1] = 0;
		board[2][1] = -1;
		assertThat(king.set(board, 2, 2), is(false));
	}
}
