package main.java.org.battleship.utilities;

import main.java.org.battleship.Board.Direction;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


public class ConsoleInput implements Input {

    private final Display display;
    private final Scanner input = new Scanner(System.in);
    private final int[] coordinates = new int[2];

    public ConsoleInput(Display display) {
        this.display = display;
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
            while (mode < 1 || mode > 3 ) {
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
        } catch (NumberFormatException e) {
            display.showMessage("Wrong input! Try again!");
            getCoordinates();
        }
        return coordinates;
    }

    private boolean areCoordinatesOnBoard(){
        return coordinates[0] >= 0 && coordinates[0] <= 10
                && coordinates[1] >= 0 && coordinates[1] <= 10;
    }


    public Direction getDirection() {
        display.showMessage("Enter direction");
        String direction = "";
        while (!direction.equals("v") && !direction.equals("h")) {
            display.showMessage("Type h for horizontal or v for vertical direction.");
            direction = getStringInput();
        }
        return getDirectionValue(direction);
    }

    private Direction getDirectionValue(String direction) {
        for(Direction d: Direction.values()){
            if (Objects.equals(d.shortcut, direction)){
                return d;
            }
        }
        return null;
    }

    public int getOption(int numOfOptions){
        int option;
        while(true) {
            if (input.hasNextInt()) {
                option = input.nextInt();
                if (option >= 1 && option <= numOfOptions) {
                    return option;
                }
            }
            display.showMessage("Enter a number between 1 and " + numOfOptions);
        }
    }
    public void getAnyKey(){
        display.showMessage("Press any key to change player!");
        try{System.in.read();}
        catch(Exception e){}
    }
}

