package baseball.domain.user;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class UserImplTest {

    private final User user = new UserImpl();

    @ParameterizedTest
    @ValueSource(strings = {"111", "012", "asd"})
    @DisplayName("숫자야구 게임을 위한 숫자 입력 시 서로다른 3자리 숫자가 아닌 숫자를 입력하면 에러가 발생한다.")
    void failSubmitBaseballNumberTest(String baseballInput) {
        //given //when //then
        assertThatThrownBy(() -> {
            user.submitBaseballNumber(baseballInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "357", "931"})
    @DisplayName("숫자야구 게임을 위한 숫자 입력 시 서로다른 3자리를 입력해야 한다.")
    void successSubmitBaseballNumberTest(String baseballInput) {
        //given //when
        String result = user.submitBaseballNumber(baseballInput);
        //then
        assertThat(result).isEqualTo(baseballInput);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "RR", "RQ", "r"})
    @DisplayName("게임 재시작 여부 입력 시 'R', 'Q' 한 문자 외의 다른 것을 입력하면 에러가 발생한다.")
    void failValidateGameCommandTest(String gameCommandInput) {
        //given //when //then
        assertThatThrownBy(() -> {
            user.submitGameCommand(gameCommandInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    @DisplayName("게임 재시작 여부 입력 시 'R', 'Q' 중 한 문자를 입력해야 한다.")
    void successValidateGameCommandTest(String gameCommandInput) {
        //given //when
        String result = user.submitGameCommand(gameCommandInput);

        // then
        assertThat(result).isEqualTo(gameCommandInput);
    }
}
