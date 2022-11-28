package baseball.domain.user;

import static baseball.utils.ErrorMessage.ERROR_BASEBALL;
import static baseball.utils.ErrorMessage.ERROR_GAME_COMMAND;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserImpl implements User{

    private static final String REGEX_NUMBER = "^[1-9]*$";
    private static final String REGEX_GAME_COMMAND = "^R|Q$";

    @Override
    public String submitBaseballNumber(String baseballInput) {
        validateBaseballInput(baseballInput);
        return baseballInput;
    }

    @Override
    public String submitGameCommand(String gameCommandInput) {
        validateGameCommand(gameCommandInput);
        return gameCommandInput;
    }


    private void validateBaseballInput(String baseballInput) {
        if (!baseballInput.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException(ERROR_BASEBALL);
        }
        validateDuplicatedNumber(baseballInput);
    }

    private void validateDuplicatedNumber(String baseballInput) {
        Set<String> nonDuplicatedNumber = new HashSet<>(List.of(baseballInput.split("")));
        if (nonDuplicatedNumber.size() != 3) {
            throw new IllegalArgumentException(ERROR_BASEBALL);
        }
    }

    private void validateGameCommand(String gameCommandInput) {
        if (!gameCommandInput.matches(REGEX_GAME_COMMAND)) {
            throw new IllegalArgumentException(ERROR_GAME_COMMAND);
        }
    }
}
