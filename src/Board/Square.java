package Board;

public class Square {

    public final int X;
    public final int Y;
    SquareStatus status;

    public Square(int x, int y, SquareStatus status) {
        X = x;
        Y = y;
        this.status = status;
    }

    public String getStatusCharacter() {
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

    public String toString() {
        return getStatusCharacter();
    }

}