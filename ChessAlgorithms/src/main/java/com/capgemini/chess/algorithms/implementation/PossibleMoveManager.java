package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class PossibleMoveManager {

	public static boolean checkMovePossibility(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {

		Piece currentPiece = board.getPieceAt(from);
		PieceType currentPieceType = currentPiece.getType();
		Piece capturedPiece = board.getPieceAt(to);

		int currentx = from.getX();
		int currenty = from.getY();
		int newx = to.getX();
		int newy = to.getY();
	

		switch (currentPieceType)

		{
		case PAWN:
			// White Player
			if (currentPiece.getColor() == Color.WHITE) {
				// Capture - move diagonally
				if ((currentx == newx - 1 || currentx == newx + 1) && currenty == newy + 1
						&& capturedPiece.getColor() == Color.BLACK) {
					return true;
				}
				// Move straight
				if (currenty == 1) {
					if ((newy - currenty == 1 || newy - currenty == 2) && newx == currentx
							&& (board.getPieceAt(new Coordinate(currentx, currenty + 1))) == null && capturedPiece==null) {
						return true;
					} else {
						return false;
					}
				} else {
					if (newy - currenty == 1 && newx == currentx && capturedPiece==null) {
						return true;
					} else {
						return false;
					}
				}
			}
			// Black Player
			else {
				// Capture - move diagonally
				if ((currentx == newx - 1 || currentx == newx + 1) && currenty == newy - 1
						&& capturedPiece.getColor() == Color.WHITE) {
					return true;
				}
				// Move straight
				if (currenty == 6) {
					if ((newy - currenty == -1 || newy - currenty == -2) && newx == currentx
							&& (board.getPieceAt(new Coordinate(currentx, currenty - 1))) == null && capturedPiece==null) {
						return true;
					} else {
						return false;
					}
				} else {
					if (newy - currenty == -1 && newx == currentx) {
						return true;
					} else {
						return false;
					}
				}

			}
			
		case ROOK:
			if (currentx == newx) {
				if (currenty < newy) {
					for (int i = currenty + 1; i < newy; i++) {
						if (board.getPieceAt(new Coordinate(currentx, i)) != null) {
							return false;
						}
					}
					return true;
				} else if (currenty > newy) {
					for (int i = newy + 1; i < currenty; i++) {
						if (board.getPieceAt(new Coordinate(currentx, i)) != null) {
							return false;
						}
					}
					return true;
				}
			}
			if (currenty == newy) {
				if (currentx < newx) {
					for (int i = currentx + 1; i < newx; i++) {
						if (board.getPieceAt(new Coordinate(currenty, i)) != null) {
							return false;
						}
					}
					return true;
				} else if (currentx > newx) {
					for (int i = newx + 1; i < currentx; i++) {
						if (board.getPieceAt(new Coordinate(currenty, i)) != null) {
							return false;
						}
					}
					return true;
				}
			} 
			break;
			
		case KNIGHT:
			if (Math.abs(newy - currenty) == 2 && Math.abs(newx - currentx) == 1) {
				return true;
			}
			if (Math.abs(newy - currenty) == 1 && Math.abs(newx - currentx) == 2) {
				return true;
			} else {
				return false;
			}
			
		case BISHOP:
			if (Math.abs(currenty - newy) != Math.abs(currentx - newx)) {
				return false;
			}

			if (newx > currentx && newy > currenty) {
				for (int i = 1; i < Math.abs(currenty - newy); i++) {
					Coordinate clearWay = new Coordinate(currentx + i, currenty + i);
					if (board.getPieceAt(clearWay) != null) {
						return false;
					}
				}
			}

			if (newx > currentx && newy < currenty) {
				for (int i = 1; i < Math.abs(currenty - newy); i++) {
					Coordinate clearWay = new Coordinate(currentx + i, currenty - i);
					if (board.getPieceAt(clearWay) != null) {
						return false;
					}
				}
			}

			if (newx < currentx && newy < currenty) {
				for (int i = 1; i < Math.abs(currenty - newy); i++) {
					Coordinate clearWay = new Coordinate(currentx - i, currenty - i);
					if (board.getPieceAt(clearWay) != null) {
						return false;
					}
				}
			}

			if (newx < currentx && newy > currenty) {
				for (int i = 1; i < Math.abs(currenty - newy); i++) {
					Coordinate clearWay = new Coordinate(currentx - i, currenty + i);
					if (board.getPieceAt(clearWay) != null) {
						return false;
					}
				}
			}
			break;

		case QUEEN:
			// Copied form Rook
			if (currentx == newx) {
				if (currenty < newy) {
					for (int i = currenty + 1; i < newy; i++) {
						if (board.getPieceAt(new Coordinate(currentx, i)) != null) {
							return false;
						}
					}
				} else if (currenty > newy) {
					for (int i = newy + 1; i < currenty; i++) {
						if (board.getPieceAt(new Coordinate(currentx, i)) != null) {
							return false;
						}
					}
				}
			}
			if (currenty == newy) {
				if (currentx < newx) {
					for (int i = currentx + 1; i < newx; i++) {
						if (board.getPieceAt(new Coordinate(currenty, i)) != null) {
							return false;
						}
					}
				} else if (currentx > newx) {
					for (int i = newx + 1; i < currentx; i++) {
						if (board.getPieceAt(new Coordinate(currenty, i)) != null) {
							return false;
						}
					}
				}
			}
			// Moves similar to Bishop
			if (Math.abs(currenty - newy) == Math.abs(currentx - newx)) {
				
				// Copied from Bishop
				if (newx > currentx && newy > currenty) {
					for (int i = 1; i < Math.abs(currenty - newy); i++) {
						Coordinate clearWay = new Coordinate(currentx + i, currenty + i);
						if (board.getPieceAt(clearWay) != null) {
							return false;
						}
					}
				}

				if (newx > currentx && newy < currenty) {
					for (int i = 1; i < Math.abs(currenty - newy); i++) {
						Coordinate clearWay = new Coordinate(currentx + i, currenty - i);
						if (board.getPieceAt(clearWay) != null) {
							return false;
						}
					}
				}

				if (newx < currentx && newy < currenty) {
					for (int i = 1; i < Math.abs(currenty - newy); i++) {
						Coordinate clearWay = new Coordinate(currentx - i, currenty - i);
						if (board.getPieceAt(clearWay) != null) {
							return false;
						}
					}
				}

				if (newx < currentx && newy > currenty) {
					for (int i = 1; i < Math.abs(currenty - newy); i++) {
						Coordinate clearWay = new Coordinate(currentx - i, currenty + i);
						if (board.getPieceAt(clearWay) != null) {
							return false;
						}
					}
				}
			} else {
				return false;
			}
			break;
		case KING:
			if ((Math.abs(currentx-newx)==1 || Math.abs(currentx-newx)==0) && (Math.abs(currenty-newy)==1 || Math.abs(currenty-newy)==0)){
				return true;
			}
			else{
				return false;
			}
		}
		return true;
	}
}