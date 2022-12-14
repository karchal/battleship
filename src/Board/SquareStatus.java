package Board;

public enum SquareStatus{
    EMPTY("\uD83C\uDF0A"), SHIP("\uD83D\uDEA2"), HIT("\uD83D\uDD25"), MISSED("❌"), SUNK("\uD83D\uDC80"), BLOCKED("⛔");

    private String character;

    SquareStatus(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

}