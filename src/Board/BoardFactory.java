package Board;

import Player.Player;
import Ship.Ship;
import Ship.ShipType;
import utilities.Input;

import java.util.List;

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
        return board;
    }

    public Board manualPlacement(Player player) {
        Board board = new Board(player);
        Square[][] ocean = board.getOcean();
        for (ShipType shipType: ShipType.values()){
            // pobieranie kierunku,
            // sprawdzenie czy położenie jest ok, jeśli nie wracamy do (*)
            // zmiana statusu konkretnych komórek oceanu z EMPTY na SHIP
            // stworzenie nowego statku złożonego z tych komórek oceanu i typu shipType
            // dodanie statku do listy playera (metoda player.addShip(ship))
            // zablokowanie komórek wokół statku
        }
        //odblokowanie komórek wokół statków
        return board;
    }

}
