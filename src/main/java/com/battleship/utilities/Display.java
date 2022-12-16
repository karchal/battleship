package com.battleship.utilities;

import com.battleship.board.Board;

import java.util.Map;

public interface Display {

    void showMenu();

    void showModes();

    void showMessage(String message);

    void showBoards(Board playerBoard, Board enemyBoard);

    void showBoard(Board board);

    void showHighScores(Map<String, Integer> topFiveScores);

    void clearConsole();
}
