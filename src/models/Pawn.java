package models;

import models.enums.Color_Piece;
import service.movement.StandardPawnMovement;

import java.util.List;

public class Pawn extends Piece {
    private boolean wasMoved;
    
    public Pawn(Color_Piece color, Square initSq, String img_file) {
        super(color, initSq, img_file);
        this.wasMoved=false;
    }
    
    @Override
    public boolean move(Square fin) {
        boolean b = super.move(fin);
        wasMoved = true;
        return b;
    }
    @Override
    public List<Square> getLegalMoves(Board b) {
        return new StandardPawnMovement(this,this.wasMoved).getLegalMoves(b);
    }
}
