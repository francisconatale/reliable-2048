package ar.edu.unrc.game2048;
import ar.utils.BoardParser;
import java.util.Scanner;

/**
 * Command-line interface for the 2048 game.
 * 
 * This class handles user input and displays the board state.
 * It demonstrates how to use the Board class and its methods.
 */
public class MainCLI {
    private final Board board;
    private final InputReader inputReader;
    
    public MainCLI() {
        this(new Board(), new Scanner(System.in));
    }

    public MainCLI(Board board){
        this(board, new Scanner(System.in));
    }

    public MainCLI(Board board, Scanner scanner) {
        this(board, new ScannerInputReader(scanner));
    }

    public MainCLI(Board board, InputReader inputReader) {
        this.board = board;
        this.inputReader = inputReader;
    }
    
    /**
     * Main game loop.
     */
    public void play() {
        System.out.println("=== 2048 Game ===");
        System.out.println("Controls: W(up), S(down), A(left), D(right), Q(quit)");
        System.out.println();
        
        while (true) {
            displayBoard();
            
            if (board.isWinningBoard()) {
                System.out.println("🎉 Congratulations! You reached 2048! 🎉");
                System.out.println("You can continue playing or quit.");
            }
            
            if (board.isLosingBoard()) {
                System.out.println("💀 Game Over! No more moves available. 💀");
                System.out.println("Final score: " + board.getScore());
                break;
            }
            
            System.out.print("Enter move: ");
            String input = inputReader.nextLine().trim().toUpperCase();
            
            if (input.equals("Q")) {
                System.out.println("Thanks for playing! Final score: " + board.getScore());
                break;
            }
            
            boolean moved = false;
            switch (input) {
                case "W": moved = board.move(Direction.UP); break;
                case "S": moved = board.move(Direction.DOWN); break;
                case "A": moved = board.move(Direction.LEFT); break;
                case "D": moved = board.move(Direction.RIGHT); break;
                default: 
                    System.out.println("Invalid input! Use W, A, S, D, or Q.");
                    continue;
            }

            if (moved) {
                System.out.println("Tile moved!");
            } else {
                System.out.println("No tiles moved. Try a different direction.");
            }
            
            System.out.println();
        }
        
        inputReader.close();
    }
    
    /**
     * Displays the current board state.
     */
    private void displayBoard() {
        System.out.println(board);
    }    

    // for grammar fuzzing, (size, [0, 1,..., n]) or directly ([0, 1,..., n])
    public static void main(String[] args) {
        MainCLI game = null;
        if (args.length == 2) {
            Integer sizeOfBoard = Integer.parseInt(args[0]);
            String[] boardValues = args[1].replace("[", "").replace("]", "").split(",");
            Board board = BoardParser.parse(boardValues, sizeOfBoard);
            game = new MainCLI(board);
        } else if (args.length == 1 && !args[0].equals("--stdin") && !args[0].equals("-") && !args[0].equals("stdin")) {
            String[] boardValues = args[0].replace("[", "").replace("]", "").split(",");
            Board board = BoardParser.parse(boardValues);
            game = new MainCLI(board);
        } else if (args.length == 1 && (args[0].equals("--stdin") || args[0].equals("-") || args[0].equals("stdin"))) {
            Scanner scanner = new Scanner(System.in);
            if (!scanner.hasNextLine()) {
                return;
            }
            String firstLine = scanner.nextLine().trim();
            String boardLine;
            if (firstLine.contains(",")) {
                boardLine = firstLine;
            } else if (firstLine.contains(" ")) {
                String[] parts = firstLine.split(" ", 2);
                if (parts[1].trim().contains(",")) {
                    boardLine = parts[1].trim();
                } else {
                    boardLine = firstLine;
                }
            } else {
                boardLine = firstLine;
            }
            String[] boardValues = boardLine.replace("[", "").replace("]", "").split(",");
            Board board = BoardParser.parse(boardValues);
            game = new MainCLI(board, scanner);
        } else {
            game = new MainCLI();
        }
        game.play();
    }
}
