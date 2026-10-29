package ar.edu.unrc.game2048.move;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;
import ar.edu.unrc.game2048.Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Base abstract class for movement strategies.
 * Implements the Template Method pattern to slide and merge tiles in a given direction.
 */

public abstract class Move {

    protected abstract boolean isColumn();
    protected abstract boolean isReversed();

    /**
     * Executes the move on the board's grid and updates the score.
     */
    public void execute(Board board, Cell[][] grid, Score score) {
        int size = grid.length;
        for (int i = 0; i < size; i++) {
            slideLine(i, grid, score, size);
        }
    }

    private void slideLine(int index, Cell[][] grid, Score score, int size) {
        List<Cell> line = extractLine(index, grid, size);
        if (isReversed()) {
            Collections.reverse(line);
        }

        List<Cell> merged = mergeLine(line, score, size);

        if (isReversed()) {
            Collections.reverse(merged);
        }
        writeLine(index, grid, merged, size);
    }

    private List<Cell> extractLine(int index, Cell[][] grid, int size) {
        List<Cell> line = new ArrayList<>(size);
        for (int j = 0; j < size; j++) {
            Cell c = isColumn() ? grid[j][index] : grid[index][j];
            if (!c.isEmpty()) {
                line.add(c);
            }
        }
        return line;
    }

    private void writeLine(int index, Cell[][] grid, List<Cell> line, int size) {
        for (int j = 0; j < size; j++) {
            if (isColumn()) {
                grid[j][index] = line.get(j);
            } else {
                grid[index][j] = line.get(j);
            }
        }
    }

    private List<Cell> mergeLine(List<Cell> line, Score score, int size) {
        List<Cell> merged = new ArrayList<>(size);
        int i = 0;
        while (i < line.size()) {
            if (i + 1 < line.size() && line.get(i).canMergeWith(line.get(i + 1))) {
                Cell combined = line.get(i).mergeWith(line.get(i + 1));
                merged.add(combined);
                score.increaseScore(combined.getValue());
                i += 2;
            } else {
                merged.add(line.get(i));
                i++;
            }
        }
        while (merged.size() < size) {
            merged.add(Cell.EMPTY);
        }
        return merged;
    }
}
