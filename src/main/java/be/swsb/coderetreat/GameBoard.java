package be.swsb.coderetreat;

import java.util.ArrayList;

public class GameBoard {
    public static final int DEFAULT_SIZE = 10;
    private int size;
    private ArrayList<Boat> boats = new ArrayList<Boat>();
    private ArrayList<Position> misses = new ArrayList<Position>();
    private ArrayList<Position> hits = new ArrayList<Position>();

    public GameBoard() {
        this.size = DEFAULT_SIZE;
    }

    public GameBoard(int gridSize) {
        this.size = gridSize;
    }

    public int getNumberOfBoats() {
        return boats.size();
    }

    public void placeBoat(Position position, Orientation orientation, BoatType type) {
        validateArgumentsOfPlacingBoat(position, orientation, type);
        Boat boat = new Boat(position.x(), position.y(), orientation, type);
        validatePositionOfPlacingBoat(boat);
        boats.add(boat);
    }

    public void placeBoat(Boat boat) {
        placeBoat(boat.getPositions().get(0), boat.getOrientation(), boat.getType());
    }

    private void validateArgumentsOfPlacingBoat(Position position, Orientation orientation, BoatType type) {
        int x = position.x();
        int y = position.y();
        //Check if they fit the grid
        if (orientation == Orientation.HORIZONTAL && (x < 0 || x + type.getSize() - 1 > size - 1 || y < 0 || y > size - 1))
            throw new IllegalArgumentException("This " + new Boat(position.x(), position.y(), orientation, type) + " doesn't fit the grid");
        if (orientation == Orientation.VERTICAL && (x < 0 || x > size - 1 || y < 0 || y + type.getSize() - 1 > size - 1))
            throw new IllegalArgumentException("This " + new Boat(position.x(), position.y(), orientation, type) + " doesn't fit the grid");
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

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
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

    public boolean isFinished() {
        return misses.size() + hits.size() == size * size;
    }
}
