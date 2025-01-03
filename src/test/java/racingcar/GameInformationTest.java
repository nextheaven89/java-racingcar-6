package racingcar;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameInformationTest {

    @Test
    public void 인티저_스트링으로변환(){

        int count = 5;

        String str = Stream.generate(() -> "").limit(count).collect(Collectors.joining("-"));

        System.out.println(str);
    }

}