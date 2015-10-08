package com.misakyanls.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.misakyanls.chess.piece.Bishop;
import com.misakyanls.chess.piece.ChessPiece;
import com.misakyanls.chess.piece.King;
import com.misakyanls.chess.piece.Knight;
import com.misakyanls.chess.piece.Queen;
import com.misakyanls.chess.piece.Rook;

public class ChessProblem {
	// private static int[][] board;

	private static int[][] copyBoard(int[][] board) {
		int[][] result = new int[board.length][];
		for (int i = 0; i < board.length; ++i) {
			result[i] = new int[board[i].length];
			System.arraycopy(board[i], 0, result[i], 0, board[i].length);
		}
		return result;
	}

	static List<ChessPiece> createPieces(BufferedReader in) throws IOException {
		int kings = 0, queens = 0, bishops = 0, rooks = 0, knights = 0;
		List<ChessPiece> result = new ArrayList<>();
		String line = null;
		while ((line = in.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(line);
			switch (tokenizer.nextToken()) {
			case "K":
				kings = Integer.parseInt(tokenizer.nextToken());
				break;
			case "Q":
				queens = Integer.parseInt(tokenizer.nextToken());
				break;
			case "B":
				bishops = Integer.parseInt(tokenizer.nextToken());
				break;
			case "R":
				rooks = Integer.parseInt(tokenizer.nextToken());
				break;
			case "N":
				knights = Integer.parseInt(tokenizer.nextToken());
				break;
			}
		}
		for (int i = 0; i < queens; ++i)
			result.add(new Queen());
		for (int i = 0; i < rooks; ++i)
			result.add(new Rook());
		for (int i = 0; i < bishops; ++i)
			result.add(new Bishop());
		for (int i = 0; i < knights; ++i)
			result.add(new Knight());
		for (int i = 0; i < kings; ++i)
			result.add(new King());
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		List<ChessPiece> pieces = createPieces(in);
		out.println(solve(m, n, pieces));
		out.flush();
	}

	private static boolean canStand(ChessPiece piece, int row, int col) {
		int[][] board = piece.getBoard();
		row = row == -1 ? 0 : row;
		col = col == -1 ? 0 : col + 1;
		while (row < board.length) {
			while (col < board[row].length) {
				if (board[row][col] == 0) {
					if (!piece.attackAnybody(board, row, col)) {
						piece.remove();
						piece.set(board, row, col);
						return true;
					}
				}
				++col;
			}
			col = 0;
			++row;
		}
		return false;
	}

	public static int solve(int m, int n, List<ChessPiece> pieces) {
		int result = 0;
		int[][] board = new int[m][n];
		int pieceCount = pieces.size();
		int y = 0;
		int initRow = -1, initCol = -1;
		ChessPiece piece = pieces.get(y);
		piece.setBoard(board);
		while (y >= 0) {
			board = copyBoard(piece.getBoard());
			if (canStand(piece, initRow, initCol))
				if (y < pieceCount - 1) {
					ChessPiece prev = piece;
					piece = pieces.get(++y);
					if (prev.getClass() == piece.getClass()) {
						initRow = prev.getRow();
						initCol = prev.getCol();
					} else {
						initRow = -1;
						initCol = -1;
					}
					piece.setBoard(prev.getBoard());
					prev.setBoard(board);
				} else {
					++result;
					// System.out.println(Arrays.deepToString(board));
					// piece.markTakePositions(board, true);
				}
			else if (--y >= 0) {
				piece.remove();
				piece = pieces.get(y);
				// piece.markTakePositions(board, true);
				initRow = piece.getRow();
				initCol = piece.getCol();
			}
		}
		return result;
	}
}
