package Player;

import utilities.Input;

import java.util.Set;


public class HumanPlayer extends Player {
    Input input;

    public HumanPlayer(Input input) {
        this.input = input;
    }

    public int[] getShotCoors() {
        return input.getCoordinates();
    }

    public String getName(Set nicknamesTaken) {
        return input.getStringInput();
    }


}
