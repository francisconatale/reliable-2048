package ar.edu.unrc.game2048;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unrc.game2048.Board.Direction;

public class MainCLITest {

    @Test
    public void testInputMovesUp() {
        assertInputMoves("w", Direction.UP);
    }

    @Test
    public void testInputMovesDown() {
        assertInputMoves("s", Direction.DOWN);
    }

    @Test
    public void testInputMovesLeft() {
        assertInputMoves("a", Direction.LEFT);
    }

    @Test
    public void testInputMovesRight() {
        assertInputMoves("d", Direction.RIGHT);
    }

    @Test
    public void testCliReportsMovedBoardAndClosesInput() {
        InputReader mockInputReader = Mockito.mock(InputReader.class);
        Mockito.when(mockInputReader.nextLine()).thenReturn("w", "q");
        Board board = new Board(4, true);
        board.setCell(3, 0, new Cell(2));
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        String cliOutput = runCli(board, mockInputReader, output);

        assertTrue(cliOutput.contains("=== 2048 Game ==="));
        assertTrue(cliOutput.contains("Controls: W(up), S(down), A(left), D(right), Q(quit)"));
        assertTrue(cliOutput.contains("Score: 0"));
        assertTrue(cliOutput.contains("Enter move: "));
        assertTrue(cliOutput.contains("Tile moved!"));
        assertTrue(cliOutput.contains("Tile moved!\n\n"));
        assertTrue(cliOutput.contains("Thanks for playing!"));
        Mockito.verify(mockInputReader).close();
    }

    @Test
    public void testMainStartsCliAndProcessesQuit() {
        java.io.InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream("q\n".getBytes()));
            System.setOut(new PrintStream(output));
            MainCLI.main(new String[0]);
        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
        assertTrue(output.toString().contains("Thanks for playing!"));
    }

    @Test
    public void testCliReportsNoMovement() {
        InputReader mockInputReader = Mockito.mock(InputReader.class);
        Mockito.when(mockInputReader.nextLine()).thenReturn("d", "q");
        Board board = new Board(4, true);
        board.setCell(0, 3, new Cell(2));

        String cliOutput = runCli(board, mockInputReader, new ByteArrayOutputStream());

        assertTrue(cliOutput.contains("No tiles moved. Try a different direction."));
    }

    @Test
    public void testCliReportsInvalidInput() {
        InputReader mockInputReader = Mockito.mock(InputReader.class);
        Mockito.when(mockInputReader.nextLine()).thenReturn("x", "q");

        String cliOutput = runCli(new Board(4, true), mockInputReader,
                new ByteArrayOutputStream());

        assertTrue(cliOutput.contains("Invalid input! Use W, A, S, D, or Q."));
    }

    @Test
    public void testCliReportsWinningBoard() {
        InputReader mockInputReader = Mockito.mock(InputReader.class);
        Mockito.when(mockInputReader.nextLine()).thenReturn("q");
        Board board = new Board(4, true);
        board.setCell(0, 0, new Cell(2048));

        String cliOutput = runCli(board, mockInputReader, new ByteArrayOutputStream());

        assertTrue(cliOutput.contains("Congratulations! You reached 2048!"));
    }

    @Test
    public void testCliReportsLosingBoardUsingMockedBoard() {
        Board mockBoard = Mockito.mock(Board.class);
        InputReader mockInputReader = Mockito.mock(InputReader.class);
        Mockito.when(mockBoard.toString()).thenReturn("losing board");
        Mockito.when(mockBoard.isWinningBoard()).thenReturn(false);
        Mockito.when(mockBoard.isLosingBoard()).thenReturn(true);
        Mockito.when(mockBoard.getScore()).thenReturn(42);

        String cliOutput = runCli(mockBoard, mockInputReader,
                new ByteArrayOutputStream());

        assertTrue(cliOutput.contains("Game Over! No more moves available."));
        assertTrue(cliOutput.contains("Final score: 42"));
        Mockito.verify(mockInputReader).close();
        Mockito.verify(mockInputReader, Mockito.never()).nextLine();
    }

    @Test
    public void testCliReportsWinningBoardUsingMockedBoard() {
        Board mockBoard = Mockito.mock(Board.class);
        InputReader mockInputReader = Mockito.mock(InputReader.class);
        Mockito.when(mockBoard.toString()).thenReturn("winning board");
        Mockito.when(mockBoard.isWinningBoard()).thenReturn(true);
        Mockito.when(mockBoard.isLosingBoard()).thenReturn(false);
        Mockito.when(mockInputReader.nextLine()).thenReturn("q");

        String cliOutput = runCli(mockBoard, mockInputReader,
                new ByteArrayOutputStream());

        assertTrue(cliOutput.contains("Congratulations! You reached 2048!"));
        assertTrue(cliOutput.contains("You can continue playing or quit."));
        Mockito.verify(mockInputReader).nextLine();
        Mockito.verify(mockInputReader).close();
    }

    private String runCli(Board board, InputReader inputReader,
            ByteArrayOutputStream output) {
        PrintStream originalOutput = System.out;
        try {
            System.setOut(new PrintStream(output));
            new MainCLI(board, inputReader).play();
            return output.toString();
        } finally {
            System.setOut(originalOutput);
        }
    }

    private void assertInputMoves(String input, Direction direction) {
        InputReader mockInputReader = Mockito.mock(InputReader.class);
        Mockito.when(mockInputReader.nextLine()).thenReturn(input, "q");

        Board board = new Board(4, true);
        if (direction == Direction.UP || direction == Direction.DOWN) {
            board.setCell(0, 0, new Cell(2));
            board.setCell(1, 0, new Cell(2));
        } else {
            board.setCell(0, 0, new Cell(2));
            board.setCell(0, 1, new Cell(2));
        }
        MainCLI cli = new MainCLI(board, mockInputReader);

        cli.play();

        int expectedRow = direction == Direction.UP ? 0 : direction == Direction.DOWN ? 3 : 0;
        int expectedColumn = direction == Direction.LEFT ? 0 : direction == Direction.RIGHT ? 3 : 0;
        assertEquals(4, board.getCell(expectedRow, expectedColumn).getValue());
        assertEquals(4, board.getScore());
    }
}