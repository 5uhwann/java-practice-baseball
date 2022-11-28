package baseball.domain.computer;

import baseball.domain.result.BaseballResult;
import baseball.domain.result.BaseballResultMaker;

public class ComputerImpl implements Computer {

    private static final RandomNumberGenerator RANDOM_NUMBER_GENERATOR = new RandomNumberGenerator();

    private RandomNumbers randomNumbers;

    @Override
    public RandomNumbers generateRandomNumber() {
        randomNumbers = new RandomNumbers(RANDOM_NUMBER_GENERATOR.generateRandomNumbers());
        return randomNumbers;
    }

    @Override
    public BaseballResult generateBaseballResult(String baseballInput) {
        return new BaseballResult(new BaseballResultMaker(baseballInput).makeResult(randomNumbers));
    }
}
