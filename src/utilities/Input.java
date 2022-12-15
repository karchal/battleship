package utilities;

import Board.Direction;

public interface Input {

    int getNumberInput();

    String getStringInput();

    int getGameMode();

    int[] getCoordinates();

    Direction getDirection();

    int getOption(int numOfOptions);

    public void getAnyKey();

}
