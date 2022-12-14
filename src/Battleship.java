import logic.Game;
import utilities.ConsoleDisplay;
import utilities.ConsoleInput;
import utilities.Display;
import utilities.Input;


public class Battleship {
    private Display display;
    private Input input;
    private static final int MENU_OPTIONS_NUMBER = 3;

    public Battleship(Display display, Input input) {
        this.display = display;
        this.input = input;
    }

    public void start() {
        while(true) {
            display.showMenu();
            int menuOption = input.getOption(MENU_OPTIONS_NUMBER);
            switch (menuOption) {
                case 1:
                    Game game = new Game(display, input);
                    game.start();
                    game.play();
                    game.end();
                    break;
                case 2:
                    display.showHighScores();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
