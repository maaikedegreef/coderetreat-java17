package be.swsb.coderetreat;

public enum BoatType {
    CARRIER(5),
    BATTLESHIP(4),
    DESTROYER(3),
    SUBMARINE(2),
    PATROLBOAT(1);

    private final int size;

    BoatType(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}


