package ar.edu.unrc.game2048.manual;
import ar.edu.unrc.game2048.*;
import ar.edu.unrc.game2048.strategy.*;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.Random;

import ar.edu.unrc.game2048.Board.Direction;
import ar.edu.unrc.game2048.Board.Position;
import ar.edu.unrc.game2048.manual.utils.Seeder;
public class BoardTest {
    Seeder seeder = new Seeder();
    @Test
    public void invalidBoardTest() {
    assertThrows(IllegalArgumentException.class, () -> new Board(0, true));
    }

    @Test
    public void lostBoardTest() {
        Board board = new Board(4, true);
        seeder.seederLostBoard(board);
        assertTrue(board.isLosingBoard());
    }

     @Test
    public void copyABoardTest() {
        Board board = new Board(4, true);
        seeder.seederBoard(board, 5);
        Board copyOfBoard = new Board(board);
        assertEquals(board,copyOfBoard);
    }

    @Test
    public void hasEmptyCellsInBoardTest() {
        Board board = new Board(4, true);
        seeder.seederBoard(board, 1);
        System.out.println(board.toString());
        assertTrue(board.hasEmptyCells());
    }

    @Test
    public void testMoveUpInGame(){
     Board actual_board = new Board(4, true);
     actual_board.setCell(0,0, new Cell(2));
     actual_board.setCell(1,0, new Cell(2));
     Board expected_board = new Board(4, true);
     expected_board.setCell(0,0,new Cell(4));
     expected_board.setScore(4); 
     actual_board.move(Direction.UP);
      assertEquals(actual_board, expected_board);
    }

    @Test
    public void testMoveLeftInGame(){
        Board actual_board = new Board(4, true);
        actual_board.setCell(0,1, new Cell(2));
        actual_board.setCell(0,0, new Cell(2));
        Board expected_board = new Board(4, true);
        expected_board.setCell(0,0,new Cell(4));
        expected_board.setScore(4); 
        actual_board.move(Direction.LEFT);
        assertEquals(actual_board, expected_board);
    }

    @Test
    public void maximumScoreOfBoardTest() {
        Board board = new Board(4,true);
        board.setCell(0,  0,new Cell(2));
        board.setCell(0,1, new Cell(2));
        board.move(Direction.LEFT);
        int scoreExpected = 4;
        assertEquals(scoreExpected, board.getScore());
    }

    @Test
    public void notHasEmptyCellsInBoardTest() {
        Board board = new Board(4, true);
        int n = board.getSize();
        seeder.seederBoard(board, n * n);
        assertFalse(board.hasEmptyCells());
    }

