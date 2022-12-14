package Board;

import Player.Player;
import Ship.Ship;
import Ship.ShipType;
import utilities.Input;

import java.util.List;

import static Board.SquareStatus.BLOCKED;

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
        Input input = new Input();
        for (ShipType shipType: ShipType.values()){
            // pobieranie współrzędnych (*)
            int row = input.getCoordinates()[0];
            int col = input.getCoordinates()[1];
            // pobieranie kierunku,
            String direction = input.getDirection();
            // sprawdzenie czy położenie jest ok, jeśli nie wracamy do (*) +
            board.isPlacementOk(row, col, direction, shipType.getLength());
            // zmiana statusu konkretnych komórek oceanu z EMPTY na SHIP >>
            board.placeShip(row, col, direction, shipType.getLength());
            // stworzenie nowego statku złożonego z tych komórek oceanu i typu shipType

            // dodanie statku do listy playera (metoda player.addShip(ship))

            // zablokowanie komórek wokół statku

            board.blockFieldsAround(row, col);
        }
        //odblokowanie komórek wokół statków
        board.unblockFieldsAround();
        return board;
    }

}
