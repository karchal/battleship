package com.battleship.utilities;

import com.battleship.board.Direction;

public interface Input {

    int getNumberInput();

    String getStringInput();

    int getGameMode();

    int[] getCoordinates();

    Direction getDirection();

    int getOption(int numOfOptions);

    void getAnyKey();

}
