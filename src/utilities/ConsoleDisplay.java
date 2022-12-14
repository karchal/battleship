package utilities;

import Board.Board;

public class ConsoleDisplay implements Display {

    public void showModes() {
        System.out.println("1. Player vs player\n" +
                "2: Player vs computer\n" +
                "3: Computer vs computer");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    //board1 tablica gracza, board2 tablica przeciwnika
    public void showBoards(Board board1, Board board2){

    }

    public void showMenu(){
        System.out.println("Choose one of the options:\n" +
                "1. Start new game\n" +
                "2. Display high scores\n" +
                "3. Exit");
    }

    public void showHighScores() {
        System.out.println("1. Ambroży\n" +
                "2. Mietek\n" +
                "3. Brajan");
    }
}
