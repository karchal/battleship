package Ship;

import Board.Square;
import Board.SquareStatus;

import java.util.List;

public class Ship {
    private List<Square> shipParts;
    private ShipType type;

    public Ship(List<Square> squares, ShipType type) {
        this.shipParts = squares;
        this.type = type;
    }

    public boolean checkIfSunk(){
        return false;
    }

    public void sink(){
        for(Square part: shipParts){
            part.setStatus(SquareStatus.SUNK);
        }
    }
}
