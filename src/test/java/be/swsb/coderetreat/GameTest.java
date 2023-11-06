package be.swsb.coderetreat;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    public void game_renderNewGame_NumberOfBoatsEqualsToZero() {
        Game game = new Game();
        assertEquals(game.getNumberOfBoats(), 0);
    }

    @Test
    public void game_renderNewGame_Visualisation() {
        Game game = new Game();
        assertEquals(game.render(), """
                            
                            🌊🌊🌊🌊🌊
                            🌊🌊🌊🌊🌊
                            🌊🌊🌊🌊🌊
                            🌊🌊🌊🌊🌊
                            🌊🌊🌊🌊🌊
                            """);

    }
}
