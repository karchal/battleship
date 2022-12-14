package Player;

import Board.Square;
import Ship.Ship;

import java.util.List;

public interface Player {

    int[] getShotCoors();

    boolean isAlive();

    void showBoards();

    List<Ship> getShips();

    void updatePlayersShips(Square square);

    void addShip(Ship ship);

    void addShot(Square square);

    boolean hasNextShot();

    Ship getShipByShipPart(Square square);
}
