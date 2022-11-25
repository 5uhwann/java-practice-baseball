package baseball.domain.computer;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private List<Integer> randomNumbers;

    public List<Integer> generateRandomNumbers() {
        randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < RandomNumbers.RANDOM_NUMBER_SIZE) {
            randomNumbers.add(generateRandomNumber());
        }
        return randomNumbers;
    }

    private int generateRandomNumber() {
        int randomNumber = (int) (Math.random() * 9) + 1;
        if (!randomNumbers.contains(randomNumber)) {
            return randomNumber;
        }
        return generateRandomNumber();
    }
}
