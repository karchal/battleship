package utilities;

import Board.Board;

public interface Display {

    void showMenu();

    void showModes();

    void showMessage(String message);

    void showBoards(Board board1, Board board2);

    void showBoard(); // we will use it during board creation

    void showHighScores();

}
