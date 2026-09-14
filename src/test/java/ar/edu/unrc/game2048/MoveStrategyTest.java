package ar.edu.unrc.game2048;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unrc.game2048.Board.Direction;

public class MoveStrategyTest {

    @Test
    public void testMoveRightPreservesOrder() {
        Board board = new Board(4, true);
        board.setCell(0, 0, new Cell(2));
        board.setCell(0, 1, new Cell(4));

        board.move(Direction.RIGHT);

        assertEquals(2, board.getCell(0, 2).getValue());
        assertEquals(4, board.getCell(0, 3).getValue());
    }

    @Test
    public void testMoveUpFillsColumnWithoutDroppingLastCell() {
        Board board = new Board(4, true);
        board.setCell(0, 0, new Cell(2));
        board.setCell(1, 0, new Cell(4));
        board.setCell(2, 0, new Cell(8));
        board.setCell(3, 0, new Cell(16));

        board.move(Direction.UP);

        assertEquals(2, board.getCell(0, 0).getValue());
        assertEquals(4, board.getCell(1, 0).getValue());
        assertEquals(8, board.getCell(2, 0).getValue());
        assertEquals(16, board.getCell(3, 0).getValue());
    }

    @Test
    public void testMoveUpCompactsCellsFromBottom() {
        Board board = new Board(4, true);
        board.setCell(2, 0, new Cell(2));
        board.setCell(3, 0, new Cell(4));

        board.move(Direction.UP);

        assertEquals(2, board.getCell(0, 0).getValue());
        assertEquals(4, board.getCell(1, 0).getValue());
        assertTrue(board.getCell(2, 0).isEmpty());
        assertTrue(board.getCell(3, 0).isEmpty());
    }

    @Test
    public void testMoveUpMergesPairsAtColumnBoundary() {
        Board board = new Board(4, true);
        board.setCell(0, 0, new Cell(2));
        board.setCell(1, 0, new Cell(2));
        board.setCell(2, 0, new Cell(4));
        board.setCell(3, 0, new Cell(4));

        board.move(Direction.UP);

        assertEquals(4, board.getCell(0, 0).getValue());
        assertEquals(8, board.getCell(1, 0).getValue());
        assertTrue(board.getCell(2, 0).isEmpty());
        assertTrue(board.getCell(3, 0).isEmpty());
        assertEquals(12, board.getScore());
    }

    @Test
    public void testMoveLeftFillsRowWithoutDroppingLastCell() {
        Board board = new Board(4, true);
        board.setCell(0, 0, new Cell(2));
        board.setCell(0, 1, new Cell(4));
        board.setCell(0, 2, new Cell(8));
        board.setCell(0, 3, new Cell(16));

        board.move(Direction.LEFT);

        assertEquals(2, board.getCell(0, 0).getValue());
        assertEquals(4, board.getCell(0, 1).getValue());
        assertEquals(8, board.getCell(0, 2).getValue());
        assertEquals(16, board.getCell(0, 3).getValue());
    }

    @Test
    public void testMoveLeftCompactsCellsFromRight() {
        Board board = new Board(4, true);
        board.setCell(0, 2, new Cell(2));
        board.setCell(0, 3, new Cell(4));

        board.move(Direction.LEFT);

        assertEquals(2, board.getCell(0, 0).getValue());
        assertEquals(4, board.getCell(0, 1).getValue());
        assertTrue(board.getCell(0, 2).isEmpty());
        assertTrue(board.getCell(0, 3).isEmpty());
    }

    @Test
    public void testMoveLeftMergesPairsAtRowBoundary() {
        Board board = new Board(4, true);
        board.setCell(0, 0, new Cell(2));
        board.setCell(0, 1, new Cell(2));
        board.setCell(0, 2, new Cell(4));
        board.setCell(0, 3, new Cell(4));

        board.move(Direction.LEFT);

        assertEquals(4, board.getCell(0, 0).getValue());
        assertEquals(8, board.getCell(0, 1).getValue());
        assertTrue(board.getCell(0, 2).isEmpty());
        assertTrue(board.getCell(0, 3).isEmpty());
        assertEquals(12, board.getScore());
    }
}