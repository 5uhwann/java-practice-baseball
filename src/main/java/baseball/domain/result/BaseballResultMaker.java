package baseball.domain.result;

import static baseball.domain.computer.BallAndStrike.*;

import baseball.domain.computer.BallAndStrike;
import baseball.domain.computer.RandomNumbers;
import java.util.ArrayList;
import java.util.List;

public class BaseballResultMaker {

    private final List<String> baseballInput;
    private final List<BallAndStrike> baseballResult = new ArrayList<>();

    public BaseballResultMaker(String baseballInput) {
        this.baseballInput = new ArrayList<>(List.of(baseballInput.split("")));
    }

    public List<BallAndStrike> makeResult(RandomNumbers randomNumbers) {
        for (String number : baseballInput) {
            checkBallAndStrike(number, randomNumbers);
        }
        return baseballResult;
    }

    private void checkBallAndStrike(String number, RandomNumbers randomNumbers) {
        if (checkStrike(number, randomNumbers)) {
            baseballResult.add(strike);
            return;
        }
        checkBall(number, randomNumbers);
    }

    private void checkBall(String number, RandomNumbers randomNumbers) {
        if (randomNumbers.getRandomNumbers().contains(Integer.parseInt(number))) {
            baseballResult.add(ball);
        }
    }

    private boolean checkStrike(String number, RandomNumbers randomNumbers) {
        return baseballInput.indexOf(number) == randomNumbers.getRandomNumbers().indexOf(Integer.parseInt(number));
    }
}
