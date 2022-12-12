package Board;

public enum Direction {
    VERTICAL('v'), HORIZONTAL('h');

    public final char shortcut;

    Direction(char shortcut) {
        this.shortcut = shortcut;
    }
}
