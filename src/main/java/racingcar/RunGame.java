package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RunGame {

    public void run(List<GameInformation> cars, int runTime) {
        for (int i = 0; i < runTime; i++) {
            racing(cars);
            showRacing(cars);
            System.out.println();
        }
        showRacingResult(cars);
    }

    public void racing(List<GameInformation> cars) {
        for (GameInformation car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) car.setGameScore();
        }
    }

    public void showRacing(List<GameInformation> cars) {
        cars.forEach(System.out::println);
    }

    public void showRacingResult(List<GameInformation> cars) {
        StringBuilder championName = new StringBuilder();

        List<String> champion = cars.stream()
                .filter(car -> car.getScore() ==
                        cars.stream()
                                .mapToInt(GameInformation::getScore)
                                .max().orElse(0))
                .map(GameInformation::getGameName)
                .toList();

        for (int i = 0; i < champion.size(); i++) {
            if (i == champion.size() - 1) championName.append(champion.get(i));
            else championName.append(champion.get(i)).append(", ");
        }

        System.out.println("최종 우승자 : " + championName);
    }

}
