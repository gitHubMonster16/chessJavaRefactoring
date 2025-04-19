package models;

import models.enums.Color_Piece;
import service.movement.StandardKingMovement;

import java.util.LinkedList;
import java.util.List;

public class King extends Piece {



    public King(Color_Piece color, Square initSq, String img_file) {
        super(color, initSq, img_file);
    }

    @Override
    public List<Square> getLegalMoves(Board b) {
       return new StandardKingMovement(this).getLegalMoves(b);
    }

}
