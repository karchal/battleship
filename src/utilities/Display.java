package utilities;

import Board.Board;


public class Display {

    public void showModes() {
        System.out.println("1: Pilot vs Pilot\n2: Top Gun\n3: Terminator II");
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
            for (int row = 0; row < playerBoard.size; row++) {
                if (row != 4) {
                    board.append(columns[row]).append("   ");
                } else {
                    board.append(columns[row]).append("    ");
                }
            }
            boardsCount++;
            if (boardsCount==1){
                board.append("|     ");
            }
        }
        board.append("\n");

        for (int i=0; i< playerBoard.size; i++){
            if (i< playerBoard.size-1) {
                board.append(i + 1).append("  ");
            } else {
                board.append(i + 1).append(" ");
            }
            for (int j=0; j<playerBoard.size*2+6; j++){
                if (j<10) {
                    board.append(playerBoard.getOcean()[i][j]).append("  ");
                } else if (j>15){
                    board.append(enemyBoard.getOcean()[i][j-16]).append("  ");
                } else if (j==11){
                    board.append("| ");
                } else if (j==13){
                    if (i<playerBoard.size-1) {
                        board.append(i + 1).append("  ");
                    } else {
                        board.append(i + 1).append(" ");
                    }
                }
            }
            board.append("\n");
        }
        System.out.println(board);
    }


}
