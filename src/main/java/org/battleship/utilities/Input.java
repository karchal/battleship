package main.java.org.battleship.utilities;

import main.java.org.battleship.Board.Direction;

public interface Input {

    int getNumberInput();

    String getStringInput();

    int getGameMode();

    int[] getCoordinates();

    Direction getDirection();

    int getOption(int numOfOptions);

    void getAnyKey();

}
