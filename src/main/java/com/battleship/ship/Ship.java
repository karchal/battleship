package com.battleship.ship;

import com.battleship.square.Square;
import com.battleship.square.SquareStatus;

import java.util.List;

public class Ship {
    private final List<Square> shipParts;
    private final ShipType type;

    public Ship(List<Square> squares, ShipType type) {
        this.shipParts = squares;
        this.type = type;
    }

    public boolean isSinking(){
        for(Square part: shipParts){
            if (SquareStatus.SHIP.equals(part.getStatus())){
                return false;
            }
        }
        return true;
    }

    public void sink(){
        for(Square part: shipParts){
            part.sink();
        }
    }

    public boolean hasSquare(Square square) {
        for(Square part: shipParts){
            if (square == part) return true;
        }
        return false;
    }

    public int getPoints() {
        int sum = 0;
        for (Square square: shipParts){
            sum += square.getPoints();
        }
        return sum;
    }

    public void hit() {
        if (isSinking()) {
           sink();
        }
    }
}
