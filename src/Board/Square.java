package Board;

public class Square {

    private final int X;
    private final int Y;
    SquareStatus status;

    public Square(int x, int y, SquareStatus status) {
        X = x;
        Y = y;
        this.status = status;
    }

    public char getStatusCharacter() {
        return status.getCharacter();
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
}