    @Test
    public void setCellNegativeRowTest() {
    Board board = new Board(4, true);
    Cell cell = new Cell(2);
    assertThrows(
        IndexOutOfBoundsException.class,
        () -> board.setCell(-1, 2, cell)
    );
    }
    @Test
    public void trySetCellNullAndGetThrows() {
    Board board = new Board(4, true);
    Cell cell = null;
    assertThrows(
        IllegalArgumentException.class,
        () -> board.setCell(2, 2, cell)
    );
    }
    @Test
    public void setCellRowOutOfBoundsTest() {
    Board board = new Board(4, true);
    Cell cell = new Cell(2);
    assertThrows(
        IndexOutOfBoundsException.class,
        () -> board.setCell(4, 2, cell)
    );
    }
    @Test
    public void setCellNegativeColumnTest() {
    Board board = new Board(4, true);
    Cell cell = new Cell(2);
    assertThrows(
        IndexOutOfBoundsException.class,
        () -> board.setCell(2, -1, cell)
    );
    }
    @Test
    public void setCellColumnOutOfBoundsTest() {
    Board board = new Board(4, true);
    Cell cell = new Cell(2);
    assertThrows(
        IndexOutOfBoundsException.class,
        () -> board.setCell(2, 4, cell)
    );
    }
    @Test
    public void setCellFirstValidPositionTest() {
    Board board = new Board(4, true);
    Cell cell = new Cell(2);
    board.setCell(0, 0, cell);
    }
    @Test
    public void setCellLastValidPositionTest() {
    Board board = new Board(4, true);
    Cell cell = new Cell(2);
    board.setCell(3, 3, cell);
    }
    @Test
    public void testBoardGetCell() {
        Board board = new Board();
        Cell cell = board.getCell(0, 0);
        assertNotNull(cell);
    }
    @Test
    public void testBoardIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Board board = new Board();
            board.getCell(-1, 0);
        });
    }


    @Test
    public void toStringTest() {
    Board board = new Board(2, true);

    board.setCell(0, 0, new Cell(2));
    board.setCell(1, 1, new Cell(4));

    String expected =
            "Score: 0\n" +
            "+-----+-----+\n" +
            "|    2|     |\n" +
            "+-----+-----+\n" +
            "|     |    4|\n" +
            "+-----+-----+\n";

    assertEquals(expected, board.toString());
    }

    @Test
    public void notEqualsClass(){
    Board board = new Board(2, true);
    Cell cell = new Cell(2);
    assertEquals(board.equals(cell), false);
    }

    @Test
    public void testBoardEqualsSameBoard() {
        Board board = new Board(4, true);
        assertTrue(board.equals(board));
    }

    @Test
    public void testBoardEqualsDifferentBoardState() {
        Board first = new Board(4, true);
        Board second = new Board(4, true);
        second.setCell(0, 0, new Cell(2));
        assertFalse(first.equals(second));
    }

    @Test
    public void testBoardEqualsDifferentScore() {
        Board first = new Board(4, true);
        Board second = new Board(4, true);
        second.setScore(4);
        assertFalse(first.equals(second));
    }

    @Test
    public void testBoardGetGrid() {
        Board board = new Board(4, true);
        assertSame(board.getCell(0, 0), board.getGrid()[0][0]);
        assertEquals(4, board.getGrid().length);
    }

    @Test
    public void testBoardAllowsNullRandomByCreatingDefaultRandom() {
        Board board = new Board(4, false, null);
        assertTrue(board.hasEmptyCells());
    }

    @Test
    public void validBoardSatisfiesRepOk() {
        assertTrue(new Board(4, true).repOK());
    }

    @Test
    public void boardWithNullCellFailsRepOk() {
        Board board = new Board(4, true);
        // getGrid() retorna una copia defensiva, necesitamos usar reflexion para modificar el estado interno del tablero
        try {
            java.lang.reflect.Field gridField = Board.class.getDeclaredField("grid");
            gridField.setAccessible(true);
            ((Cell[][]) gridField.get(board))[0][0] = null;
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(e);
        }
        assertFalse(board.repOK());
    }

    @Test
    public void boardWithInvalidCellFailsRepOk() {
        Board board = new Board(4, true);
        try {
            board.setCell(0, 0, new Cell(3)); // Invalid cell value
        } catch (IllegalArgumentException e) {
            // Expected exception, do nothing
            return;
        }
        assertFalse(board.repOK());
    }

    @Test
    public void testBoardEqualsNull() {
        Board board = new Board(4, true);
        assertFalse(board.equals(null));
    }


    @Test
    public void testBoardGetEmptyPositions() {
        Board board = new Board();
        Set<Position> emptyPositions = board.getEmptyPositions();
        assertNotNull(emptyPositions);
    }

    @Test
    public void testBoardIsWinningBoard() {
        Board board = new Board(4, true);
        board.setCell(0,0, new Cell(2048));
        boolean isWinning = board.isWinningBoard();
        assertTrue(isWinning);
    }

    @Test
    public void testBoardIsNotWinningBoard() {
        Board board = new Board();
        boolean isWinning = board.isWinningBoard();
        assertFalse(isWinning);
    }

    @Test
    public void testBoardIsFull() {
        Board board = new Board(4, false);
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                board.setCell(i, j, new Cell(2));
            }
        }
        boolean isFull = board.isFull();
        assertTrue(isFull);
    }

    @Test
    public void testBoardIsNotFull() {
        Board board = new Board();
        boolean isFull = board.isFull();
        assertFalse(isFull);
    }

    @Test
    public void testBoardMoveDown() {
        Board actual_board = new Board(4, true);
        actual_board.setCell(0,0, new Cell(2));
        actual_board.setCell(1,0, new Cell(2));
        Board expected_board = new Board(4, true);
        expected_board.setCell(3,0,new Cell(4));
        expected_board.setScore(4);
        actual_board.move(Direction.DOWN);
        assertEquals(actual_board, expected_board);
    }

    @Test
    public void testBoardMmoveRight() {
        Board actual_board = new Board(4, true);
        actual_board.setCell(0,0, new Cell(2));
        actual_board.setCell(0,1, new Cell(2));
        Board expected_board = new Board(4, true);
        expected_board.setCell(0,3,new Cell(4));
        expected_board.setScore(4);
        actual_board.move(Direction.RIGHT);
        assertEquals(actual_board, expected_board);
    }

    @Test
    public void testBoardHashCode() {
        Board board = new Board(4, true);
        board.setCell(0,0, new Cell(2));
        board.setCell(0,1, new Cell(2));
        int hashCode = board.hashCode();
        assertNotNull(hashCode);
    }

    @Test
    public void testMoveReturnsTrueWhenBoardChanges() {
        Board board = new Board(4, true);
        board.setCell(0, 0, new Cell(2));
        assertTrue(board.move(Direction.RIGHT));
    }

    @Test
    public void testMoveReturnsFalseWhenBoardDoesNotChange() {
        Board board = new Board(4, true);
        board.setCell(0, 3, new Cell(2));
        assertFalse(board.move(Direction.RIGHT));
    }

    @Test
    public void testAddRandomTileOnFullBoardDoesNothing() throws Exception {
        Board board = new Board(4, false, new Random(1));
        int[] values = {2, 4, 8, 16};
        for (int row = 0; row < board.getSize(); row++) {
            for (int column = 0; column < board.getSize(); column++) {
                board.setCell(row, column, new Cell(values[column]));
            }
        }

            java.lang.reflect.Method addRandomTile = Board.class
                .getDeclaredMethod("addRandomTile");
            addRandomTile.setAccessible(true);
            addRandomTile.invoke(board);

        assertFalse(board.hasEmptyCells());
    }

    @Test
    public void testBoardHashCodeChangesWithBoardState() {
        Board first = new Board(4, true);
        Board second = new Board(4, true);
        second.setCell(0, 0, new Cell(2));
        assertNotEquals(first.hashCode(), second.hashCode());
    }

    @Test
    public void testAddRandomTileSelectsPositionUsingRandomIndex() {
        Position expectedPosition = new Board(4, true).getEmptyPositions().stream()
                .skip(12)
                .findFirst()
                .get();
        Random controlledRandom = new ControlledRandom(0.75, 0.1, 0.0, 0.1);
        Board board = new Board(4, false, controlledRandom);
        assertEquals(2, board.getCell(expectedPosition.row, expectedPosition.col).getValue());
    }

    private static class ControlledRandom extends Random {
        private final double[] values;
        private int index;

        ControlledRandom(double... values) {
            this.values = values;
        }

        @Override
        public double nextDouble() {
            return values[index++];
        }
    }

    @Test
    public void testAddRandomTileEdgeCaseValue4() {
        Random mockRandom = new ControlledRandom(0.0, 0.1, 0.0, 0.95);

        Board board = new Board(4, false, mockRandom);
        
        int countFour = 0;
        int countTwo = 0;
        
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i, j).getValue() == 4) countFour++;
                if (board.getCell(i, j).getValue() == 2) countTwo++;
            }
        }
        
        assertEquals("Debe haber exactamente un 4", 1, countFour);
        assertEquals("Debe haber exactamente un 2", 1, countTwo);
    }

    @Test
    public void testAddRandomTileBoundary() {
        Random mockRandom = new ControlledRandom(Math.nextDown(1.0), 0.9, 0.0, 0.9);

        Board board = new Board(4, false, mockRandom);
        
        int countFour = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i, j).getValue() == 4) countFour++;
            }
        }
        assertEquals("El valor limite 0.9 debe generar 4", 2, countFour);
    }

    @Test
    public void testAddRandomTileNegatedConditional() {
        Random mockRandom = new ControlledRandom(0.9, 0.8, 0.0, 0.1);

        Board board = new Board(4, false, mockRandom);
        
        int countTwo = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i, j).getValue() == 2) countTwo++;
            }
        }
        assertEquals("Deberia generar solo 2s cuando los valores son menores a 0.9", 2, countTwo);
    }

    @Test
    public void getGridReturnsDefensiveCopyTest() {
        Board board = new Board(4, true);
        Cell[][] grid = board.getGrid();
        grid[0][0] = new Cell(8);
        grid[1] = null;
        assertTrue(board.getCell(0, 0).isEmpty());
        assertTrue(board.repOK());
        assertNotSame(grid, board.getGrid());
    }

    @Test
    public void setScoreNegativeThrowsTest() {
        Board board = new Board(4, true);
        board.setScore(10);
        assertThrows(IllegalArgumentException.class, () -> board.setScore(-1));
        assertEquals(10, board.getScore());
    }

    @Test
    public void setScoreZeroIsValidTest() {
        Board board = new Board(4, true);
        board.setScore(0);
        assertEquals(0, board.getScore());
    }

    @Test
    public void getCellOutOfBoundsThrowsTest() {
        Board board = new Board(4, true);
        assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(4, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(0, 4));
    }

    @Test
    public void setCellOutOfBoundsThrowsAndNullCellStillIllegalArgumentTest() {
        Board board = new Board(4, true);
        assertThrows(IndexOutOfBoundsException.class, () -> board.setCell(4, 0, new Cell(2)));
        assertThrows(IndexOutOfBoundsException.class, () -> board.setCell(0, -1, new Cell(2)));
        assertThrows(IllegalArgumentException.class, () -> board.setCell(0, 0, null));
        assertThrows(IllegalArgumentException.class, () -> board.setCell(99, 99, null));
    }

    @Test
    public void copyDoesNotShareRandomTest() throws Exception {
        Board board = new Board(4, false, new Random(7L));
        Board copy = new Board(board);
        java.lang.reflect.Field randomField = Board.class.getDeclaredField("random");
        randomField.setAccessible(true);
        assertNotSame(randomField.get(board), randomField.get(copy));
        assertTrue(copy.repOK());
    }

    @Test
    public void moveDoesNotConsumeRandomSequenceOfBoardTest() {
        // move() builds an internal copy; it must not alter the board's own random sequence
        Board a = new Board(4, false, new Random(123L));
        Board b = new Board(4, false, new Random(123L));
        assertEquals(a, b);
        for (Direction d : Direction.values()) {
            a.move(d);
            b.move(d);
        }
        assertEquals(a, b);
    }

    // ---------------------------------------------------------------
    // Escenarios para eliminar invariantes falsos de Daikon
    // ---------------------------------------------------------------

    // Llena el tablero con un patron de tablero de ajedrez de manera que no se puedan mergear celdas adyacentes
    private void fillCheckerboard(Board board) {
        for (int r = 0; r < board.getSize(); r++) {
            for (int c = 0; c < board.getSize(); c++) {
                board.setCell(r, c, new Cell(((r + c) % 2 == 0) ? 2 : 4));
            }
        }
    }

    @Test
    public void deterministicBoardCanBeFullTest() {
        Board board = new Board(4, true);
        assertFalse(board.isFull());
        fillCheckerboard(board);
        assertTrue(board.isFull());
        assertFalse(board.hasEmptyCells());
        assertTrue(board.repOK());
    }

    @Test
    public void nonDeterministicBoardCanBeFullTest() {
        Board board = new Board(4, false, new Random(1L));
        fillCheckerboard(board);
        assertTrue(board.isFull());
    }

    @Test
    public void isFullInNonStandardSizesTest() {
        for (int size : new int[] {2, 3, 5}) {
            Board board = new Board(size, true);
            assertFalse(board.isFull());
            fillCheckerboard(board);
            assertTrue("size " + size, board.isFull());
        }
    }

    @Test
    public void losingBoardInNonStandardSizesTest() {
        for (int size : new int[] {2, 3, 5, 6}) {
            Board board = new Board(size, true);
            fillCheckerboard(board);
            assertTrue("size " + size, board.isLosingBoard());
            assertTrue("size " + size, board.isFull());
        }
    }

    @Test
    public void losingBoard2x2AllDifferentTest() {
        Board board = new Board(2, true);
        board.setCell(0, 0, new Cell(2));
        board.setCell(0, 1, new Cell(4));
        board.setCell(1, 0, new Cell(8));
        board.setCell(1, 1, new Cell(16));
        assertTrue(board.isLosingBoard());
        for (Direction d : Direction.values()) {
            assertFalse(board.move(d));
        }
    }

    @Test
    public void fullBoardWithPossibleMergeIsNotLosingInOtherSizesTest() {
        for (int size : new int[] {2, 3, 5}) {
            Board board = new Board(size, true);
            fillCheckerboard(board);
            board.setCell(0, 1, new Cell(2)); // ahora (0,0) y (0,1) pueden mergear
            assertTrue(board.isFull());
            assertFalse("size " + size, board.isLosingBoard());
        }
    }

    @Test
    public void winningBoardInNonStandardSizesTest() {
        for (int size : new int[] {2, 3, 5}) {
            Board board = new Board(size, true);
            assertFalse(board.isWinningBoard());
            board.setCell(0, 0, new Cell(1024));
            board.setCell(0, 1, new Cell(1024));
            assertFalse(board.isWinningBoard());
            assertTrue(board.move(Direction.LEFT));
            assertEquals(2048, board.getCell(0, 0).getValue());
            assertTrue("size " + size, board.isWinningBoard());
            assertEquals(2048, board.getScore());
            assertTrue(board.repOK());
        }
    }

    @Test
    public void winningAndFullBoardInNonStandardSizesTest() {
        for (int size : new int[] {3, 5}) {
            Board board = new Board(size, true);
            fillCheckerboard(board);
            board.setCell(size - 1, size - 1, new Cell(2048));
            assertTrue(board.isFull());
            assertTrue("size " + size, board.isWinningBoard());
        }
    }

    @Test
    public void accumulatedScoreGreaterThanDefaultSizeTest() {
        Board board = new Board(4, true);
        board.setCell(0, 0, new Cell(4));
        board.setCell(0, 1, new Cell(4));
        board.setCell(0, 2, new Cell(8));
        board.setCell(0, 3, new Cell(16));
        assertTrue(board.move(Direction.LEFT));   // 4+4 -> 8
        assertEquals(8, board.getScore());
        assertTrue(board.move(Direction.LEFT));   // 8+8 -> 16
        assertEquals(24, board.getScore());
        assertTrue(board.move(Direction.LEFT));   // 16+16 -> 32
        assertEquals(56, board.getScore());
        assertEquals(32, board.getCell(0, 0).getValue());
        assertTrue(board.getScore() > Board.DEFAULT_SIZE);
        assertTrue(board.repOK());
    }

    @Test
    public void scoreValuesOtherThanZeroAndFourTest() {
        Board board = new Board(4, true);
        for (int score : new int[] {0, 4, 7, 100, 2048}) {
            board.setScore(score);
            assertEquals(score, board.getScore());
        }
    }

    @Test
    public void moveOnNonDeterministicBoardAddsRandomTileTest() {
        Board board = new Board(4, false, new Random(5L));
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                board.setCell(r, c, Cell.EMPTY);
            }
        }
        board.setCell(0, 3, new Cell(2));
        assertTrue(board.move(Direction.LEFT));
        assertEquals(2, board.getCell(0, 0).getValue());
        assertEquals(2, 16 - board.getEmptyPositions().size());
        assertTrue(board.repOK());
    }

    @Test
    public void moveOnDeterministicBoardDoesNotAddTileTest() {
        Board board = new Board(4, true);
        board.setCell(0, 3, new Cell(2));
        assertTrue(board.move(Direction.LEFT));
        assertEquals(1, 16 - board.getEmptyPositions().size());
    }

    @Test
    public void moveReturnsFalseInEveryDirectionTest() {
        Board board = new Board(4, true);
        assertFalse(board.move(Direction.UP));
        assertFalse(board.move(Direction.DOWN));
        assertFalse(board.move(Direction.LEFT));
        assertFalse(board.move(Direction.RIGHT));
    }

    @Test
    public void nonDeterministicBoardCanWinAndLoseTest() {
        Board winning = new Board(4, false, new Random(3L));
        winning.setCell(2, 2, new Cell(2048));
        assertTrue(winning.isWinningBoard());

        Board losing = new Board(4, false, new Random(3L));
        fillCheckerboard(losing);
        assertTrue(losing.isLosingBoard());
        assertFalse(winning.isLosingBoard());
    }

    @Test
    public void boardWithNegativeScoreFailsRepOkTest() throws Exception {
        Board board = new Board(4, true);
        assertTrue(board.repOK());

        // setScore rechaza negativos, por lo que se corrompe el Score interno por reflexion
        java.lang.reflect.Field scoreField = Board.class.getDeclaredField("score");
        
        scoreField.setAccessible(true);
        ((Score) scoreField.get(board)).setScore(-1);
        assertFalse(board.repOK());
    }
}
