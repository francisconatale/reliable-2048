package ar.edu.unrc.game2048.move;

public class MoveDown extends Move {

    @Override
    protected boolean isColumn() {
        return true;
    }

    @Override
    protected boolean isReversed() {
        return true;
    }
}
