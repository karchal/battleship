package com.battleship.board;


import com.battleship.player.Player;
import com.battleship.ship.Ship;
import com.battleship.ship.ShipType;
import com.battleship.square.Square;
import com.battleship.square.SquareStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Board {
    private final Player player;
    private final Square[][] ocean = new Square[SIZE][SIZE];
    public static final int SIZE = 10;


    public Board(Player player){
        this.player = player;
        for(int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                this.ocean[i][j] = new Square(i, j, SquareStatus.EMPTY);
            }
        }
    }

    public Square getSquare(int i, int j){
        return ocean[i][j];
    }

    public boolean isPlacementOk(int row, int col, Direction direction, int shipLength){
        if (direction == Direction.HORIZONTAL ) {
            if (col + shipLength >= SIZE) return false;
            for (int i = 0; i < shipLength; i++) {
                if (ocean[row][col + i].getStatus() == SquareStatus.SHIP
                        || ocean[row][col + i].getStatus() == SquareStatus.BLOCKED) {
                    return false;
                }
            }
        } else {
            if (row + shipLength >= SIZE) return false;
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
                ocean[row][col + i].becomeShipPart();
                shipParts.add(ocean[row][col + i]);
                blockFieldsAround(row, col + i);
            }
        } else {
            for (int i = 0; i < shipLength; i++) {
                ocean[row + i][col].becomeShipPart();
                shipParts.add(ocean[row + i][col]);
                blockFieldsAround(row + i, col);
            }
        }
        player.addShip(new Ship(shipParts, type));
    }

    public void blockFieldsAround(int x, int y){
        if(ocean[x][y].getStatus() == SquareStatus.SHIP){
            if(x < SIZE - 1 && y < SIZE - 1){
                ocean[x+1][y+1].blockIfEmpty();
            }
            if(x > 0 && y < SIZE - 1){
                ocean[x-1][y+1].blockIfEmpty();
            }
            if(x < SIZE - 1 && y > 0){
                ocean[x+1][y-1].blockIfEmpty();
            }
            if(x > 0 && y > 0){
                ocean[x-1][y-1].blockIfEmpty();
            }
            if(y < SIZE - 1 ){
                ocean[x][y+1].blockIfEmpty();
            }
            if(y > 0 ){
                ocean[x][y-1].blockIfEmpty();
            }
            if(x < SIZE - 1 ){
                ocean[x+1][y].blockIfEmpty();
            }
            if(x > 0){
                ocean[x-1][y].blockIfEmpty();
            }
        }
    }

    public Square[][] getOcean() {
        return ocean;
    }


    public void executeShot(int x, int y) {
        ocean[x][y].hit();
        Optional<Ship> ship = player.getShipByShipPart(ocean[x][y]);
        ship.ifPresent(Ship::hit);
    }

    public boolean areAllShipsSunk() {
        return !player.isAlive();
    }

    public void unblockFieldsAround() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                ocean[i][j].unlock();
            }
        }
    }
}


