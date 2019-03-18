package study.basecamp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import study.basecamp.config.GameProperties;
import study.basecamp.game.GameImpl;
import study.basecamp.game.NumberGenerator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class GameImplTest {

    private GameImpl unit;
    private GameProperties gameProperties;
    private NumberGenerator numberGenerator;

    @Before
    public void setUp() {
        unit = new GameImpl();
        gameProperties = new GameProperties();
        numberGenerator = mock(NumberGenerator.class);
    }

    @After
    public void tearDown() {
        unit = null;
        gameProperties = null;
        numberGenerator = null;
    }

    @Test
    public void testGetRemainingGuessesShouldReturn10() {
        gameProperties.setGameMaxNumber(100);
        gameProperties.setGuessNumber(10);
        gameProperties.setMinNumber(0);

        when(numberGenerator.next()).thenReturn(9);
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        unit.setGameProperties(gameProperties);
        unit.setNumberGenerator(numberGenerator);
        unit.reset();

        assertEquals(10, unit.getRemainingGuesses());

    }

    @Test
    public void testGetBiggestShouldReturn100() {
        GameProperties gameProperties = new GameProperties();
        gameProperties.setGameMaxNumber(100);
        gameProperties.setGuessNumber(10);
        gameProperties.setMinNumber(0);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.next()).thenReturn(9);
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        unit.setGameProperties(gameProperties);
        unit.setNumberGenerator(numberGenerator);
        unit.reset();

        assertEquals(100, unit.getBiggest());

    }

    @Test
    public void testGetSmallestShouldReturn0() {
        GameProperties gameProperties = new GameProperties();
        gameProperties.setGameMaxNumber(100);
        gameProperties.setGuessNumber(10);
        gameProperties.setMinNumber(0);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.next()).thenReturn(9);
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        unit.setGameProperties(gameProperties);
        unit.setNumberGenerator(numberGenerator);
        unit.reset();

        assertEquals(0, unit.getSmallest());

    }

    @Test
    public void testGetNumberShouldReturn0() {
        GameProperties gameProperties = new GameProperties();
        gameProperties.setGameMaxNumber(100);
        gameProperties.setGuessNumber(10);
        gameProperties.setMinNumber(0);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.next()).thenReturn(9);
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        unit.setGameProperties(gameProperties);
        unit.setNumberGenerator(numberGenerator);
        unit.reset();

        assertEquals(9, unit.getNumber());

    }

    @Test
    public void testIsGameWonShouldReturnTrue() {
        GameProperties gameProperties = new GameProperties();
        gameProperties.setGameMaxNumber(100);
        gameProperties.setGuessNumber(10);
        gameProperties.setMinNumber(0);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.next()).thenReturn(9);
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        unit.setGameProperties(gameProperties);
        unit.setNumberGenerator(numberGenerator);

        unit.reset();
        unit.setGuess(9);

        assertTrue(unit.isGameWon());

    }

    @Test
    public void testIsGameWonShouldReturnFalse() {
        GameProperties gameProperties = new GameProperties();
        gameProperties.setGameMaxNumber(100);
        gameProperties.setGuessNumber(10);
        gameProperties.setMinNumber(0);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.next()).thenReturn(9);
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        unit.setGameProperties(gameProperties);
        unit.setNumberGenerator(numberGenerator);

        unit.reset();
        unit.setGuess(8);

        assertFalse(unit.isGameWon());

    }

    @Test
    public void testIsGameLostShouldReturnTrue() {
        GameProperties gameProperties = new GameProperties();
        gameProperties.setGameMaxNumber(100);
        gameProperties.setGuessNumber(0);
        gameProperties.setMinNumber(0);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.next()).thenReturn(9);
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        unit.setGameProperties(gameProperties);
        unit.setNumberGenerator(numberGenerator);

        unit.reset();
        unit.setGuess(8);

        assertTrue(unit.isGameLost());

    }

    @Test
    public void testIsGameLostShouldReturnFalse() {
        GameProperties gameProperties = new GameProperties();
        gameProperties.setGameMaxNumber(100);
        gameProperties.setGuessNumber(0);
        gameProperties.setMinNumber(0);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.next()).thenReturn(9);
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        unit.setGameProperties(gameProperties);
        unit.setNumberGenerator(numberGenerator);

        unit.reset();
        unit.setGuess(9);

        assertFalse(unit.isGameLost());

    }

    @Test
    public void testGetGuessShouldReturn9() {
        unit.setGuess(9);
        assertEquals(9, unit.getGuess());
    }

    @Test
    public void testGetGuessCountShouldReturnFalse() {
        GameProperties gameProperties = new GameProperties();
        gameProperties.setGameMaxNumber(100);
        gameProperties.setGuessNumber(10);
        gameProperties.setMinNumber(0);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.next()).thenReturn(9);
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        unit.setGameProperties(gameProperties);
        unit.setNumberGenerator(numberGenerator);
        unit.reset();


        assertEquals(10, unit.getGuessCount());

    }

    @Test
    public void testCheckShouldReturnDecrementedRemainingGuesses() {
        GameProperties gameProperties = new GameProperties();
        gameProperties.setGameMaxNumber(100);
        gameProperties.setGuessNumber(10);
        gameProperties.setMinNumber(0);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.next()).thenReturn(9);
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        unit.setGameProperties(gameProperties);
        unit.setNumberGenerator(numberGenerator);
        unit.reset();
        unit.setGuess(1);
        unit.check(); //when check should decrement remainingGuesses

        assertEquals(9, unit.getRemainingGuesses());

    }

    @Test
    public void testCheckShouldReturnIncrementByOneSmallestNumber() {
        GameProperties gameProperties = new GameProperties();
        gameProperties.setGameMaxNumber(100);
        gameProperties.setGuessNumber(10);
        gameProperties.setMinNumber(0);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.next()).thenReturn(9);
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        unit.setGameProperties(gameProperties);
        unit.setNumberGenerator(numberGenerator);
        unit.reset();
        unit.setGuess(1);
        unit.check(); //when check should increment smallest number by one

        assertEquals(2, unit.getSmallest());

    }

    @Test
    public void testCheckShouldDecrementByOneBiggestNumber() {
        GameProperties gameProperties = new GameProperties();
        gameProperties.setGameMaxNumber(100);
        gameProperties.setGuessNumber(10);
        gameProperties.setMinNumber(0);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.next()).thenReturn(9);
        when(numberGenerator.getMaxNumber()).thenReturn(100);
        unit.setGameProperties(gameProperties);
        unit.setNumberGenerator(numberGenerator);
        unit.reset();
        unit.setGuess(29);
        unit.check(); //when check should increment smallest number by one

        assertEquals(28, unit.getBiggest());

    }
}