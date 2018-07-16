package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidCoordinatesException;

public class PossibleMoveManager {
	private  checkPossibleMove(Coordinate from, Coordinate to) throws InvalidCoordinatesException {
		Piece currentPiece = this.board.getPieceAt(from);
		PieceType currentPieceType = currentPiece.getType();
		
		int currentx = from.getX();
		int currenty = from.getY();
		int newx = to.getX();
		int newy = to.getY();
		
		

		switch (currentPieceType) {
		case PAWN:
			break;
		case ROOK:
			if (currentx == newx){
				if (currenty< newy){
					for (int i=currenty+1; i<newy; i++){
						if (this.board.getPieceAt(new Coordinate(currentx, i))!=null){
							throw new InvalidCoordinatesException ();
						}
					}					
				}
				else if (currenty>newy){
					for (int i=newy+1; i<currenty; i++){
						if (this.board.getPieceAt(new Coordinate(currentx, i))!=null){
							throw new InvalidCoordinatesException ();
						}
					}
				}
			}
			if (currenty == newy){
				if (currentx< newx){
					for (int i=currentx+1; i<newx; i++){
						if (this.board.getPieceAt(new Coordinate(currenty, i))!=null){
							throw new InvalidCoordinatesException ();
						}
					}					
				}
				else if (currenty>newx){
					for (int i=newx+1; i<currenty; i++){
						if (this.board.getPieceAt(new Coordinate(currenty, i))!=null){
							throw new InvalidCoordinatesException ();
						}
					}
				}
			}
				break;
		case KNIGHT:
			break;
		case BISHOP:
			break;
		case QUEEN:
			break;
		case KING:
			break;
		}
		return false;
	}
}
