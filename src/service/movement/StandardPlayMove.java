package service.movement;

import models.Board;
import models.Piece;
import models.Square;
import service.movement.Interfaces_MoveAndPlay.PlayMoveLogic;


public class StandardPlayMove implements PlayMoveLogic {
    private final Piece piece;

    public StandardPlayMove(Piece piece) {
        this.piece = piece;
    }

    public boolean playMoveTo(Board board, Square to) {
        Piece pieceOnNewSquare = to.getOccupyingPiece();
        if (pieceOnNewSquare != null) {
            if (pieceOnNewSquare.getColor() == piece.getColor()) {
                return false;
            }
            else {
                board.capturePiece(to, piece);
            }
        }
        moveHelper(to, piece);
        return true;
    }

    private void moveHelper(Square destination, Piece Piece) {
        piece.getPosition().removePiece();
        piece.setPosition(destination);
        piece.getPosition().put(piece);
    }
}