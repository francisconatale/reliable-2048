import java.util.*;

/** Caso de estudio 1 (falso positivo): puntaje de una fila de 2048. */
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

    /** Puntos ganados al deslizar la fila a la izquierda: suma de los valores de las fichas creadas por fusiones. */
    static int scoreOfLeftMove(int[] row) {
        int score = 0;
        int prev = 0;
        for (int v : row) {
            if (v == 0) {
                continue;
            }
            if (prev == v) {
                score += 2 * v;
                prev = 0;
            } else {
                prev = v;
            }
        }
        return score;
    }
}
