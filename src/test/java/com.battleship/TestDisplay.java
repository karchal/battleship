package com.battleship;

import com.battleship.board.Board;
import com.battleship.utilities.Display;

import java.util.Map;

public class TestDisplay implements Display {
    public int showMenuCounter;

    @Override
    public void showMenu() {
        showMenuCounter++;
    }

    @Override
    public void showModes() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showBoards(Board playerBoard, Board enemyBoard) {

    }

    @Override
    public void showBoard(Board board) {

    }

    @Override
    public void showHighScores(Map<String, Integer> topFiveScores) {

    }

    @Override
    public void clearConsole() {

    }
}
