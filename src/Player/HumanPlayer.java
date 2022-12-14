package Player;

import Board.Square;
import Board.SquareStatus;
import Ship.Ship;
import utilities.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HumanPlayer implements Player {
    List<Ship> ships = new ArrayList<>();
    List<Square> shots = new ArrayList<>();


    public int[] getShotCoors() {
        Input input = new Input();
        return input.getCoordinates();
    }

    public boolean isAlive() {
        for(Ship ship: ships){
            if(!ship.isSinking()){
                return true;
            }
        }
        return false;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void updatePlayersShips(Square square) {
        for(Ship ship: ships){
            for(Square part: ship.getShipParts()){
                if (part.getX() == square.getX() && part.getY() == square.getY())
                    part.setStatus(square.getStatus());
            }
        }
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void addShot(Square square){
        shots.add(square);
    }

    public boolean hasNextShot() {
        SquareStatus type = shots.get(shots.size() - 1).getStatus() ;
        return SquareStatus.HIT.equals(type) || SquareStatus.SUNK.equals(type);
    }

    public Ship getShipByShipPart(Square square){
        for (Ship ship: ships){
            if (ship.hasSquare(square)){
                return ship;
            }
        }
        return null;
    }
}
