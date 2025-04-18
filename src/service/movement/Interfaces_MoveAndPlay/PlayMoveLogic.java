package service.movement.Interfaces_MoveAndPlay;

import models.Board;
import models.Square;

public interface PlayMoveLogic {
    boolean playMoveTo(Board board, Square square);
}
