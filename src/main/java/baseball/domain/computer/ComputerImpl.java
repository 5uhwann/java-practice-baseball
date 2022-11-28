package baseball.domain.computer;

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
