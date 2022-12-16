package com.battleship;
import com.battleship.game.Battleship;
import com.battleship.game.TopScores;
import com.battleship.utilities.ConsoleDisplay;
import com.battleship.utilities.ConsoleInput;
import com.battleship.utilities.Display;
import org.junit.jupiter.api.Test;


import java.util.LinkedHashMap;

public class BattleshipTest {

    @Test
    public void shouldShowMenuOnStart() {
        Display display = new ConsoleDisplay();
        Battleship battleship = new Battleship(display, new ConsoleInput(display),  new TopScores(new LinkedHashMap<>()));

        battleship.start();

        // Jak sprawdzić czy Battleshiop w metodzie start wyświetlił menu
    }
}
