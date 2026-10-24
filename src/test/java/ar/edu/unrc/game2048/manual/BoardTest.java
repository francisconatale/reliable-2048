package ar.edu.unrc.game2048.manual;

import ar.edu.unrc.game2048.*;
import ar.edu.unrc.game2048.Direction;
import ar.edu.unrc.game2048.Position;
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
        assertEquals(board, copyOfBoard);
    }

    @Test
    public void hasEmptyCellsInBoardTest() {
        Board board = new Board(4, true);
        seeder.seederBoard(board, 1);
        System.out.println(board.toString());
        assertTrue(board.hasEmptyCells());
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

    @Test
    public void maximumScoreOfBoardTest() {
        Board board = new Board(4, true);
        board.setCell(0, 0, new Cell(2));
        board.setCell(0, 1, new Cell(2));
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

    @Test
    public void testBoardGetCell() {
        Board board = new Board();
        Cell cell = board.getCell(0, 0);
        assertNotNull(cell);
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
        board.getGrid()[0][0] = null;
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

    @Test
    public void testBoardHashCode() {
        Board board = new Board(4, true);
        board.setCell(0, 0, new Cell(2));
        board.setCell(0, 1, new Cell(2));
        int hashCode = board.hashCode();
        assertNotNull(hashCode);
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
    public void testAddRandomTileOnFullBoardDoesNothing() throws Exception {
        Board board = new Board(4, false, new Random(1));
        int[] values = {2, 4, 8, 16};
        for (int row = 0; row < board.getSize(); row++) {
            for (int column = 0; column < board.getSize(); column++) {
                board.setCell(row, column, new Cell(values[column]));
            }
        }

        java.lang.reflect.Method addRandomTile = Board.class.getDeclaredMethod("addRandomTile");
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
}
