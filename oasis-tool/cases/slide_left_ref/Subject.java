import java.util.*;

/** Caso de estudio 2 (falso negativo): deslizar y fusionar una fila de 2048 hacia la izquierda. */
public class Subject {

    /** Fila válida: cada celda es 0 o una potencia de dos entre 2 y 131072. */
    static boolean validTiles(int[] row) {
        for (int v : row) {
            if (v != 0 && !(v >= 2 && v <= 131072 && (v & (v - 1)) == 0)) {
                return false;
            }
        }
        return true;
    }

    // ---- predicados auxiliares para escribir aserciones (no forman parte del programa bajo prueba) ----

    /** No hay ceros antes de una celda no nula. */
    static boolean compacted(int[] r) {
        boolean seenZero = false;
        for (int v : r) {
            if (v == 0) {
                seenZero = true;
            } else if (seenZero) {
                return false;
            }
        }
        return true;
    }

    static int nonzero(int[] r) {
        int c = 0;
        for (int v : r) {
            if (v != 0) {
                c++;
            }
        }
        return c;
    }

    /** Hay dos celdas no nulas iguales separadas solo por ceros. */
    static boolean hasMergeablePair(int[] r) {
        int prev = 0;
        for (int v : r) {
            if (v == 0) {
                continue;
            }
            if (v == prev) {
                return true;
            }
            prev = v;
        }
        return false;
    }

    /** Implementación de referencia independiente (lista de no nulos + una pasada de fusión) para usar como oráculo. */
    static int[] expectedSlideLeft(int[] row) {
        int[] t = Arrays.stream(row).filter(x -> x != 0).toArray();
        int[] out = new int[row.length];
        int pos = 0;
        for (int i = 0; i < t.length; i++) {
            if (i + 1 < t.length && t[i] == t[i + 1]) {
                out[pos++] = 2 * t[i];
                i++;
            } else {
                out[pos++] = t[i];
            }
        }
        return out;
    }

    // ---- programa bajo prueba ----

    /** Desliza las fichas a la izquierda y fusiona pares iguales (una sola fusión por ficha). Devuelve una fila nueva. */
    static int[] slideLeft(int[] row) {
        int n = row.length;
        int[] out = new int[n];
        int pos = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int v = row[i];
            if (v == 0) {
                continue;
            }
            if (prev == v) {
                out[pos - 1] = 2 * v;
                prev = 0;
            } else {
                out[pos++] = v;
                prev = v;
            }
        }
        return out;
    }
}
