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

    @Test
    public void game_fireAndMiss_Visualisation() {
        Game game = new Game();
        game.placeBoat(new Position(1, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);

        game.fire(new Position(0, 0));

        assertEquals(game.getNumberOfBoats(), 1);
        assertEquals(game.render(), """
                                            
                🐠🌊🌊🌊🌊
                🌊🚢🚢🚢🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);

    }

    @Test
    public void game_fireAndHit_Visualisation() {
    public void game_fireAndMissMultipleTimes_Visualisation() {
        Game game = new Game();
        game.placeBoat(new Position(1, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);

        game.fire(new Position(0, 0));
        game.fire(new Position(0, 1));
        game.fire(new Position(0, 2));
        game.fire(new Position(2, 3));
        game.fire(new Position(3, 3));

        assertEquals(game.getNumberOfBoats(), 1);
        assertEquals(game.render(), """
                                            
                🐠🌊🌊🌊🌊
                🐠🚢🚢🚢🌊
                🐠🌊🌊🌊🌊
                🌊🌊🐠🐠🌊
                🌊🌊🌊🌊🌊
                """);

    }
}
