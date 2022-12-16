package com.battleship.game;

import com.battleship.utilities.Display;
import com.battleship.utilities.Input;


public class Battleship {
    private static final int MENU_OPTIONS_NUMBER = 3;

    private final Display display;
    private final Input input;
    private final TopScores topScores;

    public Battleship(Display display, Input input, TopScores topScores) {
        this.display = display;
        this.input = input;
        this.topScores = topScores;
    }

    public void start() {
        while(true) {
            display.showMenu();
            int menuOption = input.getOption(MENU_OPTIONS_NUMBER);
            switch (menuOption) {
                case 1 -> {
                    Game game = new Game(display, input);
                    game.start();
                    game.play();
                    topScores.updateHighScores(game);
                    display.showHighScores(topScores.getNamesAndScores());

                }
                case 2 -> display.showHighScores(topScores.getNamesAndScores());
                case 3 -> System.exit(0);
            }
        }
    }
}
