package ar.edu.unrc.game2048.manual;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.*;

public class SpuriousInvariantTests {
    
    // spurious invariant: this.determinist == true
    @Test
    public void testSpuriousDeterministMustBeTrueInEqualsEnter() {
        Board a = new Board(4, false);
        Board b = new Board(4, false);
        a.equals(b);
    }

    // spurious invariant: ar.edu.unrc.game2048.Board.DEFAULT_SIZE != this.size
    @Test
    public void testSpuriousDefaultSizeNotEqualsThisSize() {
        Board a = new Board(Board.DEFAULT_SIZE, true);
        Board b = new Board(a);
        assertEquals(Board.DEFAULT_SIZE, a.getSize());
        assertEquals(a, b);
    }

    // spurious invariant: this.size one of { 1, 4, 10, 100 }
    @Test
    public void testSpuriousSizeRestrictedToObservedSet() {
        int size = 5;
        Board board = new Board(size, true);
        assertEquals(size, board.getSize());
        assertTrue(board.repOK());
        Board other = new Board(board);
        assertEquals(board, other);
    }

    // spurious invariant: this.value == 0
    @Test
    public void testSpuriousCellValueMustBeZero() {
        Cell c = new Cell(2);
        assertNotEquals(0, c.getValue());
        assertEquals(2, c.getValue());
        assertTrue(c.repOK());
        assertNotSame(Cell.EMPTY, c);
    }
}
