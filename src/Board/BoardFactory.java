package Board;

import Player.Player;

import Ship.ShipType;
import utilities.Input;

import java.util.Random;

import utilities.ConsoleDisplay;
import utilities.ConsoleInput;

public class BoardFactory {

    public Board randomPlacement(Player player) {
        Board board = new Board(player);
        for (ShipType shipType: ShipType.values()){
            int[] coordinates;
            Direction direction;
            do {
                coordinates = getRandomCoordinates();
                direction = getRandomDirection();
            } while (!board.isPlacementOk(coordinates[0], coordinates[1], direction, shipType.getLength()));
                board.placeShip(coordinates[0], coordinates[1], direction, shipType.getLength(), shipType);
            }
        board.unblockFieldsAround();
        return board;
    }

    public Board manualPlacement(Player player) {
        Board board = new Board(player);
        Square[][] ocean = board.getOcean();
        //input should be of the same instance as input created in main
        ConsoleInput input = new ConsoleInput(new ConsoleDisplay());
        for (ShipType shipType: ShipType.values()){
            int[] coordinates;
            Direction direction;
            do {
                coordinates = input.getCoordinates();
                direction = input.getDirection();
            } while (!board.isPlacementOk(coordinates[0], coordinates[1], direction, shipType.getLength()));
                board.placeShip(coordinates[0], coordinates[1], direction, shipType.getLength(), shipType);
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
