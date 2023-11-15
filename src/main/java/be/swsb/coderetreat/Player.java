package be.swsb.coderetreat;

public class Player {
    private final GameBoard gameBoard;
    private Player opponent;

    public Player() {
        this.gameBoard = new GameBoard();
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void placeBoats(Boat[] boats) {
        for (Boat boat : boats ) {
            gameBoard.placeBoat(boat);
        }
    }

    public void fire(int x, int y) {
        opponent.getGameBoard().fire(new Position(x,y));
    }

    public int getNumberOfBoats() {return gameBoard.getNumberOfBoats();}

    public Status getStatus() {
        if (gameBoard.isFinished()) return Status.NOWINNERS;
        if (getNumberOfBoats() == 0) return Status.LOST;
        if (opponent.getNumberOfBoats() == 0) return Status.WON;
        else return Status.INPROGRESS;
    }
}
