package Player;

import Board.Board;
import Board.Square;

import java.util.*;

public class AiPlayer extends Player {
    private static final String[] NAMES = {"Butcher", "Drake", "Limp", "Hawk", "Lone Wolf",
            "Goresorrow", "Lightblade", "Death Cut", "Rumble Scream", "Giantcrest", "Reckless",
            "Bear", "Thirst", "Gold One", "Rockhair", "Sharp Grimace", "Demon Pelt", "Gore Stare", "Stormgaze"};

    private Random random = new Random();

    public int[] getShotCoords() {
        int x, y;
        do {
            x = random.nextInt(Board.SIZE);
            y = random.nextInt(Board.SIZE);

        } while (isShotRepeated(x, y));
        int[] coords = {x, y};
        return coords;
    }

    private boolean isShotRepeated(int x, int y) {
        for (Square shot: shots){
            if (shot.hasCoords(x, y)) return false;
        }
        return true;
    }

    @Override
    public String getName(HashSet<String> nicknamesTaken) {
        String nickname;
        do {
            nickname = NAMES[random.nextInt(NAMES.length)];
        } while (nicknamesTaken.contains(nickname));
        return nickname;
    }
}
