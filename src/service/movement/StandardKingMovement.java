package service.movement;

import models.Board;
import models.Piece;
import models.Square;
import service.movement.Interfaces_MoveAndPlay.MovementLogic;
import service.movement.handler.MovementHandle;

import java.util.LinkedList;
import java.util.List;

public class StandardKingMovement implements MovementLogic {
    public final Piece king;
    public int[][] directions={{-1,-1},{-1,0},{-1,1},{0,1},{0,-1},{1,-1},{1,0},{1,1}};
    public StandardKingMovement(Piece piece){
        this.king=piece;
    }

    @Override
    public List<Square> getLegalMoves(Board chessBoard) {
        LinkedList<Square> legalMoves = new LinkedList<Square>();
        Square[][] board = chessBoard.getSquareArray();
        int x = this.king.getPosition().getX();
        int y = this.king.getPosition().getY();
        for(int[] direction:directions){
            try {
                if (!board[y + direction[0]][x + direction[1]].isOccupied() ||
                        board[y + direction[0]][x + direction[1]].getOccupyingPiece().getColor()
                                != king.getColor()) {
                    legalMoves.add(board[y + direction[0]][x + direction[1]]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }
        return legalMoves;
    }
}
