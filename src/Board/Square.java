package Board;

public class Square {
    private static final int POINTS_FOR_HIT_SQUARE = 1;
    private static final int POINTS_FOR_SHIP_SQUARE = 3;

    private final int X;
    private final int Y;
    SquareStatus status;

    public Square(int x, int y, SquareStatus status) {
        X = x;
        Y = y;
        this.status = status;
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
        return getStatusCharacter();
    }


    public int getPoints() {
        if (status == SquareStatus.HIT) return POINTS_FOR_HIT_SQUARE;
        if (status == SquareStatus.SHIP) return POINTS_FOR_SHIP_SQUARE;
        return 0;
    }

    public boolean hasCoords(int X, int Y) {
        return this.X == X && this.Y == Y;
    }
}