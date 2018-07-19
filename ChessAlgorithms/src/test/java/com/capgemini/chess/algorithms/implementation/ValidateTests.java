package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.BoardState;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.KingInCheckException;

/**
 * Test class for testing {@link BoardManager}
 * 
 * @author Michal Bejm
 *
 *Tests by MD
 */
public class ValidateTests {

	
	
	@Test
	public void testPerformMoveWithWrongCoordinates() throws InvalidMoveException  {
		// given
		Board board = new Board();
		BoardManager boardManager = new BoardManager();
		board.setPieceAt(Piece.WHITE_QUEEN, new Coordinate(5, 0));
		
		//when
		boolean exceptionThrown = false;
		try {
			boardManager.performMove(new Coordinate(5, 0), new Coordinate(12, 2));
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}
		
		// then 
		assertTrue(exceptionThrown);
	}
	
	@Test
	public void testPerformMoveCaptureSameColor()   {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 2));
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(2, 3));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		boolean exceptionThrown = false;
		try {
			boardManager.performMove(new Coordinate(1, 2), new Coordinate(2, 3));
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}
		
		// then 
		assertTrue(exceptionThrown);
	}
	
	@Test
	public void testPerformMoveValidBishopMove()   {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_BISHOP, new Coordinate(1, 1));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		boolean exceptionThrown = false;
		try {
			boardManager.performMove(new Coordinate(1, 1), new Coordinate(4, 4));
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}
		
		// then 
		assertFalse(exceptionThrown);
	}
	
	@Test
	public void testPerformMoveInvalidKing()   {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		boolean exceptionThrown = false;
		try {
			boardManager.performMove(new Coordinate(4, 4), new Coordinate(4, 6));
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}
		
		// then 
		assertTrue(exceptionThrown);
	}
	
	@Test
	public void testKingWouldBeChecked()   {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(3, 0));
		board.setPieceAt(Piece.BLACK_BISHOP, new Coordinate(7, 3));
		// when
		BoardManager boardManager = new BoardManager(board);
		boolean exceptionThrown = false;
		try {
			boardManager.performMove(new Coordinate(4, 0), new Coordinate(5, 1));
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}
		// then 
		assertTrue(exceptionThrown);
	}
	
	
}