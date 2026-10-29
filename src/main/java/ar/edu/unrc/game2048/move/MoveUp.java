package ar.edu.unrc.game2048.move;

public class MoveUp extends Move {

    @Override
    protected boolean isColumn() {
        return true;
    }

    @Override
    protected boolean isReversed() {
        return false;
    }
}
