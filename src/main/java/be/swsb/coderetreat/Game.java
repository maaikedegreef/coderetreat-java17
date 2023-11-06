package be.swsb.coderetreat;

import java.util.ArrayList;

public class Game {
    public static final int SIZE = 5;
    private ArrayList<Boat> boats = new ArrayList<Boat>();
    public Game() {
    }

    public int getNumberOfBoats() {
        return boats.size();
    }

    public void placeBoat(Position pos) {
        Boat boat = new Boat(pos);
        boats.add(boat);
    }

    public String render() {
        String grid = "\n";

        for (int x = 0; x < SIZE ; x++) {
            for (int y = 0; y < SIZE ; y++) {
                grid += (isBoatOnPosition(x,y) ? Cell.BOAT.getEmoji() : Cell.WAVE.getEmoji());
            }
            grid += "\n";
        }

        return grid;
    }

    private boolean isBoatOnPosition(int x, int y) {
        Position position = new Position(x,y);
        for ( Boat boat : boats) {
            if ( boat.getPosition().equals(position)) return true; break;
        }
        return false;
    }
}
