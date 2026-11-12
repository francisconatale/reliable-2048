package ar.utils;

import java.util.Arrays;

import ar.edu.unrc.game2048.Board;
import ar.edu.unrc.game2048.Cell;

public class BoardParser {
    public static Board parse(String boardString, boolean deterministic) {
        if (boardString == null || boardString.trim().isEmpty()) {
            throw new IllegalArgumentException("Board string cannot be null or empty");
        }
        String[] lines = boardString.trim().split("\\r?\\n");
        int size = lines.length;
        Board board = new Board(size, deterministic);
        for (int r = 0; r < size; r++) {
            String[] tokens = lines[r].trim().split("\\s+");
            if (tokens.length != size) {
                throw new IllegalArgumentException("Invalid board format. Expected " + size + " columns, but got " + tokens.length + " on row " + r);
            }
            for (int c = 0; c < size; c++) {
                int value = Integer.parseInt(tokens[c]);
                Cell cell = (value == 0) ? Cell.EMPTY : new Cell(value);
                board.setCell(r, c, cell);
            }
        }
        return board;
    }

    public static Board parse(String[] boardToParse) {
        if (boardToParse == null || boardToParse.length == 0) {
            throw new IllegalArgumentException("Board elements cannot be null or empty");
        }
        String[] cleaned = Arrays.stream(boardToParse)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
        if (cleaned.length == 0) {
            throw new IllegalArgumentException("Board elements cannot be empty");
        }
        int totalCells = cleaned.length;
        int size = (int) Math.round(Math.sqrt(totalCells));
        if (size * size != totalCells || size <= 0) {
            throw new IllegalArgumentException(
                "Board elements count must be a positive perfect square. Got " + totalCells + " cells."
            );
        }
        return parse(cleaned, size);
    }

    public static Board parse(String[] boardToParse, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Board size must be positive: " + size);
        }
        if (boardToParse == null) {
            throw new IllegalArgumentException("Board array cannot be null");
        }
        String[] cleaned = Arrays.stream(boardToParse)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
        if (cleaned.length != size * size) {
            throw new IllegalArgumentException(
                "Invalid board size. Expected " + (size * size) + " cells for a " + size + "x" + size + " board, but got " + cleaned.length
            );
        }
        Board board = new Board(size, true);

        for (int i = 0; i < cleaned.length; i++) {
            int row = i / size;
            int col = i % size;

            int value = Integer.parseInt(cleaned[i]);
            Cell cell = (value == 0) ? Cell.EMPTY : new Cell(value);

            board.setCell(row, col, cell);
        }

        return board;
    }

    public static Board parse(String boardString) {
        return parse(boardString, true);
    }
}
