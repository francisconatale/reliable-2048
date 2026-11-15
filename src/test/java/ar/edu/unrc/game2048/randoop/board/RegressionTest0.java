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
        int int0 = ar.edu.unrc.game2048.Board.MAX_SIZE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 300 + "'", int0 == 300);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        ar.edu.unrc.game2048.Direction direction0 = ar.edu.unrc.game2048.Direction.DOWN;
        java.lang.Class<?> wildcardClass1 = direction0.getClass();
        org.junit.Assert.assertTrue("'" + direction0 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction0.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        java.lang.Object obj0 = new java.lang.Object();
        java.lang.Class<?> wildcardClass1 = obj0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        int int0 = ar.edu.unrc.game2048.Board.DEFAULT_SIZE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 4 + "'", int0 == 4);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        int int0 = ar.edu.unrc.game2048.Board.WINNING_VALUE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2048 + "'", int0 == 2048);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        java.lang.Class<?> wildcardClass5 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean5 = board1.equals((java.lang.Object) 1);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        int int3 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell6 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 10, (int) (byte) 1, cell6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell cannot be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 32 + "'", int3 == 32);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell16 = board1.getCell((int) (short) -1, (int) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 1) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertNotNull(cellArray5);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Board size must be positive: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell5 = board1.getCell((int) (byte) 100, (int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 35) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction5 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean6 = board1.move(direction5);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean11 = board10.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray12 = board10.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray13 = board10.getGrid();
        ar.edu.unrc.game2048.Board board15 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board15.setScore((int) (short) 1);
        int int18 = board15.getSize();
        boolean boolean19 = board15.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction20 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean21 = board15.move(direction20);
        boolean boolean22 = board10.move(direction20);
        boolean boolean23 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Cell cell26 = board10.getCell((int) (short) 10, 4);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 0, (int) '4', cell26);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, 52) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction5.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(cellArray12);
        org.junit.Assert.assertNotNull(cellArray13);
        org.junit.Assert.assertNotNull(board15);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 32 + "'", int18 == 32);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + direction20 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction20.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(cell26);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        java.lang.Class<?> wildcardClass6 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        boolean boolean4 = position2.equals((java.lang.Object) 100.0f);
        int int5 = position2.col;
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        boolean boolean18 = board1.isFull();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell21 = board1.getCell(10, (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (10, 97) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        java.lang.String str3 = position2.toString();
        int int4 = position2.col;
        boolean boolean6 = position2.equals((java.lang.Object) '#');
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(-1, 1)" + "'", str3, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (short) 0, 300);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, 300) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        int int3 = board1.getSize();
        boolean boolean4 = board1.isWinningBoard();
        int int5 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 32 + "'", int3 == 32);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        java.lang.Class<?> wildcardClass13 = direction10.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        boolean boolean4 = position2.equals((java.lang.Object) 0.0f);
        int int5 = position2.col;
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        int int3 = board1.getSize();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        int int16 = board12.getSize();
        ar.edu.unrc.game2048.Cell cell19 = board12.getCell((int) (byte) 0, 0);
        board8.setCell(0, (int) (short) 1, cell19);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) 'a', 1, cell19);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (97, 1) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 32 + "'", int3 == 32);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 32 + "'", int16 == 32);
        org.junit.Assert.assertNotNull(cell19);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean8 = board7.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board7.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board7.getGrid();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        boolean boolean16 = board12.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction17 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean18 = board12.move(direction17);
        boolean boolean19 = board7.move(direction17);
        boolean boolean20 = board7.isLosingBoard();
        ar.edu.unrc.game2048.Cell cell23 = board7.getCell((int) (short) 10, 4);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(2048, (int) (short) 1, cell23);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (2048, 1) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + direction17 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction17.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(cell23);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.col;
        java.lang.String str4 = position2.toString();
        int int5 = position2.row;
        int int6 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1) + "'", int5 == (-1));
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1 + "'", int6 == 1);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        ar.edu.unrc.game2048.Board board15 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean16 = board15.hasEmptyCells();
        board15.setScore(0);
        int int19 = board15.getSize();
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board21.setScore((int) (short) 1);
        boolean boolean24 = board21.isFull();
        ar.edu.unrc.game2048.Direction direction25 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean26 = board21.move(direction25);
        boolean boolean27 = board15.move(direction25);
        boolean boolean28 = board1.move(direction25);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet29 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(board15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 32 + "'", int19 == 32);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + direction25 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction25.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNotNull(positionSet29);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        boolean boolean9 = board1.isFull();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet10 = board1.getEmptyPositions();
        int int11 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(positionSet10);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 1 + "'", int11 == 1);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isFull();
        board1.setScore(32);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (byte) 1, 32);
        ar.edu.unrc.game2048.Direction direction3 = ar.edu.unrc.game2048.Direction.LEFT;
        java.lang.Class<?> wildcardClass4 = direction3.getClass();
        boolean boolean5 = position2.equals((java.lang.Object) wildcardClass4);
        org.junit.Assert.assertTrue("'" + direction3 + "' != '" + ar.edu.unrc.game2048.Direction.LEFT + "'", direction3.equals(ar.edu.unrc.game2048.Direction.LEFT));
        org.junit.Assert.assertNotNull(wildcardClass4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        java.lang.String str3 = position2.toString();
        int int4 = position2.col;
        java.lang.Class<?> wildcardClass5 = position2.getClass();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(-1, 1)" + "'", str3, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isLosingBoard();
        boolean boolean14 = board1.hasEmptyCells();
        board1.setScore(100);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell20 = board1.getCell(1, (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (1, 100) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) 'a', (int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (97, 10) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        boolean boolean3 = board1.isFull();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean8 = board7.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board7.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board7.getGrid();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        boolean boolean16 = board12.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction17 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean18 = board12.move(direction17);
        boolean boolean19 = board7.move(direction17);
        boolean boolean20 = board7.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray21 = board7.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet22 = board7.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell25 = board7.getCell((int) (byte) 10, 0);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 100, (int) (short) 0, cell25);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 0) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + direction17 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction17.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(cellArray21);
        org.junit.Assert.assertNotNull(positionSet22);
        org.junit.Assert.assertNotNull(cell25);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertNotNull(cellArray6);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        boolean boolean5 = board1.isLosingBoard();
        int int6 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell9 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(300, 0, cell9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell cannot be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 32 + "'", int6 == 32);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Board size must be positive: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isFull();
        boolean boolean14 = board1.isWinningBoard();
        java.lang.Class<?> wildcardClass15 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cellArray6);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        java.lang.Class<?> wildcardClass14 = direction11.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(wildcardClass14);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(2048);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Board size must be less than or equal to 300: 2048");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction5 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean6 = board1.move(direction5);
        int int7 = board1.getScore();
        int int8 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction5.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (byte) 10, (int) (byte) 10);
        java.lang.String str3 = position2.toString();
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int6 = board5.getSize();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board8.setScore((int) (short) 1);
        int int11 = board8.getSize();
        boolean boolean12 = board8.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction13 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean14 = board8.move(direction13);
        boolean boolean15 = board5.move(direction13);
        boolean boolean16 = position2.equals((java.lang.Object) boolean15);
        ar.edu.unrc.game2048.Board board18 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean19 = board18.hasEmptyCells();
        boolean boolean20 = position2.equals((java.lang.Object) boolean19);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(10, 10)" + "'", str3, "(10, 10)");
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 32 + "'", int6 == 32);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 32 + "'", int11 == 32);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + direction13 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction13.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(board18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) '#');
        java.lang.String str3 = position2.toString();
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        int int9 = board5.getSize();
        ar.edu.unrc.game2048.Cell cell12 = board5.getCell((int) (byte) 0, 0);
        boolean boolean13 = board5.isFull();
        boolean boolean14 = position2.equals((java.lang.Object) boolean13);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(-1, 35)" + "'", str3, "(-1, 35)");
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertNotNull(cell12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet16 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell19 = board1.getCell((int) (byte) 10, 0);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell22 = board1.getCell(0, (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, 97) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cellArray15);
        org.junit.Assert.assertNotNull(positionSet16);
        org.junit.Assert.assertNotNull(cell19);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet16 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell[][] cellArray17 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cellArray15);
        org.junit.Assert.assertNotNull(positionSet16);
        org.junit.Assert.assertNotNull(cellArray17);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        int int3 = board1.getSize();
        boolean boolean4 = board1.isWinningBoard();
        int int5 = board1.getScore();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board7.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board11.setScore((int) (short) 1);
        int int14 = board11.getSize();
        boolean boolean15 = board11.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction16 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean17 = board11.move(direction16);
        boolean boolean18 = board7.move(direction16);
        boolean boolean19 = board1.move(direction16);
        boolean boolean20 = board1.isFull();
        java.lang.Class<?> wildcardClass21 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 32 + "'", int3 == 32);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 32 + "'", int14 == 32);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + direction16 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction16.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(wildcardClass21);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction5 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean6 = board1.move(direction5);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        int int8 = board1.getSize();
        boolean boolean9 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction5.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position(10, (int) (byte) 1);
        int int3 = position2.row;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 10 + "'", int3 == 10);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(300);
        boolean boolean2 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.col;
        java.lang.String str4 = position2.toString();
        int int5 = position2.col;
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean8 = board7.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board7.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board7.getGrid();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        boolean boolean16 = board12.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction17 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean18 = board12.move(direction17);
        boolean boolean19 = board7.move(direction17);
        boolean boolean20 = board7.isLosingBoard();
        boolean boolean21 = board7.isLosingBoard();
        board7.setScore(4);
        boolean boolean24 = position2.equals((java.lang.Object) board7);
        boolean boolean25 = board7.isWinningBoard();
        ar.edu.unrc.game2048.Board board27 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board27.setScore((int) (short) 1);
        int int30 = board27.getScore();
        board27.setScore((int) (short) 0);
        boolean boolean33 = board27.isLosingBoard();
        boolean boolean34 = board7.equals((java.lang.Object) boolean33);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + direction17 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction17.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertNotNull(board27);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 1 + "'", int30 == 1);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isLosingBoard();
        board1.setScore(4);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet18 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(positionSet18);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        java.lang.String str3 = position2.toString();
        java.lang.Class<?> wildcardClass4 = position2.getClass();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(-1, 1)" + "'", str3, "(-1, 1)");
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        int int16 = board12.getSize();
        ar.edu.unrc.game2048.Cell cell19 = board12.getCell((int) (byte) 0, 0);
        board8.setCell(0, (int) (short) 1, cell19);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (byte) 100, (int) (byte) 1, cell19);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 1) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 32 + "'", int16 == 32);
        org.junit.Assert.assertNotNull(cell19);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (byte) 10, (int) (byte) 10);
        java.lang.String str3 = position2.toString();
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        int int9 = board5.getSize();
        ar.edu.unrc.game2048.Cell cell12 = board5.getCell((int) (byte) 0, 0);
        boolean boolean13 = position2.equals((java.lang.Object) (byte) 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(10, 10)" + "'", str3, "(10, 10)");
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertNotNull(cell12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        boolean boolean5 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean10 = board9.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray11 = board9.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray12 = board9.getGrid();
        ar.edu.unrc.game2048.Board board16 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean17 = board16.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray18 = board16.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray19 = board16.getGrid();
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board21.setScore((int) (short) 1);
        int int24 = board21.getSize();
        boolean boolean25 = board21.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction26 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean27 = board21.move(direction26);
        boolean boolean28 = board16.move(direction26);
        boolean boolean29 = board16.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray30 = board16.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet31 = board16.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell34 = board16.getCell((int) (byte) 10, 0);
        board9.setCell((int) (byte) 10, 4, cell34);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) '4', 10, cell34);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (52, 10) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(cellArray11);
        org.junit.Assert.assertNotNull(cellArray12);
        org.junit.Assert.assertNotNull(board16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertNotNull(cellArray18);
        org.junit.Assert.assertNotNull(cellArray19);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 32 + "'", int24 == 32);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + direction26 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction26.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(cellArray30);
        org.junit.Assert.assertNotNull(positionSet31);
        org.junit.Assert.assertNotNull(cell34);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (byte) 10, (int) (byte) 10);
        int int3 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 10 + "'", int3 == 10);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        ar.edu.unrc.game2048.Board board3 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board3.setScore((int) (short) 1);
        int int6 = board3.getSize();
        boolean boolean7 = board1.equals((java.lang.Object) int6);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board3);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 32 + "'", int6 == 32);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Board size must be positive: 0");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) 100, 0);
        int int3 = position2.row;
        int int4 = position2.row;
        int int5 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 100 + "'", int4 == 100);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isFull();
        java.lang.Class<?> wildcardClass15 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        boolean boolean9 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board7.setScore((int) (short) 1);
        boolean boolean10 = board7.isFull();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean12 = board7.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board16 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean17 = board16.hasEmptyCells();
        int int18 = board16.getSize();
        boolean boolean19 = board16.isWinningBoard();
        int int20 = board16.getScore();
        ar.edu.unrc.game2048.Board board22 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board22.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board26 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board26.setScore((int) (short) 1);
        int int29 = board26.getSize();
        boolean boolean30 = board26.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction31 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean32 = board26.move(direction31);
        boolean boolean33 = board22.move(direction31);
        boolean boolean34 = board16.move(direction31);
        boolean boolean35 = board1.move(direction31);
        ar.edu.unrc.game2048.Board board39 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean40 = board39.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray41 = board39.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray42 = board39.getGrid();
        ar.edu.unrc.game2048.Board board44 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board44.setScore((int) (short) 1);
        int int47 = board44.getSize();
        boolean boolean48 = board44.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction49 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean50 = board44.move(direction49);
        boolean boolean51 = board39.move(direction49);
        boolean boolean52 = board39.isLosingBoard();
        ar.edu.unrc.game2048.Cell cell55 = board39.getCell((int) (short) 10, 4);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(1, 2048, cell55);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (1, 2048) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction11.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(board16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 32 + "'", int18 == 32);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertNotNull(board22);
        org.junit.Assert.assertNotNull(board26);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 32 + "'", int29 == 32);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + direction31 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction31.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(board39);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + true + "'", boolean40 == true);
        org.junit.Assert.assertNotNull(cellArray41);
        org.junit.Assert.assertNotNull(cellArray42);
        org.junit.Assert.assertNotNull(board44);
        org.junit.Assert.assertTrue("'" + int47 + "' != '" + 32 + "'", int47 == 32);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertTrue("'" + direction49 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction49.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + false + "'", boolean50 == false);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertNotNull(cell55);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (short) 100);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board7.setScore((int) (short) 1);
        boolean boolean10 = board7.isFull();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean12 = board7.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.hasEmptyCells();
        boolean boolean15 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction11.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.col;
        java.lang.String str4 = position2.toString();
        int int5 = position2.row;
        java.lang.Object obj6 = null;
        boolean boolean7 = position2.equals(obj6);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1) + "'", int5 == (-1));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell cell17 = board1.getCell((int) (short) 10, 4);
        java.lang.Class<?> wildcardClass18 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cell17);
        org.junit.Assert.assertNotNull(wildcardClass18);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        board1.setScore(1);
        boolean boolean9 = board1.equals((java.lang.Object) 'a');
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isLosingBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell[][] cellArray18 = board1.getGrid();
        java.lang.Class<?> wildcardClass19 = cellArray18.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(cellArray18);
        org.junit.Assert.assertNotNull(wildcardClass19);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        boolean boolean6 = board1.isWinningBoard();
        java.lang.Class<?> wildcardClass7 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction5 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean6 = board1.move(direction5);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board9.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board13 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board13.setScore((int) (short) 1);
        int int16 = board13.getSize();
        boolean boolean17 = board13.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction18 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean19 = board13.move(direction18);
        boolean boolean20 = board9.move(direction18);
        boolean boolean21 = board9.isFull();
        boolean boolean22 = board1.equals((java.lang.Object) board9);
        boolean boolean23 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction5.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertNotNull(board13);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 32 + "'", int16 == 32);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + direction18 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction18.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        boolean boolean3 = board1.isFull();
        boolean boolean4 = board1.isLosingBoard();
        int int5 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position(2048, (int) (byte) 10);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int21 = board20.getSize();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board23.setScore((int) (short) 1);
        int int26 = board23.getSize();
        boolean boolean27 = board23.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction28 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean29 = board23.move(direction28);
        boolean boolean30 = board20.move(direction28);
        boolean boolean31 = board20.isLosingBoard();
        boolean boolean32 = board1.equals((java.lang.Object) board20);
        boolean boolean33 = board20.isWinningBoard();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell36 = board20.getCell((int) (byte) 0, (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, 100) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 32 + "'", int21 == 32);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + direction28 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction28.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        boolean boolean4 = position2.equals((java.lang.Object) 0.0f);
        boolean boolean6 = position2.equals((java.lang.Object) (-1L));
        java.lang.String str7 = position2.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "(-1, 1)" + "'", str7, "(-1, 1)");
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isLosingBoard();
        board1.setScore(4);
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell[][] cellArray20 = board1.getGrid();
        board1.setScore((int) 'a');
        ar.edu.unrc.game2048.Board board26 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board26.setScore((int) (short) 1);
        int int29 = board26.getScore();
        board26.setScore((int) (short) 0);
        boolean boolean32 = board26.isLosingBoard();
        ar.edu.unrc.game2048.Cell cell35 = board26.getCell(10, 0);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(2048, 100, cell35);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (2048, 100) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(cellArray20);
        org.junit.Assert.assertNotNull(board26);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 1 + "'", int29 == 1);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(cell35);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        boolean boolean4 = position2.equals((java.lang.Object) 0.0f);
        boolean boolean6 = position2.equals((java.lang.Object) 0.0f);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (byte) 1, 32);
        int int3 = position2.row;
        int int4 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (byte) 10, (int) (byte) 10);
        int int3 = position2.row;
        java.lang.String str4 = position2.toString();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 10 + "'", int3 == 10);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(10, 10)" + "'", str4, "(10, 10)");
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isLosingBoard();
        int int14 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 1 + "'", int14 == 1);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        boolean boolean18 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isFull();
        boolean boolean14 = board1.isWinningBoard();
        boolean boolean15 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board7.setScore((int) (short) 1);
        int int10 = board7.getSize();
        int int11 = board7.getSize();
        ar.edu.unrc.game2048.Cell cell14 = board7.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board16 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board16.setScore((int) (short) 1);
        int int19 = board16.getSize();
        boolean boolean20 = board16.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction21 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean22 = board16.move(direction21);
        boolean boolean23 = board7.move(direction21);
        boolean boolean24 = board1.move(direction21);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 32 + "'", int10 == 32);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 32 + "'", int11 == 32);
        org.junit.Assert.assertNotNull(cell14);
        org.junit.Assert.assertNotNull(board16);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 32 + "'", int19 == 32);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + direction21 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction21.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isLosingBoard();
        boolean boolean14 = board1.hasEmptyCells();
        int int15 = board1.getSize();
        boolean boolean16 = board1.hasEmptyCells();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell19 = board1.getCell((int) '#', (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (35, 100) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction5 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean6 = board1.move(direction5);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        int int8 = board1.getSize();
        boolean boolean9 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction5.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        boolean boolean3 = board1.isFull();
        boolean boolean4 = board1.isLosingBoard();
        int int5 = board1.getSize();
        boolean boolean6 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        int int3 = board1.getSize();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet4 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board9.setScore((int) (short) 1);
        int int12 = board9.getSize();
        int int13 = board9.getSize();
        ar.edu.unrc.game2048.Cell cell16 = board9.getCell((int) (byte) 0, 0);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(32, 32, cell16);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (32, 32) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 32 + "'", int3 == 32);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 32 + "'", int12 == 32);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertNotNull(cell16);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction5 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean6 = board1.move(direction5);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell[][] cellArray8 = board1.getGrid();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board10.isWinningBoard();
        board10.setScore((int) (short) 100);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet20 = board10.getEmptyPositions();
        boolean boolean21 = board1.equals((java.lang.Object) board10);
        board10.setScore((int) (byte) 1);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction5.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertNotNull(cellArray8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(positionSet20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.col;
        java.lang.String str4 = position2.toString();
        java.lang.String str5 = position2.toString();
        int int6 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "(-1, 1)" + "'", str5, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1 + "'", int6 == 1);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) '#', (int) (byte) 0);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction5 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean6 = board1.move(direction5);
        board1.setScore((int) (byte) 100);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction5.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.col;
        java.lang.String str4 = position2.toString();
        int int5 = position2.col;
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean8 = board7.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board7.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board7.getGrid();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        boolean boolean16 = board12.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction17 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean18 = board12.move(direction17);
        boolean boolean19 = board7.move(direction17);
        boolean boolean20 = board7.isLosingBoard();
        boolean boolean21 = board7.isLosingBoard();
        board7.setScore(4);
        boolean boolean24 = position2.equals((java.lang.Object) board7);
        boolean boolean26 = position2.equals((java.lang.Object) (short) 10);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + direction17 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction17.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (byte) 100, (int) (byte) 0);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) '4', 10);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int21 = board20.getSize();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board23.setScore((int) (short) 1);
        int int26 = board23.getSize();
        boolean boolean27 = board23.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction28 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean29 = board23.move(direction28);
        boolean boolean30 = board20.move(direction28);
        boolean boolean31 = board20.isLosingBoard();
        boolean boolean32 = board1.equals((java.lang.Object) board20);
        int int33 = board20.getSize();
        ar.edu.unrc.game2048.Board board35 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean36 = board35.hasEmptyCells();
        board35.setScore(0);
        int int39 = board35.getSize();
        board35.setScore(2048);
        ar.edu.unrc.game2048.Board board43 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board43.setScore((int) (short) 1);
        int int46 = board43.getSize();
        int int47 = board43.getSize();
        ar.edu.unrc.game2048.Cell cell50 = board43.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board52 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board52.setScore((int) (short) 1);
        int int55 = board52.getSize();
        boolean boolean56 = board52.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction57 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean58 = board52.move(direction57);
        boolean boolean59 = board43.move(direction57);
        boolean boolean60 = board43.isFull();
        boolean boolean61 = board35.equals((java.lang.Object) board43);
        boolean boolean62 = board20.equals((java.lang.Object) board43);
        // The following exception was thrown during execution in test generation
        try {
            board43.setScore((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Score cannot be negative: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 32 + "'", int21 == 32);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + direction28 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction28.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 32 + "'", int33 == 32);
        org.junit.Assert.assertNotNull(board35);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + int39 + "' != '" + 32 + "'", int39 == 32);
        org.junit.Assert.assertNotNull(board43);
        org.junit.Assert.assertTrue("'" + int46 + "' != '" + 32 + "'", int46 == 32);
        org.junit.Assert.assertTrue("'" + int47 + "' != '" + 32 + "'", int47 == 32);
        org.junit.Assert.assertNotNull(cell50);
        org.junit.Assert.assertNotNull(board52);
        org.junit.Assert.assertTrue("'" + int55 + "' != '" + 32 + "'", int55 == 32);
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertTrue("'" + direction57 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction57.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + false + "'", boolean59 == false);
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + false + "'", boolean60 == false);
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + false + "'", boolean62 == false);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isLosingBoard();
        boolean boolean16 = board1.hasEmptyCells();
        boolean boolean17 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        ar.edu.unrc.game2048.Board board4 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board4.setScore((int) (short) 1);
        int int7 = board4.getSize();
        boolean boolean8 = board4.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction9 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean10 = board4.move(direction9);
        boolean boolean11 = board1.move(direction9);
        boolean boolean12 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board14 = ar.edu.unrc.game2048.Board.forTesting((int) (short) 1);
        boolean boolean15 = board14.hasEmptyCells();
        ar.edu.unrc.game2048.Board board17 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean18 = board17.hasEmptyCells();
        int int19 = board17.getSize();
        boolean boolean20 = board17.isWinningBoard();
        int int21 = board17.getScore();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board23.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board27 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board27.setScore((int) (short) 1);
        int int30 = board27.getSize();
        boolean boolean31 = board27.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction32 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean33 = board27.move(direction32);
        boolean boolean34 = board23.move(direction32);
        boolean boolean35 = board17.move(direction32);
        boolean boolean36 = board14.move(direction32);
        boolean boolean37 = board1.equals((java.lang.Object) direction32);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertNotNull(board4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 32 + "'", int7 == 32);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + direction9 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction9.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertNotNull(board14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertNotNull(board17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 32 + "'", int19 == 32);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertNotNull(board27);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 32 + "'", int30 == 32);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + direction32 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction32.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        ar.edu.unrc.game2048.Board board15 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean16 = board15.hasEmptyCells();
        board15.setScore(0);
        int int19 = board15.getSize();
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board21.setScore((int) (short) 1);
        boolean boolean24 = board21.isFull();
        ar.edu.unrc.game2048.Direction direction25 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean26 = board21.move(direction25);
        boolean boolean27 = board15.move(direction25);
        boolean boolean28 = board1.move(direction25);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell31 = board1.getCell(0, (int) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, 32) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(board15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 32 + "'", int19 == 32);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + direction25 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction25.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) -1, 4);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 4) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        java.lang.String str3 = position2.toString();
        java.lang.String str4 = position2.toString();
        int int5 = position2.col;
        int int6 = position2.row;
        int int7 = position2.col;
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(-1, 1)" + "'", str3, "(-1, 1)");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + (-1) + "'", int6 == (-1));
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        int int9 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet16 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell19 = board1.getCell((int) (byte) 10, 0);
        int int20 = board1.getScore();
        board1.setScore((int) '4');
        boolean boolean23 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cellArray15);
        org.junit.Assert.assertNotNull(positionSet16);
        org.junit.Assert.assertNotNull(cell19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (byte) 1);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        boolean boolean5 = board1.isLosingBoard();
        int int6 = board1.getSize();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell9 = board1.getCell((int) '4', (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (52, 97) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 32 + "'", int6 == 32);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.col;
        java.lang.String str4 = position2.toString();
        int int5 = position2.col;
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean8 = board7.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board7.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board7.getGrid();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        boolean boolean16 = board12.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction17 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean18 = board12.move(direction17);
        boolean boolean19 = board7.move(direction17);
        boolean boolean20 = board7.isLosingBoard();
        boolean boolean21 = board7.isLosingBoard();
        board7.setScore(4);
        boolean boolean24 = position2.equals((java.lang.Object) board7);
        java.lang.String str25 = position2.toString();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + direction17 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction17.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "(-1, 1)" + "'", str25, "(-1, 1)");
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean3 = board1.hasEmptyCells();
        java.lang.Class<?> wildcardClass4 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Direction direction6 = ar.edu.unrc.game2048.Direction.UP;
        boolean boolean7 = board1.move(direction6);
        boolean boolean8 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertTrue("'" + direction6 + "' != '" + ar.edu.unrc.game2048.Direction.UP + "'", direction6.equals(ar.edu.unrc.game2048.Direction.UP));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Position position7 = new ar.edu.unrc.game2048.Position((int) (short) 100, 0);
        int int8 = position7.row;
        boolean boolean9 = board1.equals((java.lang.Object) position7);
        boolean boolean10 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 100 + "'", int8 == 100);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        boolean boolean5 = board1.isLosingBoard();
        boolean boolean6 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        int int13 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell16 = board1.getCell(10, (int) (byte) 10);
        boolean boolean17 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertNotNull(cell16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) 1, (-1));
        ar.edu.unrc.game2048.Board board4 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int5 = board4.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board7.setScore((int) (short) 1);
        int int10 = board7.getSize();
        boolean boolean11 = board7.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction12 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean13 = board7.move(direction12);
        boolean boolean14 = board4.move(direction12);
        boolean boolean15 = position2.equals((java.lang.Object) boolean14);
        org.junit.Assert.assertNotNull(board4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 32 + "'", int10 == 32);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + direction12 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction12.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction5 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean6 = board1.move(direction5);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        boolean boolean8 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction5.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position(10, (int) (byte) 1);
        int int3 = position2.col;
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean6 = board5.hasEmptyCells();
        int int7 = board5.getSize();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet8 = board5.getEmptyPositions();
        ar.edu.unrc.game2048.Direction direction9 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean10 = board5.move(direction9);
        boolean boolean11 = position2.equals((java.lang.Object) board5);
        ar.edu.unrc.game2048.Cell[][] cellArray12 = board5.getGrid();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 32 + "'", int7 == 32);
        org.junit.Assert.assertNotNull(positionSet8);
        org.junit.Assert.assertTrue("'" + direction9 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction9.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(cellArray12);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board7.setScore((int) (short) 1);
        boolean boolean10 = board7.isFull();
        boolean boolean11 = board1.equals((java.lang.Object) boolean10);
        boolean boolean12 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isLosingBoard();
        boolean boolean14 = board1.hasEmptyCells();
        int int15 = board1.getSize();
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Cell[][] cellArray18 = board1.getGrid();
        board1.setScore((int) (byte) 0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertNotNull(cellArray18);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        boolean boolean9 = board1.isFull();
        boolean boolean10 = board1.hasEmptyCells();
        java.lang.Class<?> wildcardClass11 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board22 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean23 = board22.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray24 = board22.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray25 = board22.getGrid();
        ar.edu.unrc.game2048.Board board27 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board27.setScore((int) (short) 1);
        int int30 = board27.getSize();
        boolean boolean31 = board27.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction32 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean33 = board27.move(direction32);
        boolean boolean34 = board22.move(direction32);
        boolean boolean35 = board22.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray36 = board22.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet37 = board22.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell40 = board22.getCell((int) (byte) 10, 0);
        board1.setCell((int) (short) 10, 0, cell40);
        boolean boolean42 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNotNull(cellArray24);
        org.junit.Assert.assertNotNull(cellArray25);
        org.junit.Assert.assertNotNull(board27);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 32 + "'", int30 == 32);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + direction32 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction32.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(cellArray36);
        org.junit.Assert.assertNotNull(positionSet37);
        org.junit.Assert.assertNotNull(cell40);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + true + "'", boolean42 == true);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        java.lang.Class<?> wildcardClass9 = cell8.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(32);
        ar.edu.unrc.game2048.Board board3 = ar.edu.unrc.game2048.Board.forTesting(300);
        ar.edu.unrc.game2048.Cell cell6 = board3.getCell((int) '#', 4);
        boolean boolean7 = board1.equals((java.lang.Object) '#');
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board3);
        org.junit.Assert.assertNotNull(cell6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        boolean boolean6 = board1.isWinningBoard();
        int int7 = board1.getSize();
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board11.setScore((int) (short) 1);
        int int14 = board11.getScore();
        board11.setScore((int) (short) 0);
        boolean boolean17 = board11.isLosingBoard();
        ar.edu.unrc.game2048.Cell cell20 = board11.getCell(10, 0);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) '4', 300, cell20);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (52, 300) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 32 + "'", int7 == 32);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 1 + "'", int14 == 1);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(cell20);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isLosingBoard();
        java.lang.Class<?> wildcardClass16 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isFull();
        int int14 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 32 + "'", int14 == 32);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        ar.edu.unrc.game2048.Board board4 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board4.setScore((int) (short) 1);
        int int7 = board4.getSize();
        boolean boolean8 = board4.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction9 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean10 = board4.move(direction9);
        boolean boolean11 = board1.move(direction9);
        boolean boolean12 = board1.hasEmptyCells();
        int int13 = board1.getScore();
        board1.setScore(300);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertNotNull(board4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 32 + "'", int7 == 32);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + direction9 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction9.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isLosingBoard();
        boolean boolean16 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray17 = board1.getGrid();
        boolean boolean18 = board1.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet19 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertNotNull(cellArray17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(positionSet19);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(10);
        int int2 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        boolean boolean3 = board1.isFull();
        boolean boolean4 = board1.isFull();
        boolean boolean5 = board1.hasEmptyCells();
        board1.setScore((int) (byte) 0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Position position7 = new ar.edu.unrc.game2048.Position((int) (short) 100, 0);
        int int8 = position7.row;
        boolean boolean9 = board1.equals((java.lang.Object) position7);
        int int10 = position7.row;
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        boolean boolean15 = board12.isFull();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet16 = board12.getEmptyPositions();
        board12.setScore(1);
        boolean boolean19 = position7.equals((java.lang.Object) 1);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 100 + "'", int8 == 100);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 100 + "'", int10 == 100);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(positionSet16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position(10, (int) (byte) 1);
        int int3 = position2.col;
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean6 = board5.hasEmptyCells();
        int int7 = board5.getSize();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet8 = board5.getEmptyPositions();
        ar.edu.unrc.game2048.Direction direction9 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean10 = board5.move(direction9);
        boolean boolean11 = position2.equals((java.lang.Object) board5);
        java.lang.Class<?> wildcardClass12 = board5.getClass();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 32 + "'", int7 == 32);
        org.junit.Assert.assertNotNull(positionSet8);
        org.junit.Assert.assertTrue("'" + direction9 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction9.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) '4', 32);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        boolean boolean3 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        boolean boolean5 = board1.isLosingBoard();
        boolean boolean6 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        boolean boolean9 = board1.isFull();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet10 = board1.getEmptyPositions();
        board1.setScore(0);
        java.lang.Class<?> wildcardClass13 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(positionSet10);
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        boolean boolean4 = position2.equals((java.lang.Object) 0.0f);
        boolean boolean6 = position2.equals((java.lang.Object) 0L);
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean9 = board8.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board8.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray11 = board8.getGrid();
        boolean boolean12 = position2.equals((java.lang.Object) cellArray11);
        int int13 = position2.row;
        ar.edu.unrc.game2048.Position position16 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int17 = position16.col;
        java.lang.String str18 = position16.toString();
        int int19 = position16.col;
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean22 = board21.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray23 = board21.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray24 = board21.getGrid();
        ar.edu.unrc.game2048.Board board26 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board26.setScore((int) (short) 1);
        int int29 = board26.getSize();
        boolean boolean30 = board26.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction31 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean32 = board26.move(direction31);
        boolean boolean33 = board21.move(direction31);
        boolean boolean34 = board21.isLosingBoard();
        boolean boolean35 = board21.isLosingBoard();
        board21.setScore(4);
        boolean boolean38 = position16.equals((java.lang.Object) board21);
        boolean boolean39 = position2.equals((java.lang.Object) position16);
        int int40 = position2.col;
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertNotNull(cellArray11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + (-1) + "'", int13 == (-1));
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 1 + "'", int17 == 1);
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "(-1, 1)" + "'", str18, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 1 + "'", int19 == 1);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertNotNull(cellArray23);
        org.junit.Assert.assertNotNull(cellArray24);
        org.junit.Assert.assertNotNull(board26);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 32 + "'", int29 == 32);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + direction31 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction31.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + true + "'", boolean39 == true);
        org.junit.Assert.assertTrue("'" + int40 + "' != '" + 1 + "'", int40 == 1);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isLosingBoard();
        board1.setScore(4);
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell[][] cellArray20 = board1.getGrid();
        ar.edu.unrc.game2048.Direction direction21 = ar.edu.unrc.game2048.Direction.UP;
        boolean boolean22 = board1.move(direction21);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(cellArray20);
        org.junit.Assert.assertTrue("'" + direction21 + "' != '" + ar.edu.unrc.game2048.Direction.UP + "'", direction21.equals(ar.edu.unrc.game2048.Direction.UP));
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction5 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean6 = board1.move(direction5);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        boolean boolean8 = board1.isLosingBoard();
        boolean boolean9 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction5.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position(300, (int) (short) -1);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isFull();
        boolean boolean14 = board1.isLosingBoard();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell17 = board1.getCell((int) (short) 1, 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (1, 100) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        boolean boolean6 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean9 = board8.hasEmptyCells();
        board8.setScore(0);
        int int12 = board8.getSize();
        ar.edu.unrc.game2048.Board board14 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board14.setScore((int) (short) 1);
        boolean boolean17 = board14.isFull();
        ar.edu.unrc.game2048.Direction direction18 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean19 = board14.move(direction18);
        boolean boolean20 = board8.move(direction18);
        boolean boolean21 = board1.move(direction18);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 32 + "'", int12 == 32);
        org.junit.Assert.assertNotNull(board14);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + direction18 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction18.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(300);
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Cell cell5 = board1.getCell((int) '#', (int) (byte) 0);
        boolean boolean6 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(cell5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        ar.edu.unrc.game2048.Board board4 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board4.setScore((int) (short) 1);
        int int7 = board4.getSize();
        boolean boolean8 = board4.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction9 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean10 = board4.move(direction9);
        boolean boolean11 = board4.isWinningBoard();
        board4.setScore((int) (short) 100);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet14 = board4.getEmptyPositions();
        boolean boolean15 = position2.equals((java.lang.Object) board4);
        org.junit.Assert.assertNotNull(board4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 32 + "'", int7 == 32);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + direction9 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction9.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(positionSet14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        java.lang.String str3 = position2.toString();
        java.lang.String str4 = position2.toString();
        java.lang.String str5 = position2.toString();
        int int6 = position2.col;
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(-1, 1)" + "'", str3, "(-1, 1)");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "(-1, 1)" + "'", str5, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1 + "'", int6 == 1);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isLosingBoard();
        board1.setScore(4);
        board1.setScore(4);
        boolean boolean20 = board1.hasEmptyCells();
        int int21 = board1.getScore();
        int int22 = board1.getSize();
        int int23 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 4 + "'", int21 == 4);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 32 + "'", int22 == 32);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 4 + "'", int23 == 4);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.col;
        java.lang.String str4 = position2.toString();
        int int5 = position2.col;
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean8 = board7.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board7.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board7.getGrid();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        boolean boolean16 = board12.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction17 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean18 = board12.move(direction17);
        boolean boolean19 = board7.move(direction17);
        boolean boolean20 = board7.isLosingBoard();
        boolean boolean21 = board7.isLosingBoard();
        board7.setScore(4);
        boolean boolean24 = position2.equals((java.lang.Object) board7);
        int int25 = position2.row;
        java.lang.Class<?> wildcardClass26 = position2.getClass();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + direction17 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction17.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + (-1) + "'", int25 == (-1));
        org.junit.Assert.assertNotNull(wildcardClass26);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        board1.setScore((int) '#');
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell10 = board1.getCell((int) '#', 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (35, 100) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        boolean boolean5 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction6 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean7 = board1.move(direction6);
        boolean boolean8 = board1.isWinningBoard();
        board1.setScore((int) (short) 100);
        ar.edu.unrc.game2048.Cell[][] cellArray11 = board1.getGrid();
        boolean boolean12 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + direction6 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction6.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(cellArray11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board7.setScore((int) (short) 1);
        boolean boolean10 = board7.isFull();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean12 = board7.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isFull();
        boolean boolean15 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction11.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        boolean boolean5 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction6 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean7 = board1.move(direction6);
        boolean boolean8 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + direction6 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction6.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int21 = board20.getSize();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board23.setScore((int) (short) 1);
        int int26 = board23.getSize();
        boolean boolean27 = board23.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction28 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean29 = board23.move(direction28);
        boolean boolean30 = board20.move(direction28);
        boolean boolean31 = board20.isLosingBoard();
        boolean boolean32 = board1.equals((java.lang.Object) board20);
        int int33 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 32 + "'", int21 == 32);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + direction28 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction28.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 1 + "'", int33 == 1);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        boolean boolean18 = board1.isFull();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet19 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(positionSet19);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position(2048, (int) (short) 0);
        java.lang.String str3 = position2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(2048, 0)" + "'", str3, "(2048, 0)");
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board1.getGrid();
        int int16 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cellArray15);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 32 + "'", int16 == 32);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isLosingBoard();
        boolean boolean14 = board1.hasEmptyCells();
        int int15 = board1.getSize();
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Cell[][] cellArray18 = board1.getGrid();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean21 = board20.hasEmptyCells();
        int int22 = board20.getSize();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet23 = board20.getEmptyPositions();
        ar.edu.unrc.game2048.Direction direction24 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean25 = board20.move(direction24);
        boolean boolean26 = board1.move(direction24);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertNotNull(cellArray18);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 32 + "'", int22 == 32);
        org.junit.Assert.assertNotNull(positionSet23);
        org.junit.Assert.assertTrue("'" + direction24 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction24.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (byte) 10, (int) (byte) 10);
        java.lang.String str3 = position2.toString();
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int6 = board5.getSize();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board8.setScore((int) (short) 1);
        int int11 = board8.getSize();
        boolean boolean12 = board8.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction13 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean14 = board8.move(direction13);
        boolean boolean15 = board5.move(direction13);
        boolean boolean16 = position2.equals((java.lang.Object) boolean15);
        ar.edu.unrc.game2048.Position position19 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        boolean boolean21 = position19.equals((java.lang.Object) 0.0f);
        java.lang.String str22 = position19.toString();
        int int23 = position19.col;
        boolean boolean24 = position2.equals((java.lang.Object) position19);
        int int25 = position2.col;
        java.lang.Class<?> wildcardClass26 = position2.getClass();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(10, 10)" + "'", str3, "(10, 10)");
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 32 + "'", int6 == 32);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 32 + "'", int11 == 32);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + direction13 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction13.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "(-1, 1)" + "'", str22, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 1 + "'", int23 == 1);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 10 + "'", int25 == 10);
        org.junit.Assert.assertNotNull(wildcardClass26);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board1.getGrid();
        boolean boolean16 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board18 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board18.setScore((int) (short) 1);
        int int21 = board18.getSize();
        int int22 = board18.getSize();
        ar.edu.unrc.game2048.Cell cell25 = board18.getCell((int) (byte) 0, 0);
        boolean boolean26 = board18.isFull();
        boolean boolean27 = board18.hasEmptyCells();
        boolean boolean28 = board1.equals((java.lang.Object) boolean27);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cellArray15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertNotNull(board18);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 32 + "'", int21 == 32);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 32 + "'", int22 == 32);
        org.junit.Assert.assertNotNull(cell25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board22 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean23 = board22.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray24 = board22.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray25 = board22.getGrid();
        ar.edu.unrc.game2048.Board board27 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board27.setScore((int) (short) 1);
        int int30 = board27.getSize();
        boolean boolean31 = board27.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction32 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean33 = board27.move(direction32);
        boolean boolean34 = board22.move(direction32);
        boolean boolean35 = board22.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray36 = board22.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet37 = board22.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell40 = board22.getCell((int) (byte) 10, 0);
        board1.setCell((int) (short) 10, 0, cell40);
        boolean boolean42 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell cell45 = board1.getCell(1, 0);
        board1.setScore(1);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNotNull(cellArray24);
        org.junit.Assert.assertNotNull(cellArray25);
        org.junit.Assert.assertNotNull(board27);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 32 + "'", int30 == 32);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + direction32 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction32.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(cellArray36);
        org.junit.Assert.assertNotNull(positionSet37);
        org.junit.Assert.assertNotNull(cell40);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNotNull(cell45);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isLosingBoard();
        board1.setScore(4);
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell[][] cellArray20 = board1.getGrid();
        board1.setScore((int) 'a');
        ar.edu.unrc.game2048.Cell[][] cellArray23 = board1.getGrid();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell26 = board1.getCell(2048, (int) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (2048, 1) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(cellArray20);
        org.junit.Assert.assertNotNull(cellArray23);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        int int13 = board1.getSize();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet14 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Position position17 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int18 = position17.col;
        java.lang.String str19 = position17.toString();
        int int20 = position17.col;
        java.lang.Class<?> wildcardClass21 = position17.getClass();
        boolean boolean22 = board1.equals((java.lang.Object) position17);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertNotNull(positionSet14);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "(-1, 1)" + "'", str19, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 1 + "'", int20 == 1);
        org.junit.Assert.assertNotNull(wildcardClass21);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board7.setScore((int) (short) 1);
        boolean boolean10 = board7.isFull();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean12 = board7.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.hasEmptyCells();
        int int15 = board1.getSize();
        // The following exception was thrown during execution in test generation
        try {
            board1.setScore((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Score cannot be negative: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction11.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet5 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board7.setScore((int) (short) 1);
        int int10 = board7.getSize();
        boolean boolean11 = board7.isLosingBoard();
        boolean boolean12 = board1.equals((java.lang.Object) boolean11);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(positionSet5);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 32 + "'", int10 == 32);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) 0, (int) (byte) 100);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        boolean boolean5 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction6 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean7 = board1.move(direction6);
        boolean boolean8 = board1.isWinningBoard();
        board1.setScore((int) (short) 100);
        board1.setScore(0);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet13 = board1.getEmptyPositions();
        board1.setScore((int) (short) 1);
        board1.setScore(100);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + direction6 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction6.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(positionSet13);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        int int16 = board12.getSize();
        ar.edu.unrc.game2048.Cell cell19 = board12.getCell((int) (byte) 0, 0);
        board8.setCell(0, (int) (short) 1, cell19);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((-1), 1, cell19);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 1) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 32 + "'", int16 == 32);
        org.junit.Assert.assertNotNull(cell19);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (byte) 10, (int) (byte) 10);
        boolean boolean4 = position2.equals((java.lang.Object) 0.0d);
        java.lang.String str5 = position2.toString();
        int int6 = position2.row;
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "(10, 10)" + "'", str5, "(10, 10)");
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        int int3 = board1.getSize();
        boolean boolean4 = board1.isWinningBoard();
        int int5 = board1.getScore();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board7.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board11.setScore((int) (short) 1);
        int int14 = board11.getSize();
        boolean boolean15 = board11.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction16 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean17 = board11.move(direction16);
        boolean boolean18 = board7.move(direction16);
        boolean boolean19 = board1.move(direction16);
        boolean boolean20 = board1.isFull();
        boolean boolean21 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board25 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean26 = board25.hasEmptyCells();
        int int27 = board25.getSize();
        boolean boolean28 = board25.isWinningBoard();
        int int29 = board25.getScore();
        ar.edu.unrc.game2048.Board board33 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        ar.edu.unrc.game2048.Board board37 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board37.setScore((int) (short) 1);
        int int40 = board37.getSize();
        int int41 = board37.getSize();
        ar.edu.unrc.game2048.Cell cell44 = board37.getCell((int) (byte) 0, 0);
        board33.setCell(0, (int) (short) 1, cell44);
        board25.setCell((int) (byte) 1, (int) (short) 0, cell44);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(100, (int) (byte) 0, cell44);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 0) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 32 + "'", int3 == 32);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 32 + "'", int14 == 32);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + direction16 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction16.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        org.junit.Assert.assertNotNull(board25);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + true + "'", boolean26 == true);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 32 + "'", int27 == 32);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 0 + "'", int29 == 0);
        org.junit.Assert.assertNotNull(board33);
        org.junit.Assert.assertNotNull(board37);
        org.junit.Assert.assertTrue("'" + int40 + "' != '" + 32 + "'", int40 == 32);
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + 32 + "'", int41 == 32);
        org.junit.Assert.assertNotNull(cell44);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int21 = board20.getSize();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board23.setScore((int) (short) 1);
        int int26 = board23.getSize();
        boolean boolean27 = board23.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction28 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean29 = board23.move(direction28);
        boolean boolean30 = board20.move(direction28);
        boolean boolean31 = board20.isLosingBoard();
        boolean boolean32 = board1.equals((java.lang.Object) board20);
        boolean boolean33 = board20.isWinningBoard();
        int int34 = board20.getSize();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell37 = board20.getCell(32, (int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (32, 35) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 32 + "'", int21 == 32);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + direction28 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction28.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 32 + "'", int34 == 32);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        boolean boolean9 = board1.isFull();
        board1.setScore((int) '#');
        boolean boolean12 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.row;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board22 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean23 = board22.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray24 = board22.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray25 = board22.getGrid();
        ar.edu.unrc.game2048.Board board29 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean30 = board29.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray31 = board29.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray32 = board29.getGrid();
        ar.edu.unrc.game2048.Board board34 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board34.setScore((int) (short) 1);
        int int37 = board34.getSize();
        boolean boolean38 = board34.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction39 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean40 = board34.move(direction39);
        boolean boolean41 = board29.move(direction39);
        boolean boolean42 = board29.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray43 = board29.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet44 = board29.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell47 = board29.getCell((int) (byte) 10, 0);
        board22.setCell((int) (byte) 10, 4, cell47);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(0, 100, cell47);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (0, 100) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNotNull(cellArray24);
        org.junit.Assert.assertNotNull(cellArray25);
        org.junit.Assert.assertNotNull(board29);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertNotNull(cellArray31);
        org.junit.Assert.assertNotNull(cellArray32);
        org.junit.Assert.assertNotNull(board34);
        org.junit.Assert.assertTrue("'" + int37 + "' != '" + 32 + "'", int37 == 32);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + direction39 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction39.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNotNull(cellArray43);
        org.junit.Assert.assertNotNull(positionSet44);
        org.junit.Assert.assertNotNull(cell47);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        board1.setScore(2048);
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board9.setScore((int) (short) 1);
        int int12 = board9.getSize();
        int int13 = board9.getSize();
        ar.edu.unrc.game2048.Cell cell16 = board9.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board18 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board18.setScore((int) (short) 1);
        int int21 = board18.getSize();
        boolean boolean22 = board18.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction23 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean24 = board18.move(direction23);
        boolean boolean25 = board9.move(direction23);
        boolean boolean26 = board9.isFull();
        boolean boolean27 = board1.equals((java.lang.Object) board9);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet28 = board9.getEmptyPositions();
        boolean boolean29 = board9.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 32 + "'", int12 == 32);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertNotNull(cell16);
        org.junit.Assert.assertNotNull(board18);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 32 + "'", int21 == 32);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + direction23 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction23.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(positionSet28);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isLosingBoard();
        boolean boolean14 = board1.hasEmptyCells();
        int int15 = board1.getSize();
        boolean boolean16 = board1.hasEmptyCells();
        boolean boolean17 = board1.isWinningBoard();
        int int18 = board1.getSize();
        boolean boolean19 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 32 + "'", int18 == 32);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet16 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell19 = board1.getCell((int) (byte) 10, 0);
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting(300);
        int int22 = board21.getScore();
        boolean boolean23 = board1.equals((java.lang.Object) board21);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cellArray15);
        org.junit.Assert.assertNotNull(positionSet16);
        org.junit.Assert.assertNotNull(cell19);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        int int3 = board1.getSize();
        boolean boolean4 = board1.isWinningBoard();
        int int5 = board1.getScore();
        boolean boolean6 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 32 + "'", int3 == 32);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Direction direction4 = ar.edu.unrc.game2048.Direction.LEFT;
        boolean boolean5 = board1.move(direction4);
        boolean boolean6 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + direction4 + "' != '" + ar.edu.unrc.game2048.Direction.LEFT + "'", direction4.equals(ar.edu.unrc.game2048.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isLosingBoard();
        boolean boolean14 = board1.hasEmptyCells();
        int int15 = board1.getSize();
        boolean boolean16 = board1.hasEmptyCells();
        boolean boolean17 = board1.isWinningBoard();
        int int18 = board1.getSize();
        ar.edu.unrc.game2048.Board board22 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean23 = board22.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray24 = board22.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray25 = board22.getGrid();
        ar.edu.unrc.game2048.Board board29 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean30 = board29.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray31 = board29.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray32 = board29.getGrid();
        ar.edu.unrc.game2048.Board board34 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board34.setScore((int) (short) 1);
        int int37 = board34.getSize();
        boolean boolean38 = board34.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction39 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean40 = board34.move(direction39);
        boolean boolean41 = board29.move(direction39);
        boolean boolean42 = board29.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray43 = board29.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet44 = board29.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell47 = board29.getCell((int) (byte) 10, 0);
        board22.setCell((int) (byte) 10, 4, cell47);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(32, (int) (byte) 0, cell47);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (32, 0) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 32 + "'", int18 == 32);
        org.junit.Assert.assertNotNull(board22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNotNull(cellArray24);
        org.junit.Assert.assertNotNull(cellArray25);
        org.junit.Assert.assertNotNull(board29);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
        org.junit.Assert.assertNotNull(cellArray31);
        org.junit.Assert.assertNotNull(cellArray32);
        org.junit.Assert.assertNotNull(board34);
        org.junit.Assert.assertTrue("'" + int37 + "' != '" + 32 + "'", int37 == 32);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + direction39 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction39.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNotNull(cellArray43);
        org.junit.Assert.assertNotNull(positionSet44);
        org.junit.Assert.assertNotNull(cell47);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean3 = board1.hasEmptyCells();
        int int4 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) 100, (int) (byte) 10);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction5 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean6 = board1.move(direction5);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        boolean boolean8 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting(300);
        ar.edu.unrc.game2048.Cell cell15 = board12.getCell((int) '#', 4);
        board1.setCell((int) (short) 10, (int) (byte) 0, cell15);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction5.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertNotNull(cell15);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet16 = board1.getEmptyPositions();
        boolean boolean17 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean20 = board19.hasEmptyCells();
        board19.setScore(0);
        int int23 = board19.getSize();
        ar.edu.unrc.game2048.Board board25 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board25.setScore((int) (short) 1);
        boolean boolean28 = board25.isFull();
        ar.edu.unrc.game2048.Direction direction29 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean30 = board25.move(direction29);
        boolean boolean31 = board19.move(direction29);
        boolean boolean32 = board1.move(direction29);
        boolean boolean33 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cellArray15);
        org.junit.Assert.assertNotNull(positionSet16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 32 + "'", int23 == 32);
        org.junit.Assert.assertNotNull(board25);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + direction29 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction29.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet19 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(positionSet19);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board22 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean23 = board22.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray24 = board22.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray25 = board22.getGrid();
        ar.edu.unrc.game2048.Board board27 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board27.setScore((int) (short) 1);
        int int30 = board27.getSize();
        boolean boolean31 = board27.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction32 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean33 = board27.move(direction32);
        boolean boolean34 = board22.move(direction32);
        boolean boolean35 = board22.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray36 = board22.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet37 = board22.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell40 = board22.getCell((int) (byte) 10, 0);
        board1.setCell((int) (short) 10, 0, cell40);
        boolean boolean42 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell cell45 = board1.getCell(1, 0);
        java.lang.Class<?> wildcardClass46 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board22);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNotNull(cellArray24);
        org.junit.Assert.assertNotNull(cellArray25);
        org.junit.Assert.assertNotNull(board27);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 32 + "'", int30 == 32);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + direction32 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction32.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(cellArray36);
        org.junit.Assert.assertNotNull(positionSet37);
        org.junit.Assert.assertNotNull(cell40);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNotNull(cell45);
        org.junit.Assert.assertNotNull(wildcardClass46);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(1);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Board size must be positive: 0");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        boolean boolean6 = board1.isWinningBoard();
        int int7 = board1.getSize();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean10 = board9.hasEmptyCells();
        board9.setScore(0);
        int int13 = board9.getSize();
        ar.edu.unrc.game2048.Board board15 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board15.setScore((int) (short) 1);
        boolean boolean18 = board15.isFull();
        ar.edu.unrc.game2048.Direction direction19 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean20 = board15.move(direction19);
        boolean boolean21 = board9.move(direction19);
        boolean boolean22 = board9.hasEmptyCells();
        ar.edu.unrc.game2048.Board board24 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean25 = board24.hasEmptyCells();
        int int26 = board24.getSize();
        boolean boolean27 = board24.isWinningBoard();
        int int28 = board24.getScore();
        ar.edu.unrc.game2048.Board board30 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board30.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board34 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board34.setScore((int) (short) 1);
        int int37 = board34.getSize();
        boolean boolean38 = board34.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction39 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean40 = board34.move(direction39);
        boolean boolean41 = board30.move(direction39);
        boolean boolean42 = board24.move(direction39);
        boolean boolean43 = board9.move(direction39);
        boolean boolean44 = board1.move(direction39);
        ar.edu.unrc.game2048.Board board46 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean47 = board46.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray48 = board46.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray49 = board46.getGrid();
        ar.edu.unrc.game2048.Board board51 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board51.setScore((int) (short) 1);
        int int54 = board51.getSize();
        boolean boolean55 = board51.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction56 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean57 = board51.move(direction56);
        boolean boolean58 = board46.move(direction56);
        boolean boolean59 = board46.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray60 = board46.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet61 = board46.getEmptyPositions();
        boolean boolean62 = board46.isWinningBoard();
        ar.edu.unrc.game2048.Board board64 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean65 = board64.hasEmptyCells();
        board64.setScore(0);
        int int68 = board64.getSize();
        ar.edu.unrc.game2048.Board board70 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board70.setScore((int) (short) 1);
        boolean boolean73 = board70.isFull();
        ar.edu.unrc.game2048.Direction direction74 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean75 = board70.move(direction74);
        boolean boolean76 = board64.move(direction74);
        boolean boolean77 = board46.move(direction74);
        boolean boolean78 = board1.move(direction74);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 32 + "'", int7 == 32);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertNotNull(board15);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + direction19 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction19.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertNotNull(board24);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 0 + "'", int28 == 0);
        org.junit.Assert.assertNotNull(board30);
        org.junit.Assert.assertNotNull(board34);
        org.junit.Assert.assertTrue("'" + int37 + "' != '" + 32 + "'", int37 == 32);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + direction39 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction39.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertNotNull(board46);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + true + "'", boolean47 == true);
        org.junit.Assert.assertNotNull(cellArray48);
        org.junit.Assert.assertNotNull(cellArray49);
        org.junit.Assert.assertNotNull(board51);
        org.junit.Assert.assertTrue("'" + int54 + "' != '" + 32 + "'", int54 == 32);
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
        org.junit.Assert.assertTrue("'" + direction56 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction56.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + false + "'", boolean59 == false);
        org.junit.Assert.assertNotNull(cellArray60);
        org.junit.Assert.assertNotNull(positionSet61);
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + false + "'", boolean62 == false);
        org.junit.Assert.assertNotNull(board64);
        org.junit.Assert.assertTrue("'" + boolean65 + "' != '" + true + "'", boolean65 == true);
        org.junit.Assert.assertTrue("'" + int68 + "' != '" + 32 + "'", int68 == 32);
        org.junit.Assert.assertNotNull(board70);
        org.junit.Assert.assertTrue("'" + boolean73 + "' != '" + false + "'", boolean73 == false);
        org.junit.Assert.assertTrue("'" + direction74 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction74.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean75 + "' != '" + false + "'", boolean75 == false);
        org.junit.Assert.assertTrue("'" + boolean76 + "' != '" + false + "'", boolean76 == false);
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + false + "'", boolean77 == false);
        org.junit.Assert.assertTrue("'" + boolean78 + "' != '" + false + "'", boolean78 == false);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        boolean boolean3 = board1.isFull();
        boolean boolean4 = board1.isLosingBoard();
        boolean boolean5 = board1.isFull();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        boolean boolean7 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(cellArray6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getScore();
        board1.setScore((int) (short) 0);
        boolean boolean7 = board1.isLosingBoard();
        int int8 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) 'a');
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board7.setScore((int) (short) 1);
        boolean boolean10 = board7.isFull();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean12 = board7.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isFull();
        java.lang.Class<?> wildcardClass15 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction11.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int21 = board20.getSize();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board23.setScore((int) (short) 1);
        int int26 = board23.getSize();
        boolean boolean27 = board23.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction28 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean29 = board23.move(direction28);
        boolean boolean30 = board20.move(direction28);
        boolean boolean31 = board20.isLosingBoard();
        boolean boolean32 = board1.equals((java.lang.Object) board20);
        int int33 = board20.getSize();
        ar.edu.unrc.game2048.Board board35 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean36 = board35.hasEmptyCells();
        board35.setScore(0);
        int int39 = board35.getSize();
        board35.setScore(2048);
        ar.edu.unrc.game2048.Board board43 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board43.setScore((int) (short) 1);
        int int46 = board43.getSize();
        int int47 = board43.getSize();
        ar.edu.unrc.game2048.Cell cell50 = board43.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board52 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board52.setScore((int) (short) 1);
        int int55 = board52.getSize();
        boolean boolean56 = board52.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction57 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean58 = board52.move(direction57);
        boolean boolean59 = board43.move(direction57);
        boolean boolean60 = board43.isFull();
        boolean boolean61 = board35.equals((java.lang.Object) board43);
        boolean boolean62 = board20.equals((java.lang.Object) board43);
        ar.edu.unrc.game2048.Cell[][] cellArray63 = board20.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 32 + "'", int21 == 32);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + direction28 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction28.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 32 + "'", int33 == 32);
        org.junit.Assert.assertNotNull(board35);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + int39 + "' != '" + 32 + "'", int39 == 32);
        org.junit.Assert.assertNotNull(board43);
        org.junit.Assert.assertTrue("'" + int46 + "' != '" + 32 + "'", int46 == 32);
        org.junit.Assert.assertTrue("'" + int47 + "' != '" + 32 + "'", int47 == 32);
        org.junit.Assert.assertNotNull(cell50);
        org.junit.Assert.assertNotNull(board52);
        org.junit.Assert.assertTrue("'" + int55 + "' != '" + 32 + "'", int55 == 32);
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertTrue("'" + direction57 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction57.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + false + "'", boolean59 == false);
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + false + "'", boolean60 == false);
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + false + "'", boolean62 == false);
        org.junit.Assert.assertNotNull(cellArray63);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isLosingBoard();
        boolean boolean14 = board1.hasEmptyCells();
        int int15 = board1.getSize();
        board1.setScore((int) (short) 1);
        boolean boolean18 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) 100, 0);
        int int3 = position2.row;
        int int4 = position2.col;
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board6.move(direction15);
        int int18 = board6.getSize();
        boolean boolean19 = position2.equals((java.lang.Object) int18);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 32 + "'", int18 == 32);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, 1);
        int int3 = position2.col;
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        boolean boolean8 = board5.isFull();
        ar.edu.unrc.game2048.Position position11 = new ar.edu.unrc.game2048.Position((int) (short) 100, 0);
        int int12 = position11.row;
        boolean boolean13 = board5.equals((java.lang.Object) position11);
        int int14 = position11.row;
        boolean boolean15 = position2.equals((java.lang.Object) int14);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 100 + "'", int12 == 100);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 100 + "'", int14 == 100);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position(10, (int) (byte) 1);
        int int3 = position2.col;
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean6 = board5.hasEmptyCells();
        int int7 = board5.getSize();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet8 = board5.getEmptyPositions();
        ar.edu.unrc.game2048.Direction direction9 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean10 = board5.move(direction9);
        boolean boolean11 = position2.equals((java.lang.Object) board5);
        int int12 = position2.col;
        int int13 = position2.col;
        int int14 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 32 + "'", int7 == 32);
        org.junit.Assert.assertNotNull(positionSet8);
        org.junit.Assert.assertTrue("'" + direction9 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction9.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 1 + "'", int12 == 1);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 1 + "'", int13 == 1);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 1 + "'", int14 == 1);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        int int9 = board5.getSize();
        ar.edu.unrc.game2048.Cell cell12 = board5.getCell((int) (byte) 0, 0);
        board1.setCell(0, (int) (short) 1, cell12);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet14 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board16 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board16.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board20.setScore((int) (short) 1);
        int int23 = board20.getSize();
        boolean boolean24 = board20.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction25 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean26 = board20.move(direction25);
        boolean boolean27 = board16.move(direction25);
        int int28 = board16.getSize();
        ar.edu.unrc.game2048.Cell cell31 = board16.getCell(10, (int) (byte) 10);
        ar.edu.unrc.game2048.Board board33 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board33.setScore((int) (short) 1);
        int int36 = board33.getSize();
        boolean boolean37 = board33.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction38 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean39 = board33.move(direction38);
        boolean boolean40 = board16.move(direction38);
        boolean boolean41 = board1.move(direction38);
        int int42 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertNotNull(cell12);
        org.junit.Assert.assertNotNull(positionSet14);
        org.junit.Assert.assertNotNull(board16);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 32 + "'", int23 == 32);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + direction25 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction25.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 32 + "'", int28 == 32);
        org.junit.Assert.assertNotNull(cell31);
        org.junit.Assert.assertNotNull(board33);
        org.junit.Assert.assertTrue("'" + int36 + "' != '" + 32 + "'", int36 == 32);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + direction38 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction38.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + int42 + "' != '" + 35 + "'", int42 == 35);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) 100, (-1));
        java.lang.String str3 = position2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(100, -1)" + "'", str3, "(100, -1)");
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getScore();
        board12.setScore((int) (short) 0);
        boolean boolean18 = board12.isLosingBoard();
        ar.edu.unrc.game2048.Cell cell21 = board12.getCell(10, 0);
        board1.setCell((int) (byte) 0, (int) (short) 10, cell21);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet23 = board1.getEmptyPositions();
        boolean boolean24 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 1 + "'", int15 == 1);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(cell21);
        org.junit.Assert.assertNotNull(positionSet23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.col;
        java.lang.String str4 = position2.toString();
        int int5 = position2.col;
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean8 = board7.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board7.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board7.getGrid();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        boolean boolean16 = board12.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction17 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean18 = board12.move(direction17);
        boolean boolean19 = board7.move(direction17);
        boolean boolean20 = board7.isLosingBoard();
        boolean boolean21 = board7.isLosingBoard();
        board7.setScore(4);
        boolean boolean24 = position2.equals((java.lang.Object) board7);
        boolean boolean25 = board7.isWinningBoard();
        int int26 = board7.getScore();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + direction17 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction17.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 4 + "'", int26 == 4);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        ar.edu.unrc.game2048.Board board4 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board4.setScore((int) (short) 1);
        int int7 = board4.getSize();
        boolean boolean8 = board4.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction9 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean10 = board4.move(direction9);
        boolean boolean11 = board1.move(direction9);
        boolean boolean12 = board1.hasEmptyCells();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell15 = board1.getCell((int) '4', 300);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (52, 300) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertNotNull(board4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 32 + "'", int7 == 32);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + direction9 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction9.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        boolean boolean5 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction6 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean7 = board1.move(direction6);
        boolean boolean8 = board1.isWinningBoard();
        board1.setScore((int) (short) 100);
        board1.setScore(0);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet13 = board1.getEmptyPositions();
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean18 = board17.hasEmptyCells();
        int int19 = board17.getSize();
        boolean boolean20 = board17.isWinningBoard();
        int int21 = board17.getScore();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board23.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board27 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board27.setScore((int) (short) 1);
        int int30 = board27.getSize();
        boolean boolean31 = board27.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction32 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean33 = board27.move(direction32);
        boolean boolean34 = board23.move(direction32);
        boolean boolean35 = board17.move(direction32);
        boolean boolean36 = board17.isFull();
        boolean boolean37 = board17.isWinningBoard();
        ar.edu.unrc.game2048.Board board39 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board39.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board43 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board43.setScore((int) (short) 1);
        int int46 = board43.getSize();
        boolean boolean47 = board43.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction48 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean49 = board43.move(direction48);
        boolean boolean50 = board39.move(direction48);
        boolean boolean51 = board17.move(direction48);
        boolean boolean52 = board1.move(direction48);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + direction6 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction6.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertNotNull(board17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 32 + "'", int19 == 32);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertNotNull(board27);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 32 + "'", int30 == 32);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + direction32 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction32.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNotNull(board39);
        org.junit.Assert.assertNotNull(board43);
        org.junit.Assert.assertTrue("'" + int46 + "' != '" + 32 + "'", int46 == 32);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
        org.junit.Assert.assertTrue("'" + direction48 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction48.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + false + "'", boolean49 == false);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + false + "'", boolean50 == false);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        boolean boolean5 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction6 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean7 = board1.move(direction6);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell10 = board1.getCell((int) (byte) -1, 4);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 4) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + direction6 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction6.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int21 = board20.getSize();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board23.setScore((int) (short) 1);
        int int26 = board23.getSize();
        boolean boolean27 = board23.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction28 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean29 = board23.move(direction28);
        boolean boolean30 = board20.move(direction28);
        boolean boolean31 = board20.isLosingBoard();
        boolean boolean32 = board1.equals((java.lang.Object) board20);
        ar.edu.unrc.game2048.Board board34 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board34.setScore((int) (short) 1);
        boolean boolean37 = board34.isFull();
        ar.edu.unrc.game2048.Direction direction38 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean39 = board34.move(direction38);
        boolean boolean40 = board20.move(direction38);
        ar.edu.unrc.game2048.Board board44 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean45 = board44.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray46 = board44.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray47 = board44.getGrid();
        ar.edu.unrc.game2048.Board board49 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board49.setScore((int) (short) 1);
        int int52 = board49.getSize();
        boolean boolean53 = board49.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction54 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean55 = board49.move(direction54);
        boolean boolean56 = board44.move(direction54);
        boolean boolean57 = board44.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray58 = board44.getGrid();
        ar.edu.unrc.game2048.Cell cell61 = board44.getCell((int) (short) 0, 10);
        // The following exception was thrown during execution in test generation
        try {
            board20.setCell((int) (byte) -1, (int) (short) 1, cell61);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 1) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 32 + "'", int21 == 32);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + direction28 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction28.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(board34);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + direction38 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction38.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNotNull(board44);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + true + "'", boolean45 == true);
        org.junit.Assert.assertNotNull(cellArray46);
        org.junit.Assert.assertNotNull(cellArray47);
        org.junit.Assert.assertNotNull(board49);
        org.junit.Assert.assertTrue("'" + int52 + "' != '" + 32 + "'", int52 == 32);
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
        org.junit.Assert.assertTrue("'" + direction54 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction54.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertNotNull(cellArray58);
        org.junit.Assert.assertNotNull(cell61);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position(100, (int) (short) 1);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) 0, (int) (short) 0);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Position position7 = new ar.edu.unrc.game2048.Position((int) (short) 100, 0);
        int int8 = position7.row;
        boolean boolean9 = board1.equals((java.lang.Object) position7);
        java.lang.String str10 = position7.toString();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 100 + "'", int8 == 100);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "(100, 0)" + "'", str10, "(100, 0)");
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction5 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean6 = board1.move(direction5);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        boolean boolean8 = board1.isFull();
        boolean boolean9 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction5.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        java.lang.String str3 = position2.toString();
        int int4 = position2.col;
        int int5 = position2.row;
        java.lang.String str6 = position2.toString();
        int int7 = position2.row;
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(-1, 1)" + "'", str3, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1) + "'", int5 == (-1));
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "(-1, 1)" + "'", str6, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int21 = board20.getSize();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board23.setScore((int) (short) 1);
        int int26 = board23.getSize();
        boolean boolean27 = board23.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction28 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean29 = board23.move(direction28);
        boolean boolean30 = board20.move(direction28);
        boolean boolean31 = board20.isLosingBoard();
        boolean boolean32 = board1.equals((java.lang.Object) board20);
        ar.edu.unrc.game2048.Board board34 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board34.setScore((int) (short) 1);
        boolean boolean37 = board34.isFull();
        ar.edu.unrc.game2048.Direction direction38 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean39 = board34.move(direction38);
        boolean boolean40 = board20.move(direction38);
        int int41 = board20.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 32 + "'", int21 == 32);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + direction28 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction28.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(board34);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + direction38 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction38.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + 32 + "'", int41 == 32);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        boolean boolean9 = board1.isFull();
        board1.setScore((int) '#');
        java.lang.Object obj12 = null;
        boolean boolean13 = board1.equals(obj12);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position(0, 100);
        int int3 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) 0, (int) '#');
        int int3 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 35 + "'", int3 == 35);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) '#');
        java.lang.String str3 = position2.toString();
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean6 = board5.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board5.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray8 = board5.getGrid();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board5.move(direction15);
        boolean boolean18 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean21 = board20.hasEmptyCells();
        board20.setScore(0);
        int int24 = board20.getSize();
        boolean boolean25 = board20.isWinningBoard();
        int int26 = board20.getSize();
        ar.edu.unrc.game2048.Board board28 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean29 = board28.hasEmptyCells();
        board28.setScore(0);
        int int32 = board28.getSize();
        ar.edu.unrc.game2048.Board board34 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board34.setScore((int) (short) 1);
        boolean boolean37 = board34.isFull();
        ar.edu.unrc.game2048.Direction direction38 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean39 = board34.move(direction38);
        boolean boolean40 = board28.move(direction38);
        boolean boolean41 = board28.hasEmptyCells();
        ar.edu.unrc.game2048.Board board43 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean44 = board43.hasEmptyCells();
        int int45 = board43.getSize();
        boolean boolean46 = board43.isWinningBoard();
        int int47 = board43.getScore();
        ar.edu.unrc.game2048.Board board49 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board49.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board53 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board53.setScore((int) (short) 1);
        int int56 = board53.getSize();
        boolean boolean57 = board53.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction58 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean59 = board53.move(direction58);
        boolean boolean60 = board49.move(direction58);
        boolean boolean61 = board43.move(direction58);
        boolean boolean62 = board28.move(direction58);
        boolean boolean63 = board20.move(direction58);
        boolean boolean64 = board5.move(direction58);
        boolean boolean65 = position2.equals((java.lang.Object) board5);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(-1, 35)" + "'", str3, "(-1, 35)");
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        org.junit.Assert.assertNotNull(cellArray7);
        org.junit.Assert.assertNotNull(cellArray8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 32 + "'", int24 == 32);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
        org.junit.Assert.assertNotNull(board28);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
        org.junit.Assert.assertTrue("'" + int32 + "' != '" + 32 + "'", int32 == 32);
        org.junit.Assert.assertNotNull(board34);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + direction38 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction38.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        org.junit.Assert.assertNotNull(board43);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
        org.junit.Assert.assertTrue("'" + int45 + "' != '" + 32 + "'", int45 == 32);
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + false + "'", boolean46 == false);
        org.junit.Assert.assertTrue("'" + int47 + "' != '" + 0 + "'", int47 == 0);
        org.junit.Assert.assertNotNull(board49);
        org.junit.Assert.assertNotNull(board53);
        org.junit.Assert.assertTrue("'" + int56 + "' != '" + 32 + "'", int56 == 32);
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + false + "'", boolean57 == false);
        org.junit.Assert.assertTrue("'" + direction58 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction58.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + false + "'", boolean59 == false);
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + false + "'", boolean60 == false);
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + false + "'", boolean62 == false);
        org.junit.Assert.assertTrue("'" + boolean63 + "' != '" + false + "'", boolean63 == false);
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + false + "'", boolean64 == false);
        org.junit.Assert.assertTrue("'" + boolean65 + "' != '" + false + "'", boolean65 == false);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        int int9 = board5.getSize();
        ar.edu.unrc.game2048.Cell cell12 = board5.getCell((int) (byte) 0, 0);
        board1.setCell(0, (int) (short) 1, cell12);
        board1.setScore((int) (byte) 0);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertNotNull(cell12);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board1.getGrid();
        boolean boolean16 = board1.hasEmptyCells();
        int int17 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cellArray15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        boolean boolean4 = position2.equals((java.lang.Object) 0.0f);
        java.lang.String str5 = position2.toString();
        int int6 = position2.row;
        boolean boolean8 = position2.equals((java.lang.Object) "(-1, 35)");
        java.lang.String str9 = position2.toString();
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "(-1, 1)" + "'", str5, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + (-1) + "'", int6 == (-1));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "(-1, 1)" + "'", str9, "(-1, 1)");
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 10);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isLosingBoard();
        board1.setScore(4);
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell[][] cellArray20 = board1.getGrid();
        board1.setScore((int) 'a');
        ar.edu.unrc.game2048.Cell[][] cellArray23 = board1.getGrid();
        int int24 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertNotNull(cellArray20);
        org.junit.Assert.assertNotNull(cellArray23);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 97 + "'", int24 == 97);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getScore();
        board1.setScore((int) (short) 0);
        boolean boolean7 = board1.isLosingBoard();
        int int8 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray15 = board1.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet16 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell19 = board1.getCell((int) (byte) 10, 0);
        int int20 = board1.getScore();
        boolean boolean21 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(cellArray15);
        org.junit.Assert.assertNotNull(positionSet16);
        org.junit.Assert.assertNotNull(cell19);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 0 + "'", int20 == 0);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        boolean boolean3 = board1.isFull();
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isFull();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        boolean boolean4 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean7 = board6.hasEmptyCells();
        board6.setScore(0);
        int int10 = board6.getSize();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        boolean boolean15 = board12.isFull();
        ar.edu.unrc.game2048.Direction direction16 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean17 = board12.move(direction16);
        boolean boolean18 = board6.move(direction16);
        boolean boolean19 = board6.hasEmptyCells();
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean22 = board21.hasEmptyCells();
        int int23 = board21.getSize();
        boolean boolean24 = board21.isWinningBoard();
        int int25 = board21.getScore();
        ar.edu.unrc.game2048.Board board27 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board27.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board31 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board31.setScore((int) (short) 1);
        int int34 = board31.getSize();
        boolean boolean35 = board31.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction36 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean37 = board31.move(direction36);
        boolean boolean38 = board27.move(direction36);
        boolean boolean39 = board21.move(direction36);
        boolean boolean40 = board6.move(direction36);
        boolean boolean41 = board1.move(direction36);
        boolean boolean42 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 32 + "'", int10 == 32);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + direction16 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction16.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 32 + "'", int23 == 32);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
        org.junit.Assert.assertNotNull(board27);
        org.junit.Assert.assertNotNull(board31);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 32 + "'", int34 == 32);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + direction36 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction36.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        int int13 = board1.getSize();
        int int14 = board1.getScore();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.LEFT;
        boolean boolean16 = board1.move(direction15);
        boolean boolean17 = board1.isFull();
        board1.setScore(1);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 1 + "'", int14 == 1);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.LEFT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        boolean boolean3 = board1.isFull();
        boolean boolean4 = board1.isLosingBoard();
        boolean boolean5 = board1.isFull();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean8 = board7.hasEmptyCells();
        int int9 = board7.getSize();
        boolean boolean10 = board7.isWinningBoard();
        int int11 = board7.getScore();
        ar.edu.unrc.game2048.Board board13 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board13.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board17 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board17.setScore((int) (short) 1);
        int int20 = board17.getSize();
        boolean boolean21 = board17.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction22 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean23 = board17.move(direction22);
        boolean boolean24 = board13.move(direction22);
        boolean boolean25 = board7.move(direction22);
        boolean boolean26 = board1.move(direction22);
        // The following exception was thrown during execution in test generation
        try {
            board1.setScore((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Score cannot be negative: -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 0 + "'", int11 == 0);
        org.junit.Assert.assertNotNull(board13);
        org.junit.Assert.assertNotNull(board17);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 32 + "'", int20 == 32);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + direction22 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction22.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        ar.edu.unrc.game2048.Board board4 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board4.setScore((int) (short) 1);
        int int7 = board4.getSize();
        boolean boolean8 = board4.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction9 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean10 = board4.move(direction9);
        boolean boolean11 = board1.move(direction9);
        boolean boolean12 = board1.hasEmptyCells();
        board1.setScore(0);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet15 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertNotNull(board4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 32 + "'", int7 == 32);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + direction9 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction9.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertNotNull(positionSet15);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        boolean boolean4 = position2.equals((java.lang.Object) 0.0f);
        boolean boolean6 = position2.equals((java.lang.Object) 0L);
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean9 = board8.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board8.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray11 = board8.getGrid();
        boolean boolean12 = position2.equals((java.lang.Object) cellArray11);
        ar.edu.unrc.game2048.Board board14 = ar.edu.unrc.game2048.Board.forTesting(300);
        ar.edu.unrc.game2048.Board board16 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean17 = board16.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray18 = board16.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray19 = board16.getGrid();
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board21.setScore((int) (short) 1);
        int int24 = board21.getSize();
        boolean boolean25 = board21.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction26 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean27 = board21.move(direction26);
        boolean boolean28 = board16.move(direction26);
        ar.edu.unrc.game2048.Board board30 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean31 = board30.hasEmptyCells();
        board30.setScore(0);
        int int34 = board30.getSize();
        ar.edu.unrc.game2048.Board board36 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board36.setScore((int) (short) 1);
        boolean boolean39 = board36.isFull();
        ar.edu.unrc.game2048.Direction direction40 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean41 = board36.move(direction40);
        boolean boolean42 = board30.move(direction40);
        boolean boolean43 = board16.move(direction40);
        boolean boolean44 = board14.move(direction40);
        boolean boolean45 = position2.equals((java.lang.Object) board14);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertNotNull(cellArray11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(board14);
        org.junit.Assert.assertNotNull(board16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertNotNull(cellArray18);
        org.junit.Assert.assertNotNull(cellArray19);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 32 + "'", int24 == 32);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + direction26 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction26.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNotNull(board30);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 32 + "'", int34 == 32);
        org.junit.Assert.assertNotNull(board36);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertTrue("'" + direction40 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction40.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + false + "'", boolean44 == false);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        java.lang.String str3 = position2.toString();
        int int4 = position2.col;
        int int5 = position2.row;
        java.lang.String str6 = position2.toString();
        java.lang.String str7 = position2.toString();
        java.lang.String str8 = position2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(-1, 1)" + "'", str3, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1) + "'", int5 == (-1));
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "(-1, 1)" + "'", str6, "(-1, 1)");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "(-1, 1)" + "'", str7, "(-1, 1)");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "(-1, 1)" + "'", str8, "(-1, 1)");
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        ar.edu.unrc.game2048.Board board4 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board4.setScore((int) (short) 1);
        int int7 = board4.getSize();
        boolean boolean8 = board4.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction9 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean10 = board4.move(direction9);
        boolean boolean11 = board1.move(direction9);
        boolean boolean12 = board1.hasEmptyCells();
        int int13 = board1.getScore();
        boolean boolean14 = board1.isFull();
        int int15 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertNotNull(board4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 32 + "'", int7 == 32);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + direction9 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction9.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 0 + "'", int13 == 0);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        java.lang.String str3 = position2.toString();
        java.lang.String str4 = position2.toString();
        int int5 = position2.col;
        int int6 = position2.row;
        java.lang.String str7 = position2.toString();
        int int8 = position2.row;
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(-1, 1)" + "'", str3, "(-1, 1)");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + (-1) + "'", int6 == (-1));
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "(-1, 1)" + "'", str7, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + (-1) + "'", int8 == (-1));
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        int int3 = board1.getSize();
        boolean boolean4 = board1.isWinningBoard();
        int int5 = board1.getScore();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        ar.edu.unrc.game2048.Board board13 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board13.setScore((int) (short) 1);
        int int16 = board13.getSize();
        int int17 = board13.getSize();
        ar.edu.unrc.game2048.Cell cell20 = board13.getCell((int) (byte) 0, 0);
        board9.setCell(0, (int) (short) 1, cell20);
        board1.setCell((int) (byte) 1, (int) (short) 0, cell20);
        ar.edu.unrc.game2048.Board board26 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean27 = board26.hasEmptyCells();
        int int28 = board26.getSize();
        boolean boolean29 = board26.isWinningBoard();
        int int30 = board26.getScore();
        ar.edu.unrc.game2048.Board board34 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        ar.edu.unrc.game2048.Board board38 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board38.setScore((int) (short) 1);
        int int41 = board38.getSize();
        int int42 = board38.getSize();
        ar.edu.unrc.game2048.Cell cell45 = board38.getCell((int) (byte) 0, 0);
        board34.setCell(0, (int) (short) 1, cell45);
        board26.setCell((int) (byte) 1, (int) (short) 0, cell45);
        board1.setCell(10, (int) (short) 0, cell45);
        ar.edu.unrc.game2048.Direction direction49 = ar.edu.unrc.game2048.Direction.UP;
        boolean boolean50 = board1.move(direction49);
        boolean boolean51 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 32 + "'", int3 == 32);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertNotNull(board13);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 32 + "'", int16 == 32);
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 32 + "'", int17 == 32);
        org.junit.Assert.assertNotNull(cell20);
        org.junit.Assert.assertNotNull(board26);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 32 + "'", int28 == 32);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
        org.junit.Assert.assertNotNull(board34);
        org.junit.Assert.assertNotNull(board38);
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + 32 + "'", int41 == 32);
        org.junit.Assert.assertTrue("'" + int42 + "' != '" + 32 + "'", int42 == 32);
        org.junit.Assert.assertNotNull(cell45);
        org.junit.Assert.assertTrue("'" + direction49 + "' != '" + ar.edu.unrc.game2048.Direction.UP + "'", direction49.equals(ar.edu.unrc.game2048.Direction.UP));
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + false + "'", boolean50 == false);
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        boolean boolean18 = board1.isFull();
        board1.setScore(32);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        boolean boolean9 = board1.isFull();
        boolean boolean10 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        boolean boolean5 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction6 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean7 = board1.move(direction6);
        boolean boolean8 = board1.isWinningBoard();
        board1.setScore((int) (short) 100);
        board1.setScore(0);
        int int13 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + direction6 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction6.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        boolean boolean13 = board1.isLosingBoard();
        boolean boolean14 = board1.hasEmptyCells();
        int int15 = board1.getSize();
        boolean boolean16 = board1.hasEmptyCells();
        boolean boolean17 = board1.isWinningBoard();
        int int18 = board1.getSize();
        boolean boolean19 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean22 = board21.hasEmptyCells();
        board21.setScore(0);
        int int25 = board21.getSize();
        ar.edu.unrc.game2048.Board board27 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board27.setScore((int) (short) 1);
        boolean boolean30 = board27.isFull();
        ar.edu.unrc.game2048.Direction direction31 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean32 = board27.move(direction31);
        boolean boolean33 = board21.move(direction31);
        boolean boolean34 = board21.hasEmptyCells();
        ar.edu.unrc.game2048.Board board36 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean37 = board36.hasEmptyCells();
        int int38 = board36.getSize();
        boolean boolean39 = board36.isWinningBoard();
        int int40 = board36.getScore();
        ar.edu.unrc.game2048.Board board42 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board42.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board46 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board46.setScore((int) (short) 1);
        int int49 = board46.getSize();
        boolean boolean50 = board46.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction51 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean52 = board46.move(direction51);
        boolean boolean53 = board42.move(direction51);
        boolean boolean54 = board36.move(direction51);
        boolean boolean55 = board21.move(direction51);
        ar.edu.unrc.game2048.Board board57 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board57.setScore((int) (short) 1);
        int int60 = board57.getScore();
        board57.setScore((int) (short) 0);
        boolean boolean63 = board57.isLosingBoard();
        ar.edu.unrc.game2048.Board board65 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean66 = board65.hasEmptyCells();
        board65.setScore(0);
        int int69 = board65.getSize();
        ar.edu.unrc.game2048.Board board71 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board71.setScore((int) (short) 1);
        boolean boolean74 = board71.isFull();
        ar.edu.unrc.game2048.Direction direction75 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean76 = board71.move(direction75);
        boolean boolean77 = board65.move(direction75);
        boolean boolean78 = board57.move(direction75);
        boolean boolean79 = board21.equals((java.lang.Object) boolean78);
        boolean boolean80 = board1.equals((java.lang.Object) boolean78);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 32 + "'", int18 == 32);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 32 + "'", int25 == 32);
        org.junit.Assert.assertNotNull(board27);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + direction31 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction31.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertNotNull(board36);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + true + "'", boolean37 == true);
        org.junit.Assert.assertTrue("'" + int38 + "' != '" + 32 + "'", int38 == 32);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertTrue("'" + int40 + "' != '" + 0 + "'", int40 == 0);
        org.junit.Assert.assertNotNull(board42);
        org.junit.Assert.assertNotNull(board46);
        org.junit.Assert.assertTrue("'" + int49 + "' != '" + 32 + "'", int49 == 32);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + false + "'", boolean50 == false);
        org.junit.Assert.assertTrue("'" + direction51 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction51.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + false + "'", boolean55 == false);
        org.junit.Assert.assertNotNull(board57);
        org.junit.Assert.assertTrue("'" + int60 + "' != '" + 1 + "'", int60 == 1);
        org.junit.Assert.assertTrue("'" + boolean63 + "' != '" + false + "'", boolean63 == false);
        org.junit.Assert.assertNotNull(board65);
        org.junit.Assert.assertTrue("'" + boolean66 + "' != '" + true + "'", boolean66 == true);
        org.junit.Assert.assertTrue("'" + int69 + "' != '" + 32 + "'", int69 == 32);
        org.junit.Assert.assertNotNull(board71);
        org.junit.Assert.assertTrue("'" + boolean74 + "' != '" + false + "'", boolean74 == false);
        org.junit.Assert.assertTrue("'" + direction75 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction75.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean76 + "' != '" + false + "'", boolean76 == false);
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + false + "'", boolean77 == false);
        org.junit.Assert.assertTrue("'" + boolean78 + "' != '" + false + "'", boolean78 == false);
        org.junit.Assert.assertTrue("'" + boolean79 + "' != '" + false + "'", boolean79 == false);
        org.junit.Assert.assertTrue("'" + boolean80 + "' != '" + false + "'", boolean80 == false);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        boolean boolean9 = board1.isFull();
        board1.setScore((int) '#');
        boolean boolean12 = board1.isWinningBoard();
        boolean boolean13 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.col;
        java.lang.String str4 = position2.toString();
        int int5 = position2.row;
        java.lang.String str6 = position2.toString();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1) + "'", int5 == (-1));
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "(-1, 1)" + "'", str6, "(-1, 1)");
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        boolean boolean3 = board1.isFull();
        boolean boolean4 = board1.isLosingBoard();
        boolean boolean5 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int21 = board20.getSize();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board23.setScore((int) (short) 1);
        int int26 = board23.getSize();
        boolean boolean27 = board23.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction28 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean29 = board23.move(direction28);
        boolean boolean30 = board20.move(direction28);
        boolean boolean31 = board20.isLosingBoard();
        boolean boolean32 = board1.equals((java.lang.Object) board20);
        int int33 = board20.getSize();
        ar.edu.unrc.game2048.Board board35 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean36 = board35.hasEmptyCells();
        board35.setScore(0);
        int int39 = board35.getSize();
        board35.setScore(2048);
        ar.edu.unrc.game2048.Board board43 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board43.setScore((int) (short) 1);
        int int46 = board43.getSize();
        int int47 = board43.getSize();
        ar.edu.unrc.game2048.Cell cell50 = board43.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board52 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board52.setScore((int) (short) 1);
        int int55 = board52.getSize();
        boolean boolean56 = board52.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction57 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean58 = board52.move(direction57);
        boolean boolean59 = board43.move(direction57);
        boolean boolean60 = board43.isFull();
        boolean boolean61 = board35.equals((java.lang.Object) board43);
        boolean boolean62 = board20.equals((java.lang.Object) board43);
        int int63 = board43.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 32 + "'", int21 == 32);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + direction28 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction28.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + int33 + "' != '" + 32 + "'", int33 == 32);
        org.junit.Assert.assertNotNull(board35);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        org.junit.Assert.assertTrue("'" + int39 + "' != '" + 32 + "'", int39 == 32);
        org.junit.Assert.assertNotNull(board43);
        org.junit.Assert.assertTrue("'" + int46 + "' != '" + 32 + "'", int46 == 32);
        org.junit.Assert.assertTrue("'" + int47 + "' != '" + 32 + "'", int47 == 32);
        org.junit.Assert.assertNotNull(cell50);
        org.junit.Assert.assertNotNull(board52);
        org.junit.Assert.assertTrue("'" + int55 + "' != '" + 32 + "'", int55 == 32);
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertTrue("'" + direction57 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction57.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean58 + "' != '" + false + "'", boolean58 == false);
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + false + "'", boolean59 == false);
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + false + "'", boolean60 == false);
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + false + "'", boolean61 == false);
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + false + "'", boolean62 == false);
        org.junit.Assert.assertTrue("'" + int63 + "' != '" + 1 + "'", int63 == 1);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        ar.edu.unrc.game2048.Board board15 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean16 = board15.hasEmptyCells();
        board15.setScore(0);
        int int19 = board15.getSize();
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board21.setScore((int) (short) 1);
        boolean boolean24 = board21.isFull();
        ar.edu.unrc.game2048.Direction direction25 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean26 = board21.move(direction25);
        boolean boolean27 = board15.move(direction25);
        boolean boolean28 = board1.move(direction25);
        int int29 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(board15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 32 + "'", int19 == 32);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + direction25 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction25.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + 0 + "'", int29 == 0);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        board1.setScore(0);
        int int5 = board1.getSize();
        board1.setScore(2048);
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board9.setScore((int) (short) 1);
        int int12 = board9.getSize();
        int int13 = board9.getSize();
        ar.edu.unrc.game2048.Cell cell16 = board9.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board18 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board18.setScore((int) (short) 1);
        int int21 = board18.getSize();
        boolean boolean22 = board18.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction23 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean24 = board18.move(direction23);
        boolean boolean25 = board9.move(direction23);
        boolean boolean26 = board9.isFull();
        boolean boolean27 = board1.equals((java.lang.Object) board9);
        boolean boolean28 = board1.hasEmptyCells();
        boolean boolean29 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 32 + "'", int12 == 32);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertNotNull(cell16);
        org.junit.Assert.assertNotNull(board18);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 32 + "'", int21 == 32);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + direction23 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction23.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + true + "'", boolean28 == true);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean7 = board6.hasEmptyCells();
        board6.setScore(0);
        int int10 = board6.getSize();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        boolean boolean15 = board12.isFull();
        ar.edu.unrc.game2048.Direction direction16 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean17 = board12.move(direction16);
        boolean boolean18 = board6.move(direction16);
        boolean boolean19 = board6.hasEmptyCells();
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean22 = board21.hasEmptyCells();
        int int23 = board21.getSize();
        boolean boolean24 = board21.isWinningBoard();
        int int25 = board21.getScore();
        ar.edu.unrc.game2048.Board board27 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board27.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board31 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board31.setScore((int) (short) 1);
        int int34 = board31.getSize();
        boolean boolean35 = board31.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction36 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean37 = board31.move(direction36);
        boolean boolean38 = board27.move(direction36);
        boolean boolean39 = board21.move(direction36);
        boolean boolean40 = board6.move(direction36);
        boolean boolean41 = board1.move(direction36);
        int int42 = board1.getScore();
        int int43 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 32 + "'", int10 == 32);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + direction16 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction16.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + 32 + "'", int23 == 32);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + int25 + "' != '" + 0 + "'", int25 == 0);
        org.junit.Assert.assertNotNull(board27);
        org.junit.Assert.assertNotNull(board31);
        org.junit.Assert.assertTrue("'" + int34 + "' != '" + 32 + "'", int34 == 32);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + direction36 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction36.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + int42 + "' != '" + 1 + "'", int42 == 1);
        org.junit.Assert.assertTrue("'" + int43 + "' != '" + 1 + "'", int43 == 1);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (byte) 10, (int) (byte) 10);
        boolean boolean4 = position2.equals((java.lang.Object) 0.0d);
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board6.move(direction15);
        int int18 = board6.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray19 = board6.getGrid();
        boolean boolean20 = position2.equals((java.lang.Object) board6);
        int int21 = position2.col;
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 32 + "'", int18 == 32);
        org.junit.Assert.assertNotNull(cellArray19);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 10 + "'", int21 == 10);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getScore();
        board1.setScore((int) (short) 0);
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board8.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        boolean boolean16 = board12.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction17 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean18 = board12.move(direction17);
        boolean boolean19 = board8.move(direction17);
        int int20 = board8.getSize();
        ar.edu.unrc.game2048.Cell cell23 = board8.getCell(10, (int) (byte) 10);
        ar.edu.unrc.game2048.Board board25 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board25.setScore((int) (short) 1);
        int int28 = board25.getSize();
        boolean boolean29 = board25.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction30 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean31 = board25.move(direction30);
        boolean boolean32 = board8.move(direction30);
        boolean boolean33 = board1.move(direction30);
        ar.edu.unrc.game2048.Board board37 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board37.setScore((int) (short) 1);
        int int40 = board37.getSize();
        int int41 = board37.getSize();
        ar.edu.unrc.game2048.Cell cell44 = board37.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board48 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board48.setScore((int) (short) 1);
        int int51 = board48.getScore();
        board48.setScore((int) (short) 0);
        boolean boolean54 = board48.isLosingBoard();
        ar.edu.unrc.game2048.Cell cell57 = board48.getCell(10, 0);
        board37.setCell((int) (byte) 0, (int) (short) 10, cell57);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) -1, (int) (byte) 0, cell57);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (-1, 0) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + direction17 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction17.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + 32 + "'", int20 == 32);
        org.junit.Assert.assertNotNull(cell23);
        org.junit.Assert.assertNotNull(board25);
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 32 + "'", int28 == 32);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + direction30 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction30.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
        org.junit.Assert.assertNotNull(board37);
        org.junit.Assert.assertTrue("'" + int40 + "' != '" + 32 + "'", int40 == 32);
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + 32 + "'", int41 == 32);
        org.junit.Assert.assertNotNull(cell44);
        org.junit.Assert.assertNotNull(board48);
        org.junit.Assert.assertTrue("'" + int51 + "' != '" + 1 + "'", int51 == 1);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertNotNull(cell57);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.col;
        java.lang.String str4 = position2.toString();
        int int5 = position2.col;
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean8 = board7.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board7.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board7.getGrid();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        boolean boolean16 = board12.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction17 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean18 = board12.move(direction17);
        boolean boolean19 = board7.move(direction17);
        boolean boolean20 = board7.isLosingBoard();
        boolean boolean21 = board7.isLosingBoard();
        board7.setScore(4);
        boolean boolean24 = position2.equals((java.lang.Object) board7);
        ar.edu.unrc.game2048.Board board28 = ar.edu.unrc.game2048.Board.forTesting(300);
        ar.edu.unrc.game2048.Cell cell31 = board28.getCell((int) '#', 4);
        // The following exception was thrown during execution in test generation
        try {
            board7.setCell(35, 1, cell31);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (35, 1) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + direction17 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction17.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(board28);
        org.junit.Assert.assertNotNull(cell31);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isLosingBoard();
        boolean boolean16 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray17 = board1.getGrid();
        boolean boolean18 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board20.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board24 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board24.setScore((int) (short) 1);
        int int27 = board24.getSize();
        boolean boolean28 = board24.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction29 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean30 = board24.move(direction29);
        boolean boolean31 = board20.move(direction29);
        boolean boolean32 = board20.isLosingBoard();
        boolean boolean33 = board20.hasEmptyCells();
        boolean boolean34 = board20.hasEmptyCells();
        boolean boolean35 = board1.equals((java.lang.Object) board20);
        ar.edu.unrc.game2048.Board board37 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board37.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board41 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board41.setScore((int) (short) 1);
        int int44 = board41.getSize();
        boolean boolean45 = board41.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction46 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean47 = board41.move(direction46);
        boolean boolean48 = board37.move(direction46);
        int int49 = board37.getSize();
        int int50 = board37.getScore();
        ar.edu.unrc.game2048.Direction direction51 = ar.edu.unrc.game2048.Direction.LEFT;
        boolean boolean52 = board37.move(direction51);
        boolean boolean53 = board20.move(direction51);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertNotNull(cellArray17);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertNotNull(board24);
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + 32 + "'", int27 == 32);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + direction29 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction29.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + true + "'", boolean34 == true);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(board37);
        org.junit.Assert.assertNotNull(board41);
        org.junit.Assert.assertTrue("'" + int44 + "' != '" + 32 + "'", int44 == 32);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertTrue("'" + direction46 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction46.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + false + "'", boolean48 == false);
        org.junit.Assert.assertTrue("'" + int49 + "' != '" + 32 + "'", int49 == 32);
        org.junit.Assert.assertTrue("'" + int50 + "' != '" + 1 + "'", int50 == 1);
        org.junit.Assert.assertTrue("'" + direction51 + "' != '" + ar.edu.unrc.game2048.Direction.LEFT + "'", direction51.equals(ar.edu.unrc.game2048.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(97);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        boolean boolean3 = board1.isFull();
        boolean boolean4 = board1.isLosingBoard();
        int int5 = board1.getSize();
        boolean boolean6 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board6.setScore((int) (short) 1);
        int int9 = board6.getSize();
        boolean boolean10 = board6.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction11 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean12 = board6.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        boolean boolean15 = board1.isLosingBoard();
        board1.setScore(4);
        board1.setScore(4);
        boolean boolean20 = board1.hasEmptyCells();
        int int21 = board1.getScore();
        int int22 = board1.getSize();
        boolean boolean23 = board1.hasEmptyCells();
        boolean boolean24 = board1.hasEmptyCells();
        boolean boolean25 = board1.hasEmptyCells();
        int int26 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(cellArray3);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 32 + "'", int9 == 32);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 4 + "'", int21 == 4);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 32 + "'", int22 == 32);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        int int3 = board1.getSize();
        boolean boolean4 = board1.isWinningBoard();
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 32 + "'", int3 == 32);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int2 = board1.getSize();
        ar.edu.unrc.game2048.Board board4 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board4.setScore((int) (short) 1);
        int int7 = board4.getSize();
        boolean boolean8 = board4.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction9 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean10 = board4.move(direction9);
        boolean boolean11 = board1.move(direction9);
        boolean boolean13 = board1.equals((java.lang.Object) (byte) 100);
        ar.edu.unrc.game2048.Board board17 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board21.setScore((int) (short) 1);
        int int24 = board21.getScore();
        board21.setScore((int) (short) 0);
        boolean boolean27 = board21.isLosingBoard();
        ar.edu.unrc.game2048.Cell cell30 = board21.getCell(10, 0);
        board17.setCell(10, (int) (byte) 1, cell30);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (byte) 100, 35, cell30);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Position (100, 35) is outside the 32x32 board");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 32 + "'", int2 == 32);
        org.junit.Assert.assertNotNull(board4);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 32 + "'", int7 == 32);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + direction9 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction9.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(board17);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + 1 + "'", int24 == 1);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertNotNull(cell30);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        boolean boolean4 = board1.isFull();
        ar.edu.unrc.game2048.Direction direction5 = ar.edu.unrc.game2048.Direction.DOWN;
        boolean boolean6 = board1.move(direction5);
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet7 = board1.getEmptyPositions();
        boolean boolean8 = board1.isFull();
        boolean boolean9 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Direction.DOWN + "'", direction5.equals(ar.edu.unrc.game2048.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(positionSet7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test257");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board5.setScore((int) (short) 1);
        int int8 = board5.getSize();
        boolean boolean9 = board5.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction10 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean11 = board5.move(direction10);
        boolean boolean12 = board1.move(direction10);
        int int13 = board1.getSize();
        int int14 = board1.getScore();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.LEFT;
        boolean boolean16 = board1.move(direction15);
        ar.edu.unrc.game2048.Board board18 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean19 = board18.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray20 = board18.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray21 = board18.getGrid();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board23.setScore((int) (short) 1);
        int int26 = board23.getSize();
        boolean boolean27 = board23.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction28 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean29 = board23.move(direction28);
        boolean boolean30 = board18.move(direction28);
        boolean boolean31 = board18.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray32 = board18.getGrid();
        java.util.Set<ar.edu.unrc.game2048.Position> positionSet33 = board18.getEmptyPositions();
        boolean boolean34 = board1.equals((java.lang.Object) positionSet33);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 32 + "'", int8 == 32);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + direction10 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction10.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 1 + "'", int14 == 1);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.LEFT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(board18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertNotNull(cellArray20);
        org.junit.Assert.assertNotNull(cellArray21);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + direction28 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction28.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNotNull(cellArray32);
        org.junit.Assert.assertNotNull(positionSet33);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test258");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 0, 0);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board10.setScore((int) (short) 1);
        int int13 = board10.getSize();
        boolean boolean14 = board10.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction15 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean16 = board10.move(direction15);
        boolean boolean17 = board1.move(direction15);
        int int18 = board1.getScore();
        ar.edu.unrc.game2048.Board board20 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        int int21 = board20.getSize();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board23.setScore((int) (short) 1);
        int int26 = board23.getSize();
        boolean boolean27 = board23.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction28 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean29 = board23.move(direction28);
        boolean boolean30 = board20.move(direction28);
        boolean boolean31 = board20.isLosingBoard();
        boolean boolean32 = board1.equals((java.lang.Object) board20);
        java.lang.Class<?> wildcardClass33 = board20.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + 32 + "'", int13 == 32);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + direction15 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction15.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 1 + "'", int18 == 1);
        org.junit.Assert.assertNotNull(board20);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 32 + "'", int21 == 32);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + 32 + "'", int26 == 32);
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + direction28 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction28.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(wildcardClass33);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test259");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) 100, 0);
        int int3 = position2.row;
        int int4 = position2.col;
        int int5 = position2.row;
        java.lang.String str6 = position2.toString();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "(100, 0)" + "'", str6, "(100, 0)");
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test260");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getScore();
        board1.setScore((int) (short) 0);
        boolean boolean7 = board1.isLosingBoard();
        board1.setScore(32);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test261");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(35);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test262");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.col;
        java.lang.String str4 = position2.toString();
        int int5 = position2.col;
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean8 = board7.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray9 = board7.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board7.getGrid();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board12.setScore((int) (short) 1);
        int int15 = board12.getSize();
        boolean boolean16 = board12.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction17 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean18 = board12.move(direction17);
        boolean boolean19 = board7.move(direction17);
        boolean boolean20 = board7.isLosingBoard();
        boolean boolean21 = board7.isLosingBoard();
        board7.setScore(4);
        boolean boolean24 = position2.equals((java.lang.Object) board7);
        boolean boolean25 = board7.isWinningBoard();
        boolean boolean26 = board7.hasEmptyCells();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 1 + "'", int5 == 1);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(cellArray9);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 32 + "'", int15 == 32);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + direction17 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction17.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + true + "'", boolean26 == true);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test263");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) 0, (int) (byte) 1);
        int int3 = position2.row;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test264");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board1.setScore((int) (short) 1);
        int int4 = board1.getSize();
        int int5 = board1.getSize();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 32 + "'", int4 == 32);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 32 + "'", int5 == 32);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test265");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position(32, (int) (byte) 100);
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test266");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        int int3 = position2.col;
        java.lang.String str4 = position2.toString();
        int int5 = position2.row;
        int int6 = position2.row;
        int int7 = position2.row;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(-1, 1)" + "'", str4, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1) + "'", int5 == (-1));
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + (-1) + "'", int6 == (-1));
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test267");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.hasEmptyCells();
        int int3 = board1.getSize();
        boolean boolean4 = board1.isWinningBoard();
        int int5 = board1.getScore();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board7.setScore((int) (short) 1);
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board11.setScore((int) (short) 1);
        int int14 = board11.getSize();
        boolean boolean15 = board11.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction16 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean17 = board11.move(direction16);
        boolean boolean18 = board7.move(direction16);
        boolean boolean19 = board1.move(direction16);
        boolean boolean20 = board1.isFull();
        boolean boolean21 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board board23 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean24 = board23.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray25 = board23.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray26 = board23.getGrid();
        ar.edu.unrc.game2048.Board board28 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        board28.setScore((int) (short) 1);
        int int31 = board28.getSize();
        boolean boolean32 = board28.isLosingBoard();
        ar.edu.unrc.game2048.Direction direction33 = ar.edu.unrc.game2048.Direction.RIGHT;
        boolean boolean34 = board28.move(direction33);
        boolean boolean35 = board23.move(direction33);
        boolean boolean36 = board1.move(direction33);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 32 + "'", int3 == 32);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 32 + "'", int14 == 32);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + direction16 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction16.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(board23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertNotNull(cellArray25);
        org.junit.Assert.assertNotNull(cellArray26);
        org.junit.Assert.assertNotNull(board28);
        org.junit.Assert.assertTrue("'" + int31 + "' != '" + 32 + "'", int31 == 32);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertTrue("'" + direction33 + "' != '" + ar.edu.unrc.game2048.Direction.RIGHT + "'", direction33.equals(ar.edu.unrc.game2048.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test268");
        ar.edu.unrc.game2048.Position position2 = new ar.edu.unrc.game2048.Position((int) (short) -1, (int) (byte) 1);
        boolean boolean4 = position2.equals((java.lang.Object) 0.0f);
        boolean boolean6 = position2.equals((java.lang.Object) 0L);
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean9 = board8.hasEmptyCells();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board8.getGrid();
        ar.edu.unrc.game2048.Cell[][] cellArray11 = board8.getGrid();
        boolean boolean12 = position2.equals((java.lang.Object) cellArray11);
        java.lang.String str13 = position2.toString();
        int int14 = position2.col;
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(cellArray10);
        org.junit.Assert.assertNotNull(cellArray11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "(-1, 1)" + "'", str13, "(-1, 1)");
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + 1 + "'", int14 == 1);
    }
}

