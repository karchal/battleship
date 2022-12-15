package utilities;

import Board.Board;

import java.util.HashMap;
import java.util.Map;

public interface Display {

    void showMenu();

    void showModes();

    void showMessage(String message);

    void showBoards(Board playerBoard, Board enemyBoard);

    public void showBoard(Board board); // we will use it during board creation

    void showHighScores(Map<String, Integer> topFiveScores);

}
