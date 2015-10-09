package com.misakyanls.chess;

import static com.misakyanls.chess.ChessProblem.solve;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.misakyanls.chess.piece.Bishop;
import com.misakyanls.chess.piece.ChessPiece;
import com.misakyanls.chess.piece.King;
import com.misakyanls.chess.piece.Knight;
import com.misakyanls.chess.piece.Queen;
import com.misakyanls.chess.piece.Rook;

public class ChessTest {
	@Test
	public void eightQeensTest() {
		List<ChessPiece> pieces = new ArrayList<>();
		for (int i = 0; i < 8; ++i)
			pieces.add(new Queen());

		assertThat(solve(8, 8, pieces), is(92));
	}

	@Test
	public void eightRooksTest() {
		List<ChessPiece> pieces = new ArrayList<>();
		for (int i = 0; i < 8; ++i)
			pieces.add(new Rook());

		assertThat(solve(8, 8, pieces), is(40320));
	}

	@Test
	public void rooksAndKnightsTest() {
		List<ChessPiece> pieces = new ArrayList<>();
		for (int i = 0; i < 2; ++i)
			pieces.add(new Rook());
		for (int i = 0; i < 4; ++i)
			pieces.add(new Knight());

		assertThat(solve(4, 4, pieces), is(8));
	}

	@Test
	public void queensAndKnightsTest() {
		List<ChessPiece> pieces = new ArrayList<>();
		for (int i = 0; i < 5; ++i)
			pieces.add(new Queen());
		for (int i = 0; i < 5; ++i)
			pieces.add(new Knight());

		assertThat(solve(8, 8, pieces), is(16));
	}

	@Test
	public void kingsAndRooksTest() {
		List<ChessPiece> pieces = new ArrayList<>();
		pieces.add(new Rook());
		for (int i = 0; i < 2; ++i)
			pieces.add(new King());

		assertThat(solve(3, 3, pieces), is(4));
	}

	@Test
	public void knightsAndRooksTest() {
		List<ChessPiece> pieces = new ArrayList<>();
		pieces.add(new Rook());
		pieces.add(new Rook());
		for (int i = 0; i < 4; ++i)
			pieces.add(new Knight());

		assertThat(solve(4, 4, pieces), is(8));
	}

	@Test
	public void fourKnightsTest() {
		List<ChessPiece> pieces = new ArrayList<>();
		for (int i = 0; i < 4; ++i)
			pieces.add(new Knight());

		assertThat(solve(2, 2, pieces), is(1));
	}

	@Test
	public void bishopKnightTest() {
		List<ChessPiece> pieces = new ArrayList<>();
		pieces.add(new Bishop());
		pieces.add(new Knight());

		assertThat(solve(2, 2, pieces), is(8));
	}

	@Test
	public void allPiecesTest() {
		List<ChessPiece> pieces = new ArrayList<>();
		pieces.add(new Queen());
		pieces.add(new Rook());
		pieces.add(new Bishop());
		pieces.add(new Knight());
		for (int i = 0; i < 2; ++i)
			pieces.add(new King());

		assertThat(solve(6, 9, pieces), is(20136752));
	}
}
