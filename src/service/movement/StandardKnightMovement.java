package service.movement;

import models.Board;
import models.Piece;
import models.Square;
import service.movement.Interfaces_MoveAndPlay.MovementLogic;

import java.util.LinkedList;
import java.util.List;

public class StandardKnightMovement implements MovementLogic {
    public final Piece knight;
    public final int[][] directions={{-2,-1},{-2,1},{-1,-2},{-1,2},{1,2},{1,-2},{2,-1},{2,1}};
    public StandardKnightMovement(Piece piece){
        this.knight=piece;
    }

    @Override
    public List<Square> getLegalMoves(Board chessBoard) {
        LinkedList<Square> legalMoves = new LinkedList<Square>();
        Square[][] board = chessBoard.getSquareArray();
        int x = this.knight.getPosition().getX();
        int y = this.knight.getPosition().getY();
        for(int[] direction:directions){
            try {
                if (!board[y + direction[0]][x + direction[1]].isOccupied() ||
                        board[y + direction[0]][x + direction[1]].getOccupyingPiece().getColor()
                                != knight.getColor()) {
                    legalMoves.add(board[y + direction[0]][x + direction[1]]);
                }
            }
            catch(ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }
        return legalMoves;
    }
}
