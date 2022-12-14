package utilities;

import utilities.Display;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


public class Input {
    private final Display display = new Display();
    private final Scanner input;
    private final int[] coordinates = new int[2];

    public Input() {
        input = new Scanner(System.in);
    }

    public int getNumberInput(){
        return input.nextInt();
    }

    public String getStringInput(){
        return input.nextLine();
    }

    public int getGameMode() {
        int mode = 0;
        try{
            while (mode<1 || mode >3 ) {
                display.showMessage("Choose a number between 1-3");
                mode = getNumberInput();
            }
        }
        catch (InputMismatchException e){
            display.showMessage("Wrong format! Try again!");
            input.next();
            getGameMode();
        }
        return mode;
    }


    public int[] getCoordinates(){
        try{
            String playerCoordinates="";
            while (playerCoordinates.length()<1) {
                playerCoordinates = getStringInput();
            }
            String columns = "abcdefghijklmnopqrstuvwxyz";
            String coordinate = playerCoordinates.substring(0, 1).toLowerCase();
            int row = Integer.parseInt(playerCoordinates.substring(1));
            coordinates[0] = columns.indexOf(coordinate);
            coordinates[1] = row - 1;
            while (!areCoordinatesOnBoard()){
                display.showMessage("Coordinates out of board! Try again!");
                getCoordinates();
            }
            return coordinates;
        } catch (NumberFormatException e) {
            display.showMessage("Wrong input! Try again!");
            getCoordinates();
            return null;
        }
    }

    public boolean areCoordinatesOnBoard(){
        return coordinates[0] >= 0 && coordinates[0] <= 10
                && coordinates[1] >= 0 && coordinates[1] <= 10;
    }

    public String getDirection() {
        String direction ="";
        while (!direction.equals("v") && !direction.equals("h")) {
            display.showMessage("Type horizontal or vertical.");
            direction = getStringInput();
        }
        return direction;
    }
}

