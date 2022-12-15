package Board;

import Player.Player;
import Ship.ShipType;

import java.util.Random;

import utilities.Display;
import utilities.Input;

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
            display.showMessage("You place the" + shipType.toString());
            display.showBoard(board);
            int[] coordinates;
            Direction direction;
            Boolean isPossibleToPlaceShip = false;
            while (!isPossibleToPlaceShip){
                coordinates = getRandomCoordinates();
                direction = getRandomDirection();
                if (board.isPlacementOk(coordinates[0], coordinates[1], direction, shipType.getLength())){
                    board.placeShip(coordinates[0], coordinates[1], direction, shipType.getLength(), shipType);
                    isPossibleToPlaceShip = true;
                } else { display.showMessage("It's impossible to place your ship here");}
            }
            }
        board.unblockFieldsAround();
        return board;
    }

    public Board manualPlacement(Player player) {
        Board board = new Board(player);
        for (ShipType shipType: ShipType.values()){
            display.showMessage("You place the " + shipType.toString());
            display.showBoard(board);
            int[] coordinates;
            Boolean isPossibleToPlaceShip = false;
            Direction direction;
            while (!isPossibleToPlaceShip) {
                coordinates = input.getCoordinates();
                direction = input.getDirection();
                if (board.isPlacementOk(coordinates[0], coordinates[1], direction, shipType.getLength())) {
                    board.placeShip(coordinates[0], coordinates[1], direction, shipType.getLength(), shipType);
                    isPossibleToPlaceShip = true;
                } else { display.showMessage("It's impossible to place your ship here");}
            }
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
