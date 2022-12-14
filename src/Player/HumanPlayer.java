package Player;


import utilities.ConsoleDisplay;
import utilities.ConsoleInput;
import utilities.Input;


public class HumanPlayer extends Player {
    Input input;

    public HumanPlayer(Input input) {
        this.input = input;
    }

    public int[] getShotCoors() {
        //eliminate new instance of input
        ConsoleInput input = new ConsoleInput(new ConsoleDisplay());
        return input.getCoordinates();
    }

    public String getName() {
        return input.getStringInput();
    }


}
