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
        game.placeBoat(new Position(0, 0));
        assertEquals(game.getNumberOfBoats(), 1);
    }



                        //    class HelloTest {
                        //
                        //        @Test
                        //        fun `renderAnEmptyOcean`() {
                        //            val game = Game();
                        //
                        //            assertThat(game.render()).isEqualTo(
                        //                    """
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                    """.trimIndent()
//            )
//        }
//
//        @Test
//        fun `aShipCanBePlacedHorizontally` () {
//            val game = Game();
//
//            game.placeShip(Position(0, 0), 4, Orientation.HORIZONTAL);
//
//            assertThat(game.render()).isEqualTo(
//                    """
//                        🛳️️️️🛳️️️️🛳️️️️🛳️️️️🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                    """.trimIndent());
//
//        }
//
//        @Test
//        fun `aShipCanBePlacedHorizontallyAtAnderePositie` () {
//            val game = Game();
//
//            game.placeShip(Position(3, 4), 3, Orientation.HORIZONTAL);
//
//            assertThat(game.render()).isEqualTo(
//                    """
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🛳️️️️🛳️️️️🛳️️️️
//                        🌊🌊🌊🌊🌊🌊
//                    """.trimIndent());
//
//        }
//
//        @Test
//        fun `a ship can be placed vertically` () {
//            val game = Game();
//
//            game.placeShip(Position(0, 0), 3, Orientation.VERTICAL);
//
//            assertThat(game.render()).isEqualTo(
//                    """
//                        🛳️️️️🌊🌊🌊🌊🌊
//                        🛳️️️️🌊🌊🌊🌊🌊
//                        🛳️️️️🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                    """.trimIndent());
//
//        }
//
//        @Test
//        fun `We can fire and miss` () {
//            val game = Game();
//
//            game.placeShip(Position(0, 0), 3, Orientation.VERTICAL);
//            game.fire(Position(2, 1));
//
//            assertThat(game.render()).isEqualTo(
//                    """
//                        🛳️️️️🌊🌊🌊🌊🌊
//                        🛳️️️️🌊💥🌊🌊🌊
//                        🛳️️️️🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                        🌊🌊🌊🌊🌊🌊
//                    """.trimIndent());
//        }
//    }

}
