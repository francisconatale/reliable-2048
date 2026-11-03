package ar.edu.unrc.game2048.manual;

import ar.edu.unrc.game2048.Score;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

    @ParameterizedTest(name = "Score negativo {0} lanza IllegalArgumentException")
    @ValueSource(ints = {-1, -4, -2048})
    public void negativeScoreThrowsTest(int negative) {
        assertThrows(IllegalArgumentException.class, () -> new Score(negative));
    }

    @ParameterizedTest(name = "Score {0} es valido")
    @ValueSource(ints = {0, 1, 4, 2048})
    public void nonNegativeScoreIsValidTest(int value) {
        assertEquals(value, new Score(value).getScore());
    }

    @Test
    public void increaseScoreAddsToTotalTest() {
        Score score = new Score(4);
        score.increaseScore(8);
        assertEquals(12, score.getScore());
    }

    @Test
    public void setScoreReplacesTotalTest() {
        Score score = new Score(4);
        score.setScore(100);
        assertEquals(100, score.getScore());
    }
}
