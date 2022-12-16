package main.java.org.battleship.Player;

import main.java.org.battleship.Ship.Ship;
import main.java.org.battleship.square.Square;
import main.java.org.battleship.square.SquareStatus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class Player {
    private static final int POINTS_FOR_WINNING = 100;

    protected List<Ship> ships = new ArrayList<>();
    protected List<Square> shots = new ArrayList<>();

    public abstract int[] getShotCoords();

    public abstract String getName(HashSet<String> nicknamesTaken);

    public boolean isAlive() {
        for(Ship ship: ships){
            if(!ship.isSinking()){
                return true;
            }
        }
        return false;
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

    public int getScore(){
        return POINTS_FOR_WINNING - shots.size() + getPointsForShips();

    }

    private int getPointsForShips() {
        int sum = 0;
        for (Ship ship: ships){
            sum += ship.getPoints();
        }
        return sum;
    }
}
