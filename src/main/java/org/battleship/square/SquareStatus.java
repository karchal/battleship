package main.java.org.battleship.square;

public enum SquareStatus{
    EMPTY("\uD83C\uDF0A"), SHIP("\uD83D\uDEA2"), HIT("\uD83D\uDD25"), MISSED("❌"), SUNK("☠"), BLOCKED("⛔");

    private final String symbol;

    SquareStatus(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}