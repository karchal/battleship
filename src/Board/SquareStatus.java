package Board;

public enum SquareStatus{
    EMPTY("\uD83C\uDF0A"), SHIP("\uD83D\uDEA2"), HIT("\uD83D\uDD25"), MISSED("❌"), SUNK("☠"), BLOCKED("⛔");

    private String symbol;

    SquareStatus(String character) {
        this.symbol = character;
    }

    public String getSymbol() {
        return symbol;
    }

}