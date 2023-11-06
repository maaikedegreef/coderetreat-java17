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

    public void placeBoat(Position position, Orientation orientation) {
        validateRequest(position, orientation);
        Boat boat = new Boat(position.getX(), position.getY(), orientation);
        boats.add(boat);
    }

    private void validateRequest(Position position, Orientation orientation) {
        int x = position.getX();
        int y = position.getY();
        //Check if they fit the grid
        if(orientation == Orientation.HORIZONTAL && (x < 0 || x + 2 > 4 || y < 0 || y > 4))
            throw new IllegalArgumentException("This " + new Boat(position.getX(), position.getY(), orientation) + " doesn't fit the grid");
        if(orientation == Orientation.VERTICAL && (x < 0 || x > 4 || y < 0 || y + 2 > 4))
            throw new IllegalArgumentException("This " + new Boat(position.getX(), position.getY(), orientation) + " doesn't fit the grid");
    }

    public ArrayList<Boat> getBoats() {
        return boats;
    }

    public String render() {
        String grid = "\n";

        for (int y = 0; y < SIZE ; y++) {
            for (int x = 0; x < SIZE ; x++) {
                grid += (isBoatOnPosition(x,y) ? Cell.BOAT.getEmoji() : Cell.WAVE.getEmoji());
            }
            grid += "\n";
        }
        return grid;
    }

    private boolean isBoatOnPosition(int x, int y) {
        Position position = new Position(x,y);
        for ( Boat boat : boats) {
            if ( boat.isOnPosition(position)) return true; break;
        }
        return false;
    }
}
