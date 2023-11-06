package be.swsb.coderetreat;



import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleshipTest {

    @Test
    public void game_renderNewGame_NumberOfBoatsEqualsToZero() {
        Game game = new Game();
        assertEquals(game.getNumberOfBoats(), 0);
    }

    @Test
    public void game_placingOneShipHorizontallyOnX1Y1_NumberOfBoatsEqualsToOne() {
        Game game = new Game();
        game.placeBoat(new Position(0, 0));
        assertEquals(game.getNumberOfBoats(), 1);
    }

