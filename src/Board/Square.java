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
}