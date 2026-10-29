package ar.edu.unrc.game2048.move;

public class MoveRight extends Move {

    @Override
    protected boolean isColumn() {
        return false;
    }

    @Override
    protected boolean isReversed() {
        return true;
    }
}
