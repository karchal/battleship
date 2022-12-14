import logic.Game;
import utilities.ConsoleDisplay;
import utilities.ConsoleInput;
import utilities.Display;
import utilities.Input;

public class Main {

    public static void main(String[] args){
        Display display = new ConsoleDisplay();
        Input input = new ConsoleInput((ConsoleDisplay) display);
        Battleship battleship = new Battleship(display, input);
        battleship.start();

    }

}
