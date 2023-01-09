package com.battleship;

import com.battleship.board.Direction;
import com.battleship.utilities.Input;

public class TestInput implements Input {
    @Override
    public int getNumberInput() {
        return 0;
    }

    @Override
    public String getStringInput() {
        return null;
    }

    @Override
    public int getGameMode() {
        return 0;
    }

    @Override
    public int[] getCoordinates() {
        return new int[0];
    }

    @Override
    public Direction getDirection() {
        return null;
    }

    @Override
    public int getOption(int numOfOptions) {
        return 3;
    }

    @Override
    public void getAnyKey() {

    }
}
