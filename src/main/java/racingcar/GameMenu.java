package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameMenu {

    private final RacingCar racingCar;
    private final RunGame runGame;

    public GameMenu() {
        racingCar = new RacingCar();
        runGame = new RunGame();

    }

    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racingCar.createCar(Console.readLine()); // 자동차 정보 입력

        System.out.println("시도할 회수는 몇회인가요?");
        runGame.run(racingCar.getCars(), Integer.parseInt(Console.readLine())); // Game Run
    }

}
