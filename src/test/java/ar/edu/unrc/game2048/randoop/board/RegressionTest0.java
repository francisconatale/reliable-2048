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
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Board size must be positive: 0");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        int int0 = ar.edu.unrc.game2048.Board.WINNING_VALUE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2048 + "'", int0 == 2048);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        ar.edu.unrc.game2048.Board.Direction direction0 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        java.lang.Class<?> wildcardClass1 = direction0.getClass();
        org.junit.Assert.assertTrue("'" + direction0 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction0.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
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
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell cell5 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 0, 10, cell5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell cannot be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Class<?> wildcardClass4 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        ar.edu.unrc.game2048.Cell cell6 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(10, 100, cell6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell cannot be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet2 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell5 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((-1), 10, cell5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell cannot be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(positionSet2);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        ar.edu.unrc.game2048.Board.Direction direction0 = ar.edu.unrc.game2048.Board.Direction.UP;
        java.lang.Class<?> wildcardClass1 = direction0.getClass();
        org.junit.Assert.assertTrue("'" + direction0 + "' != '" + ar.edu.unrc.game2048.Board.Direction.UP + "'", direction0.equals(ar.edu.unrc.game2048.Board.Direction.UP));
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        ar.edu.unrc.game2048.Cell cell6 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) 'a', (int) (short) 0, cell6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell cannot be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        ar.edu.unrc.game2048.Cell cell8 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 100, (int) (short) -1, cell8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cell cannot be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        int int3 = board1.getScore();
        java.lang.Class<?> wildcardClass4 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (byte) 100, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        int int3 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider5 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (byte) 100, (int) (byte) 0);
        boolean boolean4 = position2.equals((java.lang.Object) 2048);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (byte) 100, (int) (byte) 0);
        int int3 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean8 = board7.isWinningBoard();
        board7.setScore(4);
        ar.edu.unrc.game2048.Cell cell13 = board7.getCell((int) (byte) 1, 4);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 100, (int) '4', cell13);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(cell13);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) (byte) 1, 4);
        java.lang.Class<?> wildcardClass8 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider6 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        board1.setScore((int) 'a');
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean8 = board7.isWinningBoard();
        board7.setScore(4);
        ar.edu.unrc.game2048.Cell cell13 = board7.getCell((int) (byte) 1, 4);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(2048, (int) 'a', cell13);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 2048");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(cell13);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        boolean boolean5 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isFull();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean7 = board6.isWinningBoard();
        board6.setScore(4);
        ar.edu.unrc.game2048.Cell cell12 = board6.getCell((int) (byte) 1, 4);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (byte) 100, (int) '4', cell12);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(cell12);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        board1.setScore((int) 'a');
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet4 = board1.getEmptyPositions();
        int int5 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(positionSet4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean7 = board6.isWinningBoard();
        board6.setScore(4);
        ar.edu.unrc.game2048.Cell cell12 = board6.getCell((int) (byte) 1, 4);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) -1, 0, cell12);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(cell12);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        java.lang.String str3 = position2.toString();
        int int4 = position2.row;
        int int5 = position2.row;
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(100, 1)" + "'", str3, "(100, 1)");
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 100 + "'", int4 == 100);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        boolean boolean4 = board1.hasEmptyCells();
        int int5 = board1.getSize();
        java.lang.Class<?> wildcardClass6 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(10);
        java.lang.Class<?> wildcardClass2 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        int int3 = board1.getScore();
        boolean boolean4 = board1.isFull();
        java.lang.Class<?> wildcardClass5 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isLosingBoard();
        int int5 = board1.getSize();
        int int6 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 100 + "'", int6 == 100);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean7 = board6.isWinningBoard();
        board6.setScore(4);
        ar.edu.unrc.game2048.Cell cell12 = board6.getCell((int) (byte) 1, 4);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(2048, (int) ' ', cell12);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 2048");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(cell12);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        board1.setScore((int) (byte) 0);
        boolean boolean8 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        int int3 = board1.getScore();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean9 = board8.isWinningBoard();
        board8.setScore(4);
        ar.edu.unrc.game2048.Cell cell14 = board8.getCell((int) (byte) 1, 4);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(100, 10, cell14);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(cell14);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '4');
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        int int5 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) (byte) 1, 4);
        boolean boolean8 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting(100);
        board10.setScore((int) 'a');
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet13 = board10.getEmptyPositions();
        boolean boolean14 = board1.equals((java.lang.Object) positionSet13);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell17 = board1.getCell((-1), (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        boolean boolean6 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board.Direction direction7 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean8 = board1.move(direction7);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell11 = board1.getCell(2048, (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 2048");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + direction7 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction7.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        int int3 = board1.getScore();
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider4 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        int int3 = position2.row;
        java.lang.String str4 = position2.toString();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(100, 1)" + "'", str4, "(100, 1)");
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(4);
        boolean boolean2 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (short) 1);
        ar.edu.unrc.game2048.Cell[][] cellArray2 = board1.getGrid();
        int int3 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cellArray2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.isWinningBoard();
        boolean boolean3 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction4 = ar.edu.unrc.game2048.Board.Direction.LEFT;
        boolean boolean5 = board1.move(direction4);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet6 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell[][] cellArray7 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + direction4 + "' != '" + ar.edu.unrc.game2048.Board.Direction.LEFT + "'", direction4.equals(ar.edu.unrc.game2048.Board.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(cellArray7);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        int int6 = board1.getScore();
        int int7 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (short) 1);
        ar.edu.unrc.game2048.Cell[][] cellArray2 = board1.getGrid();
        ar.edu.unrc.game2048.Board.Direction direction3 = ar.edu.unrc.game2048.Board.Direction.UP;
        boolean boolean4 = board1.move(direction3);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cellArray2);
        org.junit.Assert.assertTrue("'" + direction3 + "' != '" + ar.edu.unrc.game2048.Board.Direction.UP + "'", direction3.equals(ar.edu.unrc.game2048.Board.Direction.UP));
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board.Position position8 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        java.lang.String str9 = position8.toString();
        java.lang.Object obj10 = null;
        boolean boolean11 = position8.equals(obj10);
        ar.edu.unrc.game2048.Board board13 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean14 = position8.equals((java.lang.Object) 100);
        boolean boolean15 = board1.equals((java.lang.Object) 100);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "(100, 1)" + "'", str9, "(100, 1)");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(board13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Board.Direction direction5 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean6 = board1.move(direction5);
        boolean boolean7 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction5.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        boolean boolean4 = board1.hasEmptyCells();
        boolean boolean5 = board1.isWinningBoard();
        board1.setScore((int) (byte) 10);
        boolean boolean8 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isLosingBoard();
        boolean boolean7 = board1.isWinningBoard();
        board1.setScore((int) (short) 100);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        boolean boolean6 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        int int5 = board1.getSize();
        int int6 = board1.getSize();
        java.lang.Class<?> wildcardClass7 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 100 + "'", int6 == 100);
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) (byte) 1, 4);
        boolean boolean8 = board1.hasEmptyCells();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell11 = board1.getCell(2048, (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 2048");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction4 = ar.edu.unrc.game2048.Board.Direction.LEFT;
        boolean boolean5 = board1.move(direction4);
        int int6 = board1.getSize();
        boolean boolean7 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + direction4 + "' != '" + ar.edu.unrc.game2048.Board.Direction.LEFT + "'", direction4.equals(ar.edu.unrc.game2048.Board.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 100 + "'", int6 == 100);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 1, 0);
        java.lang.Class<?> wildcardClass3 = position2.getClass();
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.isWinningBoard();
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider6 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        int int2 = board1.getScore();
        ar.edu.unrc.game2048.Board.Direction direction3 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean4 = board1.move(direction3);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + direction3 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction3.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Board.Direction direction5 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean6 = board1.move(direction5);
        boolean boolean7 = board1.isFull();
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider8 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction5.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean8 = board7.isWinningBoard();
        board7.setScore(4);
        ar.edu.unrc.game2048.Board.Direction direction11 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean12 = board7.move(direction11);
        boolean boolean13 = board1.move(direction11);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet14 = board1.getEmptyPositions();
        java.lang.Class<?> wildcardClass15 = positionSet14.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(positionSet14);
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.hasEmptyCells();
        boolean boolean8 = board1.isLosingBoard();
        boolean boolean9 = board1.isWinningBoard();
        boolean boolean10 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(cellArray5);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction4 = ar.edu.unrc.game2048.Board.Direction.LEFT;
        boolean boolean5 = board1.move(direction4);
        int int6 = board1.getSize();
        boolean boolean7 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + direction4 + "' != '" + ar.edu.unrc.game2048.Board.Direction.LEFT + "'", direction4.equals(ar.edu.unrc.game2048.Board.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 100 + "'", int6 == 100);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isLosingBoard();
        boolean boolean7 = board1.isWinningBoard();
        java.lang.Class<?> wildcardClass8 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        int int3 = board1.getScore();
        int int4 = board1.getScore();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertNotNull(cellArray5);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        ar.edu.unrc.game2048.Board.Direction direction6 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean7 = board1.move(direction6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: direction no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isLosingBoard();
        boolean boolean7 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean7 = board6.isLosingBoard();
        boolean boolean8 = board6.isLosingBoard();
        int int9 = board6.getScore();
        boolean boolean10 = board1.equals((java.lang.Object) board6);
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider11 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider11);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 0 + "'", int9 == 0);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        java.lang.String str3 = position2.toString();
        java.lang.Object obj4 = null;
        boolean boolean5 = position2.equals(obj4);
        java.lang.String str6 = position2.toString();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean10 = board8.equals((java.lang.Object) "hi!");
        boolean boolean11 = board8.isWinningBoard();
        boolean boolean12 = position2.equals((java.lang.Object) board8);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(100, 1)" + "'", str3, "(100, 1)");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "(100, 1)" + "'", str6, "(100, 1)");
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        boolean boolean2 = board1.isWinningBoard();
        boolean boolean3 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Board.Direction direction5 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean6 = board1.move(direction5);
        boolean boolean7 = board1.isFull();
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean12 = board11.isWinningBoard();
        board11.setScore(4);
        ar.edu.unrc.game2048.Cell cell17 = board11.getCell((int) (byte) 1, 4);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 10, (int) (short) 100, cell17);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction5.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(cell17);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (short) 1);
        ar.edu.unrc.game2048.Cell[][] cellArray2 = board1.getGrid();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean8 = board6.equals((java.lang.Object) "hi!");
        boolean boolean9 = board6.isLosingBoard();
        int int10 = board6.getScore();
        ar.edu.unrc.game2048.Cell cell13 = board6.getCell((int) 'a', (int) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell(4, (int) (byte) 1, cell13);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 4");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cellArray2);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(cell13);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(4, (int) (byte) 0);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (int) (short) -1);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (byte) 10, (int) 'a');
        int int3 = position2.col;
        int int4 = position2.col;
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 97 + "'", int3 == 97);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 97 + "'", int4 == 97);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet3 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(positionSet3);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (byte) 10, (int) 'a');
        java.lang.String str3 = position2.toString();
        java.lang.Object obj4 = null;
        boolean boolean5 = position2.equals(obj4);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(10, 97)" + "'", str3, "(10, 97)");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isLosingBoard();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board.Direction direction6 = ar.edu.unrc.game2048.Board.Direction.LEFT;
        boolean boolean7 = board1.move(direction6);
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean10 = board9.isWinningBoard();
        board9.setScore(4);
        ar.edu.unrc.game2048.Board.Direction direction13 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean14 = board9.move(direction13);
        boolean boolean15 = board1.move(direction13);
        boolean boolean16 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertTrue("'" + direction6 + "' != '" + ar.edu.unrc.game2048.Board.Direction.LEFT + "'", direction6.equals(ar.edu.unrc.game2048.Board.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction13 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction13.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        boolean boolean4 = board1.hasEmptyCells();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider6 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) (byte) 1, 4);
        boolean boolean8 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting(100);
        board10.setScore((int) 'a');
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet13 = board10.getEmptyPositions();
        boolean boolean14 = board1.equals((java.lang.Object) positionSet13);
        boolean boolean15 = board1.isWinningBoard();
        boolean boolean16 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        board1.setScore((int) 'a');
        board1.setScore((int) ' ');
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        java.lang.Class<?> wildcardClass3 = position2.getClass();
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        int int6 = board1.getScore();
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider7 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isLosingBoard();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Cell[][] cellArray6 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertNotNull(cellArray6);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(100, 4);
        java.lang.String str3 = position2.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(100, 4)" + "'", str3, "(100, 4)");
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        java.lang.String str3 = position2.toString();
        java.lang.Object obj4 = null;
        boolean boolean5 = position2.equals(obj4);
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean8 = position2.equals((java.lang.Object) 100);
        int int9 = position2.row;
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(100, 1)" + "'", str3, "(100, 1)");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 100 + "'", int9 == 100);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isLosingBoard();
        int int5 = board1.getScore();
        boolean boolean7 = board1.equals((java.lang.Object) (byte) 0);
        boolean boolean8 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) ' ');
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider2 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isLosingBoard();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board.Direction direction6 = ar.edu.unrc.game2048.Board.Direction.LEFT;
        boolean boolean7 = board1.move(direction6);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell10 = board1.getCell(2048, 2048);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 2048");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertTrue("'" + direction6 + "' != '" + ar.edu.unrc.game2048.Board.Direction.LEFT + "'", direction6.equals(ar.edu.unrc.game2048.Board.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        int int6 = board1.getScore();
        board1.setScore((int) (byte) 100);
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting((int) (short) 100);
        boolean boolean13 = board12.isWinningBoard();
        ar.edu.unrc.game2048.Board board17 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean19 = board17.equals((java.lang.Object) "hi!");
        boolean boolean20 = board17.isLosingBoard();
        int int21 = board17.getScore();
        ar.edu.unrc.game2048.Cell cell24 = board17.getCell((int) 'a', (int) (byte) 0);
        board12.setCell((int) ' ', (int) ' ', cell24);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (byte) -1, 4, cell24);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(board17);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + 0 + "'", int21 == 0);
        org.junit.Assert.assertNotNull(cell24);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 1, 0);
        int int3 = position2.row;
        java.lang.String str4 = position2.toString();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(1, 0)" + "'", str4, "(1, 0)");
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.hasEmptyCells();
        boolean boolean3 = board1.isFull();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell6 = board1.getCell(2048, (int) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 2048");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        board1.setScore((int) (byte) 0);
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider8 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        java.lang.String str3 = position2.toString();
        java.lang.Object obj4 = null;
        boolean boolean5 = position2.equals(obj4);
        java.lang.String str6 = position2.toString();
        int int7 = position2.col;
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(100, 1)" + "'", str3, "(100, 1)");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "(100, 1)" + "'", str6, "(100, 1)");
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 1 + "'", int7 == 1);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isLosingBoard();
        int int5 = board1.getScore();
        ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) 'a', (int) (byte) 0);
        boolean boolean9 = board1.isFull();
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider10 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNotNull(cell8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isLosingBoard();
        int int5 = board1.getScore();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell8 = board1.getCell((int) (short) 1, (int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: -1");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        int int6 = board1.getScore();
        board1.setScore((int) (byte) 100);
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean12 = board10.equals((java.lang.Object) "hi!");
        java.lang.Object obj13 = null;
        boolean boolean14 = board10.equals(obj13);
        boolean boolean15 = board10.isWinningBoard();
        boolean boolean16 = board10.hasEmptyCells();
        boolean boolean17 = board10.isLosingBoard();
        boolean boolean18 = board10.hasEmptyCells();
        int int19 = board10.getSize();
        boolean boolean20 = board1.equals((java.lang.Object) board10);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 100 + "'", int19 == 100);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isLosingBoard();
        boolean boolean7 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet6 = board1.getEmptyPositions();
        boolean boolean7 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Board.Direction direction5 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean6 = board1.move(direction5);
        boolean boolean7 = board1.isWinningBoard();
        boolean boolean8 = board1.isFull();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet9 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction5.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(positionSet9);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isLosingBoard();
        java.lang.Class<?> wildcardClass6 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        java.lang.String str3 = position2.toString();
        java.lang.Object obj4 = null;
        boolean boolean5 = position2.equals(obj4);
        int int6 = position2.col;
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(100, 1)" + "'", str3, "(100, 1)");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 1 + "'", int6 == 1);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 1, 0);
        int int3 = position2.row;
        int int4 = position2.row;
        java.lang.String str5 = position2.toString();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 1 + "'", int4 == 1);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "(1, 0)" + "'", str5, "(1, 0)");
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Board.Direction direction5 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean6 = board1.move(direction5);
        boolean boolean7 = board1.isFull();
        boolean boolean8 = board1.isFull();
        boolean boolean9 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + direction5 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction5.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        java.lang.String str3 = position2.toString();
        java.lang.String str4 = position2.toString();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean8 = board6.equals((java.lang.Object) "hi!");
        java.lang.Object obj9 = null;
        boolean boolean10 = board6.equals(obj9);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet11 = board6.getEmptyPositions();
        boolean boolean12 = position2.equals((java.lang.Object) board6);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet13 = board6.getEmptyPositions();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(100, 1)" + "'", str3, "(100, 1)");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(100, 1)" + "'", str4, "(100, 1)");
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(positionSet11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(positionSet13);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) (byte) 1, 4);
        boolean boolean8 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board10 = ar.edu.unrc.game2048.Board.forTesting(100);
        board10.setScore((int) 'a');
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet13 = board10.getEmptyPositions();
        boolean boolean14 = board1.equals((java.lang.Object) positionSet13);
        ar.edu.unrc.game2048.Board board16 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean17 = board16.isWinningBoard();
        board16.setScore(4);
        ar.edu.unrc.game2048.Board.Direction direction20 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean21 = board16.move(direction20);
        boolean boolean22 = board1.move(direction20);
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider23 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider23);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertNotNull(board10);
        org.junit.Assert.assertNotNull(positionSet13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(board16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + direction20 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction20.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction4 = ar.edu.unrc.game2048.Board.Direction.LEFT;
        boolean boolean5 = board1.move(direction4);
        board1.setScore((int) (byte) 100);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + direction4 + "' != '" + ar.edu.unrc.game2048.Board.Direction.LEFT + "'", direction4.equals(ar.edu.unrc.game2048.Board.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (short) 1);
        ar.edu.unrc.game2048.Cell[][] cellArray2 = board1.getGrid();
        boolean boolean3 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean8 = board7.isWinningBoard();
        board7.setScore(4);
        ar.edu.unrc.game2048.Cell cell13 = board7.getCell((int) (byte) 1, 4);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) 'a', 100, cell13);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 97");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(cellArray2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(cell13);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) 'a');
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean8 = board7.isWinningBoard();
        board7.setScore(4);
        ar.edu.unrc.game2048.Board.Direction direction11 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean12 = board7.move(direction11);
        boolean boolean13 = board1.move(direction11);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet14 = board1.getEmptyPositions();
        boolean boolean15 = board1.isFull();
        java.lang.Object obj16 = null;
        boolean boolean17 = board1.equals(obj16);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(positionSet14);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        java.lang.String str3 = position2.toString();
        java.lang.Object obj4 = null;
        boolean boolean5 = position2.equals(obj4);
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean8 = position2.equals((java.lang.Object) 100);
        java.lang.String str9 = position2.toString();
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting(100);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet12 = board11.getEmptyPositions();
        java.lang.Class<?> wildcardClass13 = positionSet12.getClass();
        boolean boolean14 = position2.equals((java.lang.Object) positionSet12);
        int int15 = position2.row;
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(100, 1)" + "'", str3, "(100, 1)");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "(100, 1)" + "'", str9, "(100, 1)");
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertNotNull(positionSet12);
        org.junit.Assert.assertNotNull(wildcardClass13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 100 + "'", int15 == 100);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean13 = board11.equals((java.lang.Object) "hi!");
        boolean boolean14 = board11.isLosingBoard();
        int int15 = board11.getScore();
        ar.edu.unrc.game2048.Cell cell18 = board11.getCell((int) 'a', (int) (byte) 0);
        // The following exception was thrown during execution in test generation
        try {
            board1.setCell((int) (short) 100, (int) (byte) 1, cell18);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertNotNull(cell18);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        boolean boolean6 = board1.isWinningBoard();
        int int7 = board1.getScore();
        int int8 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 100 + "'", int8 == 100);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (byte) 1, (-1));
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(10);
        ar.edu.unrc.game2048.Board board3 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean4 = board3.isWinningBoard();
        board3.setScore(4);
        ar.edu.unrc.game2048.Cell cell9 = board3.getCell((int) (byte) 1, 4);
        boolean boolean10 = board3.hasEmptyCells();
        ar.edu.unrc.game2048.Board board12 = ar.edu.unrc.game2048.Board.forTesting(100);
        board12.setScore((int) 'a');
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet15 = board12.getEmptyPositions();
        boolean boolean16 = board3.equals((java.lang.Object) positionSet15);
        ar.edu.unrc.game2048.Board board18 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean19 = board18.isWinningBoard();
        board18.setScore(4);
        ar.edu.unrc.game2048.Board.Direction direction22 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean23 = board18.move(direction22);
        boolean boolean24 = board3.move(direction22);
        boolean boolean25 = board1.equals((java.lang.Object) board3);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(cell9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(board12);
        org.junit.Assert.assertNotNull(positionSet15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(board18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + direction22 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction22.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) 'a', (-1));
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) (byte) 1, 4);
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting(100);
        board9.setScore((int) 'a');
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet12 = board9.getEmptyPositions();
        boolean boolean13 = board1.equals((java.lang.Object) board9);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertNotNull(positionSet12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.hasEmptyCells();
        boolean boolean8 = board1.isLosingBoard();
        boolean boolean9 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray10 = board1.getGrid();
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell13 = board1.getCell(2048, (int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 2048");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(cellArray10);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        int int3 = board1.getScore();
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean7 = board5.equals((java.lang.Object) "hi!");
        java.lang.Object obj8 = null;
        boolean boolean9 = board5.equals(obj8);
        boolean boolean10 = board5.isWinningBoard();
        ar.edu.unrc.game2048.Board.Direction direction11 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean12 = board5.move(direction11);
        boolean boolean13 = board1.move(direction11);
        ar.edu.unrc.game2048.Cell[][] cellArray14 = board1.getGrid();
        int int15 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction11.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(cellArray14);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 100 + "'", int15 == 100);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isLosingBoard();
        int int5 = board1.getScore();
        boolean boolean6 = board1.isLosingBoard();
        boolean boolean7 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet2 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell[][] cellArray3 = board1.getGrid();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(positionSet2);
        org.junit.Assert.assertNotNull(cellArray3);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet6 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Board board8 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean9 = board8.hasEmptyCells();
        boolean boolean10 = board8.isFull();
        boolean boolean11 = board1.equals((java.lang.Object) boolean10);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(positionSet6);
        org.junit.Assert.assertNotNull(board8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        int int5 = board1.getSize();
        int int6 = board1.getSize();
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider7 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 100 + "'", int6 == 100);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) '#');
        int int2 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 35 + "'", int2 == 35);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        int int5 = board1.getSize();
        int int6 = board1.getSize();
        boolean boolean7 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board board9 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean11 = board9.equals((java.lang.Object) "hi!");
        java.lang.Object obj12 = null;
        boolean boolean13 = board9.equals(obj12);
        boolean boolean14 = board9.isWinningBoard();
        boolean boolean15 = board9.hasEmptyCells();
        boolean boolean16 = board9.isLosingBoard();
        boolean boolean17 = board9.hasEmptyCells();
        boolean boolean18 = board1.equals((java.lang.Object) boolean17);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 100 + "'", int6 == 100);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertNotNull(board9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        boolean boolean4 = board1.hasEmptyCells();
        boolean boolean5 = board1.isWinningBoard();
        board1.setScore((int) (byte) 10);
        board1.setScore(97);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(2048, (int) '#');
        ar.edu.unrc.game2048.Board.Position position5 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        java.lang.String str6 = position5.toString();
        java.lang.String str7 = position5.toString();
        boolean boolean8 = position2.equals((java.lang.Object) position5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "(100, 1)" + "'", str6, "(100, 1)");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "(100, 1)" + "'", str7, "(100, 1)");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isWinningBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.isFull();
        ar.edu.unrc.game2048.Board.Position position8 = new ar.edu.unrc.game2048.Board.Position((int) (byte) 10, (int) 'a');
        boolean boolean9 = board1.equals((java.lang.Object) position8);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Cell[][] cellArray4 = board1.getGrid();
        boolean boolean5 = board1.isLosingBoard();
        boolean boolean6 = board1.isLosingBoard();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertNotNull(cellArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (byte) 1, (int) (short) 0);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        java.lang.Object obj4 = null;
        boolean boolean5 = board1.equals(obj4);
        boolean boolean6 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board.Direction direction7 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean8 = board1.move(direction7);
        ar.edu.unrc.game2048.Board.Direction direction9 = ar.edu.unrc.game2048.Board.Direction.LEFT;
        boolean boolean10 = board1.move(direction9);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + direction7 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction7.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + direction9 + "' != '" + ar.edu.unrc.game2048.Board.Direction.LEFT + "'", direction9.equals(ar.edu.unrc.game2048.Board.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        boolean boolean5 = board1.isLosingBoard();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.hasEmptyCells();
        int int8 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 100 + "'", int8 == 100);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (byte) 100);
        int int2 = board1.getSize();
        ar.edu.unrc.game2048.Board board4 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean5 = board4.isWinningBoard();
        board4.setScore(4);
        ar.edu.unrc.game2048.Cell cell10 = board4.getCell((int) (byte) 1, 4);
        boolean boolean11 = board4.hasEmptyCells();
        ar.edu.unrc.game2048.Board board13 = ar.edu.unrc.game2048.Board.forTesting(100);
        board13.setScore((int) 'a');
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet16 = board13.getEmptyPositions();
        boolean boolean17 = board4.equals((java.lang.Object) positionSet16);
        ar.edu.unrc.game2048.Board board19 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean20 = board19.isWinningBoard();
        board19.setScore(4);
        ar.edu.unrc.game2048.Board.Direction direction23 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean24 = board19.move(direction23);
        boolean boolean25 = board4.move(direction23);
        boolean boolean26 = board1.move(direction23);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 100 + "'", int2 == 100);
        org.junit.Assert.assertNotNull(board4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(cell10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertNotNull(board13);
        org.junit.Assert.assertNotNull(positionSet16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(board19);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + direction23 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction23.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + false + "'", boolean25 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        int int3 = board1.getScore();
        ar.edu.unrc.game2048.Board board5 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean7 = board5.equals((java.lang.Object) "hi!");
        java.lang.Object obj8 = null;
        boolean boolean9 = board5.equals(obj8);
        boolean boolean10 = board5.isWinningBoard();
        ar.edu.unrc.game2048.Board.Direction direction11 = ar.edu.unrc.game2048.Board.Direction.DOWN;
        boolean boolean12 = board5.move(direction11);
        boolean boolean13 = board1.move(direction11);
        boolean boolean14 = board1.isLosingBoard();
        ar.edu.unrc.game2048.Board board16 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean17 = board16.isLosingBoard();
        boolean boolean18 = board16.isLosingBoard();
        ar.edu.unrc.game2048.Board.Direction direction19 = ar.edu.unrc.game2048.Board.Direction.LEFT;
        boolean boolean20 = board16.move(direction19);
        boolean boolean21 = board1.equals((java.lang.Object) board16);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
        org.junit.Assert.assertNotNull(board5);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Board.Direction.DOWN + "'", direction11.equals(ar.edu.unrc.game2048.Board.Direction.DOWN));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(board16);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + direction19 + "' != '" + ar.edu.unrc.game2048.Board.Direction.LEFT + "'", direction19.equals(ar.edu.unrc.game2048.Board.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position(2048, (int) '#');
        int int3 = position2.row;
        java.lang.String str4 = position2.toString();
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 2048 + "'", int3 == 2048);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(2048, 35)" + "'", str4, "(2048, 35)");
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) 'a');
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet3 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(positionSet3);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(4);
        ar.edu.unrc.game2048.Board board3 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean5 = board3.equals((java.lang.Object) "hi!");
        java.lang.Object obj6 = null;
        boolean boolean7 = board3.equals(obj6);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet8 = board3.getEmptyPositions();
        boolean boolean9 = board1.equals((java.lang.Object) positionSet8);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(board3);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertNotNull(positionSet8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.isFull();
        boolean boolean6 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (short) 100);
        boolean boolean2 = board1.isWinningBoard();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean8 = board6.equals((java.lang.Object) "hi!");
        boolean boolean9 = board6.isLosingBoard();
        int int10 = board6.getScore();
        ar.edu.unrc.game2048.Cell cell13 = board6.getCell((int) 'a', (int) (byte) 0);
        board1.setCell((int) ' ', (int) ' ', cell13);
        int int15 = board1.getScore();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNotNull(cell13);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (byte) 1);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        ar.edu.unrc.game2048.Cell cell7 = board1.getCell((int) (byte) 1, 4);
        boolean boolean8 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.Board.Direction direction9 = ar.edu.unrc.game2048.Board.Direction.LEFT;
        boolean boolean10 = board1.move(direction9);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cell7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        org.junit.Assert.assertTrue("'" + direction9 + "' != '" + ar.edu.unrc.game2048.Board.Direction.LEFT + "'", direction9.equals(ar.edu.unrc.game2048.Board.Direction.LEFT));
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting((int) (byte) 10);
        java.lang.Class<?> wildcardClass2 = board1.getClass();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        int int5 = board1.getSize();
        ar.edu.unrc.game2048.Board board7 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean8 = board7.isWinningBoard();
        board7.setScore(4);
        ar.edu.unrc.game2048.Board.Direction direction11 = ar.edu.unrc.game2048.Board.Direction.RIGHT;
        boolean boolean12 = board7.move(direction11);
        boolean boolean13 = board1.move(direction11);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet14 = board1.getEmptyPositions();
        ar.edu.unrc.game2048.Cell cell17 = board1.getCell(97, (int) 'a');
        int int18 = board1.getSize();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        org.junit.Assert.assertNotNull(board7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + direction11 + "' != '" + ar.edu.unrc.game2048.Board.Direction.RIGHT + "'", direction11.equals(ar.edu.unrc.game2048.Board.Direction.RIGHT));
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertNotNull(positionSet14);
        org.junit.Assert.assertNotNull(cell17);
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 100 + "'", int18 == 100);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        java.lang.String str3 = position2.toString();
        java.lang.String str4 = position2.toString();
        ar.edu.unrc.game2048.Board board6 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean8 = board6.equals((java.lang.Object) "hi!");
        java.lang.Object obj9 = null;
        boolean boolean10 = board6.equals(obj9);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet11 = board6.getEmptyPositions();
        boolean boolean12 = position2.equals((java.lang.Object) board6);
        // The following exception was thrown during execution in test generation
        try {
            ar.edu.unrc.game2048.Cell cell15 = board6.getCell((int) (short) 10, (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "(100, 1)" + "'", str3, "(100, 1)");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "(100, 1)" + "'", str4, "(100, 1)");
        org.junit.Assert.assertNotNull(board6);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(positionSet11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(4);
        boolean boolean5 = board1.isLosingBoard();
        boolean boolean6 = board1.isWinningBoard();
        boolean boolean7 = board1.hasEmptyCells();
        ar.edu.unrc.game2048.strategy.MoveProvider moveProvider8 = null;
        // The following exception was thrown during execution in test generation
        try {
            board1.setMoveProvider(moveProvider8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: moveProvider no puede ser null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean3 = board1.equals((java.lang.Object) "hi!");
        boolean boolean4 = board1.isLosingBoard();
        boolean boolean5 = board1.isWinningBoard();
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet6 = board1.getEmptyPositions();
        board1.setScore(4);
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(positionSet6);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        ar.edu.unrc.game2048.Board.Position position2 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        ar.edu.unrc.game2048.Board.Position position5 = new ar.edu.unrc.game2048.Board.Position((int) (short) 100, (int) (short) 1);
        java.lang.String str6 = position5.toString();
        int int7 = position5.row;
        int int8 = position5.col;
        boolean boolean9 = position2.equals((java.lang.Object) position5);
        ar.edu.unrc.game2048.Board board11 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean12 = board11.isWinningBoard();
        board11.setScore(4);
        boolean boolean15 = board11.isLosingBoard();
        boolean boolean16 = board11.isFull();
        boolean boolean17 = position5.equals((java.lang.Object) board11);
        ar.edu.unrc.game2048.Board board21 = ar.edu.unrc.game2048.Board.forTesting((int) (short) 100);
        boolean boolean22 = board21.isWinningBoard();
        ar.edu.unrc.game2048.Board board26 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean28 = board26.equals((java.lang.Object) "hi!");
        boolean boolean29 = board26.isLosingBoard();
        int int30 = board26.getScore();
        ar.edu.unrc.game2048.Cell cell33 = board26.getCell((int) 'a', (int) (byte) 0);
        board21.setCell((int) ' ', (int) ' ', cell33);
        // The following exception was thrown during execution in test generation
        try {
            board11.setCell((int) (byte) 0, (int) (byte) 100, cell33);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: 100");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "(100, 1)" + "'", str6, "(100, 1)");
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 100 + "'", int7 == 100);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 1 + "'", int8 == 1);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertNotNull(board11);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(board21);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(board26);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + int30 + "' != '" + 0 + "'", int30 == 0);
        org.junit.Assert.assertNotNull(cell33);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(1);
        org.junit.Assert.assertNotNull(board1);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isLosingBoard();
        boolean boolean3 = board1.isLosingBoard();
        int int4 = board1.getScore();
        boolean boolean5 = board1.isFull();
        int int6 = board1.getScore();
        boolean boolean7 = board1.hasEmptyCells();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(100);
        boolean boolean2 = board1.isWinningBoard();
        board1.setScore(0);
        ar.edu.unrc.game2048.Cell[][] cellArray5 = board1.getGrid();
        boolean boolean6 = board1.isLosingBoard();
        boolean boolean7 = board1.isWinningBoard();
        boolean boolean8 = board1.isFull();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(cellArray5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        ar.edu.unrc.game2048.Board board1 = ar.edu.unrc.game2048.Board.forTesting(2048);
        java.util.Set<ar.edu.unrc.game2048.Board.Position> positionSet2 = board1.getEmptyPositions();
        org.junit.Assert.assertNotNull(board1);
        org.junit.Assert.assertNotNull(positionSet2);
    }
}

