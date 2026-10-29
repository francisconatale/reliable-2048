package ar.edu.unrc.game2048.move;

public class MoveLeft extends Move {

    @Override
    protected boolean isColumn() {
        return false;
    }

    @Override
    protected boolean isReversed() {
        return false;
    }
}
