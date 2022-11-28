package baseball.domain.user;

import static baseball.utils.ErrorMessage.ERROR_BASEBALL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserImpl implements User{

    private static final String REGEX_NUMBER = "^[1-9]*$";

    @Override
    public String submitBaseballNumber(String baseballInput) {
        validateBaseballInput(baseballInput);
        return baseballInput;
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
}
