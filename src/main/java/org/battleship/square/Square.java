package main.java.org.battleship.square;

public class Square {
    private static final int POINTS_FOR_HIT_SQUARE = 1;
    private static final int POINTS_FOR_SHIP_SQUARE = 3;

    private final int X;
    private final int Y;

    private final boolean areShipsHidden;
    private SquareStatus status;

    public Square(int x, int y, SquareStatus status) {
        X = x;
        Y = y;
        this.status = status;
        this.areShipsHidden=false;
    }

    public String getStatusCharacter() {
        return status.getSymbol();
    }

    public void setStatus(SquareStatus status) {
        this.status = status;
    }

    public SquareStatus getStatus() {
        return status;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public String toString() {
        if (areShipsHidden()){
            return SquareStatus.EMPTY.getSymbol();
        }
        return getStatusCharacter();
    }

    public boolean areShipsHidden() {
        return areShipsHidden;
    }


    public int getPoints() {
        if (status == SquareStatus.HIT) return POINTS_FOR_HIT_SQUARE;
        if (status == SquareStatus.SHIP) return POINTS_FOR_SHIP_SQUARE;
        return 0;
    }

    public boolean hasCoords(int X, int Y) {
        return this.X == X && this.Y == Y;
    }

    public boolean isEmpty(){
        if (status == SquareStatus.EMPTY) return true;
        return false;
    }

    public void blockIfEmpty(){
        if (status == SquareStatus.EMPTY) status = SquareStatus.BLOCKED;
    }

    public void unlock(){
        if (status == SquareStatus.BLOCKED) status = SquareStatus.EMPTY;
    }

    public void becomeShipPart() {
        if (status == SquareStatus.EMPTY) status = SquareStatus.SHIP;
    }

    public void changeToMissed(){
        if (status == SquareStatus.EMPTY) status = SquareStatus.MISSED;
    }

    public void changeToHit(){
        if (status == SquareStatus.SHIP) status = SquareStatus.HIT;
    }

}