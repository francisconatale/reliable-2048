package ar.edu.unrc.game2048.manual;
import ar.edu.unrc.game2048.*;
import ar.edu.unrc.game2048.strategy.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CellTest {

    @Parameters(name = "{index}: cell({0}) + cell({1}) -> {2}")
    public static Collection<Object[]> mergeData() {
        return Arrays.asList(new Object[][] {
            { 2, 2, 4 },
            { 4, 4, 8 },
            { 8, 8, 16 },
            { 16, 16, 32 },
            { 32, 32, 64 },
            { 64, 64, 128 },
            { 128, 128, 256 },
            { 256, 256, 512 },
            { 512, 512, 1024 },
            { 1024, 1024, 2048 }
        });
    }

    @Parameter(0)
    public int value1;

    @Parameter(1)
    public int value2;

    @Parameter(2)
    public int expectedResult;

    @Test
    public void testMergeWithParameterized() {
        Cell origin = new Cell(value1);
        Cell target = new Cell(value2);
        Cell result = origin.mergeWith(target);
        assertEquals(expectedResult, result.getValue());
        assertEquals(new Cell(expectedResult), result);
    }

    @Test
    public void differentCellsCannotMerge(){
        Cell origin = new Cell(2);
        Cell target = new Cell(4);
        boolean result = origin.canMergeWith(target);
        assertFalse(result);
    }

    @Test
    public void mergeCellDifferentValuesThrowsArgumentException(){
        Cell origin = new Cell(2);
        Cell target = new Cell(4);
        assertThrows(IllegalArgumentException.class, () -> { origin.mergeWith(target);});
    }

    @Test
    public void cellWithEqualsValueJoin(){
        Cell origin = new Cell(2);
        Cell target = new Cell(2);
        Cell expected = new Cell(4);
        Cell result = origin.mergeWith(target);
        assertEquals(expected, result);
    }

    @Test
    public void testCellIsEmpty(){
        Cell cell = Cell.EMPTY;
        boolean result = cell.isEmpty();
        assertTrue(result);
    }

    @Test
    public void testCellIsNotEmpty(){
        Cell cell = new Cell(2);
        boolean result = cell.isEmpty();
        assertFalse(result);
    }

    @Test
    public void negativeCellValueThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> new Cell(-1));
    }

    @Test
    public void validCellValuesSatisfyRepOk(){
        assertTrue(Cell.EMPTY.repOK());
        assertTrue(new Cell(2).repOK());
        assertTrue(new Cell(2048).repOK());
    }

    @Test
    public void nonPowerOfTwoCellFailsRepOk(){
        Cell cell;
        try {
            cell = new Cell(3);
        } catch (IllegalArgumentException e) {
            return;
        }
        assertFalse(cell.repOK());
    }

    @Test
    public void testCellEquals(){
        Cell cell = new Cell(4);
        Cell otherCell = new Cell(4);
        boolean result = cell.equals(otherCell);
        assertTrue(result);
    }

    @Test
    public void testCellNotEquals(){
        Cell cell = new Cell(4);
        Cell otherCell = new Cell(8);
        boolean result = cell.equals(otherCell);
        assertFalse(result);
    }

    @Test
    public void testCellEqualsSameReference(){
        Cell cell = new Cell(4);
        assertTrue(cell.equals(cell));
    }

    @Test
    public void testCellEqualsNull(){
        Cell cell = new Cell(4);
        assertFalse(cell.equals(null));
    }

    @Test
    public void testCellEqualsDifferentClass(){
        Cell cell = new Cell(4);
        assertFalse(cell.equals("4"));
    }

    @Test
    public void testCellNotEqualsByHash(){
        Cell cell = new Cell(4);
        Cell otherCell = new Cell(8);
        int hashCell = cell.hashCode();
        int hashOtherCell = otherCell.hashCode();
        assertNotEquals(hashCell, hashOtherCell);
    }

    @Test
    public void testCellEqualsByHash(){
        Cell cell = new Cell(4);
        Cell otherCell = new Cell(4);
        int hashCell = cell.hashCode();
        int hashOtherCell = otherCell.hashCode();
        assertEquals(hashCell, hashOtherCell);
    }

    @Test
    public void testEmptyCellCannotMerge(){
        Cell cell = Cell.EMPTY;
        Cell otherCell = Cell.EMPTY;
        assertFalse(cell.canMergeWith(otherCell));
    }

    @Test
    public void testEmptyCellToString() {
        assertEquals(".", Cell.EMPTY.toString());
    }

    @Test
    public void testNonEmptyCellToString() {
        assertEquals("4", new Cell(4).toString());
    }
}
