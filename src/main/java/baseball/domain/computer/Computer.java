package baseball.domain.computer;

import baseball.domain.result.BaseballResultDto;

public interface Computer {

    RandomNumbers generateRandomNumber();

    BaseballResultDto generateBaseballResult(String baseballInput);
}
