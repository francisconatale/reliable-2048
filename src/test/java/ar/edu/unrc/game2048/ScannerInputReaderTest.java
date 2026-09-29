package ar.edu.unrc.game2048;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

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