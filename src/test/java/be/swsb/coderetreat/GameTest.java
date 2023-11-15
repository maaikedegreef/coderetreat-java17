package be.swsb.coderetreat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameTest {

    Boat[] boats1 = {
            new Boat(0, 0, Orientation.HORIZONTAL, BoatType.PATROLBOAT),
            new Boat(5, 1, Orientation.HORIZONTAL, BoatType.SUBMARINE),
            new Boat(0, 9, Orientation.HORIZONTAL, BoatType.DESTROYER),
            new Boat(1, 3, Orientation.HORIZONTAL, BoatType.BATTLESHIP),
            new Boat(5, 7, Orientation.HORIZONTAL, BoatType.CARRIER)
    };

    Boat[] boats2 = {
            new Boat(9, 0, Orientation.HORIZONTAL, BoatType.PATROLBOAT),
            new Boat(5, 1, Orientation.HORIZONTAL, BoatType.SUBMARINE),
            new Boat(3, 3, Orientation.VERTICAL, BoatType.BATTLESHIP),
            new Boat(5, 7, Orientation.HORIZONTAL, BoatType.CARRIER),
            new Boat(0, 0, Orientation.VERTICAL, BoatType.DESTROYER)
    };

    @Test
    public void game_twoPlayers_alternatingThreeMoves() {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.setOpponent(player2);
        player2.setOpponent(player1);

        player1.placeBoats(boats1);
        player2.placeBoats(boats2);

        player1.fire(0, 0);
        player2.fire(1, 1);
        player1.fire(2, 1);
        player2.fire(3, 1);
        player1.fire(9, 0);
        player2.fire(9, 0);

        assertEquals(player1.getNumberOfBoats(), 5);
        assertEquals(player2.getNumberOfBoats(), 4);

        assertFalse(player1.isFinished());

        assertEquals(player1.getGameBoard().render(), """

                🚢🌊🌊🌊🌊🌊🌊🌊🌊🐠
                🌊🐠🌊🐠🌊🚢🚢🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🚢🚢🚢🚢🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🌊🌊🌊🌊🌊🚢🚢🚢🚢🚢
                🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                🚢🚢🚢🌊🌊🌊🌊🌊🌊🌊
                """);

        assertEquals(player2.getGameBoard().render(), """

                🔥🌊🌊🌊🌊🌊🌊🌊🌊🔥
                🚢🌊🐠🌊🌊🚢🚢🌊🌊🌊
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
