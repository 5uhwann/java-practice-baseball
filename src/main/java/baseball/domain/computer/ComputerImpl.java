package baseball.domain.computer;

public class ComputerImpl implements Computer {

    private final RandomNumberGenerator randomNumberGenerator;

    private RandomNumbers randomNumbers;

    public ComputerImpl(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomNumbers generateRandomNumber() {
        randomNumbers = new RandomNumbers(randomNumberGenerator.generateRandomNumbers());
        return randomNumbers;
    }

    @Override
    public BaseballResult generateBaseballResult(String baseballInput) {
        return new BaseballResult(new BaseballResultMaker(baseballInput).makeResult(randomNumbers));
    }
}
