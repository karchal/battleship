package Player;

import Board.Square;
import Ship.Ship;

import java.util.ArrayList;
import java.util.List;

public class AiPlayer implements Player {
    List<Ship> ships = new ArrayList<>();
    List<Square> shots = new ArrayList<>();

    @Override
    public int[] getShotCoors() {
        //return coords generated by AI
        int[] coords = {0,0};
        return coords;
    }

    @Override
    public boolean isAlive() {
        for(Ship ship: ships){
            if(!ship.isSinking()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void showBoards() {

    }

    @Override
    public List<Ship> getShips() {
        return ships;
    }

    @Override
    public void updatePlayersShips(Square square) {
        for(Ship ship: ships){
            for(Square part: ship.getShipParts()){
                if (part.getX() == square.getX() && part.getY() == square.getY())
                    part.setStatus(square.getStatus());
            }
        }
    }

    @Override
    public void addShip(Ship ship) {
        ships.add(ship);
    }

    @Override
    public boolean hasNextShot() {
        return false;
    }

    @Override
    public Ship getShipByShipPart(Square square) {
        for (Ship ship: ships){
            if (ship.hasSquare(square)){
                return ship;
            }
        }
        return null;
    }

    public void addShot(Square square){
        shots.add(square);
    }

}
