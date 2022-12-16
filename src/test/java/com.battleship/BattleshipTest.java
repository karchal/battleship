package com.battleship;

import main.java.org.battleship.utilities.ConsoleDisplay;
public class BattleshipTest {

    @Test
    public void shouldShowMenuOnStart() {
        ConsoleDisplay display = new ConsoleDisplay();
        Battleship battleship = new Battleship(display, new ConsoleInput(display));

        battleship.start();

        // Jak sprawdzić czy Battleshiop w metodzie start wyświetlił menu
    }
}
