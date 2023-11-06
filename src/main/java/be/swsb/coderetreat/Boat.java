package be.swsb.coderetreat;

import java.util.ArrayList;

public class Boat {
    private ArrayList<Position> positions = new ArrayList<Position>();
    public Boat(int x, int y) {
        for (int i = 0; i < 3; i++) { //hardcoded 3
            positions.add(new Position(x,y+i)); //hardcoded horizontally
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
        return "Boat{" +
                "positions=" + positions +
                '}';
    }
}
