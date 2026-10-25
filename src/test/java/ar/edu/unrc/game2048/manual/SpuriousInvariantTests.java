package ar.edu.unrc.game2048.manual;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.*;

public class SpuriousInvariantTests {

    // spurious invariant: ar.edu.unrc.game2048.Board.WINNING_VALUE >= this.size
    @Test
    public void testSpuriousWinningValueGeqSizeInBoardObject() {
        int size = Board.WINNING_VALUE + 2;
        Board board = new Board(size, true);
        assertEquals(size, board.getSize());
    }

    // spurious invariant: ar.edu.unrc.game2048.Board.WINNING_VALUE != other.size
    @Test
    public void testSpuriousWinningValueNotEqualsOtherSizeInCopyConstructorEnter() {
        Board other = new Board(Board.WINNING_VALUE, true);
        Board copy = new Board(other);
        assertEquals(Board.WINNING_VALUE, copy.getSize());
        assertEquals(other, copy);
    }

    // spurious invariant: ar.edu.unrc.game2048.Board.WINNING_VALUE >= size(other.grid[])-1
    @ParameterizedTest(name = "getCell fuera de límites ({0} lanza IndexOutOfBoundsException")
    @CsvSource({
        "1", "2", "5", "20"
    })
    public void testSpuriousWinningValueGeqGridSizeMinusOneInCopyConstructorEnter(int increments) {
        int size = Board.WINNING_VALUE + increments;
        Board other = new Board(size, true);
        Board copy = new Board(other);
        assertEquals(size, copy.getSize());
        assertEquals(other, copy);
    }
    
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

    // spurious invariant: ar.edu.unrc.game2048.Board.WINNING_VALUE > this.size
    @Test
    public void testSpuriousWinningValueGreaterThanSize() {
        Board board = new Board(Board.WINNING_VALUE, true);
        assertEquals(Board.WINNING_VALUE, board.getSize());
        assertTrue(board.repOK());
    }

    // spurious invariant: value >= 2
    @Test
    public void testSpuriousCellValueGeqTwo() {
        Cell empty = new Cell(0);
        assertTrue(empty.isEmpty());
        assertEquals(0, empty.getValue());
        assertEquals(Cell.EMPTY, empty);
        assertTrue(Cell.EMPTY.repOK());

        Cell two = new Cell(2);
        assertFalse(two.isEmpty());
        assertEquals(2, two.getValue());
        assertTrue(two.repOK());
    }

    // spurious invariant: this.value == 0 || this.value >= 2
    @Test
    public void testSpuriousCellValueZeroOrGeqTwo() {
        Cell c1 = new Cell(1);
        assertEquals(1, c1.getValue());
        assertTrue(c1.repOK());

        Cell c2 = new Cell(2);
        Cell c4 = new Cell(4);
        Cell c8 = new Cell(8);
        Cell c16 = new Cell(16);

        assertEquals(2, c2.getValue());
        assertEquals(4, c4.getValue());
        assertEquals(8, c8.getValue());
        assertEquals(16, c16.getValue());

        assertTrue(Cell.EMPTY.repOK());
        assertTrue(c2.repOK());
        assertTrue(c4.repOK());
        assertTrue(c8.repOK());
        assertTrue(c16.repOK());
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
