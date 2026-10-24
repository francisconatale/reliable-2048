package ar.edu.unrc.game2048;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import ar.edu.unrc.game2048.strategy.Move;
import ar.edu.unrc.game2048.strategy.MoveProvider;
import randoop.CheckRep;
import java.util.Random;

/**
 * Represents the 2048 game board.
 * The board is a square grid of Cells, typically 4x4.
 *
 * Representation Invariants:
 * - grid is a non-null square matrix (rows == cols)
 * - all cells in the grid are non-null (they may be EMPTY)
 * - all cell values are valid per Cell invariants
 * - the board is always in a valid game state
 *
 * Thread-safety: This class is not thread-safe.
 */
public class Board {
  
    public static final int DEFAULT_SIZE = 4;
    public static final int WINNING_VALUE = 2048;
    private final int size;
    private final Cell[][] grid;
    private Score score;
    private boolean determinist;
    private Random random;

    public Board() {
        this(DEFAULT_SIZE, false);
    }
   
    /**
     * Creates a new board of the specified size with two random tiles.
     *
     * @param size the board size (must be > 0)
     * @throws IllegalArgumentException if size <= 0
     */
    public Board(int size, boolean determinist) {
        this(size, determinist, new java.util.Random());
    }

    public static Board forTesting(int size) {
        return new Board(size, true, new Random(42L));
    }

    public Board(int size, boolean determinist, Random random) {
        if (size <= 0) {
            throw new IllegalArgumentException("Board size must be positive: " + size);
        }
        this.size = size;
        this.grid = new Cell[size][size];
        this.score = new Score(0); 
        this.random = random != null ? random : new java.util.Random();
        initializeEmpty();
        this.determinist = determinist;
        if(!determinist) {
            addRandomTile();
            addRandomTile();
        }
    }

    private void addRandomTile() {
        Set<Position> empty = getEmptyPositions();
        if (empty.isEmpty()) {
            return;
        }
        Position allowedPosition = getRandomPosition(empty);
        int value = random.nextDouble() < 0.9 ? 2 : 4; // standard rule of the 2048 game
        setCell(allowedPosition.row, allowedPosition.col, new Cell(value));
    }

    private Position getRandomPosition(Set<Position> allowedPositions){
        int randomIndex = (int) (random.nextDouble() * allowedPositions.size());
        return allowedPositions.stream().skip(randomIndex).findFirst().get();
    }

    public Cell[][] getGrid(){ return grid; }

    @CheckRep
    public boolean repOK() {
        if (size <= 0 || grid == null || grid.length != size
                || score == null || random == null) {
            return false;
        }

        for (int row = 0; row < size; row++) {
            if (grid[row] == null || grid[row].length != size) {
                return false;
            }

        
            for (int column = 0; column < size; column++) {
                if (grid[row][column] == null || !grid[row][column].repOK()) {
                    return false;
                }

                if (grid[row][column].isEmpty() && grid[row][column] != Cell.EMPTY) {
                       return false;
                }
            }
        }
        return true;
    }


