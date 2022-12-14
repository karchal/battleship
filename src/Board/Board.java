package Board;

import Player.Player;
import Ship.Ship;
import Ship.ShipType;

import java.util.ArrayList;
import java.util.List;

import static Board.SquareStatus.BLOCKED;

public class Board {
    private Player player;
    private Square[][] ocean=new Square[10][10];
    public int size=10;

    public void setOcean(Square[][] ocean) {
        this.ocean = ocean;
    }

    public Board(Player player){
        this.player = player;
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                this.ocean[i][j] = new Square(i, j, SquareStatus.EMPTY);
            }
        }
    }

    public Square getSquare(int i, int j){
        return ocean[i][j];
    }

    public boolean isPlacementOk(int row, int col, Direction direction, int shipLength){
        if (direction == Direction.HORIZONTAL ) {
            if (col + shipLength >= size) return false;
            for (int i = 0; i < shipLength; i++) {
                if (ocean[row][col + i].getStatus() == SquareStatus.SHIP
                        || ocean[row][col + i].getStatus() == SquareStatus.BLOCKED) {
                    return false;
                }
            }
        } else {
            if (row + shipLength >= size) return false;
            for (int i = 0; i < shipLength; i++) {
                if (ocean[row + i][col].getStatus() == SquareStatus.SHIP
                        || ocean[row + i][col].getStatus() == SquareStatus.BLOCKED) {
                    return false;
                }
            }
        }
        return true;
    }

    public void placeShip(int row, int col, Direction direction, int shipLength, ShipType type){
        List<Square> shipParts = new ArrayList<>();
        if (direction == Direction.HORIZONTAL ) {
            for (int i = 0; i < shipLength; i++) {
                ocean[row][col + i].setStatus(SquareStatus.SHIP);
                shipParts.add(ocean[row][col + i]);
                blockFieldsAround(row, col + i);
            }
        } else {
            for (int i = 0; i < shipLength; i++) {
                ocean[row + i][col].setStatus(SquareStatus.SHIP);
                shipParts.add(ocean[row + i][col]);
                blockFieldsAround(row + i, col);
            }
        }
        player.addShip(new Ship(shipParts, type));
    }

    public void blockFieldsAround(int x, int y){
        if(ocean[x][y].getStatus() == SquareStatus.SHIP){
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

    public Square[][] getOcean() {
        return ocean;
    }


    public void executeShot(int x, int y) {
        if (ocean[x][y].getStatus().equals(SquareStatus.EMPTY)) {
            ocean[x][y].setStatus(SquareStatus.MISSED);
            player.updatePlayersShips(ocean[x][y]);
        } else if (ocean[x][y].getStatus().equals(SquareStatus.SHIP)) {
            ocean[x][y].setStatus(SquareStatus.HIT);
            player.updatePlayersShips(ocean[x][y]);
            Ship ship = player.getShipByShipPart(ocean[x][y]);
            if (ship.isSinking()) {
                ship.sunk();
            }
        }
    }

    public boolean areAllShipsSunk() {
        return !player.isAlive();
    }

    public void unblockFieldsAround() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                if (ocean[i][j].getStatus() == BLOCKED) {
                    ocean[i][j].setStatus(SquareStatus.EMPTY);
                }
            }
        }
    }

    }


