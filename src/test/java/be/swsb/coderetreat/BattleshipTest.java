package be.swsb.coderetreat;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BattleshipTest {

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
    public void game_placingOneShipHorizontallyOnX1Y1_NumberOfBoatsEqualsToOne() {
        Game game = new Game();
        game.placeBoat(new Position(1, 1), Orientation.HORIZONTAL);
        assertEquals(game.getNumberOfBoats(), 1);
    }

    @Test
    public void game_placingOneShipHorizontallyOnX1Y1_Visualisation() {
        Game game = new Game();
        game.placeBoat(new Position(1, 1), Orientation.HORIZONTAL);
        assertEquals(game.render(), """
                            
                            🌊🌊🌊🌊🌊
                            🌊🚢🚢🚢🌊
                            🌊🌊🌊🌊🌊
                            🌊🌊🌊🌊🌊
                            🌊🌊🌊🌊🌊
                            """);
    }

    @Test
    public void game_placingOneShipHorizontallyOnX0Y1_Visualisation() {
        Game game = new Game();
        game.placeBoat(new Position(0, 1), Orientation.HORIZONTAL);

        System.out.println(game.getBoats());
        assertEquals(game.getNumberOfBoats(), 1);
        assertEquals(game.render(), """
                            
                            🌊🌊🌊🌊🌊
                            🚢🚢🚢🌊🌊
                            🌊🌊🌊🌊🌊
                            🌊🌊🌊🌊🌊
                            🌊🌊🌊🌊🌊
                            """);
    }

    @Test
    public void game_placingOneShipHorizontallyOnX2Y4_Visualisation() {
        Game game = new Game();
        game.placeBoat(new Position(2, 4), Orientation.HORIZONTAL);

        assertEquals(game.getNumberOfBoats(), 1);
        assertEquals(game.render(), """
                            
                            🌊🌊🌊🌊🌊
                            🌊🌊🌊🌊🌊
                            🌊🌊🌊🌊🌊
                            🌊🌊🌊🌊🌊
                            🌊🌊🚢🚢🚢
                            """);
    }

    @Test
    public void game_placingOneShipVerticallyOnX1Y1_Visualisation() {
        Game game = new Game();
        game.placeBoat(new Position(1, 1), Orientation.VERTICAL);
        assertEquals(game.getNumberOfBoats(), 1);
        assertEquals(game.render(), """
                            
                            🌊🌊🌊🌊🌊
                            🌊🚢🌊🌊🌊
                            🌊🚢🌊🌊🌊
                            🌊🚢🌊🌊🌊
                            🌊🌊🌊🌊🌊
                            """);
    }

    @Test
    public void game_placingOneShipHorizontallyOnX4Y4_ThrowsError() {
        Game game = new Game();
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeBoat(new Position(4, 4), Orientation.HORIZONTAL);
        });
    }

    @Test
    public void game_placingOneShipHorizontallyOnX3Y2_ThrowsError() {
        Game game = new Game();
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeBoat(new Position(3, 2), Orientation.HORIZONTAL);
        });
    }

    @Test
    public void game_placingOneShipVerticallyOnX4Y4_ThrowsError() {
        Game game = new Game();
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeBoat(new Position(4, 4), Orientation.VERTICAL);
        });
    }

    @Test
    public void game_placingOneShipVerticallyOnXmin3Y4_ThrowsError() {
        Game game = new Game();
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeBoat(new Position(-3, 4), Orientation.VERTICAL);
        });
    }
}
