package be.swsb.coderetreat;

import java.util.ArrayList;

public class Game {
    private ArrayList<Integer> boats = new ArrayList<>();
    public Game() {
    }

    public int getNumberOfBoats() {
        return boats.size();
    }
