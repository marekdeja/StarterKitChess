package com.capgemini.chess.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class CastlingValidator {

	public static boolean validateCastling(Coordinate from, Coordinate to, Board board, Color nextMoveColor)
			throws InvalidMoveException {

		List history = new ArrayList();
		history = board.getMoveHistory();
		Coordinate whiteKingCoordinate = new Coordinate(4, 0);
		Coordinate whiteRightRookCoordinate = new Coordinate(7, 0);
		Board tempBoard = new Board();
		tempBoard.

		if (history.size() % 2 == 0) {
			// WHITE
			if (from == whiteKingCoordinate && to == new Coordinate(6, 0)) {
				for (int i = 0; i < history.size(); i++) {
					Move move = (Move) history.get(i);
					if (move.getFrom().equals(whiteKingCoordinate) || move.getFrom().equals(whiteRightRookCoordinate)) {
						return false;
					} else if (board.getPieceAt(new Coordinate(6, 0)) != null
							&& board.getPieceAt(new Coordinate(5, 0)) != null) {
						return false;
					} else if (CheckValidator.isKingInCheck(Color.WHITE, board)) {
						return false;
					} 
				}
			}
			//this.board.setPieceAt(this.board.getPieceAt(from), to);
			//this.board.setPieceAt(null, currentMove.getFrom());

			else {
				// BLACK
			}
		}
		return false;
	}
}
