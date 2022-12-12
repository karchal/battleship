package Board;

public class Square {

    private int X;
    private int Y;
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
}