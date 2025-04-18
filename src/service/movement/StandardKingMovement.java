package service.movement;

import models.Board;
import models.Piece;
import models.Square;
import service.movement.Interfaces_MoveAndPlay.MovementLogic;

import java.util.ArrayList;
import java.util.List;

public class StandardKingMovement implements MovementLogic {
    private static final int[][] KING_DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1},  {1, 0}, {1, 1}
    };

    private final Piece king;

    public StandardKingMovement(Piece piece) {
        this.king = piece;
    }

    @Override
    public List<Square> getLegalMoves(Board chessBoard) {
        List<Square> legalMoves = new ArrayList<>(8); // King has max 8 possible moves
        Square[][] board = chessBoard.getSquareArray();
        int x = king.getPosition().getXNum();
        int y = king.getPosition().getYNum();

        for (int[] direction : KING_DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (isValidPosition(newX, newY)) {
                Square target = board[newY][newX];
                if (!target.isOccupied() ||
                        target.getOccupyingPiece().getColor() != king.getColor()) {
                    legalMoves.add(target);
                }
            }
        }

        // Add castling moves if needed (would need additional checks)
        // addCastlingMoves(legalMoves, chessBoard);

        return legalMoves;
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    // Optional: Add castling logic here
    /*
    private void addCastlingMoves(List<Square> legalMoves, Board board) {
        if (!king.hasMoved()) {
            // Check kingside castling
            // Check queenside castling
        }
    }
    */
}
