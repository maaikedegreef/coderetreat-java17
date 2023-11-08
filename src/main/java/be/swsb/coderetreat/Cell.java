package be.swsb.coderetreat;

public enum Cell {
    WAVE("🌊"),
    BOAT("🚢"),
    MISS("🐠"),
    HIT("🔥");

    private final String emoji;

    Cell(String emoji) {
        this.emoji = emoji;
    }


    public String getEmoji() {
        return emoji;
    }
}
