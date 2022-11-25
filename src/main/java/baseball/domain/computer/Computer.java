package baseball.domain.computer;

public interface Computer {

    RandomNumbers generateRandomNumber();

    BaseballResult generateBaseballResult(String baseballInput);
}
