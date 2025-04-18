package service.movement;

import models.Board;

import models.Piece;
import models.Square;
import service.movement.Interfaces_MoveAndPlay.MovementLogic;

import java.util.LinkedList;
import java.util.List;

public class StandardPawnMove implements MovementLogic {
    public final Piece pawn;
    public boolean wasMoved;
    public StandardPawnMove(Piece piece,boolean wasMoved){
        this.pawn=piece;
        this.wasMoved=wasMoved;
    }
    @Override
    public List<Square> getLegalMoves(Board b) {
        LinkedList<Square> legalMoves = new LinkedList<Square>();
        Square[][] board = b.getSquareArray();
        int x = this.pawn.getPosition().getXNum();
        int y = this.pawn.getPosition().getYNum();
        int c = this.pawn.getColor();

        if (c == 0) {
            if (!wasMoved) {
                if (!board[y+2][x].isOccupied()) {
                    legalMoves.add(board[y+2][x]);
                }
            }

            if (y+1 < 8) {
                if (!board[y+1][x].isOccupied()) {
                    legalMoves.add(board[y+1][x]);
                }
            }

            if (x+1 < 8 && y+1 < 8) {
                if (board[y+1][x+1].isOccupied()) {
                    legalMoves.add(board[y+1][x+1]);
                }
            }

            if (x-1 >= 0 && y+1 < 8) {
                if (board[y+1][x-1].isOccupied()) {
                    legalMoves.add(board[y+1][x-1]);
                }
            }
        }

        if (c == 1) {
            if (!wasMoved) {
                if (!board[y-2][x].isOccupied()) {
                    legalMoves.add(board[y-2][x]);
                }
            }

            if (y-1 >= 0) {
                if (!board[y-1][x].isOccupied()) {
                    legalMoves.add(board[y-1][x]);
                }
            }

            if (x+1 < 8 && y-1 >= 0) {
                if (board[y-1][x+1].isOccupied()) {
                    legalMoves.add(board[y-1][x+1]);
                }
            }

            if (x-1 >= 0 && y-1 >= 0) {
                if (board[y-1][x-1].isOccupied()) {
                    legalMoves.add(board[y-1][x-1]);
                }
            }
        }
        return legalMoves;
    }
}
