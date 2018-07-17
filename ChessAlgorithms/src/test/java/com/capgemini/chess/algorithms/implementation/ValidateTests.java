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
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidCoordinatesException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.KingInCheckException;

/**
 * Test class for testing {@link BoardManager}
 * 
 * @author Michal Bejm
 *
 */
public class ValidateTests {

	
	
	@Test (expected = InvalidCoordinatesException.class)
	public void testGivenCoordinates() {
		// given
		BoardManager boardManager;
		Coordinate from = new Coordinate (0,0);
		Coordinate to = new Coordinate (7,6);
		
		// when
		boardManager.checkGivenCoordinates(from, to);
		// then
		
	}
}