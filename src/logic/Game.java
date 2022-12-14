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
    private final Display display = new Display();
    private final Input input = new Input();



    public void play() {
        currentPlayer = player1;
        enemyBoard = board2;
        while(currentPlayer.isAlive()) {
            playTurn();
            changePlayer();
            changeBoard();
        }
    }

    public void start(){
        display.showModes();
        int mode = getMode();
        setUpPlayers(mode);
        board1 = createBoard(player1);
        board2 = createBoard(player2);
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

    private void setUpPlayers(int mode) {
        switch (mode) {
            case 1 -> setPlayerVsPlayer();
            case 2 -> setPlayerVsAi();
            case 3 -> setAiVsAi();
        }
    }

    private Board createBoard(Player player) {
        BoardFactory boardFactory = new BoardFactory();
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
            coords = currentPlayer.getShotCoors();
            enemyBoard.executeShot(coords[0], coords[1]);
            currentPlayer.addShot(enemyBoard.getSquare(coords[0], coords[1]));
        } while (currentPlayer.hasNextShot() && !enemyBoard.areAllShipsSunk());
    }

    private Board getBoard(Player player) {
        if (player == player1) return board1;
        else return board2;
    }

    public void end() {
        showWinner();
        //maybe some other features like showRanking()
    }

    private void showWinner() {
        if (player1.isAlive()) display.showMessage("Player 1 won!");
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
        player1 = new HumanPlayer();
        player2 = new AiPlayer();
    }

    private void setPlayerVsPlayer() {
        player1 = new HumanPlayer();
        player2 = new HumanPlayer();
    }
}


