package com.battleship;
import com.battleship.game.Battleship;
import com.battleship.game.TopScores;
import com.battleship.utilities.ConsoleInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleshipTest {
    //private final PrintStream standardOut = System.out;
    //private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

//    @AfterEach
//    public void tearDown() {
//        System.setOut(standardOut);
//        System.setIn(System.in);
//    }

    @Test
    public void shouldShowMenuOnStart() {
//        String data = "4\r\n3\r\n";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));

        TestDisplay display = new TestDisplay();
        TestInput input = new TestInput();

        Battleship battleship = new Battleship(display, input,  new TopScores(new LinkedHashMap<>()));

        //System.setOut(new PrintStream(outputStreamCaptor));

        battleship.start();

        assertEquals(1, display.showMenuCounter);

        //assertEquals("Choose one of the options:\n1. Start new game\n2. Display high scores\n3. Exit", outputStreamCaptor.toString().trim());

        // Jak sprawdzić czy Battleshiop w metodzie start wyświetlił menu
    }

    @Test
    public void shouldShowHighScore(){

    }
}
