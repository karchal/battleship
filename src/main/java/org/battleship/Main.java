package main.java.org.battleship;

import main.java.org.battleship.game.Battleship;
import main.java.org.battleship.game.TopScores;
import main.java.org.battleship.utilities.ConsoleDisplay;
import main.java.org.battleship.utilities.ConsoleInput;
import main.java.org.battleship.utilities.Display;
import main.java.org.battleship.utilities.Input;

import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args){

        Display display = new ConsoleDisplay();
        Input input = new ConsoleInput(display);

        Battleship battleship = new Battleship(display, input, new TopScores(new LinkedHashMap<>()) );
        battleship.start();

    }

}
