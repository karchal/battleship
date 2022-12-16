package main.java.org.battleship.game;

import main.java.org.battleship.player.Player;

import java.util.*;
import java.util.stream.Collectors;

public class TopScores {
    private Map<String, Integer> namesAndScores;
    private static final int MAX_TOP_SCORES = 5;


    public TopScores(Map<String, Integer> listOfTopScores) {
        this.namesAndScores = listOfTopScores;
    }

    public Map<String, Integer> getNamesAndScores() {
        return namesAndScores;
    }

    public void updateHighScores(Game game) {
        Player player = game.getWinner();
        int score = player.getScore();
        if (namesAndScores.size() < MAX_TOP_SCORES || score > getMinTopScore()){
            if (namesAndScores.size() >= MAX_TOP_SCORES) removeItemWithMinScore();
            String name = player.getName(new HashSet<>(namesAndScores.keySet()));
            namesAndScores.put(name, score);
            sortTopScores();
        }
    }

    private int getMinTopScore() {
        return Collections.min(namesAndScores.values());
    }

    private void removeItemWithMinScore() {
        for(String name: namesAndScores.keySet()){
            if (namesAndScores.get(name) == getMinTopScore()){
                namesAndScores.remove(name);
            }
        }
    }

    private void sortTopScores(){
        namesAndScores = namesAndScores.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
