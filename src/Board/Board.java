package Board;

public class Board {

    private Square[][] ocean;
    private int size;

    public void setOcean(Square[][] ocean) {
        this.ocean = ocean;
    }

    public Board(){
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                this.ocean[i][j] = new Square(i, j, SquareStatus.EMPTY);
            }
        }
    }

    public Square getSquare(int i, int j){
        return ocean[i][j];
    }

    public boolean isPlacementOk(int row, int col){
        return  ocean[row][col].getStatus() == SquareStatus.EMPTY && // Is square empty?
                0 <= col && col < size &&
                0 <= row && row < size; // Is on board?
    }

    public void blockFieldsAround(int x, int y){
        if(x < size - 1 && y < size - 1 && ocean[x+1][y+1].getStatus().equals(SquareStatus.EMPTY)){
                ocean[x+1][y+1].setStatus(SquareStatus.BLOCKED);
            }
        if(x > 0 && y < size - 1 && ocean[x-1][y+1].getStatus().equals(SquareStatus.EMPTY)){
                ocean[x-1][y+1].setStatus(SquareStatus.BLOCKED);
            }
        if(x < size - 1 && y > 0 && ocean[x+1][y-1].getStatus().equals(SquareStatus.EMPTY)){
                ocean[x+1][y-1].setStatus(SquareStatus.BLOCKED);
            }
        if(x > 0 && y > 0 && ocean[x-1][y-1].getStatus().equals(SquareStatus.EMPTY)){
                ocean[x-1][y-1].setStatus(SquareStatus.BLOCKED);
            }
        }
    }
}
