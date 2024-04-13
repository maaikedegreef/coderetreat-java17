package be.swsb.coderetreat;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlacingBoatTest {
    @Test
    public void placingBoat_placingOneShipHorizontallyOnX1Y1_NumberOfBoatsEqualsToOne() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(1, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);
        assertEquals(gameBoard.getNumberOfBoats(), 1);
    }

    @Test
    public void placingBoat_placingOneShipHorizontallyOnX1Y1_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(1, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);
        assertEquals(gameBoard.render(), """
                                            
                🌊🌊🌊🌊🌊
                🌊🚢🚢🚢🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);
    }

    @Test
    public void placingBoat_placingOneShipHorizontallyOnX0Y1_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(0, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);
        assertEquals(gameBoard.getNumberOfBoats(), 1);
        assertEquals(gameBoard.render(), """
                                            
                🌊🌊🌊🌊🌊
                🚢🚢🚢🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);
    }

    @Test
    public void placingBoat_placingOneShipHorizontallyOnX2Y4_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(2, 4), Orientation.HORIZONTAL, BoatType.DESTROYER);
        assertEquals(gameBoard.getNumberOfBoats(), 1);
        assertEquals(gameBoard.render(), """
                                            
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🚢🚢🚢
                """);
    }

    @Test
    public void placingBoat_placingOneShipVerticallyOnX1Y1_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(1, 1), Orientation.VERTICAL, BoatType.DESTROYER);
        assertEquals(gameBoard.getNumberOfBoats(), 1);
        assertEquals(gameBoard.render(), """
                                            
                🌊🌊🌊🌊🌊
                🌊🚢🌊🌊🌊
                🌊🚢🌊🌊🌊
                🌊🚢🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);
    }

    @Test
    public void placingBoat_placingOneShipHorizontallyOnX4Y4_ThrowsError() {
        GameBoard gameBoard = new GameBoard(5);
        //assertj chaining? fluent api
        assertThrows(IllegalArgumentException.class, () -> gameBoard.placeBoat(new Position(4, 4), Orientation.HORIZONTAL, BoatType.DESTROYER));
        Assertions.assertThatThrownBy(() -> gameBoard.placeBoat(new Position(4, 4), Orientation.HORIZONTAL, BoatType.DESTROYER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Dit mag niet");
    }

    @Test
    public void placingBoat_placingOneShipHorizontallyOnX3Y2_ThrowsError() {
        GameBoard gameBoard = new GameBoard(5);
        assertThrows(IllegalArgumentException.class, () -> gameBoard.placeBoat(new Position(3, 2), Orientation.HORIZONTAL, BoatType.DESTROYER));
    }

    @Test
    public void placingBoat_placingOneShipVerticallyOnX4Y4_ThrowsError() {
        GameBoard gameBoard = new GameBoard(5);
        assertThrows(IllegalArgumentException.class, () -> gameBoard.placeBoat(new Position(4, 4), Orientation.VERTICAL, BoatType.DESTROYER));
    }

    @Test
    public void placingBoat_placingOneShipVerticallyOnXmin3Y4_ThrowsError() {
        GameBoard gameBoard = new GameBoard(5);
        assertThrows(IllegalArgumentException.class, () -> gameBoard.placeBoat(new Position(-3, 4), Orientation.VERTICAL, BoatType.DESTROYER));
    }

    @Test
    public void placingBoat_placingOneCarrierHorizontallyOnX0Y0_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.CARRIER);
        assertEquals(gameBoard.getNumberOfBoats(), 1);
        assertEquals(gameBoard.render(), """
                                            
                🚢🚢🚢🚢🚢
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);
    }

    @Test
    public void placingBoat_placingOneBattleShipVerticallyOnX3Y0_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(3, 0), Orientation.VERTICAL, BoatType.BATTLESHIP);
        assertEquals(gameBoard.getNumberOfBoats(), 1);
        assertEquals(gameBoard.render(), """
                                            
                🌊🌊🌊🚢🌊
                🌊🌊🌊🚢🌊
                🌊🌊🌊🚢🌊
                🌊🌊🌊🚢🌊
                🌊🌊🌊🌊🌊
                """);
    }

    @Test
    public void placingBoat_placingOneSubmarineVerticallyOnX3Y0_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(3, 0), Orientation.VERTICAL, BoatType.SUBMARINE);
        assertEquals(gameBoard.getNumberOfBoats(), 1);
        assertEquals(gameBoard.render(), """
                                            
                🌊🌊🌊🚢🌊
                🌊🌊🌊🚢🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);
    }

    @Test
    public void placingBoat_placingOnePatrolboatHorizontallyOnX0Y0_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.PATROLBOAT);
        assertEquals(gameBoard.getNumberOfBoats(), 1);
        //actual en expected omgedraaid
        assertEquals(gameBoard.render(), """
                                            
                🚢🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);
    }

    @Test
    public void placingBoat_placingTwoCarriersOnSamePosition_ThrowsError() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.CARRIER);
        assertThrows(IllegalStateException.class, () -> gameBoard.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.CARRIER));
    }

    @Test
    public void placingBoat_placingTwoShipsOverlappingEachOther_ThrowsError() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(2, 0), Orientation.VERTICAL, BoatType.BATTLESHIP);
        assertThrows(IllegalStateException.class, () -> gameBoard.placeBoat(new Position(1, 3), Orientation.HORIZONTAL, BoatType.DESTROYER));
    }

    @Test
    public void placingBoat_placingTwoShips_Visualisation() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.placeBoat(new Position(0, 1), Orientation.HORIZONTAL, BoatType.SUBMARINE);
        gameBoard.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.PATROLBOAT);

        assertEquals(gameBoard.getNumberOfBoats(), 2);
        assertEquals(gameBoard.render(), """
                                            
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
    public void placingBoat_placingAllShips_Visualisation() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.placeBoat(new Position(0, 0), Orientation.HORIZONTAL, BoatType.PATROLBOAT);
        gameBoard.placeBoat(new Position(5, 1), Orientation.HORIZONTAL, BoatType.SUBMARINE);
        gameBoard.placeBoat(new Position(1, 3), Orientation.HORIZONTAL, BoatType.BATTLESHIP);
        gameBoard.placeBoat(new Position(5, 7), Orientation.HORIZONTAL, BoatType.CARRIER);
        gameBoard.placeBoat(new Position(0, 9), Orientation.HORIZONTAL, BoatType.DESTROYER);
        assertEquals(gameBoard.getNumberOfBoats(), 5);
        assertEquals(gameBoard.render(), """

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

    @Test
    public void placingBoat_placingAllShipsBis_Visualisation() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.placeBoat(new Position(9, 0), Orientation.HORIZONTAL, BoatType.PATROLBOAT);
        gameBoard.placeBoat(new Position(5, 1), Orientation.HORIZONTAL, BoatType.SUBMARINE);
        gameBoard.placeBoat(new Position(3, 3), Orientation.VERTICAL, BoatType.BATTLESHIP);
        gameBoard.placeBoat(new Position(5, 7), Orientation.HORIZONTAL, BoatType.CARRIER);
        gameBoard.placeBoat(new Position(0, 0), Orientation.VERTICAL, BoatType.DESTROYER);
        assertEquals(gameBoard.getNumberOfBoats(), 5);
        assertEquals(gameBoard.render(), """

                🚢🌊🌊🌊🌊🌊🌊🌊🌊🚢
                🚢🌊🌊🌊🌊🚢🚢🌊🌊🌊
                🚢🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🚢🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🚢🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🚢🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🚢🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🚢🚢🚢🚢🚢
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                """);
    }
}
