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

    public void showBoards(Board playerBoard, Board enemyBoard){
        int boardsCount =0;
        StringBuilder board = new StringBuilder();
        char[] columns = "ABCDEFGHIJ".toCharArray();
        board.append("    ");
        while (boardsCount!=2 ) {
            for (int i=0; i< playerBoard.size; i++) {
                if (i !=4) {
                    board.append(i + 1).append("   ");
                } else {
                    board.append(i + 1).append("    ");
                }
            }
            boardsCount++;
            if (boardsCount==1){
                board.append("|     ");
            }
        }
        board.append("\n");

        for (int i=0; i< playerBoard.size; i++){
            board.append(columns[i]).append("  ");
            for (int j=0; j<playerBoard.size*2+6; j++){
                if (j<10) {
                    board.append(playerBoard.getOcean()[i][j]).append("  ");
                } else if (j>15){
                    board.append(enemyBoard.getOcean()[i][j-16]).append("  ");
                } else if (j==11){
                    board.append(" | ");
                } else if (j==13){
                    board.append(columns[i]).append("  ");
                }
            }
            board.append("\n");
        }
        System.out.println(board);
    }

    public void showBoard(Board board){

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
