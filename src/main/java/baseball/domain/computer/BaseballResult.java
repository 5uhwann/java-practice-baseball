package baseball.domain.computer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballResult {

    private final List<BallAndStrike> baseballResult;

    public BaseballResult(List<BallAndStrike> baseballResult) {
        this.baseballResult = new ArrayList<>(baseballResult);
    }

    public List<BallAndStrike> getBaseballResult() {
        return Collections.unmodifiableList(baseballResult);
    }
}
