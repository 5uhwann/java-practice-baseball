package baseball.domain.computer;

public class ComputerImpl implements Computer {

    private final RandomNumberGenerator randomNumberGenerator;

    private RandomNumbers randomNumbers;

    public ComputerImpl(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public RandomNumbers generateRandomNumber() {
        return new RandomNumbers(randomNumberGenerator.generateRandomNumbers());
    }
}
