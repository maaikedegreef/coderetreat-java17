package be.swsb.coderetreat;

import java.util.ArrayList;

public class Game {
    public static final int SIZE = 5;
    private ArrayList<Boat> boats = new ArrayList<Boat>();
    private ArrayList<Position> misses = new ArrayList<Position>();
    public Game() {
    }

    public int getNumberOfBoats() {
        return boats.size();
    }

    public void placeBoat(Position position, Orientation orientation, BoatType type) {
        validateArgumentsOfPlacingBoat(position, orientation, type);
        Boat boat = new Boat(position.getX(), position.getY(), orientation, type);
        checkBoatPosition(boat);
        boats.add(boat);
    }

    private void validateArgumentsOfPlacingBoat(Position position, Orientation orientation, BoatType type) {
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
            if (isBoatOnPosition(position)) throw new IllegalStateException("The position " + position + " for the " + boat + " is not clear.");
        }
    }

    public ArrayList<Boat> getBoats() {
        return boats;
    }

    public String render() {
        StringBuilder grid = new StringBuilder("\n");

        for (int y = 0; y < SIZE ; y++) {
            for (int x = 0; x < SIZE ; x++) {
                grid.append(getEmojiForCellOnPosition(new Position(x, y)));
            }
            grid.append("\n");
        }
        return grid.toString();
    }

    private String getEmojiForCellOnPosition(Position position){
        if(isBoatOnPosition(position)) return Cell.BOAT.getEmoji();
        else if(isMissedOnPosition(position)) return Cell.MISS.getEmoji();
        else return Cell.WAVE.getEmoji();
    }

    private boolean isBoatOnPosition(Position position) {
        for ( Boat boat : boats) {
            if ( boat.isOnPosition(position)) return true; break;
        }
        return false;
    }

    private boolean isMissedOnPosition(Position position) {
        for ( Position missed : misses) {
            if ( missed.equals(position)) return true; break;
        }
        return false;
    }

    public void fire(Position position) {
        if(!isBoatOnPosition(position)) misses.add(position);
    }
}
