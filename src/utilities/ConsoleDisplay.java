package utilities;

import Board.Board;

import java.util.HashMap;
import java.util.Map;

public class ConsoleDisplay implements Display {

    public void showModes() {
        System.out.println("1. Player vs player\n" +
                "2: Player vs computer\n" +
                "3: Computer vs computer");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showBoards(Board playerBoard, Board enemyBoard){
        int boardsCount =0;
        StringBuilder displayBoard = new StringBuilder();
        char[] columns = "ABCDEFGHIJ".toCharArray();
        displayBoard.append("    ");
        while (boardsCount!=2 ) {
            for (int i=0; i< playerBoard.size; i++) {
                if (i !=4) {
                    displayBoard.append(i + 1).append("   ");
                } else {
                    displayBoard.append(i + 1).append("    ");
                }
            }
            boardsCount++;
            if (boardsCount==1){
                displayBoard.append("|     ");
            }
        }
        displayBoard.append("\n");

        for (int i=0; i< playerBoard.size; i++){
            displayBoard.append(columns[i]).append("  ");
            for (int j=0; j<playerBoard.size*2+6; j++){
                if (j<10) {
                    displayBoard.append(playerBoard.getOcean()[i][j]).append("  ");
                } else if (j>15){
                    displayBoard.append(enemyBoard.getOcean()[i][j-16]).append("  ");
                } else if (j==11){
                    displayBoard.append(" | ");
                } else if (j==13){
                    displayBoard.append(columns[i]).append("  ");
                }
            }
            displayBoard.append("\n");
        }
        System.out.println(displayBoard);
    }

    public void showBoard(Board board){

    }

    public void showMenu(){
        System.out.println("Choose one of the options:\n" +
                "1. Start new game\n" +
                "2. Display high scores\n" +
                "3. Exit");
    }

    public void showHighScores(Map<String, Integer> topScores) {
        topScores.entrySet()
                .stream()
                .forEach(System.out::println);
    }
}
