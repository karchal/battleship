package Board;

public class Board {

    private Square[][] ocean;

    public void setOcean(Square[][] ocean) {
        this.ocean = ocean;
    }

    public Board(int size){
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                this.ocean[i][j] = new Square(i, j, SquareStatus.EMPTY);

            }
        }
    }

    public void isPlacementOk(){

    }

}
