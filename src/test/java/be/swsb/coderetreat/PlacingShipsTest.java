package be.swsb.coderetreat;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlacingShipsTest {
    @Test
    public void placingShip_placingOneShipHorizontallyOnX1Y1_NumberOfBoatsEqualsToOne() {
        Game game = new Game(5);
        game.placeBoat(new Position(1, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);
        assertEquals(game.getNumberOfBoats(), 1);
    }

    @Test
    public void placingShip_placingOneShipHorizontallyOnX1Y1_Visualisation() {
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
    public void placingShip_placingOneShipHorizontallyOnX0Y1_Visualisation() {
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
    public void placingShip_placingOneShipHorizontallyOnX2Y4_Visualisation() {
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
    public void placingShip_placingOneShipVerticallyOnX1Y1_Visualisation() {
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
    public void placingShip_placingOneShipHorizontallyOnX4Y4_ThrowsError() {
        Game game = new Game(5);
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeBoat(new Position(4, 4), Orientation.HORIZONTAL, BoatType.DESTROYER);
        });
    }

    @Test
    public void placingShip_placingOneShipHorizontallyOnX3Y2_ThrowsError() {
        Game game = new Game(5);
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeBoat(new Position(3, 2), Orientation.HORIZONTAL, BoatType.DESTROYER);
        });
    }

    @Test
    public void placingShip_placingOneShipVerticallyOnX4Y4_ThrowsError() {
        Game game = new Game(5);
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeBoat(new Position(4, 4), Orientation.VERTICAL, BoatType.DESTROYER);
        });
    }

    @Test
    public void placingShip_placingOneShipVerticallyOnXmin3Y4_ThrowsError() {
        Game game = new Game(5);
        assertThrows(IllegalArgumentException.class, () -> {
            game.placeBoat(new Position(-3, 4), Orientation.VERTICAL, BoatType.DESTROYER);
        });
    }

    @Test
    public void placingShip_placingOneCarrierHorizontallyOnX0Y0_Visualisation() {
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
    public void placingShip_placingOneBattleShipVerticallyOnX3Y0_Visualisation() {
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
    public void placingShip_placingOneSubmarineVerticallyOnX3Y0_Visualisation() {
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
    public void placingShip_placingOnePatrolboatHorizontallyOnX0Y0_Visualisation() {
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
    public void placingShip_placingTwoCarriersOnSamePosition_ThrowsError() {
        Game game = new Game(5);
        game.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.CARRIER);
        assertThrows(IllegalStateException.class, () -> {
            game.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.CARRIER);
        });
    }

    @Test
    public void placingShip_placingTwoShipsOverlappingEachOther_ThrowsError() {
        Game game = new Game(5);
        game.placeBoat(new Position(2, 0), Orientation.VERTICAL, BoatType.BATTLESHIP);
        assertThrows(IllegalStateException.class, () -> {
            game.placeBoat(new Position(1, 3), Orientation.HORIZONTAL, BoatType.DESTROYER);
        });
    }

    @Test
    public void placingShip_placingTwoShips_Visualisation() {
        Game game = new Game();
        game.placeBoat(new Position(0, 1), Orientation.HORIZONTAL, BoatType.SUBMARINE);
        game.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.PATROLBOAT);

        assertEquals(game.getNumberOfBoats(), 2);
        assertEquals(game.render(), """
                                            
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """);
    }


    @Test
    public void placingShip_placingAllShips_Visualisation() {
        Game game = new Game();
        game.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.PATROLBOAT);
        game.placeBoat(new Position(5, 1), Orientation.HORIZONTAL, BoatType.SUBMARINE);
        game.placeBoat(new Position(1, 3), Orientation.HORIZONTAL, BoatType.BATTLESHIP);
        game.placeBoat(new Position(5, 7), Orientation.HORIZONTAL, BoatType.CARRIER);
        game.placeBoat(new Position(0, 9), Orientation.HORIZONTAL, BoatType.DESTROYER);
        assertEquals(game.getNumberOfBoats(), 5);
        assertEquals(game.render(), """

                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🚢🚢🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🚢🚢🚢🚢🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🚢🚢🚢🚢🚢
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🚢🌊🌊🌊🌊🌊🌊🌊
                """);
    }
}
