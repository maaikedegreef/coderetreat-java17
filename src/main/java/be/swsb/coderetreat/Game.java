package be.swsb.coderetreat;

import java.util.ArrayList;

public class Game {
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
