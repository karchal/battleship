package utilities;

import java.util.Scanner;

public class Input {
    private final Display display = new Display();
    private final Scanner input;

    public Input() {
        this.input = new Scanner(System.in);
    }

    public int getInt() {
        return this.input.nextInt();
    }
}

