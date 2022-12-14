package Board;

import Player.Player;
import Ship.ShipType;
import utilities.ConsoleDisplay;
import utilities.ConsoleInput;

public class BoardFactory {
    Board board;

    public Board randomPlacement(Player player) {
        Board board = new Board(player);
        Square[][] ocean = board.getOcean();
        for (ShipType shipType: ShipType.values()){
            // losowe generowanie współrzędnych (*)
            // losowe generowanie kierunku,
            // sprawdzenie czy położenie jest ok, jeśli nie wracamy do (*)
            // zmiana statusu konkretnych komórek oceanu z EMPTY na SHIP
            // stworzenie nowego statku złożonego z tych komórek oceanu i typu shipType
            // dodanie statku do listy playera (metoda player.addShip(ship))
            // zablokowanie komórek wokół statku
        }
        //odblokowanie komórek wokół statków
        board.unblockFieldsAround();
        return board;
    }

    public Board manualPlacement(Player player) {
        Board board = new Board(player);
        Square[][] ocean = board.getOcean();
        ConsoleInput input = new ConsoleInput(new ConsoleDisplay());
        for (ShipType shipType: ShipType.values()){
            // pobieranie współrzędnych (*)
            int[] coordinates = input.getCoordinates();
            // pobieranie kierunku,
            Direction direction = input.getDirection();
            // sprawdzenie czy położenie jest ok, jeśli nie wracamy do (*) +
            board.isPlacementOk(coordinates[0], coordinates[1], direction, shipType.getLength());
            // zmiana statusu konkretnych komórek oceanu z EMPTY na SHIP >>
            board.placeShip(coordinates[0], coordinates[1], direction, shipType.getLength());
            // stworzenie nowego statku złożonego z tych komórek oceanu i typu shipType

            // dodanie statku do listy playera (metoda player.addShip(ship))

            // zablokowanie komórek wokół statku
            board.blockFieldsAround(coordinates[0], coordinates[1]);
        }
        //odblokowanie komórek wokół statków
        board.unblockFieldsAround();
        return board;
    }

}
