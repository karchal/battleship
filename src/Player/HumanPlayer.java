package Player;

import utilities.Input;


public class HumanPlayer extends Player {
    Input input;

    public HumanPlayer(Input input) {
        this.input = input;
    }

    public int[] getShotCoors() {
        return input.getCoordinates();
    }

    public String getName() {
        return input.getStringInput();
    }


}
