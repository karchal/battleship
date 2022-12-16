package com.battleship.board;


import com.battleship.ship.ShipType;
import com.battleship.utilities.Display;
import com.battleship.utilities.Input;
import com.battleship.player.Player;

import java.util.Random;


public class BoardFactory {
    private final Display display;
    private final Input input;

    public BoardFactory(Display display, Input input) {
        this.display = display;
        this.input = input;
    }

    public Board randomPlacement(Player player) {
        Board board = new Board(player);
        for (ShipType shipType: ShipType.values()){
            int[] coordinates;
            Direction direction;
            boolean isPossibleToPlaceShip = false;
            while (!isPossibleToPlaceShip){
                coordinates = getRandomCoordinates();
                direction = getRandomDirection();
                if (board.isPlacementOk(coordinates[0], coordinates[1], direction, shipType.getLength())){
                    board.placeShip(coordinates[0], coordinates[1], direction, shipType.getLength(), shipType);
                    isPossibleToPlaceShip = true;
                }
            }
            display.clearConsole();
            }
        board.unblockFieldsAround();
        return board;
    }

    public Board manualPlacement(Player player) {
        Board board = new Board(player);
        for (ShipType shipType: ShipType.values()){
            display.showMessage("You place the" + shipType.toString());
            display.showBoard(board);
            display.showMessage("Enter coordinates of the first (left-up) ship part");
            int[] coordinates;
            boolean isPossibleToPlaceShip = false;
            Direction direction;
            while (!isPossibleToPlaceShip) {
                coordinates = input.getCoordinates();
                direction = input.getDirection();
                if (board.isPlacementOk(coordinates[0], coordinates[1], direction, shipType.getLength())) {
                    board.placeShip(coordinates[0], coordinates[1], direction, shipType.getLength(), shipType);
                    isPossibleToPlaceShip = true;
                } else { display.showMessage("It's impossible to place your ship here");}
            }
            display.clearConsole();
        }
        board.unblockFieldsAround();
        return board;
    }

    public Direction getRandomDirection() {
        Direction[] directions = Direction.values();
        return directions[new Random().nextInt(directions.length)];
    }

    public int[] getRandomCoordinates() {
        int size = 10;
        int x = new Random().nextInt(size);
        int y = new Random().nextInt(size);
        return new int[]{x, y};
    }

}
