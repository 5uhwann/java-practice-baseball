package baseball.domain.computer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbers {

    public static final int RANDOM_NUMBER_SIZE = 3;

    private final List<Integer> randomNumbers;

    public RandomNumbers(List<Integer> randomNumbers) {
        this.randomNumbers = new ArrayList<>(randomNumbers);
    }

    public List<Integer> getRandomNumbers() {
        return Collections.unmodifiableList(randomNumbers);
    }
}
