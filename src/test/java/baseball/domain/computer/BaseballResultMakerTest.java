package baseball.domain.computer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballResultMakerTest {

    @Test
    @DisplayName("숫자만 포함하면 볼, 자리수까지 맞으면 스트라이크를 추가한다.")
    void makeResultTest_case1() {
        //given
        BaseballResultMaker baseballResultMaker = new BaseballResultMaker("123");

        //when
        List<BallAndStrike> baseballResult = baseballResultMaker.makeResult(new RandomNumbers(List.of(2, 4, 3)));

        //then
        int ballCount = (int) baseballResult.stream()
                .filter(result -> result == BallAndStrike.ball)
                .count();

        int strikeCount = (int) baseballResult.stream()
                .filter(result -> result == BallAndStrike.strike)
                .count();

        assertThat(ballCount).isEqualTo(1);
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    @DisplayName("일치하는 것이 없으면 빈 결과가 생성된다.")
    void makeResultTest_case2() {
        //given
        BaseballResultMaker baseballResultMaker = new BaseballResultMaker("567");

        //when
        List<BallAndStrike> baseballResult = baseballResultMaker.makeResult(new RandomNumbers(List.of(2, 4, 3)));

        //then
        assertThat(baseballResult.size()).isEqualTo(0);
    }
}
