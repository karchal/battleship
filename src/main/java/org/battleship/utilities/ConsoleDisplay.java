package main.java.org.battleship.utilities;

import main.java.org.battleship.Board.Board;
import main.java.org.battleship.square.SquareStatus;

import java.util.Map;

public class ConsoleDisplay implements Display {

    public void showModes() {
        System.out.println("1. Player vs player\n2: Player vs computer\n3: Computer vs computer");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showBoards(Board playerBoard, Board enemyBoard) {
        int boardsCount = 0;
        StringBuilder displayBoard = new StringBuilder();
        char[] columns = "ABCDEFGHIJ".toCharArray();
        displayBoard.append("    ");
        while (boardsCount != 2) {
            for (int i = 0; i < Board.SIZE; i++) {
                if (i != 4) {
                    displayBoard.append(i + 1).append("   ");
                } else {
                    displayBoard.append(i + 1).append("    ");
                }
            }
            boardsCount++;
            if (boardsCount == 1) {
                displayBoard.append("|     ");
            }
        }
        displayBoard.append("\n");

        for (int i = 0; i < Board.SIZE; i++) {
            displayBoard.append(columns[i]).append("  ");
            for (int j = 0; j < Board.SIZE * 2 + 6; j++) {
                if (j < 10) {
                    displayBoard.append(playerBoard.getOcean()[i][j]).append("  ");
                } else if (j > 15) {
                    if (enemyBoard.getOcean()[i][j - 16].getStatus().equals(SquareStatus.SHIP)) {
                        displayBoard.append(SquareStatus.EMPTY.getSymbol()).append("  ");
                    } else {
                        displayBoard.append(enemyBoard.getOcean()[i][j - 16]).append("  ");
                    }
                } else if (j == 11) {
                    displayBoard.append(" | ");
                } else if (j == 13) {
                    displayBoard.append(columns[i]).append("  ");
                }
            }
            displayBoard.append("\n");
        }
        System.out.println(displayBoard);
    }

    public void showBoard(Board board) {
        StringBuilder displayBoard = new StringBuilder();
        char[] columns = "ABCDEFGHIJ".toCharArray();
        displayBoard.append("    ");
        for (int i = 0; i < Board.SIZE; i++) {
            if (i != 4) {
                displayBoard.append(i + 1).append("   ");
            } else {
                displayBoard.append(i + 1).append("    ");
            }
        }
        displayBoard.append("\n");
        for (int i = 0; i < Board.SIZE; i++) {
            displayBoard.append(columns[i]).append("  ");
            for (int j = 0; j < Board.SIZE; j++) {
                displayBoard.append(board.getOcean()[i][j]).append("  ");
            }
            displayBoard.append("\n");
        }
        System.out.println(displayBoard);
    }

    public void showMenu() {
        System.out.println("Choose one of the options:\n1. Start new game\n2. Display high scores\n3. Exit");
    }

    public void showHighScores(Map<String, Integer> topScores) {
        System.out.println("\nTOP SCORES:");
        topScores.entrySet()
                .forEach(System.out::println);
        System.out.println(" ");
    }
    public void clearConsole() {
        System.out.println(System.lineSeparator().repeat(60));
    }
}