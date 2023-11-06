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
