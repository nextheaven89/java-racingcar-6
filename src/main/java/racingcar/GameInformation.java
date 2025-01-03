package racingcar;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameInformation {
    private final String gameName;
    private int score;

    public GameInformation(String gameName, int score) {
        this.gameName = gameName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameScore() {
        this.score++;
    }

    @Override
    public String toString() {
        return this.gameName + " : " + Stream.generate(() -> "").limit(this.score).collect(Collectors.joining("-"));
    }

}
