package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class CastlingTest {
	@Test
	public void testPerformMoveCastling() throws InvalidMoveException  {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(7, 0));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(4, 0), new Coordinate(6, 0));
		
		// then
		assertEquals(MoveType.CASTLING, move.getType());
		assertEquals(Piece.WHITE_KING, move.getMovedPiece());
	}
}
