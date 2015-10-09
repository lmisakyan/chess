package com.misakyanls.chess.piece;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.misakyanls.chess.piece.Queen;

public class QueenTest {
	Queen queen = new Queen();

	@Test
	public void takePositionsTest() {
		int[][] board = new int[3][3];
		assertTrue(queen.set(board, 2, 2));
		assertThat(board[0], is(new int[] { 1, 0, 1 }));
		assertThat(board[1], is(new int[] { 0, 1, 1 }));
		assertThat(board[2], is(new int[] { 1, 1, -1 }));
	}

}
