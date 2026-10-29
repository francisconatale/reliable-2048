package ar.edu.unrc.game2048.manual;
import ar.edu.unrc.game2048.*;
import ar.edu.unrc.game2048.move.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Scanner;

import org.junit.Test;

public class ScannerInputReaderTest {

    @Test
    public void testNextLineReadsFromScanner() {
        ScannerInputReader reader = new ScannerInputReader(new Scanner("w\n"));

        assertEquals("w", reader.nextLine());
        reader.close();
    }

    @Test
    public void testCloseClosesScanner() {
        Scanner scanner = new Scanner("q\n");
        ScannerInputReader reader = new ScannerInputReader(scanner);

        reader.close();

        assertThrows(IllegalStateException.class, scanner::hasNextLine);
    }
}