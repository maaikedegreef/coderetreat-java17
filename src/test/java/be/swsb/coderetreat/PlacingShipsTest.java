package be.swsb.coderetreat;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlacingShipsTest {
    @Test
    public void game_placingOneShipHorizontallyOnX1Y1_NumberOfBoatsEqualsToOne() {
        Game game = new Game(5);
        game.placeBoat(new Position(1, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);
        assertEquals(game.getNumberOfBoats(), 1);
    }

    @Test
    public void game_placingOneShipHorizontallyOnX1Y1_Visualisation() {
        Game game = new Game(5);
        game.placeBoat(new Position(1, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);
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
        Game game = new Game(5);
        game.placeBoat(new Position(0, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);
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
        Game game = new Game(5);
        game.placeBoat(new Position(2, 4), Orientation.HORIZONTAL, BoatType.DESTROYER);
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
        Game game = new Game(5);
        game.placeBoat(new Position(1, 1), Orientation.VERTICAL, BoatType.DESTROYER);
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
        Game game = new Game(5);
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeBoat(new Position(4, 4), Orientation.HORIZONTAL, BoatType.DESTROYER);
        });
    }

    @Test
    public void game_placingOneShipHorizontallyOnX3Y2_ThrowsError() {
        Game game = new Game(5);
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeBoat(new Position(3, 2), Orientation.HORIZONTAL, BoatType.DESTROYER);
        });
    }

    @Test
    public void game_placingOneShipVerticallyOnX4Y4_ThrowsError() {
        Game game = new Game(5);
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeBoat(new Position(4, 4), Orientation.VERTICAL, BoatType.DESTROYER);
        });
    }

    @Test
    public void game_placingOneShipVerticallyOnXmin3Y4_ThrowsError() {
        Game game = new Game(5);
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeBoat(new Position(-3, 4), Orientation.VERTICAL, BoatType.DESTROYER);
        });
    }

    @Test
    public void game_placingOneCarrierHorizontallyOnX0Y0_Visualisation() {
        Game game = new Game(5);
        game.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.CARRIER);
        assertEquals(game.getNumberOfBoats(), 1);
        assertEquals(game.render(), """
                                            
                🚢🚢🚢🚢🚢
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);
    }

    @Test
    public void game_placingOneBattleShipVerticallyOnX3Y0_Visualisation() {
        Game game = new Game(5);
        game.placeBoat(new Position(3, 0), Orientation.VERTICAL, BoatType.BATTLESHIP);
        assertEquals(game.getNumberOfBoats(), 1);
        assertEquals(game.render(), """
                                            
                🌊🌊🌊🚢🌊
                🌊🌊🌊🚢🌊
                🌊🌊🌊🚢🌊
                🌊🌊🌊🚢🌊
                🌊🌊🌊🌊🌊
                """);
    }

    @Test
    public void game_placingOneSubmarineVerticallyOnX3Y0_Visualisation() {
        Game game = new Game(5);
        game.placeBoat(new Position(3, 0), Orientation.VERTICAL, BoatType.SUBMARINE);
        assertEquals(game.getNumberOfBoats(), 1);
        assertEquals(game.render(), """
                                            
                🌊🌊🌊🚢🌊
                🌊🌊🌊🚢🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);
    }

    @Test
    public void game_placingOnePatrolboatHorizontallyOnX0Y0_Visualisation() {
        Game game = new Game(5);
        game.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.PATROLBOAT);
        assertEquals(game.getNumberOfBoats(), 1);
        assertEquals(game.render(), """
                                            
                🚢🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);
    }

    @Test
    public void game_placingTwoCarriersOnSamePosition_ThrowsError() {
        Game game = new Game(5);
        game.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.CARRIER);
        assertThrows(IllegalStateException.class, () -> {
            game.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.CARRIER);
        });
    }

    @Test
    public void game_placingTwoShipsOverlappingEachOther_ThrowsError() {
        Game game = new Game(5);
        game.placeBoat(new Position(2, 0), Orientation.VERTICAL, BoatType.BATTLESHIP);
        assertThrows(IllegalStateException.class, () -> {
            game.placeBoat(new Position(1, 3), Orientation.HORIZONTAL, BoatType.DESTROYER);
        });
    }
}
