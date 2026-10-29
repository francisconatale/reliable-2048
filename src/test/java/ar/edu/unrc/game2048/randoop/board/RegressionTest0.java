package ar.edu.unrc.game2048.randoop.board;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    public void assertBooleanArrayEquals(boolean[] expectedArray, boolean[] actualArray) {
        if (expectedArray.length != actualArray.length) {
            throw new AssertionError("Array lengths differ: " + expectedArray.length + " != " + actualArray.length);
        }
        for (int i = 0; i < expectedArray.length; i++) {
            if (expectedArray[i] != actualArray[i]) {
                throw new AssertionError("Arrays differ at index " + i + ": " + expectedArray[i] + " != " + actualArray[i]);
            }
        }
    }

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test001");
        java.lang.Object obj0 = new java.lang.Object();
        java.lang.Class<?> wildcardClass1 = obj0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        int int0 = ar.edu.unrc.game2048.Board.DEFAULT_SIZE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Board size must be positive: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        int int0 = ar.edu.unrc.game2048.Board.WINNING_VALUE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2048 + "'", int0 == 2048);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Direction direction2 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean3 = board1.move(direction2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Direction direction4 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean5 = board1.move(direction4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Cell cell7 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 1, (int) (byte) 100, cell7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell cannot be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell7 = board1.getCell(10, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (10, 52) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        ar.edu.unrc.game2048.Direction direction2 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean3 = board1.move(direction2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell11 = board8.getCell((int) '#', (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(0, (int) (byte) -1, cell11);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, -1) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertNotNull(cell11);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell10 = board7.getCell((int) '#', (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((-1), (int) (short) 1, cell10);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 1) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertNotNull(cell10);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.isFull();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell5 = board1.getCell(0, (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, -1) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Direction direction5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = board1.move(direction5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Board size must be positive: 0");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell9 = board1.getCell(100, 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 100) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        ar.edu.unrc.game2048.Direction direction6 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean7 = board1.move(direction6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        boolean boolean5 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction6 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean7 = board1.move(direction6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        java.lang.Class<?> wildcardClass7 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(cellArray6);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        java.lang.Class<?> wildcardClass7 = cellArray6.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(cellArray6);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell7 = board1.getCell(52, (int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (52, 10) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore(2048);
        boolean boolean7 = board1.isLosingBoard();
        java.lang.Class<?> wildcardClass8 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore(2048);
        boolean boolean7 = board1.isLosingBoard();
        boolean boolean8 = board1.isFull();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board1.getGrid();
        int int10 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 2048 + "'", int10 == 2048);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction7 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = board1.move(direction7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean4 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell11 = board8.getCell((int) '#', (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(52, (int) (byte) 1, cell11);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (52, 1) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertNotNull(cell11);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Direction direction5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = board1.move(direction5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell8 = board1.getCell(0, (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, -1) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        java.lang.Class<?> wildcardClass5 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int9 = board8.getScore();
        int int10 = board8.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet11 = board8.getEmptyPositions();
        boolean boolean12 = board8.isFull();
        ar.edu.unrc.game2048.Board board16 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell19 = board16.getCell((int) '#', (int) '#');
        board8.setCell((int) (short) 10, 0, cell19);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 100, (int) (short) 10, cell19);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 10) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(positionSet11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(board16);
        org.junit.Assert.assertNotNull(cell19);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.isLosingBoard();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell10 = board1.getCell(0, 52);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, 52) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        boolean boolean6 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        // The following exception was thrown during execution in test generation
        try {
            board1.setScore((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Score cannot be negative: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        // The following exception was thrown during execution in test generation
        try {
            board1.setScore((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Score cannot be negative: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell8 = board5.getCell((int) '#', (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 10, (int) (byte) 100, cell8);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (10, 100) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertNotNull(cell8);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int7 = board6.getScore();
        int int8 = board6.getScore();
        board6.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet11 = board6.getEmptyPositions();
        ar.edu.unrc.game2048.Board board15 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int16 = board15.getScore();
        int int17 = board15.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet18 = board15.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell21 = board15.getCell((int) (byte) 1, (int) (short) 0);
        board6.setCell(0, 0, cell21);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(52, 52, cell21);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (52, 52) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(positionSet11);
        org.junit.Assert.assertNotNull(board15);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertNotNull(positionSet18);
        org.junit.Assert.assertNotNull(cell21);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        ar.edu.unrc.game2048.Cell cell8 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) -1, (int) (byte) -1, cell8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell cannot be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        int int4 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell12 = board9.getCell((int) '#', (int) '#');
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(0, 2048, cell12);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, 2048) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertNotNull(cell12);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction7 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = board1.move(direction7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 0);
        boolean boolean4 = board1.hasEmptyCells();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell7 = board1.getCell(4, (int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (4, 35) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        int int4 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell8 = board1.getCell(0, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, 52) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(positionSet5);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        int int7 = board1.getScore();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        boolean boolean11 = board9.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray12 = board9.getGrid();
        boolean boolean13 = board1.equals((java.lang.Object) cellArray12);
        // The following exception was thrown during execution in test generation
        try {
            board1.setScore((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Score cannot be negative: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cellArray12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        int int4 = board1.getSize();
        java.lang.Class<?> wildcardClass5 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        board1.setScore((int) ' ');
        int int8 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 52 + "'", int8 == 52);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet2 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(positionSet2);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        int int4 = board1.getSize();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell7 = board1.getCell(100, 10);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 10) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) (byte) 10, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (10, 100) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean2 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell cell5 = board1.getCell((int) (short) 10, (int) (short) 10);
        boolean boolean6 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cell5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore(2048);
        int int7 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 2048 + "'", int7 == 2048);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        boolean boolean5 = board1.isFull();
        board1.setScore((int) (short) 100);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        int int6 = board1.getScore();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean11 = board10.hasEmptyCells();
        boolean boolean13 = board10.equals((java.lang.Object) 0);
        ar.edu.unrc.game2048.Cell cell16 = board10.getCell((int) (short) 0, (int) (short) 10);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 1, (int) 'a', cell16);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (1, 97) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(cell16);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        ar.edu.unrc.game2048.Cell[][] cellArray2 = board1.getGrid();
        boolean boolean3 = board1.isFull();
        int int4 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cellArray2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore(2048);
        boolean boolean7 = board1.isLosingBoard();
        boolean boolean8 = board1.isFull();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board1.getGrid();
        java.lang.Class<?> wildcardClass10 = cellArray9.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        ar.edu.unrc.game2048.Direction direction2 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean3 = board1.move(direction2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell6 = board1.getCell(2048, 10);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (2048, 10) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        boolean boolean6 = board1.equals((java.lang.Object) 'a');
        ar.edu.unrc.game2048.Direction direction7 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = board1.move(direction7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Board size must be positive: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell9 = board1.getCell(4, 10);
        java.lang.Class<?> wildcardClass10 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.lang.Class<?> wildcardClass6 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        boolean boolean5 = board1.isWinningBoard();
        board1.setScore(52);
        ar.edu.unrc.game2048.Direction direction8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = board1.move(direction8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        int int7 = board1.getScore();
        java.lang.Class<?> wildcardClass8 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore(2048);
        boolean boolean7 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int12 = board11.getScore();
        int int13 = board11.getScore();
        board11.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet16 = board11.getEmptyPositions();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int21 = board20.getScore();
        int int22 = board20.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet23 = board20.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell26 = board20.getCell((int) (byte) 1, (int) (short) 0);
        board11.setCell(0, 0, cell26);
        board1.setCell(0, 0, cell26);
        board1.setScore((int) (short) 10);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertNotNull(positionSet16);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
        org.junit.Assert.assertNotNull(positionSet23);
        org.junit.Assert.assertNotNull(cell26);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.isFull();
        boolean boolean3 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction4 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean5 = board1.move(direction4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        int int5 = board1.getSize();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (short) 1, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (1, 52) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 52 + "'", int5 == 52);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(positionSet6);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        ar.edu.unrc.game2048.Direction direction8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = board1.move(direction8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertNotNull(cellArray7);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        ar.edu.unrc.game2048.Direction direction7 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = board1.move(direction7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Board size must be positive: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        boolean boolean7 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.isFull();
        java.lang.Class<?> wildcardClass3 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.isFull();
        ar.edu.unrc.game2048.Cell[][] cellArray8 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(cellArray8);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean4 = board1.equals((java.lang.Object) 0);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) (short) 0, (int) (short) 10);
        board1.setScore(0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(cell7);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        boolean boolean5 = board1.isWinningBoard();
        board1.setScore(52);
        java.lang.Object obj8 = null;
        boolean boolean9 = board1.equals(obj8);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell12 = board1.getCell(52, 1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (52, 1) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        boolean boolean6 = board1.equals((java.lang.Object) (-1L));
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(cellArray7);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore(2048);
        boolean boolean7 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        int int4 = board1.getScore();
        int int5 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet8 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Direction direction9 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = board1.move(direction9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(positionSet8);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int11 = board10.getScore();
        int int12 = board10.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet13 = board10.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell16 = board10.getCell((int) (byte) 1, (int) (short) 0);
        board1.setCell(0, 0, cell16);
        ar.edu.unrc.game2048.Cell[][] cellArray18 = board1.getGrid();
        boolean boolean19 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertNotNull(cell16);
        org.junit.Assert.assertNotNull(cellArray18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean4 = board1.equals((java.lang.Object) 0);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) (short) 0, (int) (short) 10);
        java.lang.Class<?> wildcardClass8 = cell7.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        int int4 = board1.getSize();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(positionSet5);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean4 = board1.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell(0, 0);
        int int9 = board1.getScore();
        java.lang.Class<?> wildcardClass10 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        int int11 = board9.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet12 = board9.getEmptyPositions();
        board9.setScore(0);
        int int15 = board9.getScore();
        boolean boolean16 = board9.isLosingBoard();
        boolean boolean17 = board1.equals((java.lang.Object) board9);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell20 = board9.getCell((int) (byte) 100, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 0) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(positionSet12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) '#');
        int int10 = board6.getScore();
        boolean boolean11 = board6.isWinningBoard();
        boolean boolean12 = board6.isWinningBoard();
        boolean boolean13 = board1.equals((java.lang.Object) boolean12);
        ar.edu.unrc.game2048.Cell[][] cellArray14 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet15 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(cellArray14);
        org.junit.Assert.assertNotNull(positionSet15);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore(2048);
        boolean boolean7 = board1.isLosingBoard();
        boolean boolean8 = board1.isFull();
        boolean boolean9 = board1.isWinningBoard();
        boolean boolean10 = board1.isFull();
        int int11 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 52 + "'", int11 == 52);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.isFull();
        boolean boolean3 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean4 = board1.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int8 = board7.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet9 = board7.getEmptyPositions();
        int int10 = board7.getSize();
        boolean boolean12 = board7.equals((java.lang.Object) 'a');
        boolean boolean13 = board1.equals((java.lang.Object) board7);
        int int14 = board7.getSize();
        boolean boolean15 = board7.hasEmptyCells();
        ar.edu.unrc.game2048.Cell cell18 = null;
        // The following exception was thrown during execution in test generation
        try {
            board7.setCell((-1), (int) (short) 1, cell18);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell cannot be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(positionSet9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 52 + "'", int10 == 52);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 52 + "'", int14 == 52);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.isFull();
        boolean boolean3 = board1.isFull();
        boolean boolean4 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int7 = board6.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet8 = board6.getEmptyPositions();
        int int9 = board6.getSize();
        boolean boolean11 = board6.equals((java.lang.Object) 'a');
        boolean boolean12 = board1.equals((java.lang.Object) 'a');
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertNotNull(positionSet8);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 52 + "'", int9 == 52);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Direction direction8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = board1.move(direction8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(positionSet7);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore((int) (byte) 10);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        int int8 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 52 + "'", int8 == 52);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        boolean boolean7 = board1.equals((java.lang.Object) (byte) -1);
        boolean boolean8 = board1.hasEmptyCells();
        board1.setScore(0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Board size must be positive: 0");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore((int) (byte) 10);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        boolean boolean8 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean4 = board1.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell(0, 0);
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int13 = board12.getScore();
        int int14 = board12.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet15 = board12.getEmptyPositions();
        boolean boolean16 = board12.isFull();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell23 = board20.getCell((int) '#', (int) '#');
        board12.setCell((int) (short) 10, 0, cell23);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (byte) -1, (int) (byte) 10, cell23);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 10) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
        org.junit.Assert.assertNotNull(positionSet15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertNotNull(cell23);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        int int6 = board1.getScore();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell9 = board1.getCell((int) (byte) 100, 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 100) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore((int) (byte) 10);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        boolean boolean8 = board1.isLosingBoard();
        int int9 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 52 + "'", int9 == 52);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        int int8 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 52 + "'", int8 == 52);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell9 = board1.getCell((int) (byte) 100, 2048);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 2048) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(cellArray6);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean4 = board1.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (short) 100, (int) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 1) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(positionSet5);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        boolean boolean7 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(cellArray6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        int int7 = board1.getScore();
        int int8 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board1.getGrid();
        ar.edu.unrc.game2048.Direction direction10 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean11 = board1.move(direction10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 52 + "'", int8 == 52);
        org.junit.Assert.assertNotNull(cellArray9);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.isFull();
        board1.setScore((int) (short) 100);
        boolean boolean10 = board1.isLosingBoard();
        int int11 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 52 + "'", int11 == 52);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        board1.setScore(2048);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        board1.setScore(0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        int int7 = board1.getScore();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        boolean boolean11 = board9.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray12 = board9.getGrid();
        boolean boolean13 = board1.equals((java.lang.Object) cellArray12);
        ar.edu.unrc.game2048.Direction direction14 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean15 = board1.move(direction14);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cellArray12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        boolean boolean5 = board1.isFull();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell12 = board9.getCell((int) '#', (int) '#');
        board1.setCell((int) (short) 10, 0, cell12);
        boolean boolean14 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertNotNull(cell12);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(cellArray15);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int11 = board10.getScore();
        int int12 = board10.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet13 = board10.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell16 = board10.getCell((int) (byte) 1, (int) (short) 0);
        board1.setCell(0, 0, cell16);
        ar.edu.unrc.game2048.Cell[][] cellArray18 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet19 = board1.getEmptyPositions();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell22 = board1.getCell((int) '4', 4);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (52, 4) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertNotNull(cell16);
        org.junit.Assert.assertNotNull(cellArray18);
        org.junit.Assert.assertNotNull(positionSet19);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int9 = board8.getScore();
        board8.setScore(0);
        boolean boolean12 = board8.isWinningBoard();
        board8.setScore(52);
        java.lang.Object obj15 = null;
        boolean boolean16 = board8.equals(obj15);
        boolean boolean17 = board1.equals(obj15);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        int int7 = board1.getScore();
        boolean boolean8 = board1.isLosingBoard();
        boolean boolean9 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean11 = board1.move(direction10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int6 = board5.getScore();
        boolean boolean7 = board5.isWinningBoard();
        int int8 = board5.getScore();
        boolean boolean9 = board5.hasEmptyCells();
        ar.edu.unrc.game2048.Board board13 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int14 = board13.getScore();
        board13.setScore(0);
        board13.setScore(2048);
        boolean boolean19 = board13.isLosingBoard();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int24 = board23.getScore();
        int int25 = board23.getScore();
        board23.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet28 = board23.getEmptyPositions();
        ar.edu.unrc.game2048.Board board32 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int33 = board32.getScore();
        int int34 = board32.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet35 = board32.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell38 = board32.getCell((int) (byte) 1, (int) (short) 0);
        board23.setCell(0, 0, cell38);
        board13.setCell(0, 0, cell38);
        board5.setCell((int) (byte) 10, 0, cell38);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(2048, 100, cell38);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (2048, 100) is outside the 100x100 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(board13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 0 + "'", int24 == 0);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
        org.junit.Assert.assertNotNull(positionSet28);
        org.junit.Assert.assertNotNull(board32);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 0 + "'", int33 == 0);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
        org.junit.Assert.assertNotNull(positionSet35);
        org.junit.Assert.assertNotNull(cell38);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        boolean boolean5 = board1.isLosingBoard();
        boolean boolean6 = board1.isFull();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell9 = board1.getCell(0, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, 100) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.isLosingBoard();
        boolean boolean8 = board1.hasEmptyCells();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell11 = board1.getCell(0, (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, 97) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        boolean boolean5 = board1.isFull();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell12 = board9.getCell((int) '#', (int) '#');
        board1.setCell((int) (short) 10, 0, cell12);
        ar.edu.unrc.game2048.Direction direction14 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean15 = board1.move(direction14);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertNotNull(cell12);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        boolean boolean7 = board1.equals((java.lang.Object) (byte) -1);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet8 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(positionSet8);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean4 = board1.equals((java.lang.Object) 0);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) (short) 0, (int) (short) 10);
        boolean boolean8 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean4 = board1.equals((java.lang.Object) 0);
        int int5 = board1.getSize();
        int int6 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        java.lang.Class<?> wildcardClass2 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean7 = board6.isWinningBoard();
        boolean boolean8 = board1.equals((java.lang.Object) board6);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet9 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(positionSet9);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(cellArray5);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean4 = board1.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        int int6 = board1.getScore();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int9 = board8.getScore();
        boolean boolean10 = board8.isWinningBoard();
        int int11 = board8.getScore();
        boolean boolean12 = board1.equals((java.lang.Object) board8);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell6 = board1.getCell(100, 1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 1) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        int int5 = board1.getSize();
        boolean boolean7 = board1.equals((java.lang.Object) (byte) 10);
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int12 = board11.getScore();
        int int13 = board11.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet14 = board11.getEmptyPositions();
        boolean boolean15 = board11.isFull();
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell22 = board19.getCell((int) '#', (int) '#');
        board11.setCell((int) (short) 10, 0, cell22);
        board1.setCell((int) (short) 1, (int) ' ', cell22);
        board1.setScore(10);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 52 + "'", int5 == 52);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertNotNull(positionSet14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertNotNull(cell22);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        ar.edu.unrc.game2048.Cell[][] cellArray2 = board1.getGrid();
        board1.setScore(1);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cellArray2);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        int int4 = board1.getSize();
        boolean boolean5 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        int int7 = board1.getScore();
        int int8 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board1.getGrid();
        boolean boolean10 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 52 + "'", int8 == 52);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(10);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction3 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean4 = board1.move(direction3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell cell5 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (byte) -1, 32, cell5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell cannot be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        int int6 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        boolean boolean8 = board1.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet9 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(positionSet9);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        boolean boolean8 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        java.lang.Object obj5 = null;
        boolean boolean6 = board1.equals(obj5);
        int int7 = board1.getSize();
        boolean boolean8 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Direction direction9 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = board1.move(direction9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 52 + "'", int7 == 52);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        int int6 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        java.lang.Class<?> wildcardClass8 = positionSet7.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int11 = board10.getScore();
        int int12 = board10.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet13 = board10.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell16 = board10.getCell((int) (byte) 1, (int) (short) 0);
        board1.setCell(0, 0, cell16);
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean20 = board19.isWinningBoard();
        ar.edu.unrc.game2048.Cell cell23 = board19.getCell((int) (short) 10, (int) (short) 10);
        boolean boolean24 = board1.equals((java.lang.Object) cell23);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell27 = board1.getCell((int) 'a', (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (97, 100) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertNotNull(cell16);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(cell23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.isLosingBoard();
        boolean boolean6 = board1.isLosingBoard();
        boolean boolean7 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        boolean boolean4 = board1.isFull();
        int int5 = board1.getSize();
        int int6 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 52 + "'", int5 == 52);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        board1.setScore((int) (byte) 1);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertNotNull(cellArray7);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 0);
        boolean boolean4 = board1.hasEmptyCells();
        boolean boolean5 = board1.hasEmptyCells();
        boolean boolean6 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        java.lang.Object obj5 = null;
        boolean boolean6 = board1.equals(obj5);
        int int7 = board1.getSize();
        ar.edu.unrc.game2048.Direction direction8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = board1.move(direction8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 52 + "'", int7 == 52);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        int int7 = board1.getScore();
        int int8 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell11 = board1.getCell(0, 1);
        int int12 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 52 + "'", int8 == 52);
        org.junit.Assert.assertNotNull(cell11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        boolean boolean2 = board1.hasEmptyCells();
        int int3 = board1.getScore();
        boolean boolean4 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean7 = board6.isWinningBoard();
        boolean boolean8 = board1.equals((java.lang.Object) board6);
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board6.getGrid();
        boolean boolean10 = board6.isFull();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell13 = board6.getCell(32, (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (32, 100) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        int int7 = board1.getScore();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        boolean boolean11 = board9.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray12 = board9.getGrid();
        boolean boolean13 = board1.equals((java.lang.Object) cellArray12);
        boolean boolean14 = board1.isFull();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cellArray12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cellArray15);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) '#');
        int int10 = board6.getScore();
        boolean boolean11 = board6.isWinningBoard();
        boolean boolean12 = board6.isWinningBoard();
        boolean boolean13 = board1.equals((java.lang.Object) boolean12);
        ar.edu.unrc.game2048.Board board17 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int18 = board17.getScore();
        int int19 = board17.getScore();
        board17.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet22 = board17.getEmptyPositions();
        ar.edu.unrc.game2048.Board board26 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int27 = board26.getScore();
        int int28 = board26.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet29 = board26.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell32 = board26.getCell((int) (byte) 1, (int) (short) 0);
        board17.setCell(0, 0, cell32);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) '4', (int) (byte) 100, cell32);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (52, 100) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(board17);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertNotNull(positionSet22);
        org.junit.Assert.assertNotNull(board26);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 0 + "'", int27 == 0);
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 0 + "'", int28 == 0);
        org.junit.Assert.assertNotNull(positionSet29);
        org.junit.Assert.assertNotNull(cell32);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        int int5 = board1.getSize();
        board1.setScore((int) (byte) 1);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 52 + "'", int5 == 52);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean4 = board1.equals((java.lang.Object) 0);
        boolean boolean5 = board1.isFull();
        java.lang.Class<?> wildcardClass6 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int11 = board10.getScore();
        int int12 = board10.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet13 = board10.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell16 = board10.getCell((int) (byte) 1, (int) (short) 0);
        board1.setCell(0, 0, cell16);
        ar.edu.unrc.game2048.Cell[][] cellArray18 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet19 = board1.getEmptyPositions();
        board1.setScore((int) (byte) 10);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertNotNull(cell16);
        org.junit.Assert.assertNotNull(cellArray18);
        org.junit.Assert.assertNotNull(positionSet19);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        board9.setScore(0);
        board9.setScore(2048);
        boolean boolean15 = board9.isLosingBoard();
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int20 = board19.getScore();
        int int21 = board19.getScore();
        board19.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet24 = board19.getEmptyPositions();
        ar.edu.unrc.game2048.Board board28 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int29 = board28.getScore();
        int int30 = board28.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet31 = board28.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell34 = board28.getCell((int) (byte) 1, (int) (short) 0);
        board19.setCell(0, 0, cell34);
        board9.setCell(0, 0, cell34);
        board1.setCell((int) (byte) 10, 0, cell34);
        boolean boolean38 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(positionSet24);
        org.junit.Assert.assertNotNull(board28);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 0 + "'", int29 == 0);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
        org.junit.Assert.assertNotNull(positionSet31);
        org.junit.Assert.assertNotNull(cell34);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        board1.setScore(0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cellArray5);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.isFull();
        board1.setScore((int) (short) 100);
        board1.setScore(1);
        ar.edu.unrc.game2048.Direction direction12 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean13 = board1.move(direction12);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell14 = board11.getCell((int) '#', (int) '#');
        board1.setCell(0, 35, cell14);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertNotNull(cell14);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        int int4 = board1.getSize();
        board1.setScore((int) (byte) 100);
        board1.setScore((int) 'a');
        ar.edu.unrc.game2048.Cell cell11 = board1.getCell(0, 10);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(cell11);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        ar.edu.unrc.game2048.Cell[][] cellArray2 = board1.getGrid();
        boolean boolean3 = board1.isFull();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Direction direction5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = board1.move(direction5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cellArray2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(4);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        int int7 = board1.getScore();
        boolean boolean8 = board1.isLosingBoard();
        int int9 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 52 + "'", int9 == 52);
        org.junit.Assert.assertNotNull(cellArray10);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean7 = board6.isWinningBoard();
        boolean boolean8 = board1.equals((java.lang.Object) board6);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int11 = board10.getScore();
        int int12 = board10.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet13 = board10.getEmptyPositions();
        board10.setScore(0);
        int int16 = board10.getScore();
        int int17 = board10.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray18 = board10.getGrid();
        boolean boolean19 = board1.equals((java.lang.Object) board10);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 52 + "'", int17 == 52);
        org.junit.Assert.assertNotNull(cellArray18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        java.lang.Class<?> wildcardClass8 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(cellArray6);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        boolean boolean6 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        boolean boolean8 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction9 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean10 = board1.move(direction9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean4 = board1.equals((java.lang.Object) 0);
        ar.edu.unrc.game2048.Direction direction5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = board1.move(direction5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean4 = board1.equals((java.lang.Object) 0);
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int8 = board7.getScore();
        int int9 = board7.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet10 = board7.getEmptyPositions();
        board7.setScore(0);
        int int13 = board7.getScore();
        boolean boolean14 = board7.isLosingBoard();
        int int15 = board7.getSize();
        boolean boolean16 = board1.equals((java.lang.Object) int15);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(positionSet10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 52 + "'", int15 == 52);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.isWinningBoard();
        int int8 = board1.getSize();
        // The following exception was thrown during execution in test generation
        try {
            board1.setScore((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Score cannot be negative: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 52 + "'", int8 == 52);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        boolean boolean5 = board1.isWinningBoard();
        board1.setScore(52);
        java.lang.Object obj8 = null;
        boolean boolean9 = board1.equals(obj8);
        board1.setScore(35);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isLosingBoard();
        boolean boolean7 = board1.isWinningBoard();
        board1.setScore((int) 'a');
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        boolean boolean5 = board1.isLosingBoard();
        boolean boolean6 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(1);
        int int2 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        int int5 = board1.getSize();
        boolean boolean7 = board1.equals((java.lang.Object) (byte) 10);
        int int8 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 52 + "'", int5 == 52);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.isFull();
        board1.setScore((int) (byte) 0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        boolean boolean8 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        boolean boolean5 = board1.isWinningBoard();
        int int6 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 52 + "'", int6 == 52);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        boolean boolean6 = board1.equals((java.lang.Object) (-1L));
        boolean boolean7 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 0);
        boolean boolean4 = board1.hasEmptyCells();
        boolean boolean5 = board1.hasEmptyCells();
        boolean boolean6 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int11 = board10.getScore();
        int int12 = board10.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet13 = board10.getEmptyPositions();
        board10.setScore(0);
        int int16 = board10.getScore();
        int int17 = board10.getSize();
        ar.edu.unrc.game2048.Cell cell20 = board10.getCell(0, 1);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) '#', (int) (short) 100, cell20);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (35, 100) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 52 + "'", int17 == 52);
        org.junit.Assert.assertNotNull(cell20);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        int int11 = board9.getScore();
        board9.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet14 = board9.getEmptyPositions();
        ar.edu.unrc.game2048.Board board18 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int19 = board18.getScore();
        int int20 = board18.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet21 = board18.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell24 = board18.getCell((int) (byte) 1, (int) (short) 0);
        board9.setCell(0, 0, cell24);
        ar.edu.unrc.game2048.Board board27 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean28 = board27.isWinningBoard();
        ar.edu.unrc.game2048.Cell cell31 = board27.getCell((int) (short) 10, (int) (short) 10);
        boolean boolean32 = board9.equals((java.lang.Object) cell31);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) -1, 0, cell31);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 0) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(positionSet14);
        org.junit.Assert.assertNotNull(board18);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertNotNull(positionSet21);
        org.junit.Assert.assertNotNull(cell24);
        org.junit.Assert.assertNotNull(board27);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNotNull(cell31);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        int int7 = board1.getScore();
        int int8 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean7 = board6.isWinningBoard();
        boolean boolean8 = board1.equals((java.lang.Object) board6);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell11 = board1.getCell((int) 'a', (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (97, 0) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        int int4 = board1.getScore();
        java.lang.Class<?> wildcardClass5 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        int int11 = board9.getScore();
        board9.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet14 = board9.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell17 = board9.getCell(4, 10);
        boolean boolean18 = board1.equals((java.lang.Object) cell17);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell21 = board1.getCell((int) (short) 1, (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (1, 100) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(positionSet14);
        org.junit.Assert.assertNotNull(cell17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) '#');
        int int10 = board6.getScore();
        boolean boolean11 = board6.isWinningBoard();
        boolean boolean12 = board6.isWinningBoard();
        boolean boolean13 = board1.equals((java.lang.Object) boolean12);
        board1.setScore(35);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (short) 1);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean7 = board6.isWinningBoard();
        boolean boolean8 = board1.equals((java.lang.Object) board6);
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board6.getGrid();
        int int10 = board6.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore(2048);
        boolean boolean7 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int12 = board11.getScore();
        int int13 = board11.getScore();
        board11.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet16 = board11.getEmptyPositions();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int21 = board20.getScore();
        int int22 = board20.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet23 = board20.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell26 = board20.getCell((int) (byte) 1, (int) (short) 0);
        board11.setCell(0, 0, cell26);
        board1.setCell(0, 0, cell26);
        ar.edu.unrc.game2048.Direction direction29 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean30 = board1.move(direction29);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertNotNull(positionSet16);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
        org.junit.Assert.assertNotNull(positionSet23);
        org.junit.Assert.assertNotNull(cell26);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        boolean boolean7 = board1.equals((java.lang.Object) (byte) -1);
        int int8 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 2048 + "'", int8 == 2048);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        int int4 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        java.lang.Class<?> wildcardClass6 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean7 = board6.isWinningBoard();
        boolean boolean8 = board1.equals((java.lang.Object) board6);
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board6.getGrid();
        boolean boolean11 = board6.equals((java.lang.Object) 1);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean4 = board1.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int8 = board7.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet9 = board7.getEmptyPositions();
        int int10 = board7.getSize();
        boolean boolean12 = board7.equals((java.lang.Object) 'a');
        boolean boolean13 = board1.equals((java.lang.Object) board7);
        board7.setScore(1);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(positionSet9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 52 + "'", int10 == 52);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        boolean boolean5 = board1.isWinningBoard();
        board1.setScore(52);
        ar.edu.unrc.game2048.Cell[][] cellArray8 = board1.getGrid();
        boolean boolean9 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(cellArray8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        java.lang.Object obj5 = null;
        boolean boolean6 = board1.equals(obj5);
        int int7 = board1.getSize();
        boolean boolean9 = board1.equals((java.lang.Object) (byte) 10);
        boolean boolean10 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board14 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell17 = board14.getCell((int) '#', (int) '#');
        int int18 = board14.getScore();
        boolean boolean19 = board14.isWinningBoard();
        boolean boolean20 = board14.isWinningBoard();
        ar.edu.unrc.game2048.Board board24 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int25 = board24.getScore();
        board24.setScore(0);
        board24.setScore(2048);
        boolean boolean30 = board24.isLosingBoard();
        boolean boolean31 = board24.isFull();
        boolean boolean32 = board24.isWinningBoard();
        int int33 = board24.getScore();
        ar.edu.unrc.game2048.Board board37 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean38 = board37.hasEmptyCells();
        boolean boolean40 = board37.equals((java.lang.Object) 0);
        ar.edu.unrc.game2048.Cell cell43 = board37.getCell((int) (short) 0, (int) (short) 10);
        board24.setCell((int) (byte) 0, 0, cell43);
        board14.setCell(10, (int) '#', cell43);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (byte) 10, 2048, cell43);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (10, 2048) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 52 + "'", int7 == 52);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(board14);
        org.junit.Assert.assertNotNull(cell17);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(board24);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 2048 + "'", int33 == 2048);
        org.junit.Assert.assertNotNull(board37);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNotNull(cell43);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        java.lang.Class<?> wildcardClass4 = cellArray3.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean4 = board1.hasEmptyCells();
        boolean boolean6 = board1.equals((java.lang.Object) 0L);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell13 = board10.getCell((int) '#', (int) '#');
        int int14 = board10.getScore();
        boolean boolean15 = board10.isWinningBoard();
        boolean boolean16 = board10.isWinningBoard();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int21 = board20.getScore();
        board20.setScore(0);
        board20.setScore(2048);
        boolean boolean26 = board20.isLosingBoard();
        boolean boolean27 = board20.isFull();
        boolean boolean28 = board20.isWinningBoard();
        int int29 = board20.getScore();
        ar.edu.unrc.game2048.Board board33 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean34 = board33.hasEmptyCells();
        boolean boolean36 = board33.equals((java.lang.Object) 0);
        ar.edu.unrc.game2048.Cell cell39 = board33.getCell((int) (short) 0, (int) (short) 10);
        board20.setCell((int) (byte) 0, 0, cell39);
        board10.setCell(10, (int) '#', cell39);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((-1), (int) (byte) 1, cell39);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 1) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertNotNull(cell13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 2048 + "'", int29 == 2048);
        org.junit.Assert.assertNotNull(board33);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNotNull(cell39);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        ar.edu.unrc.game2048.Direction direction5 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = board1.move(direction5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet8 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(positionSet8);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        boolean boolean7 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        boolean boolean11 = board9.isWinningBoard();
        int int12 = board9.getScore();
        boolean boolean13 = board9.hasEmptyCells();
        ar.edu.unrc.game2048.Board board17 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int18 = board17.getScore();
        board17.setScore(0);
        board17.setScore(2048);
        boolean boolean23 = board17.isLosingBoard();
        ar.edu.unrc.game2048.Board board27 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int28 = board27.getScore();
        int int29 = board27.getScore();
        board27.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet32 = board27.getEmptyPositions();
        ar.edu.unrc.game2048.Board board36 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int37 = board36.getScore();
        int int38 = board36.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet39 = board36.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell42 = board36.getCell((int) (byte) 1, (int) (short) 0);
        board27.setCell(0, 0, cell42);
        board17.setCell(0, 0, cell42);
        board9.setCell((int) (byte) 10, 0, cell42);
        boolean boolean46 = board1.equals((java.lang.Object) 0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNotNull(board17);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(board27);
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 0 + "'", int28 == 0);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 0 + "'", int29 == 0);
        org.junit.Assert.assertNotNull(positionSet32);
        org.junit.Assert.assertNotNull(board36);
        org.junit.Assert.assertTrue("'" + int37 + "' != '" + 0 + "'", int37 == 0);
        org.junit.Assert.assertTrue("'" + int38 + "' != '" + 0 + "'", int38 == 0);
        org.junit.Assert.assertNotNull(positionSet39);
        org.junit.Assert.assertNotNull(cell42);
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + false + "'", boolean46 == false);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        board9.setScore(0);
        board9.setScore(2048);
        boolean boolean15 = board1.equals((java.lang.Object) 2048);
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int20 = board19.getScore();
        int int21 = board19.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet22 = board19.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell25 = board19.getCell((int) (byte) 1, (int) (short) 0);
        board1.setCell(4, 4, cell25);
        boolean boolean27 = board1.isFull();
        ar.edu.unrc.game2048.Cell cell30 = board1.getCell((int) '#', 32);
        boolean boolean31 = board1.isFull();
        int int32 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(positionSet22);
        org.junit.Assert.assertNotNull(cell25);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(cell30);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + int32 + "' != '" + 52 + "'", int32 == 52);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        board9.setScore(0);
        board9.setScore(2048);
        boolean boolean15 = board1.equals((java.lang.Object) 2048);
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int20 = board19.getScore();
        int int21 = board19.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet22 = board19.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell25 = board19.getCell((int) (byte) 1, (int) (short) 0);
        board1.setCell(4, 4, cell25);
        ar.edu.unrc.game2048.Cell[][] cellArray27 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(positionSet22);
        org.junit.Assert.assertNotNull(cell25);
        org.junit.Assert.assertNotNull(cellArray27);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isWinningBoard();
        board1.setScore((int) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell10 = board1.getCell((int) (short) -1, 2048);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 2048) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int11 = board10.getScore();
        int int12 = board10.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet13 = board10.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell16 = board10.getCell((int) (byte) 1, (int) (short) 0);
        board1.setCell(0, 0, cell16);
        ar.edu.unrc.game2048.Cell[][] cellArray18 = board1.getGrid();
        ar.edu.unrc.game2048.Direction direction19 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean20 = board1.move(direction19);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertNotNull(cell16);
        org.junit.Assert.assertNotNull(cellArray18);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        board1.setScore((int) ' ');
        board1.setScore(0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        int int11 = board9.getScore();
        board9.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet14 = board9.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell17 = board9.getCell(4, 10);
        boolean boolean18 = board1.equals((java.lang.Object) cell17);
        ar.edu.unrc.game2048.Board board22 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int23 = board22.getScore();
        board22.setScore(0);
        board22.setScore(2048);
        boolean boolean28 = board22.isLosingBoard();
        ar.edu.unrc.game2048.Board board32 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int33 = board32.getScore();
        int int34 = board32.getScore();
        board32.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet37 = board32.getEmptyPositions();
        ar.edu.unrc.game2048.Board board41 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int42 = board41.getScore();
        int int43 = board41.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet44 = board41.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell47 = board41.getCell((int) (byte) 1, (int) (short) 0);
        board32.setCell(0, 0, cell47);
        board22.setCell(0, 0, cell47);
        board1.setCell((int) (byte) 0, (int) '#', cell47);
        ar.edu.unrc.game2048.Cell[][] cellArray51 = board1.getGrid();
        ar.edu.unrc.game2048.Direction direction52 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean53 = board1.move(direction52);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(positionSet14);
        org.junit.Assert.assertNotNull(cell17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(board22);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNotNull(board32);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 0 + "'", int33 == 0);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
        org.junit.Assert.assertNotNull(positionSet37);
        org.junit.Assert.assertNotNull(board41);
        org.junit.Assert.assertTrue("'" + int42 + "' != '" + 0 + "'", int42 == 0);
        org.junit.Assert.assertTrue("'" + int43 + "' != '" + 0 + "'", int43 == 0);
        org.junit.Assert.assertNotNull(positionSet44);
        org.junit.Assert.assertNotNull(cell47);
        org.junit.Assert.assertNotNull(cellArray51);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell9 = board6.getCell((int) '#', (int) '#');
        int int10 = board6.getScore();
        boolean boolean11 = board6.isWinningBoard();
        boolean boolean12 = board6.isWinningBoard();
        boolean boolean13 = board1.equals((java.lang.Object) boolean12);
        java.lang.Object obj14 = null;
        boolean boolean15 = board1.equals(obj14);
        ar.edu.unrc.game2048.Board board17 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int18 = board17.getScore();
        int int19 = board17.getScore();
        board17.setScore(2048);
        boolean boolean22 = board17.isLosingBoard();
        boolean boolean23 = board1.equals((java.lang.Object) boolean22);
        ar.edu.unrc.game2048.Cell[][] cellArray24 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(board17);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(cellArray24);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        board9.setScore(0);
        board9.setScore(2048);
        boolean boolean15 = board9.isLosingBoard();
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int20 = board19.getScore();
        int int21 = board19.getScore();
        board19.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet24 = board19.getEmptyPositions();
        ar.edu.unrc.game2048.Board board28 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int29 = board28.getScore();
        int int30 = board28.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet31 = board28.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell34 = board28.getCell((int) (byte) 1, (int) (short) 0);
        board19.setCell(0, 0, cell34);
        board9.setCell(0, 0, cell34);
        board1.setCell((int) (byte) 10, 0, cell34);
        ar.edu.unrc.game2048.Board board39 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        boolean boolean40 = board1.equals((java.lang.Object) '#');
        boolean boolean41 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(positionSet24);
        org.junit.Assert.assertNotNull(board28);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 0 + "'", int29 == 0);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
        org.junit.Assert.assertNotNull(positionSet31);
        org.junit.Assert.assertNotNull(cell34);
        org.junit.Assert.assertNotNull(board39);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int11 = board10.getScore();
        int int12 = board10.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet13 = board10.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell16 = board10.getCell((int) (byte) 1, (int) (short) 0);
        board1.setCell(0, 0, cell16);
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean20 = board19.isWinningBoard();
        ar.edu.unrc.game2048.Cell cell23 = board19.getCell((int) (short) 10, (int) (short) 10);
        boolean boolean24 = board1.equals((java.lang.Object) cell23);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet25 = board1.getEmptyPositions();
        boolean boolean26 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertNotNull(cell16);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(cell23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(positionSet25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        board9.setScore(0);
        board9.setScore(2048);
        boolean boolean15 = board1.equals((java.lang.Object) 2048);
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int20 = board19.getScore();
        int int21 = board19.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet22 = board19.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell25 = board19.getCell((int) (byte) 1, (int) (short) 0);
        board1.setCell(4, 4, cell25);
        boolean boolean27 = board1.isFull();
        ar.edu.unrc.game2048.Cell cell30 = board1.getCell((int) '#', 32);
        boolean boolean31 = board1.isFull();
        boolean boolean32 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(positionSet22);
        org.junit.Assert.assertNotNull(cell25);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(cell30);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int9 = board8.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board8.getGrid();
        boolean boolean11 = board8.hasEmptyCells();
        int int12 = board8.getScore();
        boolean boolean13 = board1.equals((java.lang.Object) int12);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell16 = board1.getCell((int) (short) -1, (int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 32) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.isFull();
        board1.setScore((int) (short) 100);
        board1.setScore(1);
        boolean boolean12 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        boolean boolean2 = board1.isWinningBoard();
        int int3 = board1.getSize();
        boolean boolean4 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 35 + "'", int3 == 35);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        int int5 = board1.getSize();
        int int6 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 52 + "'", int5 == 52);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (byte) 100);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        boolean boolean5 = board1.hasEmptyCells();
        board1.setScore((int) (short) 10);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        int int11 = board9.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet12 = board9.getEmptyPositions();
        board9.setScore(0);
        int int15 = board9.getScore();
        boolean boolean16 = board9.isLosingBoard();
        boolean boolean17 = board1.equals((java.lang.Object) board9);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet18 = board9.getEmptyPositions();
        int int19 = board9.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(positionSet12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertNotNull(positionSet18);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 52 + "'", int19 == 52);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        int int5 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean4 = board1.equals((java.lang.Object) 0);
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean10 = board9.isWinningBoard();
        ar.edu.unrc.game2048.Cell cell13 = board9.getCell((int) (short) 10, (int) (short) 10);
        board1.setCell((int) 'a', 4, cell13);
        boolean boolean15 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(cell13);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        boolean boolean8 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int11 = board10.getScore();
        int int12 = board10.getScore();
        board10.setScore(2048);
        boolean boolean16 = board10.equals((java.lang.Object) (byte) -1);
        board10.setScore(0);
        ar.edu.unrc.game2048.Board board22 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int23 = board22.getScore();
        int int24 = board22.getScore();
        board22.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet27 = board22.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet28 = board22.getEmptyPositions();
        ar.edu.unrc.game2048.Board board30 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int31 = board30.getScore();
        board30.setScore(0);
        board30.setScore(2048);
        boolean boolean36 = board22.equals((java.lang.Object) 2048);
        ar.edu.unrc.game2048.Board board40 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int41 = board40.getScore();
        int int42 = board40.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet43 = board40.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell46 = board40.getCell((int) (byte) 1, (int) (short) 0);
        board22.setCell(4, 4, cell46);
        board10.setCell((int) (byte) 1, 1, cell46);
        boolean boolean49 = board1.equals((java.lang.Object) (byte) 1);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(board22);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 0 + "'", int24 == 0);
        org.junit.Assert.assertNotNull(positionSet27);
        org.junit.Assert.assertNotNull(positionSet28);
        org.junit.Assert.assertNotNull(board30);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 0 + "'", int31 == 0);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNotNull(board40);
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + 0 + "'", int41 == 0);
        org.junit.Assert.assertTrue("'" + int42 + "' != '" + 0 + "'", int42 == 0);
        org.junit.Assert.assertNotNull(positionSet43);
        org.junit.Assert.assertNotNull(cell46);
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        java.lang.Object obj5 = null;
        boolean boolean6 = board1.equals(obj5);
        int int7 = board1.getScore();
        boolean boolean8 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        boolean boolean5 = board1.isFull();
        java.lang.Class<?> wildcardClass6 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean3 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        boolean boolean7 = board1.isWinningBoard();
        boolean boolean8 = board1.isLosingBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell cell13 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 0, 52, cell13);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell cannot be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(cellArray6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.isFull();
        board1.setScore((int) (short) 100);
        boolean boolean10 = board1.isLosingBoard();
        boolean boolean11 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean4 = board1.equals((java.lang.Object) 0);
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int8 = board7.getScore();
        boolean boolean9 = board7.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board7.getGrid();
        java.lang.Object obj11 = null;
        boolean boolean12 = board7.equals(obj11);
        ar.edu.unrc.game2048.Cell[][] cellArray13 = board7.getGrid();
        boolean boolean14 = board1.equals((java.lang.Object) board7);
        java.lang.Class<?> wildcardClass15 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(cellArray13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (byte) 10);
        ar.edu.unrc.game2048.Cell[][] cellArray2 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cellArray2);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        boolean boolean5 = board1.isWinningBoard();
        board1.setScore(52);
        boolean boolean8 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        int int11 = board9.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet12 = board9.getEmptyPositions();
        board9.setScore(0);
        int int15 = board9.getScore();
        boolean boolean16 = board9.isLosingBoard();
        boolean boolean17 = board1.equals((java.lang.Object) board9);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet18 = board9.getEmptyPositions();
        ar.edu.unrc.game2048.Cell[][] cellArray19 = board9.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(positionSet12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertNotNull(positionSet18);
        org.junit.Assert.assertNotNull(cellArray19);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean2 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell cell5 = board1.getCell((int) (byte) 1, 10);
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        int int10 = board9.getScore();
        ar.edu.unrc.game2048.Cell cell13 = board9.getCell(10, 4);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(2048, (int) (short) 0, cell13);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (2048, 0) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cell5);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(cell13);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        ar.edu.unrc.game2048.Board board3 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int4 = board3.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board3.getEmptyPositions();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board3.getGrid();
        boolean boolean7 = board3.hasEmptyCells();
        boolean boolean8 = board3.isLosingBoard();
        boolean boolean9 = board1.equals((java.lang.Object) board3);
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell14 = board11.getCell((int) '#', (int) '#');
        int int15 = board11.getScore();
        boolean boolean16 = board11.isWinningBoard();
        boolean boolean17 = board11.isWinningBoard();
        int int18 = board11.getSize();
        boolean boolean19 = board1.equals((java.lang.Object) int18);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertNotNull(cellArray6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertNotNull(cell14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 52 + "'", int18 == 52);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        int int4 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        int int6 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 52 + "'", int6 == 52);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        int int11 = board9.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet12 = board9.getEmptyPositions();
        board9.setScore(0);
        int int15 = board9.getScore();
        boolean boolean16 = board9.isLosingBoard();
        boolean boolean17 = board1.equals((java.lang.Object) board9);
        boolean boolean18 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(positionSet12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell11 = board8.getCell((int) '#', (int) '#');
        int int12 = board8.getScore();
        boolean boolean13 = board8.isWinningBoard();
        boolean boolean14 = board8.isWinningBoard();
        ar.edu.unrc.game2048.Board board18 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int19 = board18.getScore();
        board18.setScore(0);
        board18.setScore(2048);
        boolean boolean24 = board18.isLosingBoard();
        boolean boolean25 = board18.isFull();
        boolean boolean26 = board18.isWinningBoard();
        int int27 = board18.getScore();
        ar.edu.unrc.game2048.Board board31 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean32 = board31.hasEmptyCells();
        boolean boolean34 = board31.equals((java.lang.Object) 0);
        ar.edu.unrc.game2048.Cell cell37 = board31.getCell((int) (short) 0, (int) (short) 10);
        board18.setCell((int) (byte) 0, 0, cell37);
        board8.setCell(10, (int) '#', cell37);
        boolean boolean40 = board1.equals((java.lang.Object) board8);
        java.lang.Object obj41 = null;
        boolean boolean42 = board8.equals(obj41);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(cellArray6);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertNotNull(cell11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(board18);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 2048 + "'", int27 == 2048);
        org.junit.Assert.assertNotNull(board31);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + true + "'", boolean32 == true);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNotNull(cell37);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore(2048);
        boolean boolean7 = board1.isLosingBoard();
        boolean boolean8 = board1.isFull();
        boolean boolean9 = board1.isWinningBoard();
        boolean boolean10 = board1.isFull();
        boolean boolean11 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        boolean boolean2 = board1.isLosingBoard();
        int int3 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 35 + "'", int3 == 35);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell cell5 = board1.getCell(10, 4);
        boolean boolean6 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cell5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean4 = board1.hasEmptyCells();
        boolean boolean5 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 0);
        boolean boolean4 = board1.hasEmptyCells();
        int int5 = board1.getSize();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (short) -1, 32);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 32) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        int int5 = board1.getSize();
        boolean boolean7 = board1.equals((java.lang.Object) (byte) 10);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet8 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 52 + "'", int5 == 52);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(positionSet8);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean4 = board1.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        int int6 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        int int8 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 52 + "'", int8 == 52);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean7 = board6.isWinningBoard();
        boolean boolean8 = board1.equals((java.lang.Object) board6);
        boolean boolean9 = board1.hasEmptyCells();
        board1.setScore((int) ' ');
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(1);
        java.lang.String str2 = board1.toString();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Score: 0\n+-----+\n|     |\n+-----+\n" + "'", str2, "Score: 0\n+-----+\n|     |\n+-----+\n");
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        int int6 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 2048 + "'", int6 == 2048);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        boolean boolean7 = board1.isLosingBoard();
        boolean boolean8 = board1.hasEmptyCells();
        boolean boolean9 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        ar.edu.unrc.game2048.Direction direction2 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean3 = board1.move(direction2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        boolean boolean7 = board1.equals((java.lang.Object) (byte) -1);
        board1.setScore(0);
        boolean boolean10 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean2 = board1.isWinningBoard();
        int int3 = board1.getScore();
        boolean boolean4 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        boolean boolean5 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        boolean boolean7 = board1.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet8 = board1.getEmptyPositions();
        java.lang.Class<?> wildcardClass9 = positionSet8.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(cellArray6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(positionSet8);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isWinningBoard();
        boolean boolean6 = board1.isFull();
        board1.setScore(0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        boolean boolean4 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell11 = board8.getCell((int) '#', (int) '#');
        board1.setCell(4, 0, cell11);
        ar.edu.unrc.game2048.Board board16 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int17 = board16.getScore();
        int int18 = board16.getScore();
        board16.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet21 = board16.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet22 = board16.getEmptyPositions();
        ar.edu.unrc.game2048.Board board24 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int25 = board24.getScore();
        int int26 = board24.getScore();
        board24.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet29 = board24.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell32 = board24.getCell(4, 10);
        boolean boolean33 = board16.equals((java.lang.Object) cell32);
        ar.edu.unrc.game2048.Board board37 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int38 = board37.getScore();
        board37.setScore(0);
        board37.setScore(2048);
        boolean boolean43 = board37.isLosingBoard();
        ar.edu.unrc.game2048.Board board47 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int48 = board47.getScore();
        int int49 = board47.getScore();
        board47.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet52 = board47.getEmptyPositions();
        ar.edu.unrc.game2048.Board board56 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int57 = board56.getScore();
        int int58 = board56.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet59 = board56.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell62 = board56.getCell((int) (byte) 1, (int) (short) 0);
        board47.setCell(0, 0, cell62);
        board37.setCell(0, 0, cell62);
        board16.setCell((int) (byte) 0, (int) '#', cell62);
        board1.setCell(4, 32, cell62);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertNotNull(cell11);
        org.junit.Assert.assertNotNull(board16);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertNotNull(positionSet21);
        org.junit.Assert.assertNotNull(positionSet22);
        org.junit.Assert.assertNotNull(board24);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 0 + "'", int26 == 0);
        org.junit.Assert.assertNotNull(positionSet29);
        org.junit.Assert.assertNotNull(cell32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(board37);
        org.junit.Assert.assertTrue("'" + int38 + "' != '" + 0 + "'", int38 == 0);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertNotNull(board47);
        org.junit.Assert.assertTrue("'" + int48 + "' != '" + 0 + "'", int48 == 0);
        org.junit.Assert.assertTrue("'" + int49 + "' != '" + 0 + "'", int49 == 0);
        org.junit.Assert.assertNotNull(positionSet52);
        org.junit.Assert.assertNotNull(board56);
        org.junit.Assert.assertTrue("'" + int57 + "' != '" + 0 + "'", int57 == 0);
        org.junit.Assert.assertTrue("'" + int58 + "' != '" + 0 + "'", int58 == 0);
        org.junit.Assert.assertNotNull(positionSet59);
        org.junit.Assert.assertNotNull(cell62);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore((int) (byte) 10);
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int9 = board8.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board8.getGrid();
        boolean boolean11 = board8.hasEmptyCells();
        boolean boolean13 = board8.equals((java.lang.Object) 0L);
        ar.edu.unrc.game2048.Board board15 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int16 = board15.getScore();
        int int17 = board15.getScore();
        board15.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet20 = board15.getEmptyPositions();
        ar.edu.unrc.game2048.Board board24 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int25 = board24.getScore();
        int int26 = board24.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet27 = board24.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell30 = board24.getCell((int) (byte) 1, (int) (short) 0);
        board15.setCell(0, 0, cell30);
        ar.edu.unrc.game2048.Cell[][] cellArray32 = board15.getGrid();
        int int33 = board15.getSize();
        boolean boolean34 = board8.equals((java.lang.Object) int33);
        boolean boolean35 = board1.equals((java.lang.Object) int33);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(board15);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
        org.junit.Assert.assertNotNull(positionSet20);
        org.junit.Assert.assertNotNull(board24);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 0 + "'", int26 == 0);
        org.junit.Assert.assertNotNull(positionSet27);
        org.junit.Assert.assertNotNull(cell30);
        org.junit.Assert.assertNotNull(cellArray32);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 52 + "'", int33 == 52);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int7 = board6.getScore();
        int int8 = board6.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet9 = board6.getEmptyPositions();
        boolean boolean10 = board6.isFull();
        ar.edu.unrc.game2048.Board board14 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell17 = board14.getCell((int) '#', (int) '#');
        board6.setCell((int) (short) 10, 0, cell17);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) 'a', (int) (byte) 0, cell17);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (97, 0) is outside the 35x35 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(positionSet9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(board14);
        org.junit.Assert.assertNotNull(cell17);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        board1.setScore(32);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isLosingBoard();
        boolean boolean7 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int12 = board11.getScore();
        int int13 = board11.getScore();
        board11.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet16 = board11.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet17 = board11.getEmptyPositions();
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int20 = board19.getScore();
        board19.setScore(0);
        board19.setScore(2048);
        boolean boolean25 = board11.equals((java.lang.Object) 2048);
        ar.edu.unrc.game2048.Board board29 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int30 = board29.getScore();
        int int31 = board29.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet32 = board29.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell35 = board29.getCell((int) (byte) 1, (int) (short) 0);
        board11.setCell(4, 4, cell35);
        boolean boolean37 = board11.isFull();
        ar.edu.unrc.game2048.Cell cell40 = board11.getCell((int) '#', 32);
        board1.setCell((int) ' ', 4, cell40);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertNotNull(positionSet16);
        org.junit.Assert.assertNotNull(positionSet17);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(board29);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 0 + "'", int31 == 0);
        org.junit.Assert.assertNotNull(positionSet32);
        org.junit.Assert.assertNotNull(cell35);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNotNull(cell40);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.isFull();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        boolean boolean4 = board1.isFull();
        boolean boolean5 = board1.isFull();
        int int6 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 32 + "'", int6 == 32);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean4 = board1.equals((java.lang.Object) 0);
        boolean boolean5 = board1.isFull();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        board9.setScore(0);
        int int13 = board9.getSize();
        boolean boolean15 = board9.equals((java.lang.Object) (byte) 10);
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int20 = board19.getScore();
        int int21 = board19.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet22 = board19.getEmptyPositions();
        boolean boolean23 = board19.isFull();
        ar.edu.unrc.game2048.Board board27 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell30 = board27.getCell((int) '#', (int) '#');
        board19.setCell((int) (short) 10, 0, cell30);
        board9.setCell((int) (short) 1, (int) ' ', cell30);
        board1.setCell((int) (short) 0, (int) (short) 10, cell30);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 52 + "'", int13 == 52);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(positionSet22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(board27);
        org.junit.Assert.assertNotNull(cell30);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        boolean boolean7 = board1.equals((java.lang.Object) (byte) -1);
        boolean boolean8 = board1.hasEmptyCells();
        int int9 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 2048 + "'", int9 == 2048);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean4 = board1.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int8 = board7.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet9 = board7.getEmptyPositions();
        int int10 = board7.getSize();
        boolean boolean12 = board7.equals((java.lang.Object) 'a');
        boolean boolean13 = board1.equals((java.lang.Object) board7);
        int int14 = board7.getSize();
        boolean boolean15 = board7.hasEmptyCells();
        ar.edu.unrc.game2048.Board board17 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int18 = board17.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray19 = board17.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray20 = board17.getGrid();
        boolean boolean21 = board17.isFull();
        boolean boolean22 = board7.equals((java.lang.Object) boolean21);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(positionSet9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 52 + "'", int10 == 52);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 52 + "'", int14 == 52);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertNotNull(board17);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 0 + "'", int18 == 0);
        org.junit.Assert.assertNotNull(cellArray19);
        org.junit.Assert.assertNotNull(cellArray20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        int int6 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        boolean boolean8 = board1.isLosingBoard();
        boolean boolean9 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) 'a');
        boolean boolean2 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean7 = board6.isWinningBoard();
        boolean boolean8 = board1.equals((java.lang.Object) board6);
        int int9 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        boolean boolean7 = board1.equals((java.lang.Object) (byte) -1);
        int int8 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 52 + "'", int8 == 52);
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test257");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        int int11 = board9.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet12 = board9.getEmptyPositions();
        board9.setScore(0);
        int int15 = board9.getScore();
        boolean boolean16 = board9.isLosingBoard();
        boolean boolean17 = board1.equals((java.lang.Object) board9);
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int22 = board21.getScore();
        int int23 = board21.getScore();
        board21.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet26 = board21.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet27 = board21.getEmptyPositions();
        ar.edu.unrc.game2048.Board board29 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int30 = board29.getScore();
        int int31 = board29.getScore();
        board29.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet34 = board29.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell37 = board29.getCell(4, 10);
        boolean boolean38 = board21.equals((java.lang.Object) cell37);
        ar.edu.unrc.game2048.Board board42 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int43 = board42.getScore();
        board42.setScore(0);
        board42.setScore(2048);
        boolean boolean48 = board42.isLosingBoard();
        ar.edu.unrc.game2048.Board board52 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int53 = board52.getScore();
        int int54 = board52.getScore();
        board52.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet57 = board52.getEmptyPositions();
        ar.edu.unrc.game2048.Board board61 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int62 = board61.getScore();
        int int63 = board61.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet64 = board61.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell67 = board61.getCell((int) (byte) 1, (int) (short) 0);
        board52.setCell(0, 0, cell67);
        board42.setCell(0, 0, cell67);
        board21.setCell((int) (byte) 0, (int) '#', cell67);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(100, (int) (byte) 1, cell67);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 1) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(positionSet12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 0 + "'", int23 == 0);
        org.junit.Assert.assertNotNull(positionSet26);
        org.junit.Assert.assertNotNull(positionSet27);
        org.junit.Assert.assertNotNull(board29);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 0 + "'", int31 == 0);
        org.junit.Assert.assertNotNull(positionSet34);
        org.junit.Assert.assertNotNull(cell37);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNotNull(board42);
        org.junit.Assert.assertTrue("'" + int43 + "' != '" + 0 + "'", int43 == 0);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertNotNull(board52);
        org.junit.Assert.assertTrue("'" + int53 + "' != '" + 0 + "'", int53 == 0);
        org.junit.Assert.assertTrue("'" + int54 + "' != '" + 0 + "'", int54 == 0);
        org.junit.Assert.assertNotNull(positionSet57);
        org.junit.Assert.assertNotNull(board61);
        org.junit.Assert.assertTrue("'" + int62 + "' != '" + 0 + "'", int62 == 0);
        org.junit.Assert.assertTrue("'" + int63 + "' != '" + 0 + "'", int63 == 0);
        org.junit.Assert.assertNotNull(positionSet64);
        org.junit.Assert.assertNotNull(cell67);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test258");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        boolean boolean5 = board1.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(positionSet7);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test259");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        boolean boolean5 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test260");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        ar.edu.unrc.game2048.Direction direction6 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean7 = board1.move(direction6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test261");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell(10, (int) (short) 10);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int11 = board10.getScore();
        int int12 = board10.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet13 = board10.getEmptyPositions();
        board10.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray16 = board10.getGrid();
        java.lang.Class<?> wildcardClass17 = cellArray16.getClass();
        boolean boolean18 = board1.equals((java.lang.Object) wildcardClass17);
        boolean boolean19 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertNotNull(cellArray16);
        org.junit.Assert.assertNotNull(wildcardClass17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test262");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        boolean boolean5 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction6 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean7 = board1.move(direction6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test263");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.isLosingBoard();
        boolean boolean8 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test264");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean4 = board1.equals((java.lang.Object) 0);
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int8 = board7.getScore();
        boolean boolean9 = board7.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board7.getGrid();
        java.lang.Object obj11 = null;
        boolean boolean12 = board7.equals(obj11);
        ar.edu.unrc.game2048.Cell[][] cellArray13 = board7.getGrid();
        boolean boolean14 = board1.equals((java.lang.Object) board7);
        int int15 = board1.getSize();
        boolean boolean16 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(cellArray13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 100 + "'", int15 == 100);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test265");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet3 = board1.getEmptyPositions();
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int12 = board11.getScore();
        board11.setScore(0);
        board11.setScore(2048);
        boolean boolean17 = board11.isLosingBoard();
        ar.edu.unrc.game2048.Cell cell20 = board11.getCell(0, (int) (byte) 1);
        board1.setCell((int) (byte) 1, (int) (byte) 1, cell20);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(positionSet3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 52 + "'", int4 == 52);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(cell20);
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test266");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet8 = board1.getEmptyPositions();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet9 = board1.getEmptyPositions();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell12 = board1.getCell((int) 'a', (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (97, 97) is outside the 52x52 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(positionSet8);
        org.junit.Assert.assertNotNull(positionSet9);
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test267");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test268");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        int int5 = board1.getScore();
        board1.setScore((int) ' ');
        boolean boolean8 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test269");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        java.lang.Object obj5 = null;
        boolean boolean6 = board1.equals(obj5);
        int int7 = board1.getSize();
        boolean boolean9 = board1.equals((java.lang.Object) (byte) 10);
        boolean boolean10 = board1.hasEmptyCells();
        java.lang.Class<?> wildcardClass11 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 52 + "'", int7 == 52);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test270");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        board1.setScore(0);
        int int7 = board1.getScore();
        int int8 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell11 = board1.getCell(0, 1);
        ar.edu.unrc.game2048.Board board13 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int14 = board13.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board13.getGrid();
        boolean boolean16 = board13.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet17 = board13.getEmptyPositions();
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int20 = board19.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet21 = board19.getEmptyPositions();
        int int22 = board19.getSize();
        boolean boolean24 = board19.equals((java.lang.Object) 'a');
        boolean boolean25 = board13.equals((java.lang.Object) board19);
        boolean boolean26 = board1.equals((java.lang.Object) board13);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 52 + "'", int8 == 52);
        org.junit.Assert.assertNotNull(cell11);
        org.junit.Assert.assertNotNull(board13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 0 + "'", int14 == 0);
        org.junit.Assert.assertNotNull(cellArray15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertNotNull(positionSet17);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertNotNull(positionSet21);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 52 + "'", int22 == 52);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + true + "'", boolean26 == true);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test271");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        java.lang.Object obj5 = null;
        boolean boolean6 = board1.equals(obj5);
        int int7 = board1.getSize();
        boolean boolean9 = board1.equals((java.lang.Object) (byte) 10);
        boolean boolean10 = board1.hasEmptyCells();
        boolean boolean11 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 52 + "'", int7 == 52);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test272");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore(2048);
        boolean boolean7 = board1.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet8 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(positionSet8);
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test273");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.isLosingBoard();
        boolean boolean6 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell cell9 = board1.getCell(0, (int) (short) 10);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(cell9);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test274");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        java.lang.Object obj5 = null;
        boolean boolean6 = board1.equals(obj5);
        int int7 = board1.getSize();
        boolean boolean8 = board1.hasEmptyCells();
        boolean boolean9 = board1.hasEmptyCells();
        boolean boolean10 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 52 + "'", int7 == 52);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test275");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        board9.setScore(0);
        board9.setScore(2048);
        boolean boolean15 = board9.isLosingBoard();
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int20 = board19.getScore();
        int int21 = board19.getScore();
        board19.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet24 = board19.getEmptyPositions();
        ar.edu.unrc.game2048.Board board28 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int29 = board28.getScore();
        int int30 = board28.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet31 = board28.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell34 = board28.getCell((int) (byte) 1, (int) (short) 0);
        board19.setCell(0, 0, cell34);
        board9.setCell(0, 0, cell34);
        board1.setCell((int) (byte) 10, 0, cell34);
        ar.edu.unrc.game2048.Board board39 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        boolean boolean40 = board1.equals((java.lang.Object) '#');
        ar.edu.unrc.game2048.Cell cell43 = board1.getCell(4, (int) (byte) 0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(positionSet24);
        org.junit.Assert.assertNotNull(board28);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 0 + "'", int29 == 0);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
        org.junit.Assert.assertNotNull(positionSet31);
        org.junit.Assert.assertNotNull(cell34);
        org.junit.Assert.assertNotNull(board39);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNotNull(cell43);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test276");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet6 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int11 = board10.getScore();
        int int12 = board10.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet13 = board10.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell16 = board10.getCell((int) (byte) 1, (int) (short) 0);
        board1.setCell(0, 0, cell16);
        ar.edu.unrc.game2048.Cell[][] cellArray18 = board1.getGrid();
        int int19 = board1.getSize();
        boolean boolean21 = board1.equals((java.lang.Object) 10.0d);
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int24 = board23.getScore();
        int int25 = board23.getScore();
        board23.setScore(2048);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet28 = board23.getEmptyPositions();
        ar.edu.unrc.game2048.Board board32 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int33 = board32.getScore();
        int int34 = board32.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet35 = board32.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell38 = board32.getCell((int) (byte) 1, (int) (short) 0);
        board23.setCell(0, 0, cell38);
        boolean boolean40 = board1.equals((java.lang.Object) cell38);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertNotNull(cell16);
        org.junit.Assert.assertNotNull(cellArray18);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 52 + "'", int19 == 52);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 0 + "'", int24 == 0);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
        org.junit.Assert.assertNotNull(positionSet28);
        org.junit.Assert.assertNotNull(board32);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 0 + "'", int33 == 0);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 0 + "'", int34 == 0);
        org.junit.Assert.assertNotNull(positionSet35);
        org.junit.Assert.assertNotNull(cell38);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test277");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean7 = board6.isWinningBoard();
        boolean boolean8 = board1.equals((java.lang.Object) board6);
        boolean boolean10 = board1.equals((java.lang.Object) ' ');
        boolean boolean11 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test278");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        boolean boolean7 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int10 = board9.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray11 = board9.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray12 = board9.getGrid();
        boolean boolean13 = board9.isFull();
        boolean boolean14 = board9.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board9.getGrid();
        boolean boolean16 = board1.equals((java.lang.Object) board9);
        ar.edu.unrc.game2048.Board board18 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int19 = board18.getScore();
        board18.setScore(0);
        boolean boolean22 = board18.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray23 = board18.getGrid();
        boolean boolean24 = board18.hasEmptyCells();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet25 = board18.getEmptyPositions();
        int int26 = board18.getSize();
        boolean boolean27 = board9.equals((java.lang.Object) board18);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(cellArray6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(cellArray11);
        org.junit.Assert.assertNotNull(cellArray12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cellArray15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertNotNull(board18);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 0 + "'", int19 == 0);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(cellArray23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertNotNull(positionSet25);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 52 + "'", int26 == 52);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
    }

    @Test
    public void test279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test279");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        board1.setScore(0);
        board1.setScore(2048);
        boolean boolean7 = board1.isLosingBoard();
        boolean boolean8 = board1.isFull();
        boolean boolean9 = board1.isWinningBoard();
        int int10 = board1.getScore();
        board1.setScore(1);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 2048 + "'", int10 == 2048);
    }

    @Test
    public void test280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test280");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(2048);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test281");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isWinningBoard();
        boolean boolean6 = board1.isFull();
        boolean boolean7 = board1.isWinningBoard();
        board1.setScore(0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test282");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        boolean boolean7 = board1.equals((java.lang.Object) (byte) -1);
        board1.setScore(0);
        boolean boolean10 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test283");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.hasEmptyCells();
        boolean boolean7 = board1.equals((java.lang.Object) 10.0f);
        java.lang.Object obj8 = null;
        boolean boolean9 = board1.equals(obj8);
        board1.setScore(4);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test284");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean4 = board1.equals((java.lang.Object) 0);
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        boolean boolean10 = board9.isWinningBoard();
        ar.edu.unrc.game2048.Cell cell13 = board9.getCell((int) (short) 10, (int) (short) 10);
        board1.setCell((int) 'a', 4, cell13);
        ar.edu.unrc.game2048.Direction direction15 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean16 = board1.move(direction15);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(cell13);
    }

    @Test
    public void test285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test285");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        board1.setScore(2048);
        boolean boolean7 = board1.equals((java.lang.Object) (byte) -1);
        boolean boolean8 = board1.hasEmptyCells();
        board1.setScore(52);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test286");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        ar.edu.unrc.game2048.Cell cell4 = board1.getCell((int) '#', (int) '#');
        boolean boolean5 = board1.isLosingBoard();
        int int6 = board1.getScore();
        boolean boolean7 = board1.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet8 = board1.getEmptyPositions();
        boolean boolean9 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cell4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(positionSet8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test287");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        int int3 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        boolean boolean5 = board1.isLosingBoard();
        boolean boolean6 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test288");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        int int2 = board1.getScore();
        boolean boolean3 = board1.isWinningBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.isLosingBoard();
        boolean boolean6 = board1.isLosingBoard();
        boolean boolean7 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }
}

