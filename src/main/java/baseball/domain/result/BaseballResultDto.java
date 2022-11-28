package baseball.domain.result;

import static baseball.domain.computer.BallAndStrike.*;

import baseball.domain.computer.BallAndStrike;
import java.util.List;

public class BaseballResultDto {

    private final String resultDto;

    public BaseballResultDto(BaseballResult baseballResult) {
        this.resultDto = translateResult(baseballResult);
    }

    public String getResultDto() {
        return resultDto;
    }

    private String translateResult(BaseballResult baseballResult) {
        List<BallAndStrike> result = baseballResult.getBaseballResult();
        if (result.size() == 0) {
            return nothing.getKoreanTag();
        }
        return translateBall(result) + translateStrike(result);
    }

    private String translateBall(List<BallAndStrike> result) {
        int ballCount = (int) result.stream()
                .filter(ballResult -> ballResult == ball)
                .count();
        if (ballCount == 0) {
            return "";
        }
        return ballCount + ball.getKoreanTag();
    }

    private String translateStrike(List<BallAndStrike> result) {
        int strikeCount = (int) result.stream()
                .filter(strikeResult -> strikeResult == strike)
                .count();
        if (strikeCount == 0) {
            return "";
        }
        return strikeCount + strike.getKoreanTag();
    }
}
