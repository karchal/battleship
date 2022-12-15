package main.java.org.battleship.Player;

import main.java.org.battleship.utilities.Display;
import main.java.org.battleship.utilities.Input;

import java.util.HashSet;


public class HumanPlayer extends Player {
    private final Input input;
    private final Display display;


    public HumanPlayer(Input input, Display display) {
        this.input = input;
        this.display = display;
    }

    public int[] getShotCoords() {
        display.showMessage("Enter coordinates to take a shot: ");
        return input.getCoordinates();
    }

    public String getName(HashSet<String> nicknamesTaken) {
        String nickname;
        do {
            display.showMessage("Enter your nickname: ");
            nickname = input.getStringInput();
        } while (nicknamesTaken.contains(nickname));
        return nickname;
    }

}
