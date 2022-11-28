package baseball.domain.computer;

import baseball.domain.result.BaseballResult;

public interface Computer {

    RandomNumbers generateRandomNumber();

    BaseballResult generateBaseballResult(String baseballInput);
}
