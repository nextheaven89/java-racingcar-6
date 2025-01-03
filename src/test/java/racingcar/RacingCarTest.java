package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingCarTest {

    private GameInformation gameScore;

    @Test
    public void 콤마입력_분할_테스트_리스트(){
        String test = "test,na,pobi,jun";

        List<String> carNames = Arrays.asList(test.split(","));


        Assertions.assertEquals(4, carNames.size());
    }

    @Test
    public void 콤마입력_분할_테스트_맵(){
        String test = "test,na,pobi,jun";

        Map<String, Integer> carNames = Stream.of(test.split(","))
                .collect(Collectors.toMap(Function.identity(), str -> Integer.parseInt("0") ));

        System.out.println(carNames);

        carNames.forEach((i,k)-> System.out.println(i + k));

    }

    @Test
    public void 게이머_생성_테스트() {
        String testGamer = "test, nam, pobi, jun";

        List<GameInformation> carNames = Arrays.asList(testGamer.split(","))
                .stream()
                .map(i -> new GameInformation(i, 0))
                .toList();

        Assertions.assertEquals(4, carNames.size());

    }

    @Test
    public void 익셉션_6자리이상_Illegal_TEST(){
        //filter 처리를 해도될것같지만 인식못하는 유저가 있으면 안되기때문에 예외처리를 하자.
        String testCarName = "1234,1235666,12,124";

        boolean hasFive = Arrays.stream(testCarName.split(",")).anyMatch(carName -> carName.length() > 5);

        //True가 나와야할것
        Assertions.assertTrue(hasFive);

    }


    public void Illegal_TEST(){
        String testCarName = "1234,1235666,12,124";

        if(Arrays.stream(testCarName.split(",")).anyMatch(carName -> carName.length() > 5)) {
            System.out.println("5자리가 초과하였습니다");
            throw new IllegalArgumentException("유저 자리수가 초과하였습니다");
        }

        System.out.println("123");


    }

    @Test
    public void 익셉션_6자리이상_Illegal_예외_테스트(){
        //filter 처리를 해도될것같지만 인식못하는 유저가 있으면 안되기때문에 예외처리를 하자.

        String testCarName = "1234,1235666,12,124";

        try{
            if(Arrays.stream(testCarName.split(",")).anyMatch(carName -> carName.length() > 5))
                throw new IllegalArgumentException("유저 자리수가 초과되었습니다");
            else
                System.out.println("잘되는데요?");
        }catch (IllegalArgumentException e){
            Assertions.assertEquals("유저 자리수가 초과되었습니다", e.getMessage());
        }

    }
}