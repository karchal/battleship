package Board;

public enum Direction {
    VERTICAL("v"), HORIZONTAL("h");

    public final String shortcut;

    Direction(String shortcut) {
        this.shortcut = shortcut;
    }
}
