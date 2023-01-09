package com.battleship;

import com.battleship.game.Battleship;
import com.battleship.game.TopScores;
import com.battleship.utilities.ConsoleDisplay;
import com.battleship.utilities.ConsoleInput;
import com.battleship.utilities.Display;
import com.battleship.utilities.Input;

import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args){

        Display display = new ConsoleDisplay();
        Input input = new ConsoleInput(display);

        Battleship battleship = new Battleship(display, input, new TopScores(new LinkedHashMap<>()) );
        //battleship.showMenu();
        battleship.start();

    }

}
