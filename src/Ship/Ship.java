package Ship;

import Board.Square;

import java.util.List;

public class Ship {
    private List<Square> shipParts;
    private ShipType type;

    public Ship(List<Square> squares, ShipType type) {
        this.shipParts = squares;
        this.type = type;
    }



}
