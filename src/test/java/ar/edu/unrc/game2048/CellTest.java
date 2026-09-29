package ar.edu.unrc.game2048;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CellTest{
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
    Cell cell = new Cell(0);
    boolean result = cell.isEmpty();
    assertTrue(result);
}
@Test
public void testCellIsNotEmpty(){
    Cell cell = new Cell(3);
    boolean result = cell.isEmpty();
    assertFalse(result);
}

@Test
public void negativeCellValueThrowsException(){
    assertThrows(IllegalArgumentException.class, () -> new Cell(-1));
}

@Test
public void validCellValuesSatisfyRepOk(){
    assertTrue(new Cell(0).repOK());
    assertTrue(new Cell(2).repOK());
    assertTrue(new Cell(2048).repOK());
}

@Test
public void nonPowerOfTwoCellFailsRepOk(){
    assertFalse(new Cell(3).repOK());
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
    Cell cell = new Cell(0);
    Cell otherCell = new Cell(0);
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
