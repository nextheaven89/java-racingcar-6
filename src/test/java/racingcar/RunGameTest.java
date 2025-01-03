package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RunGameTest {

    final int cycle = 5;

    List<GameInformation> gameInformationList = List.of(
            new GameInformation("1", 0),
            new GameInformation("2", 0),
            new GameInformation("3", 0),
            new GameInformation("4", 0)
    );

    @Test
    public void 실행결과_조회하기() {
        System.out.println("실행 결과");

        gameInformationList.forEach(gameInformation -> {
            System.out.println(gameInformation.getGameName() + " :");
        });
    }

    @Test
    public void 회수별로_반복() {
        System.out.println("실행 결과");

        for (int i = 0; i < this.cycle; i++) {
            gameInformationList.forEach(gameInformation -> {
                System.out.println(gameInformation.getGameName() + " :");
            });

            System.out.println();
        }
    }

    @Test
    public void 회수차별로_카운트_증가시키기() {
        System.out.println("실행 결과");

        //반복한번할때마다
        //사용자 한명에게 랜덤값을 돌린다
        //랜덤값을 돌렸을때 4이상이 나오게되면 점수를 1을 추가한다
        // 그추가한값을 객체에다가 넘겨줘서 값을 올려준다 add.
        // 그리고 그 점수를 '-' 로 표현한다

        for (int i = 0; i < this.cycle; i++) {
            for (GameInformation information : gameInformationList)
                if (Randoms.pickNumberInRange(0, 9) > 4) information.setGameScore();

            gameInformationList.forEach(gameInformation -> {
                System.out.println(gameInformation.getGameName() + " : " + gameInformation.getScore());
            });

            System.out.println();
        }
    }


    @Test
    public void 회수별로_차_전진시키기() {
        System.out.println("실행 결과");

        //반복한번할때마다
        //사용자 한명에게 랜덤값을 돌린다
        //랜덤값을 돌렸을때 4이상이 나오게되면 점수를 1을 추가한다
        // 그추가한값을 객체에다가 넘겨줘서 값을 올려준다 add.
        // 그리고 그 점수를 '-' 로 표현한다

        for (int i = 0; i < this.cycle; i++) {
            for (GameInformation information : gameInformationList)
                if (Randoms.pickNumberInRange(0, 9) > 4) information.setGameScore();

            gameInformationList.forEach(System.out::println);
            System.out.println();
        }
    }

    @Test
    public void 우승자_뽑기_스트림활용() {
        List<GameInformation> gameInformationList = List.of(
                new GameInformation("1", 5),
                new GameInformation("2", 4),
                new GameInformation("3", 5),
                new GameInformation("4", 5)
        );

        Integer maxScore = gameInformationList.stream()
                .mapToInt(GameInformation::getScore).max().getAsInt();

        Assertions.assertEquals(5, maxScore);
    }

    @Test
    public void 우승자_뽑기_스트림활용2() {
        List<GameInformation> gameInformationList = List.of(
                new GameInformation("1", 5),
                new GameInformation("2", 4),
                new GameInformation("3", 5),
                new GameInformation("4", 5)
        );

        int maxScore = gameInformationList.stream()
                .mapToInt(GameInformation::getScore).max().getAsInt();

        List<String> championName = gameInformationList.stream()
                .filter(information -> information.getScore() == maxScore)
                .map(GameInformation::getGameName)
                .toList();

        championName.forEach(System.out::println);

    }

    @Test
    public void 우승자_뽑기_스트림합치기() {
        List<GameInformation> gameInformationList = List.of(
                new GameInformation("1", 5),
                new GameInformation("2", 4),
                new GameInformation("3", 5),
                new GameInformation("4", 5)
        );
//
//        int maxScore = gameInformationList.stream()
//                .mapToInt(GameInformation::getScore).max().getAsInt();

        gameInformationList.stream()
                .filter(information -> information.getScore() ==
                        gameInformationList.stream()
                                .mapToInt(GameInformation::getScore)
                                .max().getAsInt())
                .map(GameInformation::getGameName)
                .forEach(System.out::println);


    }

}