package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingCar {

    private final int INITIAL_SCORE = 1;

    List<GameInformation> cars;

    public void createCar(String racingCarName) {
        isValidCarName(racingCarName);

        this.cars = Arrays.stream(racingCarName.split(","))
                .map(carName -> new GameInformation(carName, INITIAL_SCORE))
                .toList();
    }

    public void isValidCarName(String carName) {
        if (Arrays.stream(carName.split(",")).anyMatch(name -> name.length() > 5))
            throw new IllegalArgumentException("자리수 확인");

        if (Arrays.stream(carName.split(",")).anyMatch(name -> name.contains(" ")))
            throw new IllegalArgumentException("공란 허용하지않음");
    }

    public List<GameInformation> getCars() {
        return cars;
    }

}
