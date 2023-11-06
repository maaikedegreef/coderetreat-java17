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

    public void placeBoat(Position position, Orientation orientation, BoatType type) {
        validateArguments(position, orientation, type);
        Boat boat = new Boat(position.getX(), position.getY(), orientation, type);
        checkBoatPosition(boat);
        boats.add(boat);
    }

    private void validateArguments(Position position, Orientation orientation, BoatType type) {
        int x = position.getX();
        int y = position.getY();
        //Check if they fit the grid
        if(orientation == Orientation.HORIZONTAL && (x < 0 || x+ type.getSize()-1 > 4 || y < 0 || y > 4))
            throw new IllegalArgumentException("This " + new Boat(position.getX(), position.getY(), orientation, type) + " doesn't fit the grid");
        if(orientation == Orientation.VERTICAL && (x < 0 || x > 4 || y < 0 || y + type.getSize()-1 > 4))
            throw new IllegalArgumentException("This " + new Boat(position.getX(), position.getY(), orientation, type) + " doesn't fit the grid");
    }

    private void checkBoatPosition(Boat boat){
        for (Position position: boat.getPositions()) {
            if (isBoatOnPosition(position.getX(), position.getY())) throw new IllegalStateException("The position " + position + " for the " + boat + " is not clear.");
        }
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
