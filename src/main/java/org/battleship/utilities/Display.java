package main.java.org.battleship.utilities;

import main.java.org.battleship.board.Board;

import java.util.Map;

public interface Display {

    void showMenu();

    void showModes();

    void showMessage(String message);

    void showBoards(Board playerBoard, Board enemyBoard);

    void showBoard(Board board); // we will use it during board creation

    void showHighScores(Map<String, Integer> topFiveScores);

    void clearConsole();
}
