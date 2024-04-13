package be.swsb.coderetreat;

import java.util.ArrayList;

public class Boat {
    private final Orientation orientation;
    // kan dit weg gewerkt worden?
    private final ArrayList<Position> positions = new ArrayList<>();
    private final BoatType type;

    public Boat(int x, int y, Orientation orientation, BoatType type) {
        this.orientation = orientation;
        this.type = type;
        for (int i = 0; i < type.getSize(); i++) {
            if (orientation == Orientation.HORIZONTAL) positions.add(new Position(x + i, y));
            if (orientation == Orientation.VERTICAL) positions.add(new Position(x, y + i));
        }
    }

    //nodig?
    public void getHitOnPosition(Position position) {
        positions.remove(position);
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public BoatType getType() {
        return type;
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
