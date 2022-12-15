package main.java.org.battleship.game;

import main.java.org.battleship.utilities.Display;
import main.java.org.battleship.Player.Player;
import main.java.org.battleship.utilities.Input;

import java.util.*;
import java.util.stream.Collectors;


public class Battleship {
    private static final int MENU_OPTIONS_NUMBER = 3;
    private static final int MAX_TOP_SCORES = 5;

    private final Display display;
    private final Input input;
    private Map<String, Integer> topScores = new LinkedHashMap<>();

    public Battleship(Display display, Input input) {
        this.display = display;
        this.input = input;
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
                    updateHighScores(game);
                }
                case 2 -> display.showHighScores(topScores);
                case 3 -> System.exit(0);
            }
        }
    }

    private void updateHighScores(Game game) {
        Player player = game.getWinner();
        int score = player.getScore();
        if (topScores.size() < MAX_TOP_SCORES || score > getMinTopScore()){
            if (topScores.size() >= MAX_TOP_SCORES) removeItemWithMinScore();
            String name = player.getName(new HashSet<>(topScores.keySet()));
            topScores.put(name, score);
            sortTopScores();
        }
        display.showHighScores(topScores);
    }

    private int getMinTopScore() {
        return Collections.min(topScores.values());
    }

    private void removeItemWithMinScore() {
        for(String name: topScores.keySet()){
            if (topScores.get(name) == getMinTopScore()){
                topScores.remove(name);
            }
        }
    }


    private void sortTopScores(){
        topScores = topScores.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }


}
