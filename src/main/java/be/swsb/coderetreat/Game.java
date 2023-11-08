package be.swsb.coderetreat;

import java.util.ArrayList;

public class Game {
    public static final int SIZE = 5;
    private ArrayList<Boat> boats = new ArrayList<Boat>();
    private ArrayList<Position> misses = new ArrayList<Position>();
    private ArrayList<Position> hits = new ArrayList<Position>();

    public Game() {
    }

    public int getNumberOfBoats() {
        return boats.size();
    }

    public void placeBoat(Position position, Orientation orientation, BoatType type) {
        validateArgumentsOfPlacingBoat(position, orientation, type);
        Boat boat = new Boat(position.getX(), position.getY(), orientation, type);
        validatePositionOfPlacingBoat(boat);
        boats.add(boat);
    }

    private void validateArgumentsOfPlacingBoat(Position position, Orientation orientation, BoatType type) {
        int x = position.getX();
        int y = position.getY();
        //Check if they fit the grid
        if (orientation == Orientation.HORIZONTAL && (x < 0 || x + type.getSize() - 1 > 4 || y < 0 || y > 4))
            throw new IllegalArgumentException("This " + new Boat(position.getX(), position.getY(), orientation, type) + " doesn't fit the grid");
        if (orientation == Orientation.VERTICAL && (x < 0 || x > 4 || y < 0 || y + type.getSize() - 1 > 4))
            throw new IllegalArgumentException("This " + new Boat(position.getX(), position.getY(), orientation, type) + " doesn't fit the grid");
    }

    private void validatePositionOfPlacingBoat(Boat boat) {
        for (Position position : boat.getPositions()) {
            if (isBoatOnPosition(position))
                throw new IllegalStateException("The position " + position + " for the " + boat + " is not clear, you can't place this boat here.");
        }
    }

    public ArrayList<Boat> getBoats() {
        return boats;
    }

    public String render() {
        StringBuilder grid = new StringBuilder("\n");

        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                grid.append(getEmojiForCellOnPosition(new Position(x, y)));
            }
            grid.append("\n");
        }
        return grid.toString();
    }

    private String getEmojiForCellOnPosition(Position position) {
        return isMissedOnPosition(position) ? Cell.MISS.getEmoji() :
                isHittedOnPosition(position) ? Cell.HIT.getEmoji() :
                        isBoatOnPosition(position) ? Cell.BOAT.getEmoji() :
                                Cell.WAVE.getEmoji();
    }

    private boolean isBoatOnPosition(Position position) {
        return getBoatOnPosition(position) != null;
    }
    private Boat getBoatOnPosition(Position position) {
        for (Boat boat : boats) {
            if (boat.isOnPosition(position)) return boat;
            break;
        }
        return null;
    }

    private boolean isMissedOnPosition(Position position) {
        for (Position missed : misses) {
            if (missed.equals(position)) {
                return true;
            }
        }
        return false;
    }

    private boolean isHittedOnPosition(Position position) {
        for (Position hitted : hits) {
            if (hitted.equals(position)) {
                return true;
            }
        }
        return false;
    }

    public void fire(Position position) {
        if (!isBoatOnPosition(position)) {
            misses.add(position);
        } else {
            hits.add(position);
            getBoatOnPosition(position).getHitOnPosition(position);
        }
        checkForSunkenBoats();
    }

    private void checkForSunkenBoats() {
        boats.removeIf(boat -> boat.getPositions().isEmpty());
    }

}
