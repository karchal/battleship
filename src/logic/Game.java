package logic;

import Board.Board;
import Player.AiPlayer;
import Player.HumanPlayer;
import Player.Player;
import utilities.Display;
import utilities.Input;

public class Game {
    Player player1;
    Player player2;
    private Player currentPlayer;
    Board board1;
    Board board2;
    private final Display display = new Display();
    private final Input input = new Input();

    public Game() {
    }

    public void setUpGameMode() {
        this.display.showModes();
        int mode = this.getMode();
        switch (mode) {
            case 1 -> playerVsPlayer();
            case 2 -> playerVsAi();
            case 3 -> aiVsAi();
        }
    }

    private int getMode() {
        while(true) {
            int mode = input.getInt();
            if (mode >= 1 && mode <= 3) {
                return mode;
            }
            display.showMessage("Choose a number between 1-3");
        }
    }

    private void play() {
        start();
        currentPlayer = player1;
        while(currentPlayer.isAlive()) {

            playTurn();

            currentPlayer = changePlayer();
        }
        showWinner();
    }

    private void playTurn() {
        currentPlayer.showBoards();
        while(true){
            currentPlayer.getMove();
            upDateGameState();
        }
    }

    private void upDateGameState() {
    }

    private void start(){
        setUpGameMode();
        setUpPlayers();
        setUpBoards();
    }

    private void setUpBoards() {

    }

    private void setUpPlayers() {

    }

    private void showWinner() {
    }


    private Player changePlayer() {
        if (currentPlayer == player1) currentPlayer = player2;
        else currentPlayer = player1;
        return currentPlayer;
    }

    private void aiVsAi() {
        player1 = new AiPlayer();
        player2 = new AiPlayer();
    }

    private void playerVsAi() {
        player1 = new HumanPlayer();
        player2 = new AiPlayer();
    }

    private void playerVsPlayer() {
        player1 = new HumanPlayer();
        player2 = new HumanPlayer();
    }
}
