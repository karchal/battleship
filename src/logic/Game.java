package logic;

import Player.AiPlayer;
import Player.HumanPlayer;
import Player.PlayerInterface;
import utilities.Display;
import utilities.Input;

public class Game {
    PlayerInterface player1;
    PlayerInterface player2;
    private PlayerInterface currentPlayer;
    private final Display display = new Display();
    private final Input input = new Input();

    public Game() {
    }

    public void mainMenu() {
        this.display.Modes();
        int mode = this.getMode();
        switch (mode) {
            case 1 -> this.playerVsPlayer();
            case 2 -> this.playerVsAi();
            case 3 -> this.aiVsAi();
        }

        this.Play();
    }

    private int getMode() {
        while(true) {
            int mode = this.input.getInt();
            if (mode >= 1 && mode <= 3) {
                return mode;
            }
            this.display.message("Choose a number between 1-3");
        }
    }

    private void Play() {
        currentPlayer = player1;
        while(currentPlayer.isAlive()) {
            currentPlayer.showBoards();
            currentPlayer.getMove();
            currentPlayer = changePlayer();
        }
        this.showWinner();
    }

    private void showWinner() {
    }

    private PlayerInterface changePlayer() {
        if (this.currentPlayer == this.player1)this.currentPlayer = this.player2;
        else this.currentPlayer = this.player1;
        return this.currentPlayer;
    }

    private void aiVsAi() {
        this.player1 = new AiPlayer();
        this.player2 = new AiPlayer();
    }

    private void playerVsAi() {
        this.player1 = new HumanPlayer();
        this.player2 = new AiPlayer();
    }

    private void playerVsPlayer() {
        this.player1 = new HumanPlayer();
        this.player2 = new HumanPlayer();
    }
}
