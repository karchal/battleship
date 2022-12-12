package Board;

public enum SquareStatus{
    EMPTY(' '), SHIP('X'), HIT('H'), MISSED('-'), SUNK('S'), NEIGHBOUR('n');

    private char character;

    SquareStatus(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}