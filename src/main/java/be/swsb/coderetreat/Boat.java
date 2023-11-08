package be.swsb.coderetreat;

import java.util.ArrayList;

public class Boat {
    private Orientation orientation;
    private ArrayList<Position> positions = new ArrayList<Position>();

    public Boat(int x, int y, Orientation orientation, BoatType type) {
        this.orientation = orientation;
        for (int i = 0; i < type.getSize(); i++) { //hardcoded 3
            if (orientation == Orientation.HORIZONTAL) positions.add(new Position(x + i, y));
            if (orientation == Orientation.VERTICAL) positions.add(new Position(x, y + i));
        }
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public boolean isOnPosition(Position pos) {
        return positions.contains(pos);
    }

    @Override
    public String toString() {
        String orientation = this.orientation == Orientation.VERTICAL ? "vertical" : "horizontal ";
        return orientation + "boat on positions " + positions;
    }
}
