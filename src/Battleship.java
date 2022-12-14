import logic.Game;
import utilities.Display;
import utilities.Input;

public class Battleship {
    Display display = new Display();
    Input input = new Input();

    public static void main(String[] args){
        Battleship battleship = new Battleship();
        while(true) {
            battleship.display.showMessage("Do you want to play BATTLESHIP? (Y/N)");
            Game game = new Game();
            game.start();
            game.play();
            game.end();
        }
    }
}
