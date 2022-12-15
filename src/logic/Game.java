package logic;

import Board.Board;
import Board.BoardFactory;
import Player.AiPlayer;
import Player.HumanPlayer;
import Player.Player;
import utilities.Display;
import utilities.Input;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board1;
    private Board board2;
    private Board enemyBoard;
    private final Display display;
    private final Input input;

    public Game(Display display, Input input) {
        this.display = display;
        this.input = input;
    }

    public void play() {
        currentPlayer = player1;
        enemyBoard = board2;
        while(currentPlayer.isAlive()) {
            playTurn();
            changePlayer();
            changeBoard();
        }
        showWinner();
    }

    public void start(){
        display.showModes();
        int mode = input.getGameMode();
        setUpPlayers(mode);
        board1 = createBoard(player1);
        board2 = createBoard(player2);
    }


    private void setUpPlayers(int mode) {
        switch (mode) {
            case 1 -> setPlayerVsPlayer();
            case 2 -> setPlayerVsAi();
            case 3 -> setAiVsAi();
        }
    }

    private Board createBoard(Player player) {
        BoardFactory boardFactory = new BoardFactory(display, input);
        if (player instanceof HumanPlayer){
            return boardFactory.manualPlacement(player);
        } else {
            return boardFactory.randomPlacement(player);
        }
    }


    private void playTurn() {
        int[] coords;
        do {
            display.showBoards(getBoard(currentPlayer), enemyBoard);
            coords = currentPlayer.getShotCoords();
            enemyBoard.executeShot(coords[0], coords[1]);
            currentPlayer.addShot(enemyBoard.getSquare(coords[0], coords[1]));
        } while (currentPlayer.hasNextShot() && !enemyBoard.areAllShipsSunk());
    }

    private Board getBoard(Player player) {
        if (player == player1) return board1;
        else return board2;
    }


    private void showWinner() {
        if (currentPlayer == player2) {
            display.showMessage("Player 1 won!");
        }
        else display.showMessage("Player 2 won!");
    }


    private void changePlayer() {
        if (currentPlayer == player1) currentPlayer = player2;
        else currentPlayer = player1;
    }

    private void changeBoard() {
        if (enemyBoard == board1) enemyBoard = board2;
        else enemyBoard = board1;
    }

    private void setAiVsAi() {
        player1 = new AiPlayer();
        player2 = new AiPlayer();
    }

    private void setPlayerVsAi() {
        player1 = new HumanPlayer(input, display);
        player2 = new AiPlayer();
    }

    private void setPlayerVsPlayer() {
        player1 = new HumanPlayer(input, display);
        player2 = new HumanPlayer(input, display);
    }

    public Player getWinner(){
        if (player1.isAlive() && !player2.isAlive()){ // if (currentPlayer == player2){
            return player1;
        }
        if (!player1.isAlive() && player2.isAlive()){ // else{
            return player2;
        }
        return null;
    }
}


