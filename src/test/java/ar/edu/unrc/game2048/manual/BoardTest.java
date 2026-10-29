package ar.edu.unrc.game2048.manual;

import ar.edu.unrc.game2048.*;
import ar.edu.unrc.game2048.manual.utils.BoardParser;
import ar.edu.unrc.game2048.manual.utils.Seeder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private final Seeder seeder = new Seeder();

    @ParameterizedTest(name = "Tablero con tamaño inválido {0} lanza IllegalArgumentException")
    @ValueSource(ints = {0, -1, -5})
    public void invalidBoardTest(int invalidSize) {
        assertThrows(IllegalArgumentException.class, () -> new Board(invalidSize, true));
    }

    // spurious invariant: this.size one of { 1, 4 } $ canMerge() is called by losingBoard
    @ParameterizedTest(name = "Tablero con tamaño inválido {0} es perdedor")
    @ValueSource(ints = {1, 5, 10, 15, 7, 20, 50, 70, 90, 123, 150})
    public void lostBoardTest(int size) {
        Board board = new Board(size, true);
        seeder.seederLostBoard(board);
        assertTrue(board.isLosingBoard());
    }

    @Test
    public void copyABoardTest() {
        Board board = new Board(4, true);
        seeder.seederBoard(board, 5);
        Board copyOfBoard = new Board(board);
        assertEquals(board, copyOfBoard);
    }


    @Test
    public void testCounterexampleWinningValueNotEqualsOtherSizeInCopyConstructor() {
        Board other = new Board(Board.WINNING_VALUE, true);
        Board copy = new Board(other);

        assertEquals(Board.WINNING_VALUE, copy.getSize());
        assertEquals(other, copy);
    }

    @Test
    public void testCounterexampleWinningValueGreaterOrEqualGridSizeMinusOneInCopyConstructor() {
        int size = Board.WINNING_VALUE + 2;
        Board other = new Board(size, true);
        Board copy = new Board(other);

        assertEquals(size, copy.getSize());
        assertEquals(other, copy);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("moveTestCases")
    public void testMoveInGame(String testName, String initialBoardStr, Direction direction, String expectedBoardStr, int expectedScore) {
        Board actualBoard = BoardParser.parse(initialBoardStr);
        Board expectedBoard = BoardParser.parse(expectedBoardStr);
        expectedBoard.setScore(expectedScore);

        actualBoard.move(direction);
        assertEquals(expectedBoard, actualBoard);
        assertEquals(expectedScore, actualBoard.getScore());
    }

    static Stream<Arguments> moveTestCases() {
        return Stream.of(
            Arguments.of(
                "Move UP merges (0,0) and (1,0) into (0,0)",
                "2 0 0 0\n" +
                "2 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0",
                Direction.UP,
                "4 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0",
                4
            ),
            Arguments.of(
                "Move DOWN merges (0,0) and (1,0) into (3,0)",
                "2 0 0 0\n" +
                "2 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0",
                Direction.DOWN,
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "4 0 0 0",
                4
            ),
            Arguments.of(
                "Move LEFT merges (0,0) and (0,1) into (0,0)",
                "2 2 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0",
                Direction.LEFT,
                "4 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0",
                4
            ),
            Arguments.of(
                "Move RIGHT merges (0,0) and (0,1) into (0,3)",
                "2 2 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0",
                Direction.RIGHT,
                "0 0 0 4\n" +
                "0 0 0 0\n" +
                "0 0 0 0\n" +
                "0 0 0 0",
                4
            )
        );
    }

    @ParameterizedTest(name = "setCell fuera de límites ({0}, {1}) lanza IndexOutOfBoundsException")
    @CsvSource({
        "-1, 2",
        "4, 2",
        "2, -1",
        "2, 4"
    })
    public void setCellOutOfBoundsTest(int row, int col) {
        Board board = new Board(4, true);
        Cell cell = new Cell(2);
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> board.setCell(row, col, cell)
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

    @ParameterizedTest(name = "setCell en posición válida ({0}, {1})")
    @CsvSource({
        "0, 0",
        "3, 3",
        "0, 3",
        "3, 0"
    })
    public void setCellValidPositionsTest(int row, int col) {
        Board board = new Board(4, true);
        Cell cell = new Cell(2);
        board.setCell(row, col, cell);
        assertEquals(cell, board.getCell(row, col));
    }

    @ParameterizedTest(name = "getCell fuera de límites ({0}, {1}) lanza IndexOutOfBoundsException")
    @CsvSource({
        "-1, 0",
        "4, 0",
        "0, -1",
        "0, 4"
    })
    public void testBoardIndexOutOfBoundsException(int row, int col) {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Board board = new Board();
            board.getCell(row, col);
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
    public void notEqualsClass() {
        Board board = new Board(2, true);
        Cell cell = new Cell(2);
        assertFalse(board.equals(cell));
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
    public void validBoardSatisfiesRepOk() {
        assertTrue(new Board(4, true).repOK());
    }

    @Test
    public void boardWithNullCellFailsRepOk() throws Exception {
        Board board = new Board(4, true);
        // getGrid() devuelve una copia, asi que se corrompe la matriz interna por reflexion
        java.lang.reflect.Field gridField = Board.class.getDeclaredField("grid");
        gridField.setAccessible(true);
        ((Cell[][]) gridField.get(board))[0][0] = null;
        assertFalse(board.repOK());
    }

    @Test
    public void testBoardEqualsNull() {
        Board board = new Board(4, true);
        assertFalse(board.equals(null));
    }

    @Test
    public void testBoardIsWinningBoard() {
        Board board = new Board(4, true);
        board.setCell(0, 0, new Cell(2048));
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

    @ParameterizedTest(name = "move({2}) con ficha en ({0},{1}) retorna {3}")
    @CsvSource({
        "0, 0, RIGHT, true",
        "0, 3, RIGHT, false",
        "0, 0, UP,    false",
        "3, 0, UP,    true"
    })
    public void testMoveReturnsWhetherBoardChanges(int row, int col, Direction direction, boolean expectedResult) {
        Board board = new Board(4, true);
        board.setCell(row, col, new Cell(2));
        assertEquals(expectedResult, board.move(direction));
    }

    @Test
    public void testAddRandomTileOnFullBoardDoesNothing() {
        Board board = new Board(1, false, new Random(1));

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

    @ParameterizedTest(name = "Probabilidad random {0} genera ficha con valor {1}")
    @CsvSource({
        "0.95, 4",
        "0.90, 4",
        "0.80, 2"
    })
    public void testAddRandomTileProbabilityBoundary(double randomVal, int expectedValue) {
        Random mockRandom = new ControlledRandom(Math.nextDown(1.0), 0.9, 0.0, randomVal);
        Board board = new Board(4, false, mockRandom);

        int countExpected = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i, j).getValue() == expectedValue) {
                    countExpected++;
                }
            }
        }
        assertTrue(countExpected >= 1, "Debe haber generado la ficha esperada");
    }

    // ---------------------------------------------------------------
    // Tests agregados en la rama local: contratos de Board, getGrid defensivo,
    // checkBounds, Random de la copia y tableros de tamanos no estandar
    // ---------------------------------------------------------------

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
            assertTrue(board.isFull(), "size " + size);
        }
    }

    @Test
    public void losingBoardInNonStandardSizesTest() {
        for (int size : new int[] {2, 3, 5, 6}) {
            Board board = new Board(size, true);
            fillCheckerboard(board);
            assertTrue(board.isLosingBoard(), "size " + size);
            assertTrue(board.isFull(), "size " + size);
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
            assertFalse(board.isLosingBoard(), "size " + size);
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
            assertTrue(board.isWinningBoard(), "size " + size);
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
            assertTrue(board.isWinningBoard(), "size " + size);
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
