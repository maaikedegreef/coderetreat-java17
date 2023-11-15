package be.swsb.coderetreat;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameBoardTest {

    @Test
    public void gameBoard_renderNewGameBoard_NumberOfBoatsEqualsToZero() {
        GameBoard gameBoard = new GameBoard(5);
        assertEquals(gameBoard.getNumberOfBoats(), 0);
    }

    @Test
    public void gameBoard_renderNewGameBoard_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        assertEquals(gameBoard.render(), """
                                            
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);

    }

    @Test
    public void gameBoard_fireAndMiss_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(1, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);

        gameBoard.fire(new Position(0, 0));

        assertEquals(gameBoard.getNumberOfBoats(), 1);
        assertEquals(gameBoard.render(), """
                                            
                🐠🌊🌊🌊🌊
                🌊🚢🚢🚢🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);

    }

    @Test
    public void gameBoard_fireAndMissMultipleTimes_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(1, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);

        gameBoard.fire(new Position(0, 0));
        gameBoard.fire(new Position(0, 1));
        gameBoard.fire(new Position(0, 2));
        gameBoard.fire(new Position(2, 3));
        gameBoard.fire(new Position(3, 3));

        assertEquals(gameBoard.getNumberOfBoats(), 1);
        assertEquals(gameBoard.render(), """
                                            
                🐠🌊🌊🌊🌊
                🐠🚢🚢🚢🌊
                🐠🌊🌊🌊🌊
                🌊🌊🐠🐠🌊
                🌊🌊🌊🌊🌊
                """);

    }

    @Test
    public void gameBoard_fireAndHitOneCellOfDestroyerOnX1Y1_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(1, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);

        gameBoard.fire(new Position(0, 0));
        gameBoard.fire(new Position(2, 1));

        assertEquals(gameBoard.getNumberOfBoats(), 1);
        assertEquals(gameBoard.render(), """

                🐠🌊🌊🌊🌊
                🌊🚢🔥🚢🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);

    }

    @Test
    public void gameBoard_fireAndHitTwoCellsOfDestroyerOnX1Y1_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(1, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);

        gameBoard.fire(new Position(0, 0));
        gameBoard.fire(new Position(2, 1));
        gameBoard.fire(new Position(3, 1));

        assertEquals(gameBoard.getNumberOfBoats(), 1);
        assertEquals(gameBoard.render(), """

                🐠🌊🌊🌊🌊
                🌊🚢🔥🔥🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);

    }

    @Test
    public void gameBoard_fireAndHitThreeCellsOfDestroyerOnX1Y1_Visualisation() {
        GameBoard gameBoard = new GameBoard(5);
        gameBoard.placeBoat(new Position(1, 1), Orientation.HORIZONTAL, BoatType.DESTROYER);

        gameBoard.fire(new Position(0, 0));
        gameBoard.fire(new Position(1, 1));
        gameBoard.fire(new Position(2, 1));
        gameBoard.fire(new Position(3, 1));

        assertEquals(gameBoard.getNumberOfBoats(), 0);
        assertEquals(gameBoard.render(), """

                🐠🌊🌊🌊🌊
                🌊🔥🔥🔥🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊
                """);

    }
}