    /**
     * Copy constructor - creates a deep copy of another board.
     *
     * @param other the board to copy
     */
    public Board(Board other) {
        if (other == null) {
            throw new IllegalArgumentException("other no puede ser null");
        }
        this.size = other.size;
        this.grid = new Cell[size][size];
        this.score = new Score(other.score.getScore());
        this.random = other.random;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                this.grid[row][col] = other.grid[row][col];
            }
        }
    }

    /**
     * Initializes the board with all EMPTY cells.
     */
    private void initializeEmpty() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = Cell.EMPTY;
            }
        }
    }

    /**
     * Gets the board size (number of rows/columns).
     *
     * @return the board size
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the current score.
     *
     * @return the score
     */
    public int getScore() {
        return score.getScore();
    }

    /**
     * Gets the cell at the specified position.
     *
     * @param row the row index (0-based)
     * @param col the column index (0-based)
     * @return the cell at the specified position
     * @throws IndexOutOfBoundsException if row or col is out of bounds
     */
    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    /**
     * Sets a cell at the specified position.
     *
     * @param row the row index (0-based)
     * @param col the column index (0-based)
     * @param cell the cell to set (must not be null)
     * @throws IndexOutOfBoundsException if row or col is out of bounds
     * @throws IllegalArgumentException if cell is null
     */
    public void setCell(int row, int col, Cell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("Cell cannot be null");
        }
        grid[row][col] = cell;
    }

    /**
     * Gets all empty cells on the board.
     *
     * @return a set of positions of all empty cells
     */
    public Set<Position> getEmptyPositions() {
        Set<Position> empty = new HashSet<>();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c].isEmpty()) {
                    empty.add(new Position(r, c));
                }
            }
        }
        return empty;
    }

    /**
     * Checks if the board has any empty cells.
     *
     * @return true if there is at least one empty cell
     */
    public boolean hasEmptyCells() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c].isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the board is in a winning state.
     * A board is winning if it contains a cell with the WINNING_VALUE (2048).
     *
     * @return true if the board contains 2048
     */
    public boolean isWinningBoard() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (getCell(r, c).getValue() == WINNING_VALUE) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the board is in a losing state (game over).
     * A board is losing if there are no empty cells AND no adjacent cells
     * (horizontal or vertical) can be merged.
     *
     * @return true if the game is over and the player has lost
     */
    public boolean isLosingBoard() {
        if (hasEmptyCells()) {
            return false;
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                Cell current = getCell(r, c);
                Cell right = getNeighbor(r, c, 0, 1);
                Cell down  = getNeighbor(r, c, 1, 0);

                if (canMerge(current, right) || canMerge(current, down)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Cell getNeighbor(int row, int col, int rowOffset, int colOffset) {
        int neighborRow = row + rowOffset;
        int neighborCol = col + colOffset;
        if (neighborRow >= size || neighborCol >= size) {
            return null;
        }
        return getCell(neighborRow, neighborCol);
    }

    private boolean canMerge(Cell current, Cell neighbor) {
        return neighbor != null && current.canMergeWith(neighbor);
    }


    /**
     * Checks if the board is full (no empty cells).
     *
     * @return true if there are no empty cells
     */
    public boolean isFull() {
        return !hasEmptyCells();
    }

    /**
     * Checks if this board is structurally identical to another.
     * Uses deep equality including score.
     *
     * @param o the object to compare
     * @return true if the boards are identical
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return size == board.size &&
                score.getScore() == board.score.getScore() &&
                Arrays.deepEquals(grid, board.grid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, Arrays.deepHashCode(grid), score.getScore());
    }

    /**
     * Returns a string representation of the board.
     * The board is displayed in a grid format with the current score.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Score: ").append(score.getScore()).append("\n");
        for (int r = 0; r < size; r++) {
            sb.append("+");
            for (int c = 0; c < size; c++) {
                sb.append("-----+");
            }
            sb.append("\n|");
            for (int c = 0; c < size; c++) {
                String val = grid[r][c].isEmpty() ? "     " :
                        String.format("%5d", grid[r][c].getValue());
                sb.append(val).append("|");
            }
            sb.append("\n");
        }
        sb.append("+");
        for (int c = 0; c < size; c++) {
            sb.append("-----+");
        }
        sb.append("\n");
        return sb.toString();
    }


    public boolean move(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("direction no puede ser null");
        }
        Board previous = new Board(this);
        Move move = MoveProvider.provide(direction);
        move.execute(this, grid, score);
        boolean moved = !this.equals(previous);
        if (moved && !determinist) {
            addRandomTile();
        }
        return moved;
    }

    public void setScore(int value){ score.setScore(value); }

    /**
     * Represents a direction on the board.
     */
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    /**
     * Represents a position on the board.
     */
    public static class Position {
        public final int row;
        public final int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }
}