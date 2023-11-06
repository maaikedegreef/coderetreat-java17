package be.swsb.coderetreat;

public enum Cell {
    WAVE(0,"🌊"),
    BOAT(1,"🚢");

    private final int value;
    private final String emoji;

    Cell(int value, String emoji) {
        this.value = value;
        this.emoji = emoji;
    }

    public int getValue() {
        return value;
    }

    public String getEmoji() {
        return emoji;
    }
}